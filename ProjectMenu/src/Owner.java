
public class Owner extends User
{
    private boolean isAdmin = true;
    private String uCategory="Owner";

            
    public Owner(String uName, String uEmail)
    {
        super(uName, uEmail);
    }
    public void setIsAdmin(boolean i)
    {
        isAdmin = true;
    }
    public boolean getisAdmin() 
    {
        return isAdmin;
    }
    public String getuCategory() 
    {
        return uCategory;
    }
    public void setuCategory()
    {
        uCategory = "Owner";
    }
}