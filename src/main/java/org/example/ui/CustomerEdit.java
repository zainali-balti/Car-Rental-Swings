package org.example.ui;

import org.example.services.CustomerService;

import javax.swing.*;
import java.awt.*;

public class CustomerEdit{
//    private  final CustomerUi customerUi = new CustomerUi();
    private final CustomerService customerService = new CustomerService();
    public CustomerEdit(Object[] obj, Object rowDatum){
        JFrame frame = new JFrame("Car Rental App - Edit Customer");
        frame.setLayout(new GridLayout(6,2,10,10));

        //Creating Labels
        JLabel idLb = new JLabel("Id");
        JLabel nameLb = new JLabel("Name");
        JLabel phoneLb = new JLabel("Phone Number");
        JLabel cnicLb = new JLabel("CNIC");
        JLabel addressLb = new JLabel("Address");


        //Creating TextFields
        JTextField idTf = new JTextField(20);
        JTextField nameTf = new JTextField(20);
        JTextField phoneTf = new JTextField(20);
        JTextField cnicTf = new JTextField(20);
        JTextField addressTf = new JTextField(20);

        idTf.setText((String) rowDatum);
        nameTf.setText(""+obj[1]);
        phoneTf.setText(""+obj[2]);
        cnicTf.setText(""+obj[3]);
        addressTf.setText(""+obj[4]);





        //Creating Buttons
        JButton back = new JButton("Back");
        JButton update = new JButton("Update");


        update.addActionListener(e->{
//            nameTf.setText(""+obj[0]);
//            phoneTf.setText(""+obj[1]);
//            cnicTf.setText(""+obj[2]);
//            addressTf.setText(""+obj[3]);
            customerService.update(nameTf.getText(),phoneTf.getText()
                    ,cnicTf.getText(),addressTf.getText(), Long.parseLong(""+rowDatum) );

            frame.dispose();
            new CustomerUi();

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