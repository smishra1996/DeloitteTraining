"use strict";
console.log("Script loaded!");

var temp = 1;
var weatherName = "Thunder"
var photoId = "";
var unit = "C";
var iconId = "";
var flickrApiKey = "886f7c9d1bb1f055a15aef593b21e3de";
var weatherApiKey = "10653d5198f766ea99fdb77cd7326644";
var weatherApiUrl = "https://api.openweathermap.org/data/2.5/weather";
var photoURL = "";
var flickrApiSearch = "https://api.flickr.com/services/rest/?method=flickr.photos.search&format=json&nojsoncallback=1";
var flickrApiGetSize = "https://api.flickr.com/services/rest/?method=flickr.photos.getSizes&format=json&nojsoncallback=1";
var weatherOptions = {
	appid: weatherApiKey,
	units: "metric",
	q: "Oslo"
};
var flickrSearchOptions = {
	api_key: flickrApiKey,
	photo_id: photoId,
	tags: "sky,landscape,outdoor,-portrait,-indoor",
	tag_mode: "all",
	media: "photos",
	safe_search: 1
};
var flickrSizeOptions = {
	api_key: flickrApiKey,
	photo_id: photoId
	};

	
//Function for Openweathermap.org API-call
function getWeather(response) {
	weatherName = response.weather[0].main;
	$("#icon").removeClass("wi-owm-" + iconId);
	iconId = response.weather[0].id;
	$("#place").text(response.name);
	temp = Math.round(response.main.temp);
	flickrSearchOptions.tags = weatherName + ",landscape,outdoor,-portrait,-indoor";
	showWeather();
} //End of getWeather function

//Function for displaying weather data
function showWeather() {
	$("#weather").text(weatherName);
	$("#temp").text(setTemp(temp) + String.fromCharCode(176) + unit);
	$("#icon").addClass("wi-owm-" + iconId);
} //End of showWeather function

// Function for setting correct temperature unit
function setTemp(temperature) {
	if (unit === "F") {
		return Math.round(temperature * 1.8 + 32);
	} else {
		return temperature;
	}
}//End of setTemp

//Function for getting a list of images from Flickr
function searchImages() {
	$.getJSON(flickrApiSearch, flickrSearchOptions, getPhotos);
}

//Function for finding a random related image on Flickr
function getPhotos(response) {
	var photoNumber = Math.floor(Math.random() * response.photos.photo.length);
	photoId = response.photos.photo[photoNumber].id;
	flickrSizeOptions.photo_id = photoId;
	$.getJSON(flickrApiGetSize, flickrSizeOptions, displayPhoto);
} // end of getPhotos function

//Function for finding a good resoulution of the selected Flickr photo
function displayPhoto(response) {
	var atPhoto = (response.sizes.size[response.sizes.size.length - 2].url).replace(/.{9}$/, "");
	var photographer = /photos\/(.*?)\//.exec(response.sizes.size[response.sizes.size.length - 2].url)[1];
	photographer = photographer.charAt(0).toUpperCase() + photographer.slice(1);
	photographer = photographer.replace("-", " ");
	photographer = photographer.replace("_", " ");
	$("#photographer").text(photographer);
	$("#photo").attr("href", atPhoto);
	
	photoURL = response.sizes.size[response.sizes.size.length - 2].source;
	$("body").css("background-image", "url(" + photoURL + ")");
} //end of displayPhoto function


//Function for getting the users position
function getPosition() {
	navigator.geolocation.getCurrentPosition(function (position) {
		weatherOptions.lon = position.coords.longitude;
		weatherOptions.lat = position.coords.latitude;
		delete weatherOptions.q;
		go();
	});
} //end getPosition function

//Function for setting city from search
function setCity(city) {
	delete weatherOptions.lon;
	delete weatherOptions.lat;
	weatherOptions.q = city;
} //end of setCity function


//Function for starting chain of events
function go() {
	$.getJSON(weatherApiUrl, weatherOptions, getWeather);
} //end of go function


//Event for search field and button
$("#search").change(function () {
	setCity($("#search").val());
	go();
	searchImages();
}); //End of #search event

//Event for changing units
$("input[type='radio']").click(function() {
	if ($("#far").prop("checked") === true) {
		unit = "F";
	} else {
		unit = "C";
	}
	setTemp(temp);
	showWeather();
}); //End of #tempunit event

//Event for setting home location
$("#home-button").click(function () {
	getPosition();
	searchImages();
});

//Event for showing about-dialog
$("#about").click(function () {
	$("#about-dialog").css("display", "block");
});

$("#close").click(function () {
	$("#about-dialog").css("display", "none");
});

getPosition();
showWeather();
searchImages();