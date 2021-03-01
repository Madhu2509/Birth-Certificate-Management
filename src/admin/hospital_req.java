package admin;

import hospital.dbconfig;
import java.sql.*;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class hospital_req {

	public JFrame frame;
	private JTable table;

	Connection con=null;
	
	public ArrayList<hospital> hospitalList()
	{
		ArrayList<hospital> hospitalList= new ArrayList<>();
		try {
			String query="SELECT * FROM register WHERE approval_status=-1";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			hospital hosp;
			while(rs.next())
			{
				hosp=new hospital(rs.getString("hosp_name"),rs.getString("email"));
				hospitalList.add(hosp);
				
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return hospitalList;
	}
	public void showrecords()
	{
		ArrayList<hospital> list =hospitalList();
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		Object[] row = new Object[2];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getHosp_name();
			row[1]=list.get(i).getEmail();
			model.addRow(row);
			
		}
	}

	
	
	public hospital_req() {
		con=dbconfig.dbconf();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 832, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblApprove = new JLabel("Deny");
		lblApprove.setFont(new Font("Calibri", Font.BOLD, 15));
		lblApprove.setBounds(184, 327, 56, 16);
		frame.getContentPane().add(lblApprove);
		
		JLabel lblNewLabel_3 = new JLabel("Approve");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_3.setBounds(22, 327, 56, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 69, 518, 363);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name ", "Email"
			}
		));
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(95, 114, 87, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(hospital_req.class.getResource("/images/icons8-tick-box-100.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String hosp_name=comboBox.getSelectedItem().toString();
					String query="UPDATE register SET approval_status='"+1+"'WHERE email='"+hosp_name+"'";
					PreparedStatement pstmt =con.prepareStatement(query);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Hospital is Approved");
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		btnNewButton.setBounds(12, 243, 78, 71);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(hospital_req.class.getResource("/images/denied.png")));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String hosp_name=comboBox.getSelectedItem().toString();
					String query="UPDATE register SET approval_status='"+0+"'WHERE email='"+hosp_name+"'";
					PreparedStatement pstmt =con.prepareStatement(query);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Hospital is Denied");
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnNewButton_1.setBounds(155, 243, 97, 71);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(hospital_req.class.getResource("/images/hospname.png")));
		lblNewLabel.setBounds(55, 105, 35, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Requested Hospitals");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_1.setBounds(335, 5, 239, 51);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Refresh");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				hospital_req request = new hospital_req();
				request.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(570, 445, 97, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				hospital_dash manage = new hospital_dash();
				manage.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setIcon(new ImageIcon(hospital_req.class.getResource("/images/tinyarrow.png")));
		btnNewButton_3.setBounds(22, 9, 56, 33);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(hospital_req.class.getResource("/images/adminloginbackground.jpg")));
		lblNewLabel_2.setBounds(0, 0, 814, 540);
		frame.getContentPane().add(lblNewLabel_2);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/birth","root","");
			String query="SELECT email FROM register WHERE approval_status=-1";
			PreparedStatement pstmt1 =con.prepareStatement(query);
			ResultSet rs =pstmt1.executeQuery();
			while(rs.next())
			{
//				String hopitalname= rs.getString("hosp_name");
				comboBox.addItem( rs.getString("email").toString());
			}
			
			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex);
		}
		showrecords();
	}


}
