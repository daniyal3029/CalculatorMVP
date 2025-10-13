package com.calculator;


/**
 * This class is responsible to perform functions of Calculator,
 * It basically contains the Business Logic of Model MVP.
 */

public class CalcultorModel {
	
	private CalculatorGUI gui;

    public double add(double a, double b) {
    	return a + b; }
    
    public double subtract(double a, double b) {
    	return a - b; }
    
    public double multiply(double a, double b) {
    	return a * b; }
    
    public double divide(double a, double b) {
        if (b == 0) {
        	gui.getTxt1().setText("Error");
        	throw new ArithmeticException("ERROR"); }
        return a / b; 
    }
    
    public double power(double a, double b) {
    	return Math.pow(a, b); }
    
    public double negate(double a) {
    	return -a; }

    public long factorial(int n) {
    	gui.getTxt1().setText("Error");
        if (n < 0) throw new IllegalArgumentException("ERROR");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            
            if (result < 0) {
            gui.getTxt1().setText("Error");
            throw new ArithmeticException("Overflow ERROR"); }
        }
        return result;
    }
}
