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
