package tourismmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField t1, t2, t3, t4;
    Choice c1;

    Signup() {
        setBounds(200, 150, 700, 290);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        JPanel p2 = new JPanel();
        p2.setBackground(Color.WHITE);
        p2.setBounds(400, 0, 400, 400);
        p2.setLayout(null);
        add(p2);

        JLabel l1 = new JLabel("User ID");
        l1.setBounds(40, 20, 135, 25);
        l1.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        p1.add(l1);

        t1 = new JTextField();
        t1.setBounds(185, 20, 150, 25);
        p1.add(t1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(40, 50, 135, 25);
        l2.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        p1.add(l2);

        t2 = new JTextField();
        t2.setBounds(185, 50, 150, 25);
        p1.add(t2);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(40, 80, 135, 25);
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        p1.add(l3);

        t3 = new JTextField();
        t3.setBounds(185, 80, 150, 25);
        p1.add(t3);

        JLabel l4 = new JLabel("Security Question");
        l4.setBounds(40, 110, 135, 25);
        l4.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        p1.add(l4);

        c1 = new Choice();
        c1.setBounds(185, 110, 150, 25);
        c1.add("Your Nickname?");
        c1.add("Your Mother Name?");
        c1.add("Your HomeTown City?");
        c1.add("Your Lucky Number?");
        p1.add(c1);

        JLabel l5 = new JLabel("Answer");
        l5.setBounds(40, 140, 135, 25);
        l5.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        p1.add(l5);

        t4 = new JTextField();
        t4.setBounds(185, 140, 150, 25);
        p1.add(t4);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourismmanagementsystem/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(50, 40, 200, 200);
        p2.add(l6);

        b1 = new JButton("Create");
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.setBackground(Color.WHITE);
        b1.setForeground(new Color(133, 193, 233));
        b1.setBounds(50, 200, 100, 25);
        b1.addActionListener(this);
        p1.add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.setBackground(Color.WHITE);
        b2.setForeground(new Color(133, 193, 233));
        b2.setBounds(200, 200, 100, 25);
        b2.addActionListener(this);
        p1.add(b2);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String security = c1.getSelectedItem();
            String answer = t4.getText();

            if (username.isEmpty() || name.isEmpty() || password.isEmpty() || answer.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter the values");
            } else if (!isPasswordValid(password)) {
                JOptionPane.showMessageDialog(null, "Password must be alphanumeric with special characters.");
            } else {
                // Insert data into the database
                String query = "insert into accounts value('" + username + "','" + name + "','" + password + "','" + security + "','" + answer + "')";
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Accounts Created Successfully");
                    this.setVisible(false);
                    new Login().setVisible(true);
                } catch (Exception e) {
                    // Handle exceptions if needed
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == b2) {
            // Code for the "Back" button
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    private boolean isPasswordValid(String password) {
        // Check if the password contains at least one digit, one letter, and one special character
        return password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).{8,}$");
    }

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
