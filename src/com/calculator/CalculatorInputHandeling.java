package com.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for input handling of the Calculator
 * this is basically presentation part of an MVP model.
 */

public class CalculatorInputHandeling implements ActionListener {
	
    private CalculatorGUI view;
    private CalcultorModel model;
    private String number1 = null;
    private String operation = null;

    public CalculatorInputHandeling(CalculatorGUI view, CalcultorModel model) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
            // For numbers 
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    view.setInputText(view.getInputText() + cmd);
                    break;

                case "+":
                    operation = "add";
                    number1 = view.getInputText();
                    view.setInputText("");
                    break;
                case "-":
                    operation = "subtract";
                    number1 = view.getInputText();
                    view.setInputText("");
                    break;
                case "*":
                    operation = "multiply";
                    number1 = view.getInputText();
                    view.setInputText("");
                    break;
                case "/":
                    operation = "divide";
                    number1 = view.getInputText();
                    view.setInputText("");
                    break;
                case "^":
                    operation = "power";
                    number1 = view.getInputText();
                    view.setInputText("");
                    break;

                case "±":
                    if (!view.getInputText().isEmpty()){
                        double val = Double.parseDouble(view.getInputText());
                        view.setInputText(String.valueOf(model.negate(val)));
                    }
                    break;

                case "!":
                    if (!view.getInputText().isEmpty()) {
                        int val = Integer.parseInt(view.getInputText());
                        view.setInputText(String.valueOf(model.factorial(val)));
                    }
                    break;

                case "=":
                    if (number1 != null && !view.getInputText().isEmpty() && operation != null) {
                        double num1 = Double.parseDouble(number1);
                        double num2 = Double.parseDouble(view.getInputText());
                        double result = 0;

                        switch (operation) {
                        
                            case "add":
                            	result = model.add(num1, num2);
                            break;
                            
                            case "subtract":
                            	result = model.subtract(num1, num2);
                            break;
                            
                            case "multiply":
                            	result = model.multiply(num1, num2);
                            	break;
                            	
                            case "divide":
                            	result = model.divide(num1, num2);
                            	break;
                            	
                            case "power":
                            	result = model.power(num1, num2);
                            	break;
                        }
                        view.setInputText(String.valueOf(result));
                    }
                    break;
            }
        } catch (Exception ex) {
            view.setInputText("Error");
        }
    }
}
