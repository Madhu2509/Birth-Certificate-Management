package hospital;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class checkstatus {

	private JFrame frame;
	private JTextField email;



	Connection con=null;
	public checkstatus() {
		
		con =dbconfig.dbconf();
		frame = new JFrame();
		frame.setBounds(100, 100, 737, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(checkstatus.class.getResource("/images/email.png")));
		lblNewLabel_3.setBounds(211, 177, 32, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Enter Registered Email");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel.setBounds(267, 139, 144, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main m =new main();
				m.frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(checkstatus.class.getResource("/images/tinyarrow.png")));
		btnNewButton.setBounds(12, 13, 65, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check Status");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String query="SELECT approval_status FROM register WHERE email=? ";
				PreparedStatement pstm=con.prepareStatement(query);
				pstm.setString(1, email.getText());
				ResultSet rs =pstm.executeQuery();
				while(rs.next())
				{
					
					int status =rs.getInt("approval_status");
					if(status==-1)
					{
						
						JOptionPane.showMessageDialog(null, "Approval Pending");
					}
					else if(status==0)
					{
						
							JOptionPane.showMessageDialog(null, "Denied");
						
					}
					else if(status==1)
					{
						
						
							JOptionPane.showMessageDialog(null, "Approved");

					}
					else
					{
						
							JOptionPane.showMessageDialog(null, "Register Hospital");
						
					}
				}
			
				
			}
			catch(Exception ex1)
			{
				JOptionPane.showMessageDialog(null, ex1);
			}
		
				
				
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(456, 177, 132, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Status Check");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_1.setBounds(301, 13, 167, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(245, 177, 198, 30);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(checkstatus.class.getResource("/images/background.jpg")));
		lblNewLabel_2.setBounds(0, 0, 719, 376);
		frame.getContentPane().add(lblNewLabel_2);
	}
	public static void main(String[] args)
	{
		checkstatus stat = new checkstatus();
		stat.frame.setVisible(true);
	}

	

}
