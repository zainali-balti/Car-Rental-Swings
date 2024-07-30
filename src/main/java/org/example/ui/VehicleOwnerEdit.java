package org.example.ui;

import org.example.services.Vehicle_Owner_Service;

import javax.swing.*;
import java.awt.*;

public class VehicleOwnerEdit {
    private final Vehicle_Owner_Service vehicleOwnerService = new Vehicle_Owner_Service();
    public VehicleOwnerEdit(Object[] obj, Object id){
        JFrame frame = new JFrame("Car Rental App - Edit VehicleOwner");
        frame.setLayout(new GridLayout(7,2,10,10));

        //Creating Labels
        JLabel idLb = new JLabel("Id");
        JLabel nameLb = new JLabel("Name");
        JLabel phoneLb = new JLabel("Phone Number");
        JLabel cnicLb = new JLabel("CNIC");
        JLabel addressLb = new JLabel("Address");
        JLabel commissionLb = new JLabel("Commission");


        //Creating TextFields
        JTextField idTf = new JTextField(20);
        JTextField nameTf = new JTextField(20);
        JTextField phoneTf = new JTextField(20);
        JTextField cnicTf = new JTextField(20);
        JTextField addressTf = new JTextField(20);
        JTextField commissionTf = new JTextField(20);


        idTf.setText((String) id);
        nameTf.setText(""+obj[1]);
        phoneTf.setText(""+obj[2]);
        cnicTf.setText(""+obj[3]);
        addressTf.setText(""+obj[4]);
        commissionTf.setText(""+obj[5]);

        //Creating Buttons
        JButton back = new JButton("Back");
        JButton update = new JButton("Update");
        update.addActionListener(e->{

            vehicleOwnerService.update(nameTf.getText(),phoneTf.getText(),cnicTf.getText(),
                    addressTf.getText(), Integer.valueOf(commissionTf.getText()),Long.parseLong(""+idTf.getText()));

            frame.dispose();
            new Vehicle_OwnerUi();


        });


        //Adding to Frame
        frame.add(idLb);
        frame.add(idTf);

        frame.add(nameLb);
        frame.add(nameTf);

        frame.add(phoneLb);
        frame.add(phoneTf);

        frame.add(cnicLb);
        frame.add(cnicTf);

        frame.add(addressLb);
        frame.add(addressTf);

        frame.add(commissionLb);
        frame.add(commissionTf);


        frame.add(update);
        frame.add(back);

        //Adding Action listener to Back Button
        back.addActionListener(event->{
            frame.dispose();
            new Vehicle_OwnerUi();
        });

        //Adding Action Listener to Save Button



        //Basic Properties
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

}
