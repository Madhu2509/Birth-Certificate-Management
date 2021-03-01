package admin;
import hospital.dbconfig;
import net.proteanit.sql.DbUtils;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
public class requestedrecords {

	public JFrame frame;
	private JTable table;
	private JTextField name;

 
	Connection con=null;
	public requestedrecords() {
		con=dbconfig.dbconf();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1302, 819);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 52, 1303, 397);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hospital Name", "Name", "Father Name", "Mother Name", "Birth Place", "Date Of Birth", "Gender", "Address", "Phone", "Email", "Height", "Weigth", "Day", "Time"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(113);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		table.getColumnModel().getColumn(3).setPreferredWidth(101);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
		scrollPane.setViewportView(table);
		
		JButton btnrefresh = new JButton("");
		btnrefresh.setIcon(new ImageIcon(requestedrecords.class.getResource("/images/refresh.png")));
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new requestedrecords().frame.setVisible(true);

			}
		});
		btnrefresh.setBounds(970, 456, 84, 65);
		frame.getContentPane().add(btnrefresh);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 15));
		comboBox.setBounds(632, 499, 96, 22);
		frame.getContentPane().add(comboBox);
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection cond =DriverManager.getConnection("jdbc:mysql://localhost/birth","root","");
			String query="SELECT register.*,request.* FROM register INNER JOIN request ON hospita_id =hosp_nameid";
			PreparedStatement pstmt =cond.prepareStatement(query);
			ResultSet rs =pstmt.executeQuery();
			while(rs.next())
			{	
			comboBox.addItem(rs.getString("hosp_name"));
			}
		}
		catch(Exception exx)
		{
			JOptionPane.showMessageDialog(null, exx);
		}
		
		JButton btnapprove = new JButton("");
		btnapprove.setBackground(Color.WHITE);
		btnapprove.setIcon(new ImageIcon(requestedrecords.class.getResource("/images/icons8-tick-box-100.png")));
		btnapprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/birth","root","");
						//query to move data from one table to another
				String query="INSERT INTO birthcerti(hosp_nameid,name,fathers_name,mothers_name,birth_place,dob,gender,address,phone,email,height,weight,day,time)SELECT hosp_nameid,name,fathers_name,mothers_name,birth_place,dob,gender,address,phone,email,height,weight,day,time FROM request WHERE hosp_nameid=?  AND name=?";
				
				//query to delete data from table after transferring.
				String query3="DELETE FROM request WHERE id=?";
				PreparedStatement pstmt3 = con.prepareStatement(query3);
//				String name =name.getText();
				String query4="SELECT id FROM request WHERE name='"+name.getText()+"'";
				
				PreparedStatement pstmt4 =con.prepareStatement(query4);
				ResultSet rs2= pstmt4.executeQuery();
				while(rs2.next())
				{
					String del_id=rs2.getString("id");
					pstmt3.setString(1, del_id);
				}
		
				
				PreparedStatement pstmt = con.prepareStatement(query);
				String hos;
				hos=comboBox.getSelectedItem().toString();
				String query2="SELECT hospita_id FROM register WHERE hosp_name='"+hos+"'";
				PreparedStatement pstmt2 = con.prepareStatement(query2);
				ResultSet rs = pstmt2.executeQuery();
				while(rs.next())
				{
					String id=rs.getString("hospita_id");
					pstmt.setString(1,id);
				}
				
				pstmt.setString(2, name.getText());
				pstmt.executeUpdate();
				pstmt3.executeUpdate();
		        JOptionPane.showMessageDialog(null, "Approved");
		        
				}
				catch(Exception excep)
				{
					JOptionPane.showMessageDialog(null, excep);
					
				}
				
			}
		});
		btnapprove.setBounds(555, 680, 84, 65);
		frame.getContentPane().add(btnapprove);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(requestedrecords.class.getResource("/images/denied.png")));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String query="INSERT INTO denied(hosp_nameid,name,fathers_name,mothers_name,birth_place,dob,gender,address,phone,email,height,weight,day,time)SELECT hosp_nameid,name,fathers_name,mothers_name,birth_place,dob,gender,address,phone,email,height,weight,day,time FROM request WHERE hosp_nameid=?  AND name=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					
					String query3="DELETE FROM request WHERE id =?";
					PreparedStatement pstmt3=con.prepareStatement(query3);
					
					String query4="SELECT id FROM request WHERE name='"+name.getText()+"'";
					PreparedStatement pstmt4=con.prepareStatement(query4);
					ResultSet rs2=pstmt4.executeQuery();
					while(rs2.next())
					{
						String del_id;
						del_id=rs2.getString("id");
						pstmt3.setString(1,del_id);
					}
					
					String hos;
					hos=comboBox.getSelectedItem().toString();
					String query2="SELECT hospita_id FROM register WHERE hosp_name='"+hos+"'";
					PreparedStatement pstmt2=con.prepareStatement(query2);
					ResultSet rs = pstmt2.executeQuery();
					while(rs.next())
					{
						String id;
						id=rs.getString("hospita_id");
						pstmt.setString(1, id);
					}
					pstmt.setString(2, name.getText());
					pstmt.executeUpdate();
					pstmt3.executeUpdate();
					JOptionPane.showMessageDialog(null, "Denied");
					
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton_2.setBounds(722, 680, 84, 65);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel.setBounds(522, 569, 48, 22);
		frame.getContentPane().add(lblNewLabel);
		
		name = new JTextField();
		name.setFont(new Font("Calibri", Font.PLAIN, 15));
		name.setBounds(576, 565, 234, 32);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Approve");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_1.setBounds(576, 659, 63, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDeny = new JLabel("Deny");
		lblDeny.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDeny.setBounds(745, 659, 48, 22);
		frame.getContentPane().add(lblDeny);
		
		JLabel lblNewLabel_2 = new JLabel("Refresh");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_2.setBounds(970, 473, 54, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Requested Certificates");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_3.setBounds(522, 0, 257, 39);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new admin_dash().frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(requestedrecords.class.getResource("/images/tinyarrow.png")));
		btnNewButton.setBounds(12, 3, 63, 39);
		frame.getContentPane().add(btnNewButton);
		showrecords();
	}

	public ArrayList<request>requestedList()
	{
		ArrayList<request> requestedList= new ArrayList<>();
		try {
			String query="SELECT register.*,request.* FROM register INNER JOIN request ON hosp_nameid =hospita_id";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			request req;
			while(rs.next())
			{
				req=new request(rs.getString("hosp_name"),rs.getString("name"),rs.getString("fathers_name"),rs.getString("mothers_name"),rs.getString("birth_place"),rs.getString("dob"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("email"),rs.getString("height"),rs.getString("weight"),rs.getString("day"),rs.getString("time"));
				requestedList.add(req);
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return requestedList;
	}
	public void showrecords()
	{
		ArrayList<request> list= requestedList();
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		Object[] row = new Object[14];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getHosp_name();
			row[1]=list.get(i).getName();
			row[2]=list.get(i).getFathers_name();
			row[3]=list.get(i).getMothers_name();
			row[4]=list.get(i).getBirth_place();
			row[5]=list.get(i).getDob();
			row[6]=list.get(i).getGender();
			row[7]=list.get(i).getAddress();
			row[8]=list.get(i).getPhone();
			row[9]=list.get(i).getEmail();
			row[10]=list.get(i).getHeight();
			row[11]=list.get(i).getWeight();
			row[12]=list.get(i).getDay();
			row[13]=list.get(i).getTime();
			model.addRow(row);
			
		}
	}
	
	
	

}
