package com.company;

import org.intellij.lang.annotations.Pattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI extends JFrame {


    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean validatePattern(String str, Pattern pattern) {
        return !pattern.matcher(str).matches();
    }

    private JButton button = new JButton("Finish");
    private JTextField input = new JTextField("", 5);
    private JTextField input1 = new JTextField("", 5);
    private JTextField input2 = new JTextField("", 5);
    private JTextField input3 = new JTextField("", 5);
    private JTextField input4 = new JTextField("", 5);


    private JLabel label = new JLabel("Input name");
    private JLabel label1 = new JLabel("Input surname");
    private JLabel label2 = new JLabel("Input age ");
    private JLabel label3 = new JLabel("Input email");
    private JLabel label4 = new JLabel("Input password");

    private JRadioButton radio1 = new JRadioButton("male");
    private JRadioButton radio2 = new JRadioButton("female");
    private JCheckBox check = new JCheckBox("Check", false);

    public SimpleGUI (){
        super ("Simple Example");
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 2 ,2 ,2));
        container.add(label);
        container.add(input);
        String name = input.getText();

        Container container1 = this.getContentPane();
        container.setLayout(new GridLayout(4, 2 ,2 ,2));
        container1.add(label1);
        container1.add(input1);
        String surname = input1.getText();


        Container container2 = this.getContentPane();
        container.setLayout(new GridLayout(4, 2 ,2 ,2));
        container.add(label2);
        container.add(input2);
        String age = input2.getText();

        Container container3 = this.getContentPane();
        container.setLayout(new GridLayout(4, 2 ,2 ,2));
        container.add(label3);
        container.add(input3);
        String email = input3.getText();

        Container container4 = this.getContentPane();
        container.setLayout(new GridLayout(4, 2,2 ,2));
        container.add(label4);
        container.add(input4);
        String password = input4.getText();

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);


        if (isNullOrEmpty(name) || isNullOrEmpty(password)|| isNullOrEmpty(age) || isNullOrEmpty(email) || isNullOrEmpty(password)) {
            System.out.println("Please fill all fields.");
            return;
        }

        if (validatePattern(email, Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))) {
            System.out.println("Email is not valid.");
            return;
        }

    }
    class ButtonEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String message = "";
            message +=  "Registration finished\n";
            message += "Name is " + input.getText() + "\n";
            message += "Surname is " + input1.getText() + "\n";
            message += "Age is " + input2.getText() + "\n";
            message += "Email is " + input3.getText() + "\n";
            message += "Password is " + input4.getText() + "\n";
            message += (radio1.isSelected() ? "male " + "is selected!\n " : "female " + "is selected!\n") ;
            message += "Checkbox is " + ((check.isSelected()) ? "checked" : "unchecked");
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }




}
