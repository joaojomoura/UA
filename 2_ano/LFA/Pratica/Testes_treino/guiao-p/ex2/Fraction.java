/**
 * @author : moura
 * @created : 2021-07-07
**/


public class Fraction {
    /*
     * Variables
     */
  private int denominator, numerator;

  /*
   * Constructor with two arguments
   * @param dem
   * @param num
   */
  public Fraction (int num, int dem){
    if(dem == 0){
      System.err.println("Error: denominator cannot be 0, converted to 1");
      dem = 1; 
    }
    if(dem < 0){
      num = num * (-1);
      dem = dem * (-1);
    }
    numerator = num;
    denominator = dem;

  }
  
  /*Constructor with one argument
   */
  public Fraction (int num){
    numerator = num;
    denominator = 1;
  }

  /*
   * Constructor with 0 arguments
   */
  public Fraction(){
    numerator = 0;
    denominator = 1;
  }

  public int getDenominator(){
    return denominator;
  }
  public int getNumerator(){
    return numerator;
  }

  

  @Override
  public String toString() {
    if(denominator == 1)
      return "" + getNumerator();
    return "" + getNumerator() + '/' + getDenominator();
  }

  public Fraction addFraction(Fraction f){
    Fraction sum = new Fraction();
    sum.denominator = denominator * f.getDenominator();
    sum.numerator = (numerator * f.getDenominator() + f.getNumerator() * denominator);
    return sum;
  }


  public Fraction subFraction(Fraction f){
    Fraction sum = new Fraction();
    sum.denominator = denominator * f.getDenominator();
    sum.numerator = (numerator * f.getDenominator() - f.getNumerator() * denominator);
    return sum;
  }

  public Fraction mulFraction(Fraction f){
    return new Fraction(numerator * f.getNumerator(), denominator * f.getDenominator());
  }

  public Fraction divFraction (Fraction f){
    return new Fraction(denominator * f.getNumerator(), numerator * f.getDenominator());
  }
}
