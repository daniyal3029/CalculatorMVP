package com.calculator;


/**
 * This class is responsible to provide the GUI,
 * this part is basically view in MVP Model.
 */

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorGUI extends Frame {

	private TextField txt1 = new TextField(10);

    private Button addBtn = new Button("+");
    private Button subBtn = new Button("-");
    private Button mulBtn = new Button("*");
    private Button divBtn = new Button("/");
    private Button powBtn = new Button("^");
    private Button negBtn = new Button("±");
    private Button factBtn = new Button("!");
    private Button equalBtn = new Button("=");

    private ArrayList<Button> numButtons = new ArrayList<>();

    public CalculatorGUI() {
        this.setSize(200, 200);
        this.setLayout(new FlowLayout());

        this.add(getTxt1());

        // Create number buttons through loop using an ArrayList
        for (int i = 0; i < 10; i++) {
            Button btn = new Button(String.valueOf(i));
            btn.setActionCommand(String.valueOf(i));
            numButtons.add(btn);
            this.add(btn);
        }

        this.add(addBtn);
        this.add(subBtn);
        this.add(mulBtn);
        this.add(divBtn);
        this.add(powBtn);
        this.add(negBtn);
        this.add(factBtn);
        this.add(equalBtn);
    }

    // function to connect action listeners
    public void addActionListener(ActionListener listener){
        for (Button b : numButtons) b.addActionListener(listener);
        addBtn.addActionListener(listener);
        subBtn.addActionListener(listener);
        mulBtn.addActionListener(listener);
        divBtn.addActionListener(listener);
        powBtn.addActionListener(listener);
        negBtn.addActionListener(listener);
        factBtn.addActionListener(listener);
        equalBtn.addActionListener(listener);
    }

    public String getInputText(){
    	return getTxt1().getText(); 
    }
    
    public void setInputText(String text){ 
    	getTxt1().setText(text); 
    }

	public TextField getTxt1() {
		return txt1;
	}

	public void setTxt1(TextField txt1) {
		this.txt1 = txt1;
	}
}
