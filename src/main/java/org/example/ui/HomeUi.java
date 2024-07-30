package org.example.ui;

import javax.swing.*;
import java.awt.*;

public class HomeUi {

    public HomeUi(){
        JFrame jFrame = new JFrame("HOME PAGE");

        JPanel jPanel = new JPanel();
        JButton customerDetails = new JButton("Customer Details");
        JButton vehicleDetails = new JButton("Vehicle Details");
        JButton userDetails = new JButton("User Details");
        JButton bookingDetails = new JButton("Booking Details");
        JButton vehicleOwnerDetails = new JButton("Vehicle_owner Details");
        JButton report = new JButton("Repots");
        JButton commission = new JButton("Commission");
        JButton carAvailability = new JButton("Car Availability");
        JButton back = new JButton("Back");

        customerDetails.addActionListener(e->{
            new CustomerUi();
            jFrame.dispose();
        });
        vehicleDetails.addActionListener(e->{
            new VehicleUi();
            jFrame.dispose();
        });
        back.addActionListener(e -> {
            new Login();
            jFrame.dispose();
        });
        vehicleOwnerDetails.addActionListener(e->{
            new Vehicle_OwnerUi();
            jFrame.dispose();
        });
        bookingDetails.addActionListener(e->{
            jFrame.dispose();
            new BookingUi();
        });
        userDetails.addActionListener(e->{
            jFrame.dispose();
            new UserUi();
        });
        carAvailability.addActionListener(e->{
            jFrame.dispose();
            new AvailabilityVehicleUi();
        });
        commission.addActionListener(e->{
            jFrame.dispose();
            new OwnerCommissionUi();
        });

        jPanel.add(userDetails);
        jPanel.add(customerDetails);
        jPanel.add(vehicleDetails);
        jPanel.add(vehicleOwnerDetails);
        jPanel.add(bookingDetails);
        jPanel.add(report);
        jPanel.add(commission);
        jPanel.add(carAvailability);
        jPanel.add(back);

        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50,100));
        jFrame.setLayout(new GridLayout());
        jFrame.add(jPanel);

        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1000,700);
    }

}
