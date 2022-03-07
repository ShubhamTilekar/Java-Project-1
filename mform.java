import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
      public class mform extends JFrame implements ActionListener
       {
           JLabel lb1,lb2,lb3;
           JTextField tf1;
           JButton btn1,btn2;
           JPanel pn1,pn2,pn3;

           public mform()
           {
			   //JFrame f1 = new JFrame("Member Login");
               lb2 = new JLabel("Member Login");
               lb1 = new JLabel("Registration Number:");
               tf1 = new JTextField(20);
               btn1 = new JButton("Login");
               btn2 = new JButton("Back");
               pn1= new JPanel();
               pn2= new JPanel();
               pn3= new JPanel();

               setLayout(new FlowLayout());
               pn2.add(lb2);
               pn1.add(lb1);
               pn1.add(tf1);
			   pn3.add(btn2);
               pn3.add(btn1);


               lb1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,28));
               lb2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,28));
               btn1.setFont(new Font("SERIF",Font.BOLD,20));
			   btn2.setFont(new Font("SERIF",Font.BOLD,20));
			   tf1.setFont(new Font("SERIF",Font.BOLD,20));

			   btn1.addActionListener(this);
               btn2.addActionListener(this);

                  setLayout(new BorderLayout());
                  add(pn1, BorderLayout.CENTER);
                  add(pn2, BorderLayout.NORTH);
                  add(pn3, BorderLayout.SOUTH);
                  setSize(600,700);
                  setVisible(true);
                  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  //pack();

           }
           public void actionPerformed(ActionEvent e)
           {
				if(e.getSource()==btn1)
				{
					Connection conn=null;
					Statement stmt=null;
					ResultSet rs=null;

					try
						{
							Class.forName("org.gjt.mm.mysql.Driver"); //Load or Register Driver 	  ("org.gjt.mm.mysql.Driver");
							conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","0564");
							if(conn!=null)
								{
									stmt=conn.createStatement();
									String rno=tf1.getText();
									rs=stmt.executeQuery("select * from gymdb where rno="+rno);
									if(rs.next())
										{

											JFrame f2 = new JFrame("Hello");
											JLabel l3 = new JLabel("Hello User:");
											//l4 = new Label(rno,Label.CENTER);
											f2.add(l3);	//f2.add(l4);
											f2.setSize(600,700);
											f2.setLayout(new GridLayout(1,1));
											f2.setVisible(true);
											dispose();

										}
									else
										{
											JFrame f3 = new JFrame("Warning");
											JOptionPane.showMessageDialog(f3,"Invalid User");
											tf1.setText("");
										}
											stmt.close();
											rs.close();
											conn.close();
								}
							}
						catch(Exception ex)
							{
								System.out.println("Error Occured  :"+ex);
							}

				}
				else if(e.getSource()==btn2)
				{
					new pg1();
					dispose();
				}
		   }
           public static void main(String args[])
        	{
        	 mform m = new mform();
        	}
       }