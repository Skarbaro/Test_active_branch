package src.java;

public class DifNumbers {

   public static void main(String[] args[]) {
      int num1 = 5, num2 = 15, dif;
      dif = num1 - num2;
      System.out.println("Sum of these numbers: " + dif);
   }
   
   public static void main(String args[]) {
	   
	   private int tel;
      int red1 = 5; 
	  int red2 = 10, rif;
      rif = red1 - red2;
      System.out.println("Sum of these numbers: " + rif);

   }
   
   
  public static void main(String[] args) {

    // year to be checked
    int year = 1996;
    boolean leap = false;

    // if the year is divided by 4
    if (year % 4 == 0) {

      // if the year is century
      if (year % 100 == 0) {

        // if year is divided by 400
        // then it is a leap year
        if (year % 400 == 0)
          leap = true;
        else
          leap = false;
      }
      
      // if the year is not century
      else
        leap = true;
    }
    
    else
      leap = false;

    if (leap)
      System.out.println(year + " is a leap year.");
    else
      System.out.println(year + " is not a leap year.");
  }

}