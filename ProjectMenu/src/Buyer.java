public class Buyer extends User{

	private int bonus;
	private String buyerCategory;
    private String uCategory = "Buyer";
    private ShoppingCart scb;
    

	public Buyer (String uName, String uEmail, int bonus)
	{
		super(uName, uEmail);
		this.bonus=bonus;
		this.scb=scb;
		setbuyerCategory();


		


	}

	public int getBonus() {
		return bonus;
	}
	
	public ShoppingCart getScb() {
		return scb;
	}

	public void setScb(ShoppingCart scb) {
		this.scb = scb;
	}

	public void setBonus(int a)
	{
		bonus = a;
	}

	public String getbuyerCategory() 
	{
		return buyerCategory;
	}

    public String getuCategory() 
    {
        return uCategory;
    }
    
	public void setuCategory()
    {
        uCategory = "Buyer";
    }
	

	public void awardBonus() {
//		int startBonus = 0;
//		int bonus = startBonus;
		double myBonus = bonus;		
		if (ShoppingCart.getTotalCost() > 0) {
			bonus = (int) (myBonus + 0.1*ShoppingCart.getTotalCost());
			if (bonus > 100 || bonus > 200) {
				this.setbuyerCategory();
			}
		}
	}

	public void setbuyerCategory() {
		if (this.bonus <= 100) {
			buyerCategory = "Bronze";
//			System.out.println("Category: Bronze");
//			b.setCourierCost(a);
		}
		else if (this.bonus > 100 && this.bonus <= 200) {
			this.buyerCategory = "Silver";
//			System.out.println("Category: Silver");
//			b.setCourierCost(a * 0.5);
		}
		else if (this.bonus > 200) {
			this.buyerCategory = "Gold";
//			System.out.println("Category: Gold");
//			b.setCourierCost(0);
		}
		else
		{
			System.out.println("lathos sto setbuyercategory ");
		}
	}

	

	public static void placeOrder(Item a, int b) 
	{
		for (int i = 0; i < b;i++)  
        {
			ShoppingCart.addItemOrdered(a);
        }

	}

}
