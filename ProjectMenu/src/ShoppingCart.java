import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
	//Variables
	//������� �� private ��� ���������� ����� ����� "����������" ����������� ��� �� �������� �� ��� ������� ���� �� gettes-setters
	//����������� ��� �������� ���������� ��� �� ����� ��� ������ �� ������� �� ������ ���� item category (������� �� ��� �������� ��� ���� �������� � buyer)
	//�� ������� �� �������� ������ ���� ��� items ��� ���� ����������� � buyer ��� �� ������ ��� �����������
	private static double quantityCost;
	private static double totalCost;
	private static double courierCost;
	private int count = 0;
	private int scID;
	static boolean exit;  //����� ���������� ��� ����������� ��� �� ������������ �� ���������

	
	static ArrayList<ItemOrdered> OrderList = new ArrayList<ItemOrdered>();
	static Scanner scnr = new Scanner(System.in);  //��� �� ������ � user �� ������ ����� ��� �� ������

	
	
	public ShoppingCart (Item item, int quantity,double quantityCost, double totalCost, double courierCost, Buyer a) {
		super();
		this.quantityCost = quantityCost;
		this.totalCost = totalCost;
		this.courierCost = courierCost;
		
	}

//	public void OrderList() {
//	OrderList.addAll((Collection<? extends String>) ItemOrdered.item);
//  }
	
	
	public int getScID() {
		return scID;
	}

	public void setScID(int scID) {
		this.scID = scID;
	}

	public static double getTotalCost() {
		return totalCost;
	}

	public static double getQuantityCost() {
		return quantityCost;
	}

	public static void setQuantityCost(double quantityCost) {
		ShoppingCart.quantityCost = quantityCost;
	}

	public void setTotalCost(double totalCost) {
		ShoppingCart.totalCost = totalCost;
	}

	public double getCourierCost() {
		return courierCost;
	}

	public void setCourierCost(double courierCost) {
		ShoppingCart.courierCost = courierCost;
	}

	public static void addItemOrdered(Item b) {
		System.out.println("mpainei stin add item ordered");
		boolean itemFound = false;
//		while (ItemOrdered.getQuantity() <= b.getiStock())
//			try {
//				Item.setiStock(Item.getiStock()-ItemOrdered.getQuantity());
//			} catch (Exception StockNotFoundException) {
//				System.out.println("Out of stock.");
//			}

		for (int i = 0; i < OrderList.size();i++)  
        {
        	System.out.println("i:"+ i);
        	System.out.println("size: " + OrderList.size());

        	Item a = OrderList.get(i).getItem();
        	System.out.println(a.getiName());
        	System.out.println("Item:"+ a);

            if (a.equals(b)) 
            {
            	ItemOrdered.setQuantity(1 + ItemOrdered.getQuantity());
            	itemFound = true;
            	System.out.print("eimai stin if");
            	break;
           	}

            else
            {
            	System.out.println("else");
            	
            }
        
        }
        if(itemFound == true)
        {
        	System.out.println("eimai stin katw if");

        }
        else
        {
    		ItemOrdered io1 = new ItemOrdered(b,1);
    		OrderList.add(io1);
        	System.out.println("eimai stin katw else");


        }

    }
	

	public void removeItemOrdered(ItemOrdered a) {
		OrderList.remove(a);
		Item.setiStock(Item.getiStock() + ItemOrdered.getQuantity());
	}

	public void changeItemOrderedQuantity(ItemOrdered a, Item b, int e, int f) throws Exception {
		if (a.getQuantity() <= b.getiStock()) {
			Eshop.updateItemStock(e, f);
		} else
			throw new Exception ("Out of stock.");
	}

	public static void showCart() {
		
		System.out.printf("Your order cost is: "+ totalCost+" Euros. \n Shipping costs: "+courierCost+" Euros. \n Total Price: "+(totalCost+courierCost)+" Euros");
		//System.out.println(OrderList);
		System.out.println("\n+--------------------------------------------------+");
		System.out.println("Item |\t Quantity |\t Price");
		for (int i=0; i <= OrderList.size(); i++) {
			System.out.print(OrderList.size());
//			a = OrderList.get(i).getItem();
//			b = OrderList.get(i).getQuantity();
			System.out.printf(OrderList.get(i).getItem() +" |\t" + OrderList.get(i).getQuantity()+" |\t"+ quantityCost + "\n");
			}
		System.out.println("+--------------------------------------------------+");
		
	}



	

	public void clearCart() 
	{
		// me for na vazoume kathe itemOrdered jexorista sthn removeItemOrdered
		for (int i = 0; i < OrderList.size(); i++) 
		{
			removeItemOrdered(OrderList.get(i));	
		}
		
	}

