package org.example.ui;

import org.example.services.VehicleService;

import javax.swing.*;
import java.awt.*;

public class AddVehicle {
    private final VehicleService vehicleService = new VehicleService();
    public AddVehicle(){
        //Creating a Frame
        JFrame frame = new JFrame("Car Rental App - Add Vehicle");
        frame.setLayout(new GridLayout(6,2,10,10));

        //Creating Labels
        JLabel nameLb = new JLabel("Name");
        JLabel model = new JLabel("Model");
        JLabel brand = new JLabel("Brand");
        JLabel color = new JLabel("Color");
        JLabel oId = new JLabel("O_id");


        //Creating TextFields
        JTextField nameTf = new JTextField(20);
        JTextField modelTf = new JTextField(20);
        JTextField brandTf = new JTextField(20);
        JTextField colorTf = new JTextField(20);
        JTextField oidTf = new JTextField(20);


        //Creating Buttons
        JButton back = new JButton("Back");
        JButton save = new JButton("Save");

        save.addActionListener(e->{
            vehicleService.save(nameTf.getText(),Integer.parseInt(""+modelTf.getText()),
                    brandTf.getText(),colorTf.getText(),Integer.parseInt(""+oidTf.getText()));
            frame.dispose();
            new VehicleUi();
        });

        //Adding to Frame
        frame.add(nameLb);
        frame.add(nameTf);

        frame.add(model);
        frame.add(modelTf);

        frame.add(brand);
        frame.add(brandTf);

        frame.add(color);
        frame.add(colorTf);

        frame.add(oId);
        frame.add(oidTf);


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
                vehicleService.save(nameTf.getText(), Integer.valueOf(modelTf.getText()),
                        brandTf.getText(), colorTf.getText(), Integer.valueOf(oidTf.getText()));
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
