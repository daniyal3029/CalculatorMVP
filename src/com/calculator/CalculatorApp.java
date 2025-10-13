package com.calculator;

/**
 * This is a Glue class which contains main Function,
 * this starting point of the program after that the object starts being creating 
 * and called.
 */

public class CalculatorApp {
	
    public static void main(String[] args) {
        CalcultorModel model = new CalcultorModel();
        CalculatorGUI view = new CalculatorGUI();
        new CalculatorInputHandeling(view, model);

        view.setVisible(true);
    }
}

