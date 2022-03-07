import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class mformconn extends JFrame
{
	JTextField tf1 = new JTextField();

	public mformconn()
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
	public static void main(String args[])
	{
		mformconn mfc = new mformconn();
	}
}