package org.example.ui;

import org.example.services.UserAuthentication;

import javax.swing.*;
import java.awt.*;

public class UserEdit {
    private final UserAuthentication userAuthentication = new UserAuthentication();
    public UserEdit(Object[] objects,Object id){

        JFrame frame = new JFrame("Car Rental App - Edit Customer");
        frame.setLayout(new GridLayout(5,2,10,10));

        //Creating Labels
        JLabel idLb = new JLabel("Id");
        JLabel nameLb = new JLabel("Name");
        JLabel passLb = new JLabel("Password");
        JLabel conPassLb = new JLabel("Confirm Password");



        //Creating TextFields
        JTextField idTf = new JTextField(20);
        JTextField nameTf = new JTextField(20);
        JTextField passTf = new JTextField(20);
        JTextField conPassTf = new JTextField(20);


        idTf.setText((String) id);
        nameTf.setText(""+objects[1]);
        passTf.setText(""+objects[2]);
        conPassTf.setText(""+objects[3]);





        //Creating Buttons
        JButton back = new JButton("Back");
        JButton update = new JButton("Update");


        update.addActionListener(e->{
            userAuthentication.update(Integer.valueOf(idTf.getText()),nameTf.getText(),
                    passTf.getText(),conPassTf.getText());
            frame.dispose();
            new UserUi();

        });


        //Adding to Frame

        frame.add(idLb);
        frame.add(idTf);

        frame.add(nameLb);
        frame.add(nameTf);

        frame.add(passLb);
        frame.add(passTf);

        frame.add(conPassLb);
        frame.add(conPassTf);

        frame.add(update);
        frame.add(back);

        //Adding Action listener to Back Button
        back.addActionListener(event->{
            frame.dispose();
            new UserUi();
        });

        //Adding Action Listener to Save Button



        //Basic Properties
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
