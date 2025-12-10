package tourismmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3;
    Choice securityChoice;

    ForgetPassword() {
        setBounds(200, 150, 800, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourismmanagementsystem/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(560, 70, 200, 200);
        add(l6);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(30, 40, 500, 280);
        add(p);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 25);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l1);

        t1 = new JTextField();
        t1.setBounds(170, 20, 150, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p.add(t1);

        b1 = new JButton("Search");
        b1.setBackground(Color.WHITE);
        b1.setBackground(Color.GRAY);
        b1.setBounds(330, 20, 150, 25);
        p.add(b1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(40, 50, 100, 25);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l2);

        t2 = new JTextField();
        t2.setBounds(170, 50, 150, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p.add(t2);

        JLabel l3 = new JLabel("Security Question");
        l3.setBounds(40, 80, 150, 25);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l3);

        // Create the security choice with predefined questions
        securityChoice = new Choice();
        securityChoice.setBounds(170, 80, 310, 25);
        securityChoice.add("Your Nickname?");
        securityChoice.add("Your Mother Name?");
        securityChoice.add("Your HomeTown City?");
        securityChoice.add("Your Lucky Number?");
        p.add(securityChoice);

        JLabel l4 = new JLabel("Answer");
        l4.setBounds(40, 110, 100, 25);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l4);

        t4 = new JTextField();
        t4.setBounds(170, 110, 150, 25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p.add(t4);

        b2 = new JButton("Retrieve");
        b2.setBackground(Color.WHITE);
        b2.setBackground(Color.GRAY);
        b2.setBounds(330, 110, 150, 25);
        p.add(b2);

        JLabel l5 = new JLabel("Password");
        l5.setBounds(40, 140, 100, 25);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l5);

        t5 = new JTextField();
        t5.setBounds(170, 140, 150, 25);
        t5.setBorder(BorderFactory.createEmptyBorder());
        p.add(t5);

        b3 = new JButton("Back");
        b3.setBackground(Color.WHITE);
        b3.setBackground(Color.GRAY);
        b3.setBounds(80, 190, 150, 25);
        b3.addActionListener(this);
        p.add(b3);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

        } else if (ae.getSource() == b2) {

        } else if (ae.getSource() == b3) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ForgetPassword().setVisible(true);
    }
}
