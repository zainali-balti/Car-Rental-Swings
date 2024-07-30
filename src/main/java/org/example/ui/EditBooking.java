package org.example.ui;

import org.example.services.BookingService;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class EditBooking {
    private final BookingService bookingService = new BookingService();
    public EditBooking(Object[] rowData, Object id) {
        JFrame frame = new JFrame("Car Rental App - Edit Booking");
        frame.setLayout(new GridLayout(7, 2, 10, 10));

        //Creating Labels
        JLabel idLb = new JLabel("Id");
        JLabel cidLb = new JLabel("C_id");
        JLabel vidLb = new JLabel("V_id");
        JLabel dateLb = new JLabel("BookingDate");
        JLabel priceLb = new JLabel("Price");
        JLabel statusLb = new JLabel("Status");


        //Creating TextFields
        JTextField idTf = new JTextField(20);
        JTextField cidTf = new JTextField(20);
        JTextField vidTf = new JTextField(20);
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
        JDatePicker datePicker = new JDatePickerImpl(datePanel,
                new AddBooking.DateLabelFormatter());
        JTextField priceTf = new JTextField(20);
        JTextField statusTf = new JTextField(20);



        //Creating Buttons
        JButton back = new JButton("Back");
        JButton update = new JButton("Update");

        // set value on TextField;
        idTf.setText((String) id);
        cidTf.setText(""+rowData[1]);
        vidTf.setText(""+rowData[2]);
        datePicker.setTextEditable(Boolean.parseBoolean(""+rowData[3]));
        priceTf.setText(""+rowData[4]);
        statusTf.setText(""+rowData[5]);


        update.addActionListener(e -> {
            Date selectedDate = (Date) datePicker.getModel().getValue();
            LocalDate localDate = LocalDate.ofEpochDay(selectedDate.getDate());
            bookingService.edit(Integer.valueOf(idTf.getText()),Integer.valueOf(cidTf.getText()),
                    Integer.valueOf(vidTf.getText()), localDate,
                    Integer. valueOf(priceTf.getText()),statusTf.getText());
            frame.dispose();
            new BookingUi();

        });


        //Adding to Frame

        frame.add(idLb);
        frame.add(idTf);

        frame.add(cidLb);
        frame.add(cidTf);

        frame.add(vidLb);
        frame.add(vidTf);

        frame.add(dateLb);
        frame.add((Component) datePicker);

        frame.add(statusLb);
        frame.add(statusTf);

        frame.add(priceLb);
        frame.add(priceTf);


        frame.add(update);
        frame.add(back);

        //Adding Action listener to Back Button
        back.addActionListener(event -> {
            frame.dispose();
            new BookingUi();
        });

        //Adding Action Listener to Save Button


        //Basic Properties
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
//    static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
//        private final String pattern = "yyyy-MM-dd";
//        private final SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
//
//        @Override
//        public Object stringToValue(String text) {
//            try {
//                return dateFormatter.parseObject(text);
//            } catch (java.text.ParseException e) {
//                return null;
//            }
//        }
//
//        @Override
//        public String valueToString(Object value) {
//            if (value != null) {
//                Calendar cal = (Calendar) value;
//                return dateFormatter.format(cal.getTime());
//            }
//            return "";
//        }
//    }

}
