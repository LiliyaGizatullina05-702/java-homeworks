public class MyClass { 
 public static void main(String[] args) { 
 double[] firstPolynomCoef = new double[3]; 
 firstPolynomCoef[0] = 1; 
 firstPolynomCoef[1] = -1; 
 firstPolynomCoef[2] = 0; 
 Polynom polynom1 = new Polynom(firstPolynomCoef);
 System.out.println("Polynom 1: " + polynom1);
 
 double[] secondPolynomCoef = new double[3]; 
 secondPolynomCoef[0] = 3; 
 secondPolynomCoef[1] = -2; 
 secondPolynomCoef[2] = 5; 
 Polynom polynom2 = new Polynom(secondPolynomCoef);
 System.out.println("Polynom 2: " + polynom2);
 
 Polynom polynomSum = Polynom.polynomSum(polynom1, polynom2);
 
 System.out.println("Sum: " + polynomSum);
 } 
 
}
