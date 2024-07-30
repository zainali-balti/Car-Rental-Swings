package org.example.ui;

import org.example.services.CustomerService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomerUi {
    private final CustomerService customerService = new CustomerService();
    public CustomerUi(){
        JFrame jFrame = new JFrame("Customer UI");
        JPanel jPanel1 = new JPanel();
        JTextField search = new JTextField(30);
        jPanel1.add(search);

        jPanel1.setLayout(new FlowLayout(FlowLayout.LEADING));
        JPanel jPanel2 = new JPanel();
        String data[][]= customerService.getAllCustomerInJTable();
        String column[]={"ID","NAME","PHONE_NUMBER","CNIC","ADDRESS"};
        DefaultTableModel df = new DefaultTableModel(data,column);
        JTable jt=new JTable(df);
        jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        jPanel2.add(sp);
        jPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));


        JPanel jPanel3 = new JPanel();
        JButton btn1 = new JButton("Add");
        btn1.setBounds(40,40,200,80);

        // Add Button
        btn1.addActionListener(e->{
            jFrame.dispose();
            new AddCustomer();
        });

        btn1.setBackground(Color.YELLOW);
        JButton btn2 = new JButton("Edit");
        btn1.setBounds(40,40,200,80);
        btn2.setBackground(Color.GREEN);

        // Edit Button

        btn2.addActionListener(e->{

                    int selectedRow = jt.getSelectedRow();
                    if (selectedRow != -1) {
                        Object[] rowData = new Object[df.getColumnCount()];
                        for (int i = 0; i < df.getColumnCount(); i++) {
                            rowData[i] = df.getValueAt(selectedRow, i);
                        }
                            new CustomerEdit(rowData,rowData[0]);

                    } else {
                        JOptionPane.showMessageDialog(jFrame, "No row selected.");
                    }
            jFrame.dispose();
        });


        JButton btn3 = new JButton("Delete");
        btn1.setBounds(40,40,200,80);
        btn3.setBackground(Color.GRAY);

        // Delete Button
        btn3.addActionListener(e -> {
            if (jt.getRowCount() != 0) {
                int selectedRow = jt.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) jt.getModel();
                    model.removeRow(selectedRow);
                    Object[] rowData = new Object[df.getColumnCount()];
                    rowData[0] = df.getValueAt(selectedRow,0);
                    long id = Long.parseLong(""+rowData[0]);
                    customerService.remove(id);
                    JOptionPane.showMessageDialog(jFrame, "Row removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(jFrame, "Please select a row to remove.");
                }
            } else {
                JOptionPane.showMessageDialog(jFrame, "Please fill the table.");
            }
        });


        JButton btn4 = new JButton("Back");
        btn1.setBounds(40,40,200,80);
        btn4.setBackground(Color.RED);

        // Back Button
        btn4.addActionListener(e->{
            jFrame.dispose();
            new HomeUi();
        });


        jPanel3.add(btn1);
        jPanel3.add(btn2);
        jPanel3.add(btn3);
        jPanel3.add(btn4);

        // Search Bar
        search.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String[][] data = customerService.searchByName(search.getText());
                DefaultTableModel df = new DefaultTableModel(data,column);
                jt.setModel(df);
            }
        });


        jPanel3.setLayout(new FlowLayout());
        jFrame.add(jPanel1,BorderLayout.NORTH);
        jFrame.add(jPanel2,BorderLayout.EAST);
        jFrame.add(jPanel3,BorderLayout.WEST);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500,600);

    }
}
