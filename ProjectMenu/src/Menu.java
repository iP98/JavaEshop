import java.util.Scanner; 
import java.util.ArrayList;


public class Menu 
{
    ArrayList<User> usersList = new ArrayList<>();
    boolean exit;

    public void addUser(User c)
    {
        usersList.add(c);
    }
    public void removeUser(User d)
    {
        usersList.remove(d);
    }
    
	Scanner scnr = new Scanner(System.in);



	
	
	



	public void printHeader()
	{
		System.out.println("        +----------------------------------+");
		System.out.println("        |                                  |");
		System.out.println("        |          Welcome to our          |");
		System.out.println("        |               Eshop              |");
		System.out.println("        |                                  |");
		System.out.println("        +----------------------------------+");

	}
	
	public void inputEmail(Eshop e, Menu m){
        System.out.println("Please enter your email address ex:xyz@gmail.com");
        String emailaddress=scnr.nextLine();
        boolean userFound=false;


        for (int i = 0; i < usersList.size();i++)  
        {
        	String a = usersList.get(i).getuEmail();

            if (a.equals(emailaddress) ) 
            {
            	if (usersList.get(i).getuCategory() == "Owner")
            	{
                	System.out.println("Welcome Owner!");
                    printOwnerMenu();
                    int choiceO = getChoice(1, 5);
			        performOwnerAction(choiceO, e, m); 
			        userFound = true;
			        break;
                	
            	}
            	else if (usersList.get(i).getuCategory() == "Buyer")
            	{
            		System.out.println("Welcome Buyer!");
                    printBuyerMenu();
                    int choiceB = getChoice(1, 6);
			        performBuyerAction(choiceB, e, m); 
			        userFound = true;
			        break;
            	}
            	else
            	{
            		System.out.println("Egine lathos 1");
            		
            	}
            	
            }
            else
            {
            	continue;
            }
        
        }
        
        if(userFound == true)
        {
        	System.out.print("vrethike user");
        }
        else
        {
        	System.out.println("Theleis na egrafteis?  (y/n)");
            String answerYorN=scnr.nextLine();
        	if (answerYorN.equals("y") || answerYorN.equals("Y"))
            {
               	System.out.println("Teleia!");
               	System.out.println("Poio einai to onoma sou?");
                String newName=scnr.nextLine();
               	System.out.println(newName);
                Buyer uNew = new Buyer(newName, emailaddress,0);
        		m.addUser(uNew);
        		System.out.println("Welcome Buyer!");
                printBuyerMenu();
                int choiceB = getChoice(1, 6);
		        performBuyerAction(choiceB, e, m); 
        		

                
                    

            }
            else if (answerYorN.equals("n") || answerYorN.equals("N"))
            {
            	System.out.println("Lipomaste. Elpizoume na ginetai xristis mas sto mellon!");
            }
            else
            {
            	System.out.println("Egine lathos 2");

            }

        }
            
      }


        
        
	
//	
//		   Scanner input = new Scanner(System.in);
//		   System.out.println("Hello welcome: ");
//		   System.out.println("Please enter your name: ");
//		   String empName = input.nextLine();
//		   boolean found = false;
//
//
//		   for (int i = 0; i < usersList.size();i++)
//		   {
//		      if (usersList.get(i).getEmail().equals(empName))
//		      {
//		         continue;
//		      }
//		      found = true;
//
//		      // three tries to login
//		      boolean success = false;
//		      for(int i = 0; i < 3; i++)
//		      {
//		         System.out.println("Please enter your passcode: ");
//		         String code = input.nextLine();
//
//		         if (accounts.get(a).equals(code))
//		         {
//		            System.out.println("logged in");
//		            success = true;
//		         }
//		         else
//		         {
//		            System.out.println("Wrong password... try again");
//		         }
//		      }
//		      if(!success)
//		      {
//		         System.out.println("User failed to authenticate after 3 attempts. User has been locked out!");
//		      }
//
//		   }
//		   if(!found)
//		   {
//		      System.out.println("Employee does not exist!");
//		   }
//		}
//	   

	public void printOwnerMenu() 
    {
        System.out.println("Please make a selection");
        System.out.println("1) Browse Store");
        System.out.println("2) Check Status");
        System.out.println("3) Back");
        System.out.println("4) Log out");
        System.out.println("5) Exit");
    }  
	public void printBuyerMenu() 
    {
        System.out.println("Please make a selection");
        System.out.println("1) Browse Store");
        System.out.println("2) View Cart");
        System.out.println("3) Checkout");
        System.out.println("4) Back");
        System.out.println("5) Log out");
        System.out.println("6) Exit");

    }  
	
