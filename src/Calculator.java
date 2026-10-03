

import com.sun.beans.TypeResolver;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class close  extends WindowAdapter{
    
   
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
    
    
}


class cal implements ActionListener{
       
      Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25;
      
      TextField tf;
      
      String fv,sv,op;
      
      double fdv,sdv,tot;
      
      MenuItem mi1, mi2, mi3,mi4, mi5, mi6;
      
      Color c1,c2,c3,c4,c5;
      
            
            
    cal(){
    
        Frame f1 = new Frame();
        
        f1.setBackground(Color.WHITE);
        f1.addWindowListener(new close());
        f1.setBounds(800, 100, 250, 300);
        f1.setTitle("Calculator");
        
        MenuBar mBar = new MenuBar(); 
        
        mi1 = new MenuItem("New Window");
        mi2 = new MenuItem("Scientific");
        mi3 = new MenuItem("Copy");
        mi4 = new MenuItem("Cut");
        mi5 = new MenuItem("Light");
        mi6 = new MenuItem("Dark");
        
        Menu m1 = new Menu("View");
        m1.add(mi1);
        m1.add(mi2);
        
        Menu m2 = new Menu("Edit");
        m2.add(mi3);
        m2.add(mi4);
        
        Menu m3 = new Menu("Theme");
        m3.add(mi5);
        m3.add(mi6);
        
        mBar.add(m1);
        mBar.add(m2);
        mBar.add(m3);
        
        f1.setMenuBar(mBar);
        
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        b10 = new Button("0");
        b11 = new Button(".");
        b12 = new Button("+");
        b13 = new Button("-");
        b14 = new Button("/");
        b15 = new Button("*");
        b16 = new Button("=");
        b17 = new Button("<--");
        b18 = new Button("C");
        b19 = new Button("%");
        b20 = new Button("√");

        
        Font font1 = new Font("Cambria Math",Font.BOLD,10);
        
        Font font2 = new Font("Courier New",Font.BOLD,11);
        
        b13.setBackground(Color.yellow);
        b12.setBackground(Color.yellow);
        b14.setBackground(Color.yellow);
        b15.setBackground(Color.yellow);
        b17.setBackground(Color.yellow);
        b18.setBackground(Color.yellow);
        b19.setBackground(Color.yellow);
        b20.setBackground(Color.yellow);
        
        b1.setFont(font1);
        b2.setFont(font1);
        b3.setFont(font1);
        b4.setFont(font1);
        b5.setFont(font1);
        b6.setFont(font1);
        b7.setFont(font1);
        b8.setFont(font1);
        b9.setFont(font1);
        b11.setFont(font1);
        b12.setFont(font2);
        b13.setFont(font2);
        b14.setFont(font2);
        b15.setFont(font2);
        b16.setFont(font2);
        b17.setFont(font2);
        b18.setFont(font2);
        b19.setFont(font2);
        b20.setFont(font2);
        
        b1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        

        
        tf = new TextField(20);
        
        Font font = new Font("Cambria Math",Font.BOLD,16);
        
        tf.setFont(font);
        tf.setEditable(false);
        tf.setLocation(20, 40);
        
        tf.setForeground(Color.black);
        tf.setBackground(Color.white);
        
        Panel p1 = new Panel();       
        Panel p2 = new Panel();
        
        GridLayout g1 = new GridLayout(5, 4, 5, 7);
        
        p1.add(tf);
        
        p2.setLayout(g1);
        
        p2.setBackground(Color.white);
        
        p2.add(b18);
        p2.add(b19);
        p2.add(b17);
        p2.add(b12);
            
        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(b14);

        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b15);
        
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b13);

        p2.add(b11);
        p2.add(b10);
        p2.add(b16);
        p2.add(b20);
        
        
        f1.add(p1,BorderLayout.NORTH);
        f1.add(p2,BorderLayout.CENTER);
        

        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);
        b19.addActionListener(this);
        b20.addActionListener(this);
        
        
        mi1.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        mi6.addActionListener(this);        
        
        f1.setVisible(true);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent d) {
        
        Object o = d.getSource();
        
        if(o.equals(b1)){
            tf.setText(tf.getText() + b1.getLabel());
        }else if(o.equals(b2)){
            tf.setText(tf.getText() + b2.getLabel());
        }else if(o.equals(b3)){
            tf.setText(tf.getText() + b3.getLabel());
        }else if(o.equals(b4)){
            tf.setText(tf.getText() + b4.getLabel());
        }else if(o.equals(b5)){
            tf.setText(tf.getText() + b5.getLabel());
        }else if(o.equals(b6)){
            tf.setText(tf.getText() + b6.getLabel());
        }else if(o.equals(b7)){
            tf.setText(tf.getText() + b7.getLabel());
        }else if(o.equals(b8)){
            tf.setText(tf.getText() + b8.getLabel());
        }else if(o.equals(b9)){
            tf.setText(tf.getText() + b9.getLabel());
        }else if(o.equals(b10)){
            tf.setText(tf.getText() + b10.getLabel());
        }else if(o.equals(b11)){
            tf.setText(tf.getText() + b11.getLabel());
            
        }else if(o.equals(b12)){

            fv = tf.getText();
            tf.setText("");

            op = b12.getLabel();

        }else if(o.equals(b13)){

            fv = tf.getText();
            tf.setText("");

            op = b13.getLabel();

        }else if(o.equals(b14)){

            fv = tf.getText();
            tf.setText("");

            op = b14.getLabel();

        }else if(o.equals(b15)){

            fv = tf.getText();
            tf.setText("");

            op = b15.getLabel();
            
        }else if (o.equals(b19)){
            
            fv = tf.getText();
            tf.setText("");
            
            op = b19.getLabel();
            
        }else if(o.equals(b20)){
            
            fv = tf.getText();
            tf.setText("");
            
            op = b20.getLabel();

        }else if(o.equals(b16)){

            sv = tf.getText();

            fdv = Double.parseDouble(fv);
            sdv = Double.parseDouble(sv);

            if(op.equals("+")){

                tot = fdv+sdv;  
                tf.setText(tot + "");

            }else if(op.equals("-")){

                tot = fdv-sdv;  
                tf.setText(tot + "");

            }else if(op.equals("/")){

                tot = fdv/sdv;  
                tf.setText(tot + "");

            }else if(op.equals("*")){

                tot = fdv*sdv;  
                tf.setText(tot + "");

            }else if(op.equals("%")){
                
                tot = fdv/100*sdv;
                tf.setText(tot + "");
                
            }else if(op.equals("√")){
                
                tot = fdv * Math.sqrt(sdv);
                tf.setText(tot + "");
                
            }
        
        }else if(o.equals(b17)){

            StringBuffer erase  = new StringBuffer(tf.getText());
            erase.reverse();
            
            erase.deleteCharAt(0);
            erase.reverse();
            
            String x = new String(erase);
            tf.setText(x);

        }else if(o.equals(b18)){
            
            tf.setText("");
            
        }else if(o.equals(mi3)){
            
            String text = tf.getText();
            StringSelection stringselection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringselection, stringselection);
            
        }else if(o.equals(mi4)){
            
            String text = tf.getText();
            StringSelection stringselection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringselection, stringselection);
            
            tf.setText("");
            
        }else if(o.equals(mi1)){
            new cal();
        }

        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

public class Calculator {
    
    public static void main(String args[]){
        
        new cal();

    }
    
}
