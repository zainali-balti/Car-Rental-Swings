package org.example.ui;

import org.example.services.UserAuthentication;

import javax.swing.*;
import java.awt.*;

public class NewUserLogin {
    private final UserAuthentication userAuthentication = new UserAuthentication();
    public NewUserLogin(){
        JFrame jFrame = new JFrame("New User Login PAGE");
        jFrame.setLayout(new GridLayout(4,2,10,10));

        JLabel userName = new JLabel("User Name");
        JTextField uName = new JTextField();
        userName.setBounds(50,50,200,10);

        JLabel userPassword = new JLabel("Password");
        JPasswordField uPassword = new JPasswordField();
        uPassword.setBounds(50,100,200,10);

        JLabel confPassword = new JLabel("Confirm Password");
        JPasswordField cPassword = new JPasswordField();
        uPassword.setBounds(50,100,200,10);

        JButton login  = new JButton("Login");
        login.setBounds(100,200,150,80);
        JButton back  = new JButton("Back");
        back.setBounds(100,200,150,80);

        login.addActionListener(e->{
            if (uName.getText() == " " || uPassword.getText() == " " || cPassword.getText() == " "){
                JOptionPane.showMessageDialog(jFrame,"Please Fill All " +
                        "The Fields");
            }
            else{
                if (uPassword.getText().equalsIgnoreCase(cPassword.getText())){
                    userAuthentication.save(uName.getText(),uPassword.getText(),cPassword.getText());
                    jFrame.dispose();
                    new HomeUi();
                }
                else {
                    JOptionPane.showMessageDialog(jFrame,"Please Enter Same " +
                            "Password and ConfirmPassword");
                }
            }
        });



        jFrame.add(userName);
        jFrame.add(uName);
        jFrame.add(userPassword);
        jFrame.add(uPassword);
        jFrame.add(confPassword);
        jFrame.add(cPassword);
        jFrame.add(login);
        jFrame.add(back);

        jFrame.setSize(500,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }
}
