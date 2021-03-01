package hospital;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
//import hospital.dbconfig;
public class birthregister {

	public JFrame frame;
	private JTextField name;
	private JTextField gender;
	private JTextField birthplace;
	private JTextField dob;
	private JTextField address;
	private JTextField phone;
	private JTextField email;
	Connection con;
	private JTextField fathername;
	private JTextField mothername;
	private JTextField height;
	private JTextField weight;
	private JTextField day;
	private JTextField time;
	public JTextField displayhospname;
	public birthregister() {
		 con=dbconfig.dbconf();
		 frame = new JFrame();
			frame.setBounds(100, 100, 1330, 778);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel_9 = new JLabel("Hospital Id");
			lblNewLabel_9.setFont(new Font("Calibri", Font.BOLD, 15));
			lblNewLabel_9.setBounds(821, 37, 71, 22);
			frame.getContentPane().add(lblNewLabel_9);
			
			displayhospname = new JTextField();
			displayhospname.setBorder(null);
			displayhospname.setBounds(904, 34, 116, 22);
			frame.getContentPane().add(displayhospname);
			displayhospname.setColumns(10);
			displayhospname.setOpaque(false);
			displayhospname.setEditable(false);
//			displayhospname.setVisible(false);
			
			JLabel lblNewLabel_10 = new JLabel("Weight");
			lblNewLabel_10.setFont(new Font("Calibri", Font.BOLD, 20));
			lblNewLabel_10.setBounds(500, 550, 84, 30);
			frame.getContentPane().add(lblNewLabel_10);
			
			JLabel lblHeight = new JLabel("Height");
			lblHeight.setFont(new Font("Calibri", Font.BOLD, 20));
			lblHeight.setBounds(500, 450, 84, 30);
			frame.getContentPane().add(lblHeight);
			
			JLabel lblTime = new JLabel("Time");
			lblTime.setFont(new Font("Calibri", Font.BOLD, 20));
			lblTime.setBounds(500, 350, 84, 30);
			frame.getContentPane().add(lblTime);
			
			JLabel lblDate = new JLabel("Date");
			lblDate.setFont(new Font("Calibri", Font.BOLD, 20));
			lblDate.setBounds(500, 250, 84, 30);
			frame.getContentPane().add(lblDate);
			
			JLabel lblDay = new JLabel("Day");
			lblDay.setFont(new Font("Calibri", Font.BOLD, 20));
			lblDay.setBounds(500, 150, 84, 30);
			frame.getContentPane().add(lblDay);
			
			JLabel lblMotherName = new JLabel("Mother Name");
			lblMotherName.setFont(new Font("Calibri", Font.BOLD, 20));
			lblMotherName.setBounds(64, 350, 124, 34);
			frame.getContentPane().add(lblMotherName);
			
			JLabel lblNewLabel_8 = new JLabel("Father Name");
			lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 20));
			lblNewLabel_8.setBounds(65, 255, 123, 21);
			frame.getContentPane().add(lblNewLabel_8);
			
			time = new JTextField();
			time.setText("time");
			time.setBounds(600, 350, 250, 30);
			frame.getContentPane().add(time);
			time.setColumns(10);
			
			day = new JTextField();
			day.setText("day");
			day.setBounds(600, 150, 250, 30);
			frame.getContentPane().add(day);
			day.setColumns(10);
			
			weight = new JTextField();
			weight.setText("weight");
			weight.setColumns(10);
			weight.setBounds(600, 550, 250, 30);
			frame.getContentPane().add(weight);
			
			fathername = new JTextField();
			fathername.setText("father");
			fathername.setColumns(10);
			fathername.setBounds(200, 250, 250, 30);
			frame.getContentPane().add(fathername);
			
			mothername = new JTextField();
			mothername.setText("mother");
			mothername.setColumns(10);
			mothername.setBounds(200, 350, 250, 30);
			frame.getContentPane().add(mothername);
			
			height = new JTextField();
			height.setText("height");
			height.setColumns(10);
			height.setBounds(600, 450, 250, 30);
			frame.getContentPane().add(height);
			
			name = new JTextField();
			name.setText("name");
			name.setBounds(200, 150, 250, 30);
			frame.getContentPane().add(name);
			name.setColumns(10);
			
			gender = new JTextField();
			gender.setText("gender");
			gender.setColumns(10);
			gender.setBounds(200, 550, 250, 30);
			frame.getContentPane().add(gender);
			
			birthplace = new JTextField();
			birthplace.setText("birth place");
			birthplace.setColumns(10);
			birthplace.setBounds(200, 450, 250, 30);
			frame.getContentPane().add(birthplace);
			
			dob = new JTextField();
			dob.setText("dob");
			dob.setColumns(10);
			dob.setBounds(600, 250, 250, 30);
			frame.getContentPane().add(dob);
			
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
			lblNewLabel.setBounds(92, 157, 56, 16);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Birth Place");
			lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
			lblNewLabel_1.setBounds(73, 453, 103, 25);
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Request Certificate");
			lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 30));
			lblNewLabel_2.setBounds(472, 34, 337, 34);
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Gender");
			lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 20));
			lblNewLabel_3.setBounds(84, 553, 92, 25);
			frame.getContentPane().add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Address");
			lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 20));
			lblNewLabel_4.setBounds(906, 222, 80, 16);
			frame.getContentPane().add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("Phone");
			lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 20));
			lblNewLabel_5.setBounds(930, 457, 56, 16);
			frame.getContentPane().add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Email");
			lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 20));
			lblNewLabel_6.setBounds(930, 557, 56, 16);
			frame.getContentPane().add(lblNewLabel_6);
			
			address = new JTextField();
			address.setText("address");
			address.setColumns(10);
			address.setBounds(1000, 150, 250, 150);
			frame.getContentPane().add(address);
			
			phone = new JTextField();
			phone.setText("phone");
			phone.setColumns(10);
			phone.setBounds(1000, 450, 250, 30);
			frame.getContentPane().add(phone);
			
			email = new JTextField();
			email.setText("email");
			email.setColumns(10);
			email.setBounds(1000, 550, 250, 30);
			frame.getContentPane().add(email);
			
			JButton insert = new JButton("");
			insert.setBackground(Color.WHITE);
			insert.setIcon(new ImageIcon(birthregister.class.getResource("/images/apply.png")));
