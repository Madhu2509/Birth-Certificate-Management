package admin;

import hospital.dbconfig;
import java.sql.*;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class hospital_manage {

	public JFrame frame;
	private JTable table;
	private JTextField hospitalname;
	private JTextField email;

	


	Connection con=null;
	
	public hospital_manage() {
		
		con=dbconfig.dbconf();
		frame = new JFrame();
		frame.setBounds(100, 100, 913, 557);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Manage Hospitals");
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_6.setBounds(404, 13, 219, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(257, 53, 567, 330);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index=table.getSelectedRow();
				TableModel model=table.getModel();
				String hospital_name=model.getValueAt(index, 0).toString();
				String email_=model.getValueAt(index, 1).toString();
				hospitalname.setText(hospital_name);
				email.setText(email_);
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hospital Name", "Email"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		scrollPane.setViewportView(table);
		
		hospitalname = new JTextField();
		hospitalname.setBounds(55, 133, 159, 25);
		frame.getContentPane().add(hospitalname);
		hospitalname.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(hospital_manage.class.getResource("/images/viewApp.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query ="UPDATE register SET approval_status='"+1+"' WHERE email='"+email.getText()+"'";
					PreparedStatement pstmt =con.prepareStatement(query);
					pstmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Hospital Approved");
					
				}
				catch(Exception eep)
				{
					JOptionPane.showMessageDialog(null, eep);
				}
				
			}
		});
		btnNewButton.setBounds(29, 310, 91, 78);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(hospital_manage.class.getResource("/images/viewdec.png")));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query ="UPDATE register SET approval_status='"+0+"' WHERE email='"+email.getText()+"'";
					PreparedStatement pstmt =con.prepareStatement(query);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Hospital Denied");
					
				}
				catch(Exception eep)
				{
					JOptionPane.showMessageDialog(null, eep);
				}
			}
		});
		btnNewButton_1.setBounds(154, 310, 91, 73);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(hospital_manage.class.getResource("/images/denied.png")));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query ="DELETE FROM register WHERE email='"+email.getText()+"'";
					PreparedStatement pstmt =con.prepareStatement(query);
					pstmt.executeUpdate();
					
				}
				catch(Exception exce)
				{
					JOptionPane.showMessageDialog(null, exce);
				}
			}
		});
		btnNewButton_2.setBounds(90, 417, 80, 50);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Retrive Approved");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				btnNewButton.setVisible(false);
				showapprovedrecords();
			}
		});
		btnNewButton_3.setBounds(375, 401, 131, 37);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Retrive Denied");
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				btnNewButton_1.setVisible(false);
				showdeniedrecords();
			}
		});
		btnNewButton_4.setBounds(555, 401, 136, 37);
		frame.getContentPane().add(btnNewButton_4);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(55, 227, 159, 25);
		frame.getContentPane().add(email);
		
		JButton btnNewButton_5 = new JButton("Refresh");
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				hospital_manage mnge = new hospital_manage();
				mnge.frame.setVisible(true);
				
			}
		});
		btnNewButton_5.setBounds(786, 468, 97, 25);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Refresh Before Retrival");
		lblNewLabel.setBounds(644, 463, 146, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				hospital_dash dash =new hospital_dash();
				dash.frame.setVisible(true);
			}
		});
		btnNewButton_6.setIcon(new ImageIcon(hospital_manage.class.getResource("/images/tinyarrow.png")));
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(12, 13, 65, 37);
		frame.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_1 = new JLabel("Hospital Name");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_1.setBounds(91, 93, 105, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Approve");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_2.setBounds(51, 388, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblDeny = new JLabel("Deny");
		lblDeny.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDeny.setBounds(174, 388, 65, 16);
		frame.getContentPane().add(lblDeny);
		
		JLabel lblDelete = new JLabel("Remove Hospital");
		lblDelete.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDelete.setBounds(76, 469, 122, 24);
		frame.getContentPane().add(lblDelete);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEmail.setBounds(109, 187, 65, 27);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(hospital_manage.class.getResource("/images/hospname.png")));
		lblNewLabel_3.setBounds(12, 133, 43, 34);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(hospital_manage.class.getResource("/images/email.png")));
		lblNewLabel_4.setBounds(12, 225, 43, 37);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(hospital_manage.class.getResource("/images/adminloginbackground.jpg")));
		lblNewLabel_5.setBounds(0, 0, 895, 510);
		frame.getContentPane().add(lblNewLabel_5);
	}

	public ArrayList<dbretrive>approvedList()
	{
		ArrayList<dbretrive> approvedList= new ArrayList<>();
		try {
		
			String query="SELECT * FROM register WHERE approval_status ='"+1+"'";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			dbretrive retrive;
			while(rs.next())
			{
				retrive=new dbretrive(rs.getString("hosp_name"),rs.getString("email"));
				approvedList.add(retrive);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return approvedList;
	}
	
	public void showapprovedrecords()
	{
		ArrayList<dbretrive> list= approvedList();
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		Object[] row = new Object[14];
		for(int i=0;i<list.size();i++)
		{
	
			row[0]=list.get(i).getHosp_name();
			row[1]=list.get(i).getEmail();
			model.addRow(row);
			
			
		}
	}
	
	public ArrayList<dbretrive>deniedList()
	{
		ArrayList<dbretrive> deniedList= new ArrayList<>();
		try {
		
			String query="SELECT * FROM register WHERE approval_status ='"+0+"'";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			dbretrive retrive;
			while(rs.next())
			{
				retrive=new dbretrive(rs.getString("hosp_name"),rs.getString("email"));
				deniedList.add(retrive);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return deniedList;
	}
	
	public void showdeniedrecords()
	{
		ArrayList<dbretrive> list= deniedList();
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		Object[] row = new Object[14];
		for(int i=0;i<list.size();i++)
		{
	
			row[0]=list.get(i).getHosp_name();
			row[1]=list.get(i).getEmail();
			model.addRow(row);
			
			
		}
	}
	
	
	

}
