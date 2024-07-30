package org.example.ui;

import org.example.services.CustomerService;

import javax.swing.*;
import java.awt.*;

public class AddCustomer {
    private final CustomerService customerService = new CustomerService();
    public AddCustomer() {
        //Creating a Frame
        JFrame frame = new JFrame("Car Rental App - Add Customer");
        frame.setLayout(new GridLayout(6,2,10,10));

        //Creating Labels
        JLabel nameLb = new JLabel("Name");
        JLabel phoneLb = new JLabel("Phone Number");
        JLabel cnicLb = new JLabel("CNIC");
        JLabel addressLb = new JLabel("Address");


        //Creating TextFields
        JTextField nameTf = new JTextField(20);
        JTextField phoneTf = new JTextField(20);
        JTextField cnicTf = new JTextField(20);
        JTextField addressTf = new JTextField(20);


        //Creating Buttons
        JButton back = new JButton("Back");
        JButton save = new JButton("Save");

        //Adding to Frame
        frame.add(nameLb);
        frame.add(nameTf);

        frame.add(phoneLb);
        frame.add(phoneTf);

        frame.add(cnicLb);
        frame.add(cnicTf);

        frame.add(addressLb);
        frame.add(addressTf);


        frame.add(save);
        frame.add(back);

        //Adding Action listener to Back Button
        back.addActionListener(event->{
            frame.dispose();
            new CustomerUi();
        });

        //Adding Action Listener to Save Button
        save.addActionListener(e -> {
            try {
                customerService.save(nameTf.getText(), cnicTf.getText(), addressTf.getText(), phoneTf.getText());
                JOptionPane.showMessageDialog(frame,"Yes Inserted Successfully");
                frame.dispose();
                new CustomerUi();
            }catch (Exception exception){
                JOptionPane.showMessageDialog(frame,"Unable to save. Something Went Wrong");
            }
        });



        //Basic Properties
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
