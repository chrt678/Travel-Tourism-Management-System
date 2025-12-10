package tourismmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame{
    CheckPackage(){
        setBounds(300,100,750,500);
                
        JTabbedPane pane =new JTabbedPane();
        JPanel p1=createPackage();
        JLabel l1=new JLabel("Hello");
        p1.add(l1);
        
        pane.addTab("Package 1",null,p1);
        
                
        add(pane,BorderLayout.CENTER);
    }
    
    public JPanel createPackage(){
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
        JLabel l1=new JLabel("GOLD PACKAGE");
        l1.setBounds(50,5,300,30);
        l1.setFont(new Font("Tahoma",Font.PLAIN,30));
        p1.add(l1);
        
        JLabel l2=new JLabel("6 Days and 7 Nights");
        l2.setBounds(30,50,300,30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahoma",Font.PLAIN,15));
        p1.add(l2);
        
        JLabel l3=new JLabel("Airport Assistance");
        l3.setBounds(30,90,300,30);
        l3.setForeground(Color.blue);
        l3.setFont(new Font("Tahoma",Font.PLAIN,15));
        p1.add(l3);
        
        JLabel l4=new JLabel("Half Day City Tour");
        l4.setBounds(30,130,300,30);
        l4.setForeground(Color.red);
        l4.setFont(new Font("Tahoma",Font.PLAIN,15));
        p1.add(l4);  
        
        JLabel l5=new JLabel("Daily Buffet");
        l5.setBounds(30,170,300,30);
        l5.setForeground(Color.blue);
        l5.setFont(new Font("Tahoma",Font.PLAIN,15));
        p1.add(l5);
        
        JLabel l6=new JLabel("Welcome Drinks On Arrival");
        l6.setBounds(30,210,300,30);
        l6.setForeground(Color.red);
        l6.setFont(new Font("Tahoma",Font.PLAIN,15));
        p1.add(l6);
        
        JLabel l7=new JLabel("Full Day 3 Island Cruise");
        l7.setBounds(30,250,300,30);
        l7.setForeground(Color.blue);
        l7.setFont(new Font("Tahoma",Font.PLAIN,15));
        p1.add(l7);
        
        JLabel l8=new JLabel("English Speaking Guide");
        l8.setBounds(30,290,300,30);
        l8.setForeground(Color.red);
        l8.setFont(new Font("Tahoma",Font.PLAIN,15));
        p1.add(l8);
        
        JLabel l9=new JLabel("BOOK NOW");
        l9.setBounds(30,340,300,30);
        l9.setForeground(Color.blue);
        l9.setFont(new Font("Tahoma",Font.PLAIN,30));
        p1.add(l9);
        
        JLabel l10=new JLabel("Winter SPECIAL");
        l10.setBounds(270,390,300,35);
        l10.setForeground(Color.red);
        l10.setFont(new Font("Tahoma",Font.PLAIN,25));
        p1.add(l10);
        
        JLabel l11=new JLabel("Rs 12000/-");
        l11.setBounds(600,390,300,35);
        l11.setForeground(Color.red);
        l11.setFont(new Font("Tahoma",Font.PLAIN,25));
        p1.add(l11);
                
        return p1;
    }
   
    public static void main(String[] args) {
        new CheckPackage().setVisible(true);
    }
    
}
