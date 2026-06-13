package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfeducation, tfdesignation, tfemail, tfphone, tfaddress;
    JLabel lblempid, lblname, lblcnic;
    JButton update, back;
    String empid;

    UpdateEmployee(String empid) {
        this.empid = empid;
        getContentPane().setBackground(new Color(221, 160, 221)); // Light purple
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 30);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Name:");
        labelname.setBounds(50, 100, 150, 30);
        add(labelname);

        lblname = new JLabel();
        lblname.setBounds(200, 100, 150, 30);
        add(lblname);

        JLabel labelcnic = new JLabel("CNIC:");
        labelcnic.setBounds(400, 100, 150, 30);
        add(labelcnic);

        lblcnic = new JLabel();
        lblcnic.setBounds(600, 100, 150, 30);
        add(lblcnic);

        JLabel labelempId = new JLabel("Employee ID:");
        labelempId.setBounds(50, 150, 150, 30);
        add(labelempId);

        lblempid = new JLabel();
        lblempid.setBounds(200, 150, 150, 30);
        add(lblempid);

        JLabel labeleducation = new JLabel("Education:");
        labeleducation.setBounds(400, 150, 150, 30);
        add(labeleducation);

        tfeducation = new JTextField();
        tfeducation.setBounds(600, 150, 150, 30);
        add(tfeducation);

        JLabel labeldesignation = new JLabel("Designation:");
        labeldesignation.setBounds(50, 200, 150, 30);
        add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 200, 150, 30);
        add(tfdesignation);

        JLabel labelemail = new JLabel("Email:");
        labelemail.setBounds(400, 200, 150, 30);
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(600, 200, 150, 30);
        add(tfemail);

        JLabel labelphone = new JLabel("Phone:");
        labelphone.setBounds(50, 250, 150, 30);
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 250, 150, 30);
        add(tfphone);

        JLabel labeladdress = new JLabel("Address:");
        labeladdress.setBounds(400, 250, 150, 30);
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(600, 250, 150, 30);
        add(tfaddress);

        try {
            conn c = new conn();
            ResultSet rs = c.executeQuery("select * from employee where empid = '" + empid + "'");
            if (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblcnic.setText(rs.getString("cnic"));
                lblempid.setText(rs.getString("empid"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                tfaddress.setText(rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBounds(250, 320, 120, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(450, 320, 120, 30);
        back.addActionListener(this);
        add(back);

        setSize(900, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            String address = tfaddress.getText();

            try {
                conn c = new conn();
                String query = "update employee set education='" + education + "', designation='" + designation + "', email='" + email + "', phone='" + phone + "', address='" + address + "' where empid='" + empid + "'";
                c.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Details Updated Successfully");
                setVisible(false);
                new View_Employee();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new View_Employee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("101"); // test with sample empid
    }
}
