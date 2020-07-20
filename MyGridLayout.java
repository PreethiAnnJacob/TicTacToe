import java.awt.*;  
import java.awt.event.*;//for ActionListener
import javax.swing.*;  

public class MyGridLayout
{   JFrame f=new JFrame();
    int nclick=0;  
    MyGridLayout()
    {   //Create board of 3X3 with 9 buttons
        JButton b1=new JButton();  
        JButton b2=new JButton();  
        JButton b3=new JButton();  
        JButton b4=new JButton();  
        JButton b5=new JButton();  
        JButton b6=new JButton();  
        JButton b7=new JButton();  
        JButton b8=new JButton();  
        JButton b9=new JButton();  
          
        f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);  
        f.add(b6);f.add(b7);f.add(b8);f.add(b9);  
  
        f.setLayout(new GridLayout(3,3));  
        //setting grid layout of 3 rows and 3 columns  
        
        b1.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent e)
            {   if(nclick++%2==0)   b1.setText("X");
                else                b1.setText("O");
                b1.setEnabled(false);
            }  
        }); 
        b2.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent e)
            {   if(nclick++%2==0)   b2.setText("X");
                else                b2.setText("O");
                b2.setEnabled(false);
            }  
        });
        b3.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent e)
            {   if(nclick++%2==0)   b3.setText("X");
                else                b3.setText("O");
                b3.setEnabled(false);
            }  
        });
        b4.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent e)
            {   if(nclick++%2==0)   b4.setText("X");
                else                b4.setText("O");
                b4.setEnabled(false);
            }  
        });
        b5.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent e)
            {   if(nclick++%2==0)   b5.setText("X");
                else                b5.setText("O");
                b5.setEnabled(false);
            }  
        });
        b6.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent e)
            {   if(nclick++%2==0)   b6.setText("X");
                else                b6.setText("O");
                b6.setEnabled(false);
            }  
        });
        b7.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent e)
            {   if(nclick++%2==0)   b7.setText("X");
                else                b7.setText("O");
                b7.setEnabled(false);
            }  
        });
        b8.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent e)
            {   if(nclick++%2==0)   b8.setText("X");
                else                b8.setText("O");
                b8.setEnabled(false);
            }  
        });
        b9.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent e)
            {   if(nclick++%2==0)   b9.setText("X");
                else                b9.setText("O");
                b9.setEnabled(false);
            }  
        });
  
        f.setSize(300,300);  
        f.setVisible(true);  
    }  
    public static void main()
    {   new MyGridLayout();
    }
} 
