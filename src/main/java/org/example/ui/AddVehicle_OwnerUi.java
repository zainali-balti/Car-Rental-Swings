package org.example.ui;

import org.example.services.Vehicle_Owner_Service;

import javax.swing.*;
import java.awt.*;

public class AddVehicle_OwnerUi {
    private final Vehicle_Owner_Service vehicleService = new Vehicle_Owner_Service();
    public AddVehicle_OwnerUi(){
        JFrame frame = new JFrame("Car Rental App - Add Vehicle Owner");
        frame.setLayout(new GridLayout(6,2,10,10));

        //Creating Labels
        JLabel nameLb = new JLabel("Name");
        JLabel phoneLb = new JLabel("Phone Number");
        JLabel cnicLb = new JLabel("CNIC");
        JLabel addressLb = new JLabel("Address");
        JLabel comLb = new JLabel("Commission");


        //Creating TextFields
        JTextField nameTf = new JTextField(20);
        JTextField phoneTf = new JTextField(20);
        JTextField cnicTf = new JTextField(20);
        JTextField addressTf = new JTextField(20);
        JTextField comTf = new JTextField(20);


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

        frame.add(comLb);
        frame.add(comTf);


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
                vehicleService.save(nameTf.getText(), cnicTf.getText(), addressTf.getText(), phoneTf.getText(), Integer.valueOf(comTf.getText()));
                JOptionPane.showMessageDialog(frame,"Yes Inserted Successfully");
                frame.dispose();
                new Vehicle_OwnerUi();
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
