package tourismmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;

public class Paytm extends JFrame {
    Paytm() {
        JButton openInChrome = new JButton("Open in Chrome");
        openInChrome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://paytm.com/"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(openInChrome, BorderLayout.NORTH);

        // Load and display the image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\ashis\\Desktop\\TourismManagementSystem\\src\\tourismmanagementsystem\\icons\\Q R CODE.jpeg"); // Change the path accordingly
        JLabel imageLabel = new JLabel(imageIcon);
        getContentPane().add(imageLabel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(610, 20, 80, 40);
        getContentPane().add(back, BorderLayout.SOUTH);

        pack(); 
        setLocation(220, 60);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm().setVisible(true);
    }
}