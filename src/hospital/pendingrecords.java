package hospital;

import java.sql.*;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pendingrecords {

	public JFrame frame;
	private JTable table;
	public JTextField pendinghosid;

	
	Connection con=null;
	public pendingrecords() {
		
		con=dbconfig.dbconf();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1121, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 113, 1103, 301);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hospital Name", "Name", "Father Name", "Mother Name", "Place Of Birth", "Date Of Birth", "Gender", "Address", "Phone", "Email", "Height", "Weight", "Day", "Time"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(104);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		table.getColumnModel().getColumn(4).setPreferredWidth(117);
		table.getColumnModel().getColumn(5).setPreferredWidth(104);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Pending Approval");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(514, 38, 192, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String id=pendinghosid.getText();
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
		btnNewButton.setIcon(new ImageIcon(pendingrecords.class.getResource("/images/tinyarrow.png")));
		btnNewButton.setBounds(23, 26, 61, 44);
		frame.getContentPane().add(btnNewButton);
		
		pendinghosid = new JTextField();
		pendinghosid.setBorder(null);
		pendinghosid.setBounds(204, 38, 116, 22);
		frame.getContentPane().add(pendinghosid);
		pendinghosid.setColumns(10);
		pendinghosid.setEditable(false);
		pendinghosid.setOpaque(false);
		
//		pendinghosid.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Retrive Records");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showrecords();
			}
		});
		btnNewButton_1.setBounds(485, 465, 123, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Hospital Id");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_1.setBounds(125, 38, 84, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(pendingrecords.class.getResource("/images/adminloginbackground.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1103, 556);
		frame.getContentPane().add(lblNewLabel_2);
		
		
	}

	

	public ArrayList<dbretrive>pendingList()
	{
		ArrayList<dbretrive> pendingList= new ArrayList<>();
		try {
			
			
			String current_user=pendinghosid.getText();
			
			String query="SELECT register.*,request.* FROM register INNER JOIN request ON hosp_nameid =hospita_id WHERE hosp_nameid='"+current_user+"'";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			dbretrive dbrev;
			while(rs.next())
			{
				dbrev=new dbretrive(rs.getString("hosp_name"),rs.getString("name"),rs.getString("fathers_name"),rs.getString("mothers_name"),rs.getString("birth_place"),rs.getString("dob"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("email"),rs.getString("height"),rs.getString("weight"),rs.getString("day"),rs.getString("time"));
				pendingList.add(dbrev);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return pendingList;
	}
	public void showrecords()
	{
		ArrayList<dbretrive> list= pendingList();
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
