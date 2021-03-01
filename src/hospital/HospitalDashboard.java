package hospital;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class HospitalDashboard {

	

	JFrame jframe_1;
	JPanel apply_pan,approved_pan,pending_pan,declined_pan;
	JButton apply_btn,approved_btn,pending_btn,declined_btn;
	JLabel apply_lbl,approved_lbl,pending_lbl,declined_lbl,main_lbl,design_lbl;
	private JButton btnNewButton;
	public JTextField hos_name;
	private JButton btnNewButton_1;

	public HospitalDashboard(){
		
//		hos_name.setVisible(false);
		jframe_1 = new JFrame("");
		jframe_1.getContentPane().setBackground(Color.WHITE);
		jframe_1.getContentPane().setLayout(null);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					 Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/birth","root","");
						String hospitalname= hos_name.getText();
						
						String query="SELECT hosp_name FROM register WHERE email='"+hos_name.getText()+"'";
						PreparedStatement pstmt=con.prepareStatement(query);
						ResultSet rs= pstmt.executeQuery();
						while(rs.next())
						{
							jframe_1.dispose();
							profile pro = new profile();
							
							pro.hospitalemail.setText(hos_name.getText());
							pro.hospitalname.setText(rs.getString("hosp_name"));
							pro.frame.setVisible(true);
						 
						}
						
			
			         }
				catch(Exception excep)
				{
					JOptionPane.showMessageDialog(null, excep);
				}
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(512, 47, 158, 29);
		jframe_1.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setOpaque(false);
		
		hos_name = new JTextField();
		hos_name.setFont(new Font("Calibri", Font.BOLD, 15));
		hos_name.setBorder(null);
		hos_name.setBounds(524, 47, 158, 29);
		jframe_1.getContentPane().add(hos_name);
		hos_name.setColumns(10);
		hos_name.setOpaque(false);
		hos_name.setEditable(false);
		
		apply_pan = new JPanel();
		apply_pan.setBackground(Color.WHITE);
		apply_pan.setBounds(89, 106, 134, 105);
		jframe_1.getContentPane().add(apply_pan);
		
		apply_btn = new JButton("");
		apply_btn.setBackground(Color.WHITE);
		apply_btn.setIcon(new ImageIcon(HospitalDashboard.class.getResource("/images/apply.png")));
		apply_pan.add(apply_btn);
		
		apply_lbl = new JLabel("Request Certificate\r\n");
		apply_lbl.setFont(new Font("Calibri", Font.BOLD, 15));
		apply_lbl.setBounds(99, 211, 141, 26);
		jframe_1.getContentPane().add(apply_lbl);
		
		approved_pan = new JPanel();
		approved_pan.setBackground(Color.WHITE);
		approved_pan.setBounds(423, 106, 134, 105);
		jframe_1.getContentPane().add(approved_pan);
		
		approved_btn= new JButton("");
		approved_btn.setBackground(Color.WHITE);
		approved_btn.setIcon(new ImageIcon(HospitalDashboard.class.getResource("/images/viewApp.png")));
		approved_pan.add(approved_btn);
		
		approved_lbl = new JLabel("View Approved");
		approved_lbl.setFont(new Font("Calibri", Font.BOLD, 15));
		approved_lbl.setBounds(449, 211, 124, 26);
		jframe_1.getContentPane().add(approved_lbl);
		
		pending_pan = new JPanel();
		pending_pan.setBackground(Color.WHITE);
		pending_pan.setBounds(89, 309, 134, 105);
		jframe_1.getContentPane().add(pending_pan);
		
		pending_btn = new JButton("");
		pending_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/birth","root","");
						String hospitalname= hos_name.getText();
						
						String query="SELECT hospita_id FROM register WHERE email='"+hos_name.getText()+"'";
						PreparedStatement pstmt=con.prepareStatement(query);
						ResultSet rs= pstmt.executeQuery();
						while(rs.next())
						{
							pendingrecords pen =new pendingrecords();
						  pen.pendinghosid.setText(rs.getString("hospita_id"));
						  jframe_1.dispose();
						 pen.frame.setVisible(true);
						}
						
			
			         }
				catch(Exception excep)
				{
					JOptionPane.showMessageDialog(null, excep);
				}
			}
		});
		pending_btn.setBackground(Color.WHITE);
		pending_btn.setIcon(new ImageIcon(HospitalDashboard.class.getResource("/images/viewpend.png")));
		pending_pan.add(pending_btn);
		
		pending_lbl = new JLabel("View Pending");
		pending_lbl.setFont(new Font("Calibri", Font.BOLD, 15));
		pending_lbl.setBounds(99, 415, 112, 26);
		jframe_1.getContentPane().add(pending_lbl);
		
		declined_pan = new JPanel();
		declined_pan.setBackground(Color.WHITE);
		declined_pan.setBounds(423, 309, 134, 105);
		jframe_1.getContentPane().add(declined_pan);
		
		declined_btn = new JButton("");
		declined_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				


				try {
					 Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/birth","root","");
						String hospitalname= hos_name.getText();
						
						String query="SELECT hospita_id FROM register WHERE email='"+hos_name.getText()+"'";
						PreparedStatement pstmt=con.prepareStatement(query);
						ResultSet rs= pstmt.executeQuery();
						while(rs.next())
						{
							deniedcertificates den =new deniedcertificates();
						  den.idofhospital.setText(rs.getString("hospita_id"));
						  jframe_1.dispose();
						 den.frame.setVisible(true);
						}
						
			
			         }
				catch(Exception excep)
				{
					JOptionPane.showMessageDialog(null, excep);
				}
			
				
			}
		});
		declined_btn.setBackground(Color.WHITE);
		declined_btn.setIcon(new ImageIcon(HospitalDashboard.class.getResource("/images/viewdec.png")));
		declined_pan.add(declined_btn);
		
		declined_lbl = new JLabel("View Declined");
		declined_lbl.setFont(new Font("Calibri", Font.BOLD, 15));
		declined_lbl.setBounds(449, 415, 97, 26);
		jframe_1.getContentPane().add(declined_lbl);
		
		main_lbl = new JLabel("Hospital DashBoard\r\n");
		main_lbl.setFont(new Font("Calibri", Font.BOLD, 20));
		main_lbl.setBounds(247, 42, 183, 36);
		jframe_1.getContentPane().add(main_lbl);
	
		
		design_lbl = new JLabel("New label");
		design_lbl.setIcon(new ImageIcon(HospitalDashboard.class.getResource("/images/24490.jpg")));
		design_lbl.setBounds(0, 0, 682, 490);
		jframe_1.getContentPane().add(design_lbl);
		

		jframe_1.setSize(700,537);
		jframe_1.setLocationRelativeTo(null);
		jframe_1.setVisible(true);
