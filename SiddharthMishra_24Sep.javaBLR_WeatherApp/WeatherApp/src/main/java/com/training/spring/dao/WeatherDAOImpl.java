	package com.training.spring.dao;

	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.criterion.Order;
	import org.hibernate.criterion.Projections;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.stereotype.Repository;

	import com.training.spring.model.Weather;
	@Repository
	public class WeatherDAOImpl implements WeatherDAO {
		
		private static final Logger logger = LoggerFactory.getLogger(WeatherDAOImpl.class);

		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sf){
			this.sessionFactory = sf;

		}

		@Override
		public List<Weather> listcity() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Weather> cityList = session.createQuery("from Weather").list();
			Criteria criteria=session.createCriteria(Weather.class);
	    	criteria.addOrder(Order.desc("cityId"));
			return cityList;
		}

		@Override
		public void addcity(Weather c) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(c);
			logger.info("city saved sucessfully="+c);
		}
		
	    public List<Weather> showCity()
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Criteria criteria=session.createCriteria(Weather.class);
	    	criteria.addOrder(Order.desc("city"));
	    	List<Weather> result=criteria.list();
			return result;
	    }

		@Override
		public int maxCityId() {
			Session session = this.sessionFactory.getCurrentSession();
	    	//Criteria c=session.createCriteria(Weather.class);
	    	//c.addOrder(Order.desc("cityId"));
	    	//c.setMaxResults(1);
	    	//Integer i = c.setProjection(Projections.max("cityId"));
	    	
	    	Criteria cr = session.createCriteria(Weather.class);
	    	cr.setProjection(Projections.max("cityId"));

	    	Integer max = (Integer) cr.uniqueResult();
	    	System.out.println("MAX in DAO :"+max);
	    	return max;
		}
	}



