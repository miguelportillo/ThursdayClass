//----------------------------------------------------------------------
// Quadratic.java          by Miguel Portillo       portime0@sewanee.edu
//
// CSci 257 Homework 3     Instructor: Professor Carl   February 7, 2017
//
// This assignment served as a warm-up for writing the Polynomial class 
//for Project 1. I wrote a class called Quadratic for representing and
//using quadratic equations. The main method creates three Quadratic
//objects and calls the three methods on various values. 
//----------------------------------------------------------------------

public class Quadratic{

private int coeff[] = new int [3];
public static void main(String[] args){

	Quadratic quad1 = new Quadratic(3,2,1);
	System.out.println("Quadratic 1: " + quad1);
	System.out.println(quad1.toString());

	System.out.println("\n");

	Quadratic quad2 = new Quadratic(4,-5,6);
	System.out.println("Quadratic 2: " + quad2);
	System.out.println(quad2.evaluate(-1));

	System.out.println("\n");

	Quadratic quad3 = new Quadratic(2,7,-4);
	System.out.println("Quadratic 3: " + quad3);
	System.out.printf("Roots:  %f and  %f", quad3.roots()[0], quad3.roots()[1]);

    	System.out.println("\n");
}

/**
* @precondition Calls method with 3 int arguments (slots), one for each coefficient
* @postcondition A new quadratic object will be created with the 3 arguments
*/

public Quadratic (int a, int b, int c){
 coeff[0] = c;
 coeff[1] = b;
 coeff[2] = a;
}

/**
* @precondition The method has to be called by the Quadratic object
* @postcondition Method returns the coefficient array when called
*/

public int[] getCoeff (){
 return coeff;
}

/**
* @precondition Has to be called inorder for the quadratic object to be evaluated
* @postcondition Will then return both roots
*/
public double[] roots(){

	int a = coeff [2];
	int b = coeff [1];
	int c = coeff [0];

	double[] temp = new double[2];
	temp [0] = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
	temp [1] = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
	return temp;
	}

/**
* @precondition Must be called with a valid value
* @postcondition The functions with the argument x will be returned
*/

public double evaluate(double x){
	double total = 0;

	total += (coeff[0] * Math.pow(x,0));
	total += (coeff[1] * Math.pow(x,1));
	total += (coeff[2] * Math.pow(x,2));
	return total;
	}

/**
* @precondition Must be called by the Quadratic object
* @postcondition A readable string from the Quadratic object will be returned
*/

public String toString(){
    String str = "";
    for(int i=2; i>-1; i--) {
      if(i==0) {
        str += coeff[i];
      }
      else if(i ==1) {
        str += coeff[i] + "x + " ;
      }
      else if (coeff[i] <0) {
        str += " - " + coeff[i]*-1;
      }
      else 
        str += coeff[i] + "x^" + i + " + ";
      }
	return str;
      }
}
