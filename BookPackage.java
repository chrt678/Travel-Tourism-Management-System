
package tourismmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class BookPackage extends JFrame implements ActionListener{
    Choice c1;
    JLabel l11,l12,l13,l14,l15;
    JTextField t1;
    JButton b1,b2,b3;
     
    BookPackage(String username){
        setBounds(280,100,850,450); 
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("TourismManagementsystem/icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(370,260,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel l16=new JLabel(i3);
        l16.setBounds(450,50,370,260);
        add(l16);
        
        JLabel l10=new JLabel("Book Package");
        l10.setBounds(100,10,200,30);
        l10.setFont(new Font("Tahoma",Font.BOLD,25));
        add(l10);
        
        JLabel l1=new JLabel("Username");
        l1.setBounds(30,50,150,25);
        add(l1);
        
        l11=new JLabel();
        l11.setBounds(230,50,150,25);
        add(l11);
        
        JLabel l2=new JLabel("Select Package");
        l2.setBounds(30,90,150,25);
        add(l2);
        
        c1=new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(230,90,150,25);
        add(c1);
        
        JLabel l3=new JLabel("Total Persons");
        l3.setBounds(30,130,150,25);
        add(l3);
        
        t1=new JTextField("1");
        t1.setBounds(230,130,150,25);
        add(t1);
        
        JLabel l4=new JLabel("ID:");
        l4.setBounds(30,170,150,25);
        add(l4);
        
        l12=new JLabel();
        l12.setBounds(230,170,150,25);
        add(l12);
        
        JLabel l5=new JLabel("Number");
        l5.setBounds(30,210,150,25);
        add(l5);
        
        l13=new JLabel();
        l13.setBounds(230,210,150,25);
        add(l13);
        
        JLabel l6=new JLabel("Phone");
        l6.setBounds(30,250,150,25);
        add(l6);
        
        l14=new JLabel();
        l14.setBounds(230,250,150,25);
        add(l14);
        
        JLabel l7=new JLabel("Total Price");
        l7.setBounds(30,290,150,25);
        add(l7);
        
        l15=new JLabel();
        l15.setBounds(230,290,150,25);
        l15.setForeground(Color.red);
        add(l15);
        
        try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
        while(rs.next()){
            l11.setText(rs.getString("username"));  
            l12.setText(rs.getString("id")); 
            l13.setText(rs.getString("number"));
            l14.setText(rs.getString("phone"));  
        }
        }catch(Exception e){
            
        }
        
        b1=new JButton("Check Price");
        b1.setBounds(40,350,150,25);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        add(b1);
        
        b2=new JButton("Book Package");
        b2.setBounds(220,350,150,25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("Back");
        b3.setBounds(400,350,150,25);
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        add(b3);
        
}
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==b1){
                           
                String p=c1.getSelectedItem();
                int cost=0;
                if(p.equals("Gold Package")){
                    cost+=12000;
                }else if(p.equals("Silver Package")){
                    cost+=25000;
                }else if(p.equals("Bronze Package")){
                    cost+=32000;
                }
               int persons=Integer.parseInt( t1.getText());
               cost *=persons;
               
               l15.setText("Rs "+ cost);
            }else if(ae.getSource()==b2){
                try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookPackage value('"+l11.getText()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+l12.getText()+"','"+l13.getText()+"','"+l14.getText()+"','"+l15.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                this.setVisible(false);
                }catch(Exception e){
                    
                    
                }
            
        }
        else if(ae.getSource()==b3){
            this.setVisible(false);
        }
        }
    public static void main(String[] args) {
          new BookPackage("").setVisible(true);        
    }
}
