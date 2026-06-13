// Splash.java
package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Splash extends JFrame {
    Splash() {
        setUndecorated(true);
        setSize(1101, 650);
        setLocationRelativeTo(null);
        setLayout(null);

        URL bgURL = getClass().getClassLoader().getResource("icons/splash_bg.png");
        if (bgURL != null) {
            ImageIcon backgroundIcon = new ImageIcon(bgURL);
            JLabel backgroundLabel = new JLabel(backgroundIcon);
            backgroundLabel.setBounds(0, 0, 1101, 650);
            add(backgroundLabel);

            JLabel heading = new JLabel("Employee Management System");
            heading.setBounds(100, 30, 1000, 90);
            heading.setFont(new Font("serif", Font.BOLD, 40));
            heading.setForeground(Color.WHITE);
            backgroundLabel.add(heading);

            Timer animation = new Timer(500, e -> heading.setVisible(!heading.isVisible()));
            animation.start();

            Timer timer = new Timer(4000, e -> {
                animation.stop();
                setVisible(false);
                new Login();
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            System.out.println("splash_bg.png not found in icons folder!");
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Splash();
    }
}
