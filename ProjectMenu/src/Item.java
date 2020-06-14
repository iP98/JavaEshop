public abstract class Item {

	private String iName;
	private static double iPrice;
	private String iDescription;
	private static int iStock;
	private int iId;
    private String iCategory;


	//Constructors
    public Item (String iName, double iPrice, String iDescription, int iStock, int iId)
    {
        this.iName = new String(iName);
        this.iPrice = iPrice;
        this.iDescription = new String(iDescription);
        this.iStock = iStock;
        this.iId = iId;
    }

	//Methods
    public String getiName()
    {
        return iName;
    }
    public static double getiPrice()
    {
        return iPrice;
    }
    public String getiDescription()
    {
        return iDescription;
    }
    public static int getiStock()
    {
        return iStock;
    }
    public int getiId()
    {
        return iId;
    }
    public void setiName(String a)
    {
        iName = a;
    }
    public void setiPrice(double b)
    {
        iPrice = b;
    }
    public void setiDescription(String c)
    {
        iDescription = c;
    }
    public static void setiStock(int d)
    {
        iStock = d;
    }
	public void setiId(int e)
	{
		iId = e;
	}
	public String getiCategory()
	{
        return iCategory;
    }


	// όλες οι βασικές πληροφορίες για ενα item
	public String getBasicInfo() {
		return "Product Name: " +iName+"\n"+
		"           Price: "+iPrice+"\n"+ "           Description: "+iDescription+
		"\n"+ "           In stock: "+iStock+"\n"+ "           ID of product: "+iId;
	}

	//δήλωση (declaration) της μεθόδου getDetails()
	public abstract String getDetails();

	@Override
	public String toString() {
		System.out.printf("BasicInfo: " + getBasicInfo() + "\nDetails: " + getDetails() + "\n");
		//return "Item [BasicInfo: " + getBasicInfo() + "\n Details: " + getDetails() + "]";
		return null;
	}
}
