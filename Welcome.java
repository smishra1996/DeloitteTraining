class Welcome
{
    public void accept()
     {
        System.out.println("Welcome in accept");
     }
    public void display()
    {
        System.out.print("Welcome to Deloitte");
        System.out.println("\n Welcome to ITPL");
    }
    public static void main(String args[])
    {
       System.out.println("\n Welcome in MAIN");
       Welcome w=new Welcome();
       w.display();
       w.accept();
       Bye b=new Bye();
       b.sayBye();
    }
}