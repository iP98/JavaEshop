import java.io.IOException;

public class Pencil extends Item {

  private double tipSize;
  private String type;
  private String iCategory = "Pencil";


  public Pencil (String iName, double iPrice, String iDescription, int iStock, int iId, double tipSize,  String type)
  {
      super(iName, iPrice, iDescription, iStock, iId);
      this.tipSize = tipSize;
      this.type = type;
  }

  public String getType()
  {
      return type;
	}
  public double getTipSize()
  {
      return tipSize;
  }
  public String getiCategory()
  {
      return iCategory;
  }
  public void setType(String a)
  {
      type = a;
  }
  public void setTipSize(double b)
  {
      tipSize = b;
  }
  public void setiCategory()
  {
      iCategory = "Pencil";
  }
  
  public static void checkEligibility(String type) throws IOException{
    if (type != "H" || type != "B" || type != "HB"){
      throw new IOException("Type size of pen is not eligible");
      }
    else { System.out.println("Type size is valid");
      }
    }


  //υλοποίηση της getDetails() για τα extra στοιχεια του pencil
  public String getDetails()
  {
	  return "Tip Size: " +getTipSize()+" mm \n          Type: "+getType();
  }
}
