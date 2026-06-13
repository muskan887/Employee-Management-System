// Login.java
package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    Login() {
        setTitle("Employee Login");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(new Color(207, 231, 245)); // light bluish background

        JLabel heading = new JLabel("Login");
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setBounds(300, 30, 200, 40);
        add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(150, 100, 100, 30);
        add(lblusername);

        tusername = new JTextField();
        tusername.setBounds(260, 100, 200, 30);
        add(tusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(150, 150, 100, 30);
        add(lblpassword);

        tpassword = new JPasswordField();
        tpassword.setBounds(260, 150, 200, 30);
        add(tpassword);

        login = new JButton("Login");
        login.setBounds(260, 200, 90, 30);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(370, 200, 90, 30);
        back.addActionListener(e -> System.exit(0));
        add(back);

        // Add character image
        URL charURL = getClass().getClassLoader().getResource("icons/character.png");
        if (charURL != null) {
            ImageIcon icon = new ImageIcon(charURL);
            JLabel imgLabel = new JLabel(icon);
            imgLabel.setBounds(500, 80, icon.getIconWidth(), icon.getIconHeight());
            add(imgLabel);
        } else {
            System.out.println("character.png not found in icons folder!");
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String username = tusername.getText();
        String password = new String(tpassword.getPassword());

        if (username.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Login successful");
            setVisible(false);
            new Main_class();

            // You can now show your dashboard or home screen
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials");
        }
    }
}
