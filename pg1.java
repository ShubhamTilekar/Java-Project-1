import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class pg1 extends JFrame implements ActionListener
{
  JLabel l10,l9,l1,l2,l3,l4,l5,l6,l7,l8;;
  JButton b1,bt1,bt2,bt3,bt4;
  JTextField t1,t2,t3,t4,t5,t6,t7,t8;
  JPanel jp1,p3,p1,p2;

public pg1()
{
	l10 = new JLabel("BODY POWER FITNESS CLUB",JLabel.CENTER);
	bt1 = new JButton("Registration Form");
	bt2 = new JButton("Member Login");
	bt3 = new JButton("Contact Us");
	bt4 = new JButton("About Us");


	jp1 = new JPanel();
	jp1.setLayout(new GridLayout(5,1));
	jp1.add(l10);
	jp1.add(bt1);
	jp1.add(bt2);
	jp1.add(bt3);
	jp1.add(bt4);

	l10.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
	bt1.setFont(new Font("SERIF",Font.BOLD,25));
	bt2.setFont(new Font("SERIF",Font.BOLD,25));
	bt3.setFont(new Font("SERIF",Font.BOLD,25));
	bt4.setFont(new Font("SERIF",Font.BOLD,25));

	bt1.addActionListener(this);
	bt2.addActionListener(this);
	bt3.addActionListener(this);
	bt4.addActionListener(this);

	setLayout(new BorderLayout());
	add(jp1, BorderLayout.CENTER);
	setSize(600,700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

}

 	public void actionPerformed(ActionEvent e)
	{
 		if(e.getSource()==bt1)
 		{
 			gymapp gym = new gymapp();
 			dispose();
		}
 		else if(e.getSource()==bt2)
 		{
 			mform m = new mform();
 			dispose();
		}

	}
	public static void main(String args[])
	{
		new pg1();
	}

}