	private void performOwnerAction(int choice, Eshop e, Menu m) 
	{
	       switch (choice) {
	           case 1: 
	           {
	        	   System.out.println("h epilogi itan 1");
	        	   browseStoreO(e, m);		            
	           }
	           		break;
	           case 2:
	           {	
	        	   System.out.println("h epilogi itan 2");
	        	   checkStatusO(e, m);
	        	   
	        	   
	           }
	                break;
	            case 3:
	            {
	            	m.inputEmail(e, m);
	            }
	                break;
	            case 4:
	            {
	            	System.out.println("Egine aposindesi.Theleis na mpeis me allo logariasmo?  (y/n)");
	                String answerYorN=scnr.nextLine();
	        		if (answerYorN.equals("y") || answerYorN.equals("Y"))
	            	{
	        			m.inputEmail(e, m);

	            	}
	            	else if (answerYorN.equals("n") || answerYorN.equals("N"))
	            	{
		                System.out.println("Goodbye.");
		            	exit = true;
	            	}
	            	else
	            	{
	            		System.out.println("Egine lathos 2");

	            	}
	    		}
	            	break;
	            case 5:
	                System.out.println("Goodbye.");
	            	exit = true;
	            	
	        break;    	
	            default:
	                System.out.println("Ubn5nknown error has occured.");
	        }
	    }

	private void performBuyerAction(int choice, Eshop e, Menu m) 
	{
	       switch (choice) {
	       		case 1: {
	        	   System.out.println("h epilogi itan 1");
	        	   browseStoreB(e, m);		            
	           		}
	           		break;
	            case 2:
	            {	
	        	    System.out.println("h epilogi itan 2");
	            	viewCart(e, m);
 	            }
	                break;
	            case 3:
	            {
	                ShoppingCart.checkout();
	            }
	                break; 
	            case 4:
	            {
	            	System.out.println("Egine aposindesi.Theleis na mpeis me allo logariasmo?  (y/n)");
	                String answerYorN=scnr.nextLine();
	        		if (answerYorN.equals("y") || answerYorN.equals("Y"))
	            	{
	        			m.inputEmail(e, m);

	            	}
	            	else if (answerYorN.equals("n") || answerYorN.equals("N"))
	            	{
		                System.out.println("Goodbye.");
		            	exit = true;
	            	}
	            	else
	            	{
	            		System.out.println("Egine lathos 2");

	            	}
	    		}
	       break;
	            case 5:
	                System.out.println("Goodbye.");
	            	exit = true;
	            	
	        break;    	
	            default:
	                System.out.println("Ubn5nknown error has occured.");
	        }
	}
	
	public void checkStatusO(Eshop e, Menu m)
	{
		
		Eshop.checkStatus();
		int a = (Eshop.buyersList.size() + 1);
		System.out.print(a);
//		System.out.println(	(Eshop.buyersList.size()+1) + ") Back");
		int choiceO2 = getChoice(1, a);
		ShoppingCart.showCart();
		if(choiceO2 == a)
		{
            printOwnerMenu();
            int choiceO = getChoice(1, 5);
    	    performOwnerAction(choiceO, e, m);
		}    
		else
		{	
			ShoppingCart tempSc;
			Buyer tempB;
			tempB = Eshop.buyersList.get(choiceO2-1);
			tempSc = tempB.getScb();
			tempSc.showCart();
			System.out.println("Do you want to erase this user?  (y/n)");
			String answerYorN=scnr.nextLine();
    		if (answerYorN.equals("y") || answerYorN.equals("Y"))
        	{
    			tempSc.clearCart();
    			Eshop.removeBuyer(tempB);
    			System.out.println("The user has been removed");
                checkStatusO(e, m);


        	}
        	else if (answerYorN.equals("n") || answerYorN.equals("N"))
        	{
                checkStatusO(e, m);
            	
        	}
        	else
        	{
        		System.out.println("Egine lathos 2");

        	}
		}
		
	}
	
	
	