//		hos_name.setVisible(false);
	
		apply_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					 Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/birth","root","");
						String hospitalname= hos_name.getText();
						
						String query="SELECT hospita_id FROM register WHERE email='"+hos_name.getText()+"'";
						PreparedStatement pstmt=con.prepareStatement(query);
						ResultSet rs= pstmt.executeQuery();
						while(rs.next())
						{
							birthregister breg =new birthregister();
						  breg.displayhospname.setText(rs.getString("hospita_id"));
						  jframe_1.dispose();
						 breg.frame.setVisible(true);
						}
						

					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				
			
			
				
		
				
			}});
		
		approved_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			

				try {
					 Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/birth","root","");
						String hospitalname= hos_name.getText();
						
						String query="SELECT hospita_id FROM register WHERE email='"+hos_name.getText()+"'";
						PreparedStatement pstmt=con.prepareStatement(query);
						ResultSet rs= pstmt.executeQuery();
						while(rs.next())
						{
							approvedcertificates app =new approvedcertificates();
						  app. hosp_emailhid.setText(rs.getString("hospita_id"));
						  jframe_1.dispose();
						 app.frame.setVisible(true);
						}
						
			
			         }
				catch(Exception excep)
				{
					JOptionPane.showMessageDialog(null, excep);
				}
			
			
		}});
	}
		
	
		
	
		
	
		
		
	
	public static void main(String args[]) {
		new HospitalDashboard();
	}
}

