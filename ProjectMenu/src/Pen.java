public class Pen extends Item
{
    private String color;
    private double tipSize;
    private String iCategory = "Pen";


    public Pen (String iName, double iPrice, String iDescription, int iStock, int iId, String color, double tipSize)
    {
        super(iName, iPrice, iDescription, iStock, iId);
        this.color = color;
        this.tipSize = tipSize;
    }

    public String getColor()
    {
        return color;
    }
    public double getTipSize()
    {
        return tipSize;
    }
    public String getiCategory()
    {
        return iCategory;
    }
    public void setColor(String a)
    {
        color = a;
    }
    public void setTipSize(double b)
    {
        tipSize = b;
    }
    public void setiCategory()
    {
        iCategory = "Pen";
    }
    
    //υλοποίηση της getDetails() για τα extra στοιχεια του pen
    public String getDetails()
    {
    	return "Color: " +getColor()+ "\n         Tip Size: "+getTipSize()+" mm";
    }
}
