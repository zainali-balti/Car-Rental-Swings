package org.example.ui;

import org.example.services.UserAuthentication;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserUi {
    private final UserAuthentication userAuthentication  = new UserAuthentication();
    public UserUi(){
        JFrame jFrame = new JFrame("User UI");
        JPanel jPanel1 = new JPanel();
        JTextField search = new JTextField(30);
        jPanel1.add(search);

        jPanel1.setLayout(new FlowLayout(FlowLayout.LEADING));
        JPanel jPanel2 = new JPanel();
        String data[][]= userAuthentication.getAllUserInJTable();
        String column[]={"ID","NAME","PASSWORD","CONFIRM PASSWORD"};
        DefaultTableModel dataModel = new DefaultTableModel(data,column);
        JTable table=new JTable(dataModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(table);
        jPanel2.add(sp);
        jPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));


        // Buttons Panel
        JPanel jPanel3 = new JPanel();
        JButton add = new JButton("Add");
        add.setBounds(40,40,200,80);
        add.setBackground(Color.YELLOW);
        JButton edit = new JButton("Edit");
        edit.setBounds(40,40,200,80);
        edit.setBackground(Color.GREEN);
        JButton delete = new JButton("Delete");
        delete.setBounds(40,40,200,80);
        delete.setBackground(Color.GRAY);
        JButton back = new JButton("Back");
        back.setBounds(40,40,200,80);
        back.setBackground(Color.RED);

        // Add Button
        add.addActionListener(e->{
            jFrame.dispose();
            new NewUserLogin();
        });



        // Edit Button

        edit.addActionListener(e->{

            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                Object[] rowData = new Object[dataModel.getColumnCount()];
                for (int i = 0; i <dataModel.getColumnCount(); i++) {
                    rowData[i] = dataModel.getValueAt(selectedRow, i);
                }
                new UserEdit(rowData,rowData[0]);

            } else {
                JOptionPane.showMessageDialog(jFrame, "No row selected.");
            }
            jFrame.dispose();
        });




        // Delete Button
        delete.addActionListener(e -> {
            if (table.getRowCount() != 0) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRow);
                    Object[] rowData = new Object[dataModel.getColumnCount()];
                    rowData[0] = dataModel.getValueAt(selectedRow,0);
                    Integer id = Integer.parseInt(""+rowData[0]);
                    userAuthentication.delete(id);
                    JOptionPane.showMessageDialog(jFrame, "Row removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(jFrame, "Please select a row to remove.");
                }
            } else {
                JOptionPane.showMessageDialog(jFrame, "Please fill the table.");
            }
        });




        // Back Button
        back.addActionListener(e->{
            jFrame.dispose();
            new HomeUi();
        });


        jPanel3.add(add);
        jPanel3.add(edit);
        jPanel3.add(delete);
        jPanel3.add(back);

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
                String[][] data = userAuthentication.searchByName(search.getText());
                DefaultTableModel dataModel = new DefaultTableModel(data,column);
                table.setModel(dataModel);
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

