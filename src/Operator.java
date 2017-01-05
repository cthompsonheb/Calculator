/***************************************
 * Simple class used to determine which
 * operation should be performed, and 
 * return the result of that operation
 **************************************/

public class Operator{
	
	private double add(double num1, double num2){
		return num1+num2;
	}
	
	private double sub(double num1, double num2){
		return num1-num2;
	}
	
	private double div(double num1, double num2){
		return num1/num2;
	}
	
	private double mult(double num1, double num2){
		return num1*num2;
	}
	
	double result(double num1, double num2, int operator){
		if(operator == 1) return add(num1, num2);
		else if(operator==2) return sub(num1, num2);
		else if(operator==3) return mult(num1, num2);
		else return div(num1, num2);
	}
}