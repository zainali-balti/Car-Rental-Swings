package org.example.ui;

import javax.swing.*;
import java.awt.*;

public class VehicleEdit {
    public VehicleEdit(){
        JFrame frame = new JFrame("Car Rental App - Edit Vehicle");
        frame.setLayout(new GridLayout(6,2,10,10));

        //Creating Labels
        JLabel nameLb = new JLabel("Name");
        JLabel modelLb = new JLabel("Model");
        JLabel brandLb = new JLabel("Brand");
        JLabel colorLb = new JLabel("Color");
        JLabel oidLb = new JLabel("Oid");


        //Creating TextFields
        JTextField nameTf = new JTextField(20);
        JTextField modelTf = new JTextField(20);
        JTextField brandTf = new JTextField(20);
        JTextField colorTf = new JTextField(20);
        JTextField oidTf = new JTextField(20);



        //Creating Buttons
        JButton back = new JButton("Back");
        JButton update = new JButton("Update");

        //Adding to Frame
        frame.add(nameLb);
        frame.add(nameTf);

        frame.add(modelLb);
        frame.add(modelTf);

        frame.add(brandLb);
        frame.add(brandTf);

        frame.add(colorLb);
        frame.add(colorTf);

        frame.add(oidLb);
        frame.add(oidTf);



        frame.add(update);
        frame.add(back);

        //Adding Action listener to Back Button
        back.addActionListener(event->{
            frame.dispose();
            new CustomerUi();
        });

        //Adding Action Listener to Save Button



        //Basic Properties
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

}