	public void browseStoreO(Eshop e, Menu m)
	{
		String a;
		a = e.geteName();
		System.out.println(a);
		e.showCategories();
		int choiceO1 = getChoice(1, 5);
		if (choiceO1 == 1)
		{
			edit("Pen", e, m);
		}
		else if (choiceO1 == 2)
		{
			edit("Pencil", e, m);
		}
		else if (choiceO1 == 3)
		{
			edit("Notebook", e, m);
		}
		else if (choiceO1 == 4)
		{
			edit("Paper", e, m);
		}
		else if (choiceO1 == 5)
		{
			System.out.println("prepei na pas pisw");
            printOwnerMenu();
            int choiceO = getChoice(1, 5);
    	    performOwnerAction(choiceO, e, m); 

		}	
	}

	public void browseStoreB(Eshop e, Menu m)
	{
		String a;
		a = e.geteName();
		System.out.println(a);
		e.showCategories();
		int choiceO1 = getChoice(1, 5);
		if (choiceO1 == 1)
		{
			add("Pen", e , m);            
		}
		else if (choiceO1 == 2)
		{
			add("Pencil", e , m);
		}
		else if (choiceO1 == 3)
		{
			add("Notebook", e, m);
		}
		else if (choiceO1 == 4)
		{
			add("Paper", e ,m);
		}
		else if (choiceO1 == 5)
		{
            printBuyerMenu();
            int choiceB = getChoice(1, 5);
    	    performBuyerAction(choiceB, e, m); 
		}	
	}
	
	private int getChoice(int a, int b) {
	    int choice = 0;

        System.out.print("Enter your choice: ");
        do {
	        try {
	            choice = Integer.parseInt(scnr.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid selection. Numbers only please.");
	        }
	        if (choice < a || choice > b) {
	            System.out.println("Choice outside of range. Please choose again.");
	        }
        } while (choice < a || choice > b);    
	    return choice;
	    
	}   
	
	private void add(String g, Eshop e, Menu m)
	{
		int a = (Eshop.showProductsInCategory(g) + 1);
		int choiceB1 = getChoice(1, a);
		if(choiceB1 == a)
		{
			browseStoreB(e,m);
		}
		else
		{	
			Item tempItem;
			tempItem = Eshop.itemsList.get((choiceB1-1));
			int tempId;
			tempId = tempItem.getiId();
			Eshop.showProduct(tempId);
			System.out.println("Do you want to add it to your cart?  (y/n)");
	
			String answerYorN=scnr.nextLine();
			if (answerYorN.equals("y") || answerYorN.equals("Y"))
	    	{
				System.out.println("How many do you want?  (y/n)");
				int tempQ=scnr.nextInt();
				Buyer.placeOrder(tempItem, tempQ);
				System.out.println("Your item has been added to your cart.");
				browseStoreB(e, m);
	    	}
	    	else if (answerYorN.equals("n") || answerYorN.equals("N"))
	    	{
				Eshop.showCategories();
	    		
	    	}
	    	else
	    	{
	    		System.out.println("Egine lathos 2");
	
	    	}
		}
	}

	public void edit(String g, Eshop e, Menu m) 
	{
		int a = (Eshop.showProductsInCategory(g) + 1);
		System.out.println(a);
		int choiceO1 = getChoice(1, a);
		if(choiceO1 == a)
		{
			browseStoreO(e,m);
		}
		else
		{	
			Item tempItem;
			tempItem = Eshop.itemsList.get((choiceO1-1));
			int tempId;
			tempId = tempItem.getiId();		
			Eshop.showProduct(tempId);
			System.out.println("Do you want to edit it?  (y/n)");
	
			String answerYorN=scnr.nextLine();
			if (answerYorN.equals("y") || answerYorN.equals("Y"))
	    	{
				System.out.println("How many ? ");
				int tempQ=scnr.nextInt();
				Eshop.updateItemStock(tempId, tempQ);		
	
	    	}
	    	else if (answerYorN.equals("n") || answerYorN.equals("N"))
	    	{
				Eshop.showCategories();
	    		
	    	}
	    	else
	    	{
	    		System.out.println("Egine lathos 2");
	
	    	}
		
		}
		
	}
	
	



	public void viewCart(Eshop e, Menu m)
	{
		if(ShoppingCart.OrderList.size() == 0)
		{
			System.out.println("Your cart is Empty.");
			System.out.println("You can add items if you press 1!");
			printBuyerMenu();
			int choiceB = getChoice(1, 5);
    	    performBuyerAction(choiceB, e, m); 
			
		}
		else
		{
			ShoppingCart.showCart();

		}	
	    
	    

	}
	
}