public static void checkout() {
		
		System.out.println("Checking Out. \n");
		showCart();      //����������� ��� showCart ��� �� ������ � buyer �� ����� ��� �� ���� ��������
		
		System.out.println("Procceed with payment?  (y/n)");   //��� ������� �� �������� ��� ����� �� ��������
        String answerYorN=scnr.nextLine();
		if (answerYorN.equals("y") || answerYorN.equals("Y"))
    	{
			Buyer bb = new Buyer("a", "b", 0); //������������ object ��� ������ buyer
			bb.awardBonus();    //������� ��� awardBonus ��� �� ���������� �� ������ bonus ��� Buyer 
			OrderList.clear();     // ����������� �� ������ ��� buyer 
			Item.setiStock(Item.getiStock() - ItemOrdered.getQuantity());    //������ ��� ����������, ����� ��� ��� ������ ��� stock, ���� ���� ����� ��� ���� ��� (�� ��������)
			
			System.out.println("Money has been transfered.");
			System.out.println("We hope you enjoy your new items!");
    	}
    	else if (answerYorN.equals("n") || answerYorN.equals("N"))
    	{
            System.out.println("Are you sure? Your order will be deleted.   (y/n)");   //��� ������� �� ��������� �� ����� �������� ��� ��� ����� �� ��������, ��� ����� �����
            String answerYorN1=scnr.nextLine();
            if (answerYorN1.equals("y") || answerYorN1.equals("Y"))
            {
            	OrderList.clear();    //����������� �� ������, ���� ��� ��� ���� ��� ��� ��� ����� �� ��������, � ���������� ��� �� ���������
            	Item.setiStock(Item.getiStock() + ItemOrdered.getQuantity());    //����������� ���� ��� Stock ��� �� items ��� ���� "��������" � buyer ���� ��� ����������� ���
            	exit = true;     //���������� �� ���������
            }
            else if (answerYorN1.equals("n") || answerYorN1.equals("N"))
            {
            	Menu mm = new Menu();   //������������ object ��� ������ menu
            	mm.printBuyerMenu();    //������� ��� ������ ��� �� ������ � buyer �� �������� ���� ����
            }
            
            
          //��� ������� �� ������ �� ���������� � User, ����� ����������� ���� �� printBuyerMenu ��� ���������� �� ���������
            
    	}
	}


	

	public double calculateNet(Item a) {
		for (int i = 0; i < OrderList.size(); i++) {
			a = OrderList.get(i).getItem();
			quantityCost = ItemOrdered.getQuantity() * Item.getiPrice();
//			if (a == OrderList.get(i).getItem()) {
//				OrderList.get(i);
//				ItemOrdered.getQuantity();
//				quantityCost = ItemOrdered.getQuantity() * Item.getiPrice();
////			 	ArrayList<Item> itemsList = Item.getitemsList();
////			 	c.getiPrice(i) *= OrderList.get(i).getQuantity();a
//				OrderList.get(i);
//				System.out.println("Price for " + ItemOrdered.getQuantity() + " " + OrderList.get(i).getItem() + " is: " + getQuantityCost());
//			} else { return 0; }
		}
		totalCost = getQuantityCost();
		return totalCost;
	}

	public void calculateCourierCost(Buyer a, double b) {
		courierCost = totalCost * 0.02;
		if (courierCost <= 3) {
			setCourierCost(3);
//			a.getbuyerCategory();

			switch (a.getbuyerCategory()) {
				case "Bronze":  {
					setCourierCost(b);
					System.out.printf("Category: Bronze \n Courier Cost: %d", getCourierCost());
				}	break;

				case "Silver": {
					setCourierCost(b * 0.5);
					System.out.printf("Category: Silver \n Courier Cost: %d", getCourierCost());
				}	break;

				case "Gold": {
					setCourierCost(0);
					System.out.printf("Category: Gold \n Courier Cost: %d", getCourierCost());
				}	break;
			}
		}
		else {
//			a.getbuyerCategory();
			switch (a.getbuyerCategory()) {
				case "Bronze":  {
					setCourierCost(b);
					System.out.printf("Category: Bronze \n Courier Cost: %d", getCourierCost());
				}	break;

				case "Silver":  {
					setCourierCost(b * 0.5);
					System.out.printf("Category: Silver \n Courier Cost: %d", getCourierCost());
				}	break;

				case "Gold":  {
					setCourierCost(0);
					System.out.printf("Category: Gold \n Courier Cost: %d", getCourierCost());
				}	break;

			}
		}


	}



}
