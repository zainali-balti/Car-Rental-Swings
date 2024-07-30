package org.example.ui;

import org.example.services.BookingService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BookingUi {
    private final BookingService bookingService = new BookingService();
    public BookingUi() {
        //Creating a Frame
        JFrame jFrame = new JFrame("Booking UI");

        JPanel jPanel2 = new JPanel();
        String data[][]= bookingService.getAllBookingInJTable();
        String column[]={"ID","CID","VID","BOOKING_DATE","PRICE","STATUS"};
        DefaultTableModel df = new DefaultTableModel(data,column);
        JTable jt=new JTable(df);
        jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        jPanel2.add(sp);
        jPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));


        JPanel jPanel3 = new JPanel();
        JButton add = new JButton("Add");
        add.setBounds(40,40,200,80);

        // Add Button
        add.addActionListener(e->{
            jFrame.dispose();
            new AddBooking();
        });

        add.setBackground(Color.YELLOW);
        JButton edit = new JButton("Edit");
        edit.setBounds(40,40,200,80);
        edit.setBackground(Color.GREEN);

        // Edit Button

        edit.addActionListener(e->{

            int selectedRow = jt.getSelectedRow();
            if (selectedRow != -1) {
                Object[] rowData = new Object[df.getColumnCount()];
                for (int i = 0; i < df.getColumnCount(); i++) {
                    rowData[i] = df.getValueAt(selectedRow, i);
                }
                new EditBooking(rowData,rowData[0]);
            } else {
                JOptionPane.showMessageDialog(jFrame, "No row selected.");
            }
            jFrame.dispose();

        });


        JButton delete = new JButton("Delete");
        delete.setBounds(40,40,200,80);
        delete.setBackground(Color.GRAY);

        // Delete Button
        delete.addActionListener(e -> {
            if (jt.getRowCount() != 0) {
                int selectedRow = jt.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) jt.getModel();
                    model.removeRow(selectedRow);
                    Object[] rowData = new Object[df.getColumnCount()];
                    rowData[0] = df.getValueAt(selectedRow,0);
                    long id = Long.parseLong(""+rowData[0]);
                    bookingService.remove(id);
                    JOptionPane.showMessageDialog(jFrame, "Row removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(jFrame, "Please select a row to remove.");
                }
            } else {
                JOptionPane.showMessageDialog(jFrame, "Please fill the table.");
            }

        });


        JButton back = new JButton("Back");
        back.setBounds(40,40,200,80);
        back.setBackground(Color.RED);

        // Back Button
        back.addActionListener(e->{
            jFrame.dispose();
            new HomeUi();
        });


        jPanel3.add(add);
        jPanel3.add(edit);
        jPanel3.add(delete);
        jPanel3.add(back);



        jPanel3.setLayout(new FlowLayout());
        jFrame.add(jPanel2,BorderLayout.EAST);
        jFrame.add(jPanel3,BorderLayout.WEST);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500,600);

    }
    }

