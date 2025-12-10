package tourismmanagementsystem;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton b1, b2, b3;
    JTextField t1;
    JPasswordField t2;

    public Login() {
        setBounds(220, 130, 900, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourismmanagementsystem/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(100, 80, 200, 200);
        p1.add(l1);

        JPanel p2 = new JPanel();
        p2.setBounds(400, 30, 460, 300);
        p2.setLayout(null);
        add(p2);

        JLabel l2 = new JLabel("User ID");
        l2.setBounds(60, 20, 200, 25);
        l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(l2);

        t1 = new JTextField();
        t1.setBounds(60, 60, 300, 30);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t1);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(60, 100, 200, 25);
        l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(l3);

        t2 = new JPasswordField();
        t2.setBounds(60, 140, 300, 30);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t2);

        b1 = new JButton("Login");
        b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        b1.setBackground(new Color(131, 193, 233));
        b1.setForeground(Color.white);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.setBounds(60, 200, 150, 30);
        b1.addActionListener(this);
        p2.add(b1);

        b2 = new JButton("Signup");
        b2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        b2.setForeground(new Color(131, 193, 233));
        b2.setBackground(Color.white);
        b2.setBorder(new LineBorder(new Color(131, 193, 233)));
        b2.setBounds(230, 200, 150, 30);
        b2.addActionListener(this);
        p2.add(b2);

        b3 = new JButton("Forget Password");
        b3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        b3.setForeground(new Color(131, 193, 233));
        b3.setBackground(Color.white);
        b3.setBorder(new LineBorder(new Color(131, 193, 233)));
        b3.setBounds(130, 250, 200, 30);
        b3.addActionListener(this);
        p2.add(b3);

        JLabel l4 = new JLabel("Trouble in Login...");
        l4.setForeground(Color.RED);
        l4.setBounds(340, 250, 150, 20);
        p2.add(l4);

        // setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == b1) {
        try {
            String username = t1.getText();
            String password = t2.getText();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter the values");
            } else if (!isPasswordValid(password)) {
                JOptionPane.showMessageDialog(null, "Password must be alphanumeric with special characters.");
            } else {
                String sql = "Select * from accounts where username = '" + username + "' And password = '" + password + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(sql);
                if (rs.next()) {
                    this.setVisible(false);
                    new Loading(username).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == b2) {
        this.setVisible(false);
        new Signup().setVisible(true);
    } else if (ae.getSource() == b3) {
        this.setVisible(false);
        new ForgetPassword().setVisible(true);
    }
}

