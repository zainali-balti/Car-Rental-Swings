package org.example.ui;

import org.example.dao.CustomerDao;
import org.example.dao.VehicleDao;
import org.example.domain.Customer;
import org.example.mapper.CustomerMapper;
import org.example.services.BookingService;
import org.example.services.CustomerService;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class AddBooking {

    private final CustomerDao customerDao = new CustomerDao();
    private final VehicleDao vehicleDao = new VehicleDao();
    private final BookingService bookingService = new BookingService();
    JFrame frame = null;
    public AddBooking(){

        var customers = customerDao.getAll();
        var vehicles = vehicleDao.getAll();

        //Creating a Frame
        frame = new JFrame("Car Rental App - Add Booking");
        frame.setLayout(new GridLayout(6,2,10,10));


        // Create a new JComboBox
        JLabel customer = new JLabel("Customer");
        JComboBox<String> CustomerDropDown = new JComboBox<>();

        // Add items to the dropdown
        customers.stream().forEach(e -> {
            CustomerDropDown.addItem(e.getId() + ", " + e.getName());
        });

        // Set the default selection
        CustomerDropDown.setSelectedIndex(0);

        // Add the dropdown to the frame
        frame.add(customer);
        frame.add(CustomerDropDown);

        // Create a new JComboBox
        JLabel vehicle = new JLabel("Vehicle");
        JComboBox<String> vehicleDropDown = new JComboBox<>();

        // Add items to the dropdown
        vehicles.stream().forEach(e->{
            vehicleDropDown.addItem(e.getId() +", " +e.getName());
        });

        // Set the default selection
        vehicleDropDown.setSelectedIndex(0);

        // Add the dropdown to the frame
        frame.add(vehicle);
        frame.add(vehicleDropDown);


        //Creating Buttons
        JButton back = new JButton("Back");
        JButton save = new JButton("Save");


        // Date picker
        // Create a SQL date model
        SqlDateModel model = new SqlDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");

        // Create a JDatePanelImpl using the model and properties
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);


        // Create a JDatePickerImpl using the datePanel and formatter
        JLabel datePickerlb = new JLabel("Date");
        JDatePicker datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

//        JButton pickButton = new JButton("Pick Date");
//        pickButton.addActionListener(e -> pickDate(datePicker));
//        frame.add(pickButton);

        JLabel pricelb = new JLabel("Price");
        JTextField priceTf = new JTextField();
        priceTf.setBounds(50,400,200,40);


        JLabel statuslb = new JLabel("Status");
        JComboBox<String> statusDropDown = new JComboBox<>();
        statusDropDown.addItem("True");
        statusDropDown.addItem("Fale");
        statusDropDown.setSelectedIndex(0);

        //Adding to frame textfield and lable;

        frame.add(pricelb);
        frame.add(priceTf);

        //Adding to Frame
        frame.add(datePickerlb);
        frame.add((JComponent) datePicker);
        frame.add(statuslb);
        frame.add(statusDropDown);
        frame.add(save);
        frame.add(back);

        //Adding Action listener to Back Button
        back.addActionListener(event->{
            frame.dispose();
            new BookingUi();
        });

        // get id from JComboBox of Customer

//        System.out.println(selectedId);



//        System.out.println(selectedIdVehicle);


        //Adding Action Listener to Save Button
        save.addActionListener(e -> {
            try {
                String selectedItemOfCustomer = (String) CustomerDropDown.getSelectedItem();
                String[] cid = selectedItemOfCustomer.split(", ");
                String selectedId = cid[0];

                // get id from JComboBox of Vehicle
                String selectedItemOfVehicle = (String) vehicleDropDown.getSelectedItem();
                String[] vid = selectedItemOfVehicle.split(", ");
                String selectedIdVehicle = vid[0];

                String selectedStatus = (String) statusDropDown.getSelectedItem();

                Date selectedDate = (Date) datePicker.getModel().getValue();

                if (selectedDate != null) {
                    LocalDate localDate = LocalDate.ofEpochDay(selectedDate.getDate());

                    // Now you can pass selectedId and localDate to your save method

                    bookingService.save(selectedId,
                            selectedIdVehicle,localDate, Integer.valueOf(priceTf.getText()), selectedStatus);
                    JOptionPane.showMessageDialog(frame,"Yes Inserted Successfully");
                    frame.dispose();
                    new BookingUi();
                } else {
                    // Handle case when no date is selected
                    System.err.println("Please select a date.");
                }


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

//    private void pickDate(JDatePicker datePicker) {
//        // Retrieve selected date from the date picker
//        Date selectedDate = (Date) datePicker.getModel().getValue();
//        if (selectedDate != null) {
//            JOptionPane.showMessageDialog(frame, "Selected date: " + selectedDate);
//        } else {
//            JOptionPane.showMessageDialog(frame, "No date selected.");
//        }
//    }

    // Custom date formatter to display the date in the specified format
    static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private final String pattern = "yyyy-MM-dd";
        private final SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);

        @Override
        public Object stringToValue(String text) {
            try {
                return dateFormatter.parseObject(text);
            } catch (java.text.ParseException e) {
                return null;
            }
        }

        @Override
        public String valueToString(Object value) {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }
            return "";
        }
    }
}
