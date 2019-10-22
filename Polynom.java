public class Polynom { 
 
 public double[] coef; 
 
 public Polynom(double[] coef){ 
    this.coef = coef; 
 } 
 
 public static Polynom polynomSum(Polynom polynom1, Polynom polynom2) {
     double[] coefArr = new double[polynom1.coef.length];
     for(int i = 0; i < coefArr.length; i++) {
         coefArr[i] = polynom1.coef[i] + polynom2.coef[i];
     }
     return new Polynom(coefArr);
 }
 
 @Override
 public String toString(){ 
 String result = ""; 
 
 boolean isFirstEl = true;
 
 for ( int i = coef.length - 1; i >= 0; i--){ 
    if(coef[i] == 0) continue;
    String coefStr = "";
    double coefNumb = coef[i];
    if(coefNumb< 0) {
        coefNumb = Math.abs(coef[i]);
    }
    coefStr = coefNumb != 1 || i == 0  ? String.valueOf(coefNumb) : "";
    String operation = coef[i] >= 0 ? " + " : " - ";
    if(isFirstEl && coef[i] >= 0) operation = "";
    String degreeStr = i >= 2 ? "^" + i : "";
    degreeStr = i >= 1 ? "x" + degreeStr : "";
    result = result + operation + coefStr + degreeStr; 
    isFirstEl = false;
 } 
 return result; 
 
 } 
 
 
 
}