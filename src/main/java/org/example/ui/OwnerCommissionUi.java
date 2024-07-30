package org.example.ui;

import org.example.dao.OwnerCommissionDao;
import org.example.services.OwnerCommissionService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OwnerCommissionUi {
    private final OwnerCommissionService ownerCommissionService = new OwnerCommissionService();
    public OwnerCommissionUi(){
        JFrame jFrame = new JFrame("Owner-Commission UI");

        JPanel tablePanel = new JPanel();
        String data[][]= ownerCommissionService.getAllCarAvailable();
        String column[]={"ID","NAME","Commission","b_id"};
        DefaultTableModel dataModel = new DefaultTableModel(data,column);
        JTable table =new JTable(dataModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setBounds(30,40,200,300);
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);
        tablePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));


        JPanel buttonPanel = new JPanel();
        JButton back = new JButton("Back");
        back.setBounds(40,40,200,80);
        back.setBackground(Color.GREEN);

        // Back Button
        back.addActionListener(e->{
            jFrame.dispose();
            new HomeUi();
        });


        buttonPanel.add(back);



        buttonPanel.setLayout(new FlowLayout());
        jFrame.add(tablePanel,BorderLayout.NORTH);
        jFrame.add(buttonPanel,BorderLayout.EAST);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500,600);
    }
}
