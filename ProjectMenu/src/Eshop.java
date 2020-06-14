import java.util.ArrayList;

public class Eshop
{
	
	//Variables
	// βάζουμε ως private τις μεταβλητές γιατί είναι "ευαίσθητες" πληροφορίες και θα μπορούμε να τις καλούμε μόνο με gettes-setters
    private String eName;
    private Owner eOwner;
  //λίστες που θα αποθηκεύονται τα items και τους buyers που περιέχει το eshop

    static ArrayList<Item> itemsList = new ArrayList<>();
	static ArrayList<Buyer> buyersList = new ArrayList<>();
	
	
	//Constructor	   

    public Eshop(String eName, Owner eOwner)
    {
    this.eName = eName;
    this.eOwner = eOwner;
    }
    
  //Methods

    public String geteName()
    {
        return eName;
    }
    
    public void seteName(String z)
    {
    	z = eName; 
    }
           
    public Owner geteOwner() 
    {
		return eOwner;
	}

	public void seteOwner(Owner eOwner) 
	{
		this.eOwner = eOwner;
	}

	public static void addItem(Item a) throws AlreadyExistsException 
    {
		if (itemsList.contains(a)) {
			throw new AlreadyExistsException("Already exists.");
		}
		else { itemsList.add(a); }
    }
    
 
    public static Item getItembyId(int b)
    {
        for (int i = 0; i < itemsList.size();i++)  
        {
            if (b == itemsList.get(i).getiId()) 
            {
                System.out.println("The product is: " + itemsList.get(i).getiName());
                return itemsList.get(i);   
            }
        }
        return null;
    }
    
	public static void removeItem(Item a)
    {
        itemsList.remove(a);
    }
    
    public static void addBuyer(Buyer c) throws AlreadyExistsException
	{
    	if (buyersList.contains(c)) {
			throw new AlreadyExistsException("Already exists.");
		}
		else { buyersList.add(c); }
	}
	 
    public static void removeBuyer(Buyer d) 
    {
    	buyersList.remove(d); 
    }
	
    public static void updateItemStock(int e, int f)
    {
        for (int i = 0; i < itemsList.size();i++)  
        {
            if (e == itemsList.get(i).getiId()) 
            {
                itemsList.get(i).setiStock(f); 
            }
        }
    }
    
    public static void showCategories()
    {
    	System.out.println("mpainei sti showcategory");
    	int penCounter = 0;
    	int pencilCounter = 0;
    	int paperCounter= 0; 
    	int notebookCounter = 0;
    	
        for (int i = 0; i < itemsList.size();i++)  
        {
        	if (itemsList.get(i).getiCategory().equals("Pen")) 
        	{
        		penCounter++;
        	}
        	else if (itemsList.get(i).getiCategory().equals("Pencil")) 
        	{
        		pencilCounter++;
        	}
        	else if (itemsList.get(i).getiCategory().equals("Paper")) 
        	{
        		paperCounter++;
        	}
        	else if (itemsList.get(i).getiCategory().equals("Notebook")) 
        	{
        		notebookCounter++;
        	}
        	else 
        	{
        		System.out.println("Random error");
        	}       	
        } 
        System.out.println("mpainei sti showcategory");
    	System.out.printf("1) Pen (%d) \n" , penCounter);
    	System.out.printf("2) Pencil (%d) \n" , pencilCounter);
    	System.out.printf("3) Notebook (%d) \n" , notebookCounter);
    	System.out.printf("4) Paper (%d) \n" , paperCounter);
    	System.out.printf("5) Back\n");

    }
    
    public static int showProductsInCategory(String g)
    {
    	int counterCategory = 0;
        System.out.println("--------------------------------");
        for (int i = 0; i < itemsList.size();i++)  
        {
            if (g == itemsList.get(i).getiCategory()) 
            {
            	counterCategory++;
                System.out.println((counterCategory) + ") Name: " + itemsList.get(i).getiName() + "\n   ID: " + itemsList.get(i).getiId());  
                System.out.println("--------------------------------");
            }
        }
        System.out.println(counterCategory+1 + ") Back");
        System.out.println("--------------------------------");

        return counterCategory;
    }
    
	
	public static void showProduct(int f) 
	{
		Item tempitem;
		tempitem = getItembyId(f);
		tempitem.toString();
		
	}
	
	public static void checkStatus()
	{
		for (int i = 0; i < buyersList.size();i++)  
        {
           System.out.println( (i+1) + ")\n" + "Onoma: " + buyersList.get(i).getuName() + "\nBonus: " + buyersList.get(i).getBonus() + "\nBuyers Category:" + buyersList.get(i).getbuyerCategory());
           System.out.println("----------------------------------------");  
           
        }
	System.out.println((buyersList.size()+1) + ") Back");
	}
	
} 