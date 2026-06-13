package Employee.Management.System;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {
    Home() {
        setTitle("Home");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Welcome to Employee Management System", JLabel.CENTER);
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(label, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }
}
