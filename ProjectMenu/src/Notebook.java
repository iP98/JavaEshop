public class Notebook extends Item
{
	
	//Variables
	// βάζουμε ως private τις μεταβλητές γιατί είναι "ευαίσθητες" πληροφορίες και θα μπορούμε να τις καλούμε μόνο με gettes-setters
    private int sections;
    private String iCategory = "Notebook";

  //Constructor

    public Notebook (String iName, double iPrice, String iDescription, int iStock, int iId, int sections)
    {
        super(iName, iPrice, iDescription, iStock, iId);
        this.sections = sections;
    }

  //Methods

    public int getSections()
    {
        return sections;
    }
    public void setSections(int a)
    {
        sections = a;
    }
    public String getiCategory()
    {
        return iCategory;
    }
    public void setiCategory()
    {
        iCategory = "Notebook";
    }
   //υλοποίηση της getDetails() για τα extra στοιχεια του notebook
    public String getDetails()
    {
    	return "Number of Themes: " +getSections();
    }
    
}