//			displayhospname.setVisible(false);
			
			
		
			
			insert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int flags=0;
					if(name.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Name","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(fathername.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Father Name","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(mothername.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Mother Name Id","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(gender.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Gender Id","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(birthplace.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Birth Place Id","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(dob.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Date Of Birth","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(address.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Address","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(phone.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Phone","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(email.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Email","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(height.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Height","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(weight.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Weight","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(day.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Day","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else if(time.getText().isEmpty())
					{
						flags=1;
						JOptionPane.showMessageDialog(null, "Enter Time","Alert",JOptionPane.WARNING_MESSAGE);
					}
					String reg_phno = "(0/91)?[7-9][0-9]{9}";
					boolean res_phno = phone.getText().matches(reg_phno);
					if(!res_phno) {
						flags=1;
						JOptionPane.showMessageDialog(null,"Enter a valid phone number","Alert",JOptionPane.WARNING_MESSAGE);
					}
					String reg_email = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
					boolean res_email = email.getText().matches(reg_email);
					if(!(res_email)) {
						flags=1;
						JOptionPane.showMessageDialog(null,"Enter a valid mail id","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else {
					try {
						
						String query="INSERT INTO request(hosp_nameid,name,fathers_name,mothers_name,birth_place,dob,gender,address,phone,email,height,weight,day,time) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
						PreparedStatement pstmt=con.prepareStatement(query);

						pstmt.setString(1, displayhospname.getText());
						
						pstmt.setString(2, name.getText());
						pstmt.setString(3,fathername.getText());
						pstmt.setString(4, mothername.getText());
						pstmt.setString(5, birthplace.getText());
						pstmt.setString(6, dob.getText());
						pstmt.setString(7, gender.getText());
				        pstmt.setString(8, address.getText());
				        pstmt.setString(9, phone.getText());
				        pstmt.setString(10, email.getText());
				        pstmt.setString(11, height.getText());
				        pstmt.setString(12, weight.getText());
				        pstmt.setString(13, day.getText());
				        pstmt.setString(14,time.getText());
				        pstmt.executeUpdate();
				        JOptionPane.showMessageDialog(null, "Certificate Requested");
				       
					
				}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex);
					}
				
				}
						
			}
			});
			insert.setBounds(560, 629, 116, 89);
			frame.getContentPane().add(insert);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

					
					try {
						String id=displayhospname.getText();
						String query="SELECT email FROM register WHERE hospita_id='"+id+"'";
						PreparedStatement pstmts=con.prepareStatement(query);
						ResultSet rs= pstmts.executeQuery();
						while(rs.next())
						{
							String fetched_email=rs.getString("email");
							HospitalDashboard hosdash=new HospitalDashboard();
							hosdash.hos_name.setText(fetched_email);
							frame.dispose();
							hosdash.jframe_1.setVisible(true);
							
							
						}
						
					}
					catch(Exception exception)
					{
						JOptionPane.showMessageDialog(null, exception);
					}
					
					
					
				}
			});
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setIcon(new ImageIcon(birthregister.class.getResource("/images/tinyarrow.png")));
			btnNewButton.setBounds(50, 34, 56, 42);
			frame.getContentPane().add(btnNewButton);
			
			JLabel lblNewLabel_7 = new JLabel("");
			lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 20));
			lblNewLabel_7.setIcon(new ImageIcon(birthregister.class.getResource("/images/adminloginbackground.jpg")));
			lblNewLabel_7.setBounds(0, 0, 1312, 731);
			frame.getContentPane().add(lblNewLabel_7);
			
		
	}


}
