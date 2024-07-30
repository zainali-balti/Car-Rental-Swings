package org.example.ui;

import org.example.services.UserAuthentication;

import javax.swing.*;
import java.awt.*;
import java.net.Authenticator;

public class Login {

    private final UserAuthentication userAuthentication = new UserAuthentication();
    public Login(){
        JFrame jFrame = new JFrame("LOGIN PAGE");
        jFrame.setLayout(new GridLayout(3,2,10,10));

        JLabel userName = new JLabel("User Name");
        JTextField uName = new JTextField();
        userName.setBounds(50,50,200,10);

        JLabel userPassword = new JLabel("Password");
        JPasswordField uPassword = new JPasswordField();
        uPassword.setBounds(50,100,200,10);

        JButton login  = new JButton("Login");
        login.setBounds(100,200,150,80);
        JButton newUser  = new JButton("New User");
        newUser.setBounds(100,200,150,80);

        login.addActionListener((event)->{
            if (userAuthentication.checkLogin(uName.getText(),uPassword.getText())){
                jFrame.dispose();
                new HomeUi();
            }
            else {
                JOptionPane.showMessageDialog(jFrame,"Sorry Can't Found");
            }
        });
        newUser.addActionListener(e->{
            jFrame.dispose();
            new NewUserLogin();
        });

        jFrame.add(userName);
        jFrame.add(uName);
        jFrame.add(userPassword);
        jFrame.add(uPassword);
        jFrame.add(login);
        jFrame.add(newUser);

        jFrame.setSize(500,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
