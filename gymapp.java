 //package rform;
 	 import java.awt.*;
     import javax.swing.*;
     import java.awt.event.*;
     import java.sql.*;
      public class gymapp extends JFrame implements ActionListener
       {
          JLabel l10,l9,l1,l2,l3,l4,l5,l6,l7,l8;
           JTextField t9,t1,t2,t3,t4,t5,t6,t7,t8;
           JButton b1,b2;
           JPanel p3,p1,p2;


            public gymapp()
            {

				 l9=new JLabel("BODY POWER FITNESS CLUB",JLabel.CENTER);
				 l10=new JLabel("Registration No          : ",JLabel.RIGHT);
                 l1=new JLabel("Full Name          : ",JLabel.RIGHT);
                 l2=new JLabel("Address             	: ",JLabel.RIGHT);
                 l3=new JLabel("Email                 : ",JLabel.RIGHT);
                 l4=new JLabel("Phone No.          : ",JLabel.RIGHT);
                 l5=new JLabel("Age		                    : ",JLabel.RIGHT);
                 l6=new JLabel("Occupation         : ",JLabel.RIGHT);
                 l7=new JLabel("Joining Date       : ",JLabel.RIGHT);
                 l8=new JLabel("Plan Of Membership : ",JLabel.RIGHT);
                     t9=new JTextField(20);
                     t1=new JTextField(20);
                     t2=new JTextField(20);
                     t3=new JTextField(20);
                     t4=new JTextField(20);
                     t5=new JTextField(20);
                     t6=new JTextField(20);
                     t7=new JTextField(20);
                     t8=new JTextField(20);

                 Font f=new Font("Times New Roman",Font.BOLD,20);



				//Upper Name
                 p3= new JPanel();
                 p3.setLayout(new GridLayout(1,1));
                 p3.add(l9);

                 //Form
                 p1= new JPanel();
                 p1.setLayout(new GridLayout(9,2));
                 p1.add(l10);   p1.add(t9);
                 p1.add(l1);    p1.add(t1);
                 p1.add(l2);    p1.add(t2);
                 p1.add(l3);    p1.add(t3);
                 p1.add(l4);	p1.add(t4);
                 p1.add(l5);	p1.add(t5);
                 p1.add(l6);	p1.add(t6);
                 p1.add(l7);	p1.add(t7);
                 p1.add(l8);	p1.add(t8);



				 //for button
				 b1=new JButton("Submit");
                 b1.addActionListener(this);
				 b2=new JButton("Back");
				 b2.addActionListener(this);
                 p2= new JPanel();
                 p2.setLayout(new FlowLayout());
                 p2.add(b2);
                 p2.add(b1);

                 b2.setFont(new Font("SERIF",Font.BOLD,20));
                 b1.setFont(new Font("SERIF",Font.BOLD,20));
			     l1.setFont(new Font("SERIF",Font.BOLD,20));
			     l2.setFont(new Font("SERIF",Font.BOLD,20));
			     l3.setFont(new Font("SERIF",Font.BOLD,20));
			     l4.setFont(new Font("SERIF",Font.BOLD,20));
			     l5.setFont(new Font("SERIF",Font.BOLD,20));
			     l6.setFont(new Font("SERIF",Font.BOLD,20));
			     l7.setFont(new Font("SERIF",Font.BOLD,20));
			     l8.setFont(new Font("SERIF",Font.BOLD,20));
			     l9.setFont(new Font("SERIF",Font.BOLD,30));
			     l10.setFont(new Font("SERIF",Font.BOLD,20));

			     t1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,17));
				 t2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,17));
				 t3.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,17));
				 t4.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,17));
				 t5.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,17));
				 t6.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,17));
				 t7.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,17));
				 t8.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,17));
			     t9.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,17));

				  setTitle("Form");
				  setLayout(new BorderLayout());
				  add(p3, BorderLayout.NORTH);
				  add(p1, BorderLayout.CENTER);
				  add(p2, BorderLayout.SOUTH);
                  setSize(600,700);
                  setVisible(true);
                  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  setVisible(true);
                  //pack();
         }
        public void actionPerformed(ActionEvent obj)
         {
			if(obj.getSource()==b2)
			{
				new pg1();
				dispose();
			}
			else if(obj.getSource()==b1)
			{
										Connection conn=null;
										Statement stmt=null;
										ResultSet rs=null;
										PreparedStatement ps1=null;
										try
										{
											Class.forName("org.gjt.mm.mysql.Driver");
											conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","0564");
											if(conn!=null)
											{
												stmt=conn.createStatement();
												ps1= conn.prepareStatement("insert into gymdb values(?,?,?,?,?,?,?,?,?)");
												String rno = t9.getText();
												String nm = t1.getText();
												String addr = t2.getText();
												String email = t3.getText();
												String pno = t4.getText();
												String age = t5.getText();
												String occ = t6.getText();
												String jd = t7.getText();
												String pom = t8.getText();

												ps1.setString(1,rno);	ps1.setString(2,nm);  ps1.setString(3,addr);  ps1.setString(4,email);  ps1.setString(5,pno);
												 ps1.setString(6,age);  ps1.setString(7,occ);  ps1.setString(8,jd);  ps1.setString(9,pom);

												ps1.executeUpdate();
												rs=stmt.executeQuery("select * from gymdb");
												stmt.close();
												rs.close();
												conn.close();

												JFrame fr1 = new JFrame("Warning");
												JOptionPane.showMessageDialog(fr1,"Form Submitted");
												t1.setText("");	t2.setText("");	t3.setText("");
												t4.setText("");	t5.setText("");	t6.setText("");
												t7.setText("");	t8.setText("");	t9.setText("");
											}
										}
										catch(Exception e)
										{
											System.out.println("Error Occured  :"+e);
		}
			}

         }
       public static void main(String args[])
        {
          gymapp gym =new gymapp();
        }
     }