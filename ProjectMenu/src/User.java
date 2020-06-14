public abstract class User 
{
    private String uName;
    private String uEmail;
    private String uCategory;
      

    public User (String uName, String uEmail)
    {
        this.uName = uName;
        this.uEmail = uEmail;               

    }

    public void setuName(String n)
    {
        uName = n;
    }
    public String getuName() 
    {
        return uName;
    }
    public void setuEmail(String e)
    {
        uEmail = e;
    }
    public String getuEmail() 
    {
        return uEmail;
    }
    public String getuCategory() 
    {
        return uCategory;
    }

	
}