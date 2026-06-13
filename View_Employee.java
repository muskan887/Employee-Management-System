package Employee.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class View_Employee extends JFrame implements ActionListener {
    JTable table;
    Choice choiceEMP;
    JButton search, print, update, back;

    View_Employee() {
        getContentPane().setBackground(new Color(255, 131, 122));
        setLayout(null);

        JLabel searchLabel = new JLabel("Search by employee id");
        searchLabel.setBounds(20, 20, 200, 20);
        add(searchLabel);

        choiceEMP = new Choice();
        choiceEMP.setBounds(220, 20, 150, 20);
        add(choiceEMP);

        try {
            conn c = new conn();
            ResultSet resultSet = c.executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                choiceEMP.add(resultSet.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        search = new JButton("Search");
        search.setBounds(400, 20, 100, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(520, 20, 100, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(640, 20, 100, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(760, 20, 100, 20);
        back.addActionListener(this);
        add(back);

        try {
            conn c = new conn();
            ResultSet resultSet = c.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "SELECT * FROM employee WHERE empid = '" + choiceEMP.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet rs = c.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            new UpdateEmployee(choiceEMP.getSelectedItem());
            setVisible(false);
        } else if (ae.getSource() == back) {
            setVisible(false);
            // You can redirect to a Home class or main menu here if needed
        }
    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
