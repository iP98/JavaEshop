
public class Main {

	public static void main(String[] args)	
	{
		Buyer b1 = new Buyer("Makis ", "k21", 54);
		Buyer b2 = new Buyer("Du", "kb21", 4514);
		Buyer b3 = new Buyer("Louk", "tem", 55);
		Owner u1 = new Owner("Petsas", "aek");
		Eshop es1 = new Eshop("Magazara", u1);
		Item pen1 = new Pen("onoma pen", 34.71, "dfjm", 4, 457, "telsseftaio string", 41.84);
		Item pen2 = new Pen("pen2", 34.71, "dfjm", 14, 75, "teleftffaio string", 41.84);
		Item pen3 = new Pen("stylo gia na matheis", 34.71, "dfjfm", 4, 7, "teleftaio string", 41.84);
		Item pen4 = new Pen("23", 34.71, "dfjm", 4, 21, "telefdfftaio string", 41.84);
		Item pencil1 = new Pencil("pencil", 34.71, "dfjm", 4, 457, 41.84, "telsseftaio string");
		Item pencil2 = new Pencil("onoma pencilhfhd", 34.71, "dfjm", 4, 457, 41.84, "telsseftaio string");
		Item pencil3 = new Pencil("odhnoma pencil", 34.71, "dfjm", 4, 457, 41.84, "telsseftaio string");
		Item notebook1 = new Notebook("ogddnomahhcj NB", 34.71, "dfjm", 4, 457,7);
		Item notebook2 = new Notebook("ogddfchfhnoma NB", 34.71, "dfjm", 4, 457,7);
		Item notebook3 = new Notebook("ogddnomaNB pehvghn", 34.71, "dfjm", 4, 457,7);
		Item notebook4 = new Notebook("ogddngchvg  NB     homa pen", 34.71, "dfjm", 4, 457,7);
		Item notebook5 = new Notebook("ohjgjgg  NB  a pen", 34.71, "dfjm", 4, 457,7);
		Item paper1 = new Paper("paper pen", 34.71, "dfjm", 4, 457, 3, 1);

		
		Menu menu = new Menu();
		try {
		Eshop.addItem(pen1);
		Eshop.addItem(pen2);
		Eshop.addItem(pen3);
		Eshop.addItem(pen4);
		Eshop.addItem(pencil1);
		Eshop.addItem(pencil2);
		Eshop.addItem(pencil3);
		Eshop.addItem(notebook1);
		Eshop.addItem(notebook2);
		Eshop.addItem(notebook3);
		Eshop.addItem(notebook4);
		Eshop.addItem(notebook5);
		Eshop.addItem(paper1);
		} catch (AlreadyExistsException e) {
			//logging and handling the situation
		}

//		ShoppingCart.addItemOrdered(ItemOrdered a, Item b, int c)
		menu.addUser(b1);
		menu.addUser(u1);
		menu.addUser(b2);
		menu.addUser(b3);

		
		try {
	    Eshop.addBuyer(b1);
	    Eshop.addBuyer(b2);
	    Eshop.addBuyer(b3);
		} catch (AlreadyExistsException e) {
			//logging and handling the situation
		}
	    
		menu.printHeader();
		menu.inputEmail(es1, menu);

	}
}