private boolean isPasswordValid(String password) {
    // Check if the password contains at least one digit, one letter, and one special character
    return password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).{8,}$");
}

    public static void main(String args[]) {
        new Login();
    }
}

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
package tourismmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
    String username;
    Dashboard(String username){
        this.username=username;
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       setLayout(null);
       
       JPanel p1=new JPanel();
       p1.setBounds(0,0,1950,65);
       p1.setLayout(null);
       p1.setBackground(new Color(0,0,102));
       add(p1);
       
       JPanel p2=new JPanel();
       p2.setBounds(0,65,250,1000);
       p2.setLayout(null);
       p2.setBackground(new Color(0,0,102));
       add(p2);
       
       b1=new JButton("Add Personal Details");
       b1.setBackground(new Color(0,0,102));
       b1.setFont(new Font("Tahoma",Font.PLAIN,15));
       b1.setForeground(Color.white);
       b1.setMargin(new Insets(0,0,0,80));
       b1.setBounds(0,0,250,35);
       b1.addActionListener(this);
       p2.add(b1);
       
       b2=new JButton("Update Personal Details");
       b2.setBackground(new Color(0,0,102));
       b2.setFont(new Font("Tahoma",Font.PLAIN,15));
       b2.setForeground(Color.white);
       b2.setMargin(new Insets(0,0,0,60));
       b2.setBounds(0,30,250,35);
       b2.addActionListener(this);
       p2.add(b2);
       
       b3=new JButton("View Details");
       b3.setBackground(new Color(0,0,102));
       b3.setFont(new Font("Tahoma",Font.PLAIN,15));
       b3.setForeground(Color.white);
       b3.setMargin(new Insets(0,0,0,135));
       b3.setBounds(0,60,250,35);
       b3.addActionListener(this);
       p2.add(b3);
       
       b4=new JButton("Delete Personal Details");
       b4.setBackground(new Color(0,0,102));
       b4.setFont(new Font("Tahoma",Font.PLAIN,15));
       b4.setForeground(Color.white);
       b4.setMargin(new Insets(0,0,0,65));
       b4.setBounds(0,90,250,35);
       b4.addActionListener(this);
       p2.add(b4);
       
       b5=new JButton("Check Package");
       b5.setBackground(new Color(0,0,102));
       b5.setFont(new Font("Tahoma",Font.PLAIN,15));
       b5.setForeground(Color.white);
       b5.setMargin(new Insets(0,0,0,120));
       b5.setBounds(0,120,250,35);
       b5.addActionListener(this);
       p2.add(b5);
       
       b6=new JButton("Book Package");
       b6.setBackground(new Color(0,0,102));
       b6.setFont(new Font("Tahoma",Font.PLAIN,15));
       b6.setForeground(Color.white);
       b6.setMargin(new Insets(0,0,0,125));
       b6.setBounds(0,150,250,35);
       b6.addActionListener(this);
       p2.add(b6);
       
       b7=new JButton("View Package");
       b7.setBackground(new Color(0,0,102));
       b7.setFont(new Font("Tahoma",Font.PLAIN,15));
       b7.setForeground(Color.white);
       b7.setMargin(new Insets(0,0,0,125));
       b7.setBounds(0,180,250,35);
       b7.addActionListener(this);
       p2.add(b7);
       
       b8=new JButton("View Hotels");
       b8.setBackground(new Color(0,0,102));
       b8.setFont(new Font("Tahoma",Font.PLAIN,15));
       b8.setForeground(Color.white);
       b8.setMargin(new Insets(0,0,0,140));
       b8.setBounds(0,210,250,35);
       b8.addActionListener(this);
       p2.add(b8);
       
       b9=new JButton("Book Hotel");
       b9.setBackground(new Color(0,0,102));
       b9.setFont(new Font("Tahoma",Font.PLAIN,15));
       b9.setForeground(Color.white);
       b9.setMargin(new Insets(0,0,0,145));
       b9.setBounds(0,240,250,35);
       b9.addActionListener(this);
       p2.add(b9);
       
       b10=new JButton("View Booked Hotel");
       b10.setBackground(new Color(0,0,102));
       b10.setFont(new Font("Tahoma",Font.PLAIN,15));
       b10.setForeground(Color.white);
       b10.setMargin(new Insets(0,0,0,90));
       b10.setBounds(0,270,250,35);
       b10.addActionListener(this);
       p2.add(b10);
       
       b11=new JButton("Destinations");
       b11.setBackground(new Color(0,0,102));
       b11.setFont(new Font("Tahoma",Font.PLAIN,15));
       b11.setForeground(Color.white);
       b11.setMargin(new Insets(0,0,0,130));
       b11.setBounds(0,300,250,35);
       b11.addActionListener(this);
       p2.add(b11);
       
       b12=new JButton("Payment");
       b12.setBackground(new Color(0,0,102));
       b12.setFont(new Font("Tahoma",Font.PLAIN,15));
       b12.setForeground(Color.white);
       b12.setMargin(new Insets(0,0,0,155));
       b12.setBounds(0,330,250,35);
       b12.addActionListener(this);
       p2.add(b12);
       
       b13=new JButton("Calculator");
       b13.setBackground(new Color(0,0,102));
       b13.setFont(new Font("Tahoma",Font.PLAIN,15));
       b13.setForeground(Color.white);
       b13.setMargin(new Insets(0,0,0,150));
       b13.setBounds(0,360,250,35);
       b13.addActionListener(this);
       p2.add(b13);
       
       b14=new JButton("Notepad");
       b14.setBackground(new Color(0,0,102));
       b14.setFont(new Font("Tahoma",Font.PLAIN,15));
       b14.setForeground(Color.white);
       b14.setMargin(new Insets(0,0,0,155));
       b14.setBounds(0,390,250,35);
       b14.addActionListener(this);
       p2.add(b14);
       
       b15=new JButton("About");
       b15.setBackground(new Color(0,0,102));
       b15.setFont(new Font("Tahoma",Font.PLAIN,15));
       b15.setForeground(Color.white);
       b15.setMargin(new Insets(0,0,0,165));
       b15.setBounds(0,420,250,35);
       b15.addActionListener(this);
       p2.add(b15);
       
       ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("tourismmanagementsystem/icons/dash.png"));
       Image i5 =i4.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
       ImageIcon i6=new ImageIcon(i5);
       JLabel l2=new JLabel(i6);
       l2.setBounds(0,0,70,70);
       p1.add(l2);
       
       JLabel l3=new JLabel("Dashboard");
       l3.setFont(new Font("Tahome",Font.BOLD,30));
       l3.setForeground(Color.white);
       l3.setBounds(80,10,300,40);
       p1.add(l3);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("tourismmanagementsystem/icons/home.jpg"));
       Image i2 =i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel l1=new JLabel(i3);
       l1.setBounds(0,0,1950,1000);
       add(l1);
       
       JLabel l4=new JLabel("Travel And Tourism Management System");
       l4.setBounds(400,80,1000,60);
       l4.setForeground(Color.white);
       l4.setFont(new Font("Tahoma",Font.PLAIN,40));
       l1.add(l4);
    
    }  
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b13){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                
            }
        }else if(ae.getSource()==b14){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                
            }
        }else if(ae.getSource()==b1){
            new AddCustomer(username).setVisible(true);
        }else if(ae.getSource()==b2){
            new UpdateCustomer(username).setVisible(true);
        }
        else if(ae.getSource()==b3){
            new ViewCustomer(username).setVisible(true);
        }else if(ae.getSource()==b5){
            new CheckPackage().setVisible(true);
        }else if(ae.getSource()==b6){
            new BookPackage(username).setVisible(true);
        }else if(ae.getSource()==b7){
            new ViewPackage(username).setVisible(true);
        }else if(ae.getSource()==b8){
            new CheckHotels().setVisible(true);
        }else if(ae.getSource()==b11){
            new Destination().setVisible(true);
        }else if(ae.getSource()==b9){
           new BookHotel(username).setVisible(true);
        }else if(ae.getSource()==b10){
            new ViewBookedHotel(username).setVisible(true);
        }else if(ae.getSource()==b12){
            new Payment().setVisible(true);
        }else if(ae.getSource()==b15){
            new About().setVisible(true);
        }else if(ae.getSource()==b4){
            new DeleteCustomer(username).setVisible(true);
        }
    }
    public static void main(String[] args){
        new Dashboard("").setVisible(true);
    }
}

