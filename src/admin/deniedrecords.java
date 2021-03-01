package admin;
import java.sql.*;
import hospital.dbconfig;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class deniedrecords {

	public JFrame frame;
	private JTable table;

	

	Connection con=null;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	public deniedrecords() {
		con=dbconfig.dbconf();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1130, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 80, 1134, 383);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setGridColor(Color.BLACK);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Cambria", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hospital Name", "Name", "Father Name", "Mother Name", "Place of Birth", "Date of Birth", "Gender", "Address", "Phone", "Email", "Height", "Weight", "Day", "Time"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(94);
		scrollPane.setViewportView(table);
		
		JButton btnrefresh = new JButton("");
		btnrefresh.setBackground(Color.WHITE);
		btnrefresh.setIcon(new ImageIcon(deniedrecords.class.getResource("/images/refresh.png")));
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				deniedrecords drec =new deniedrecords();
				drec.frame.setVisible(true);
			}
		});
		btnrefresh.setBounds(524, 476, 73, 51);
		frame.getContentPane().add(btnrefresh);
		
		lblNewLabel = new JLabel("Denied Certificates");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(459, 13, 207, 31);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new admin_dash().frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(deniedrecords.class.getResource("/images/tinyarrow.png")));
		btnNewButton.setBounds(12, 13, 55, 41);
		frame.getContentPane().add(btnNewButton);
		con=dbconfig.dbconf();
		showrecords();
	}
	
	public ArrayList<request> deniedList()
	{
		ArrayList<request> deniedList=new ArrayList<>();
		try {
			String query="SELECT register.*,denied.* FROM register INNER JOIN denied ON hosp_nameid =hospita_id";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			request req;
			while(rs.next())
			{
				req=new request(rs.getString("hosp_name"),rs.getString("name"),rs.getString("fathers_name"),rs.getString("mothers_name"),rs.getString("birth_place"),rs.getString("dob"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("email"),rs.getString("height"),rs.getString("weight"),rs.getString("day"),rs.getString("time"));
				deniedList.add(req);
			}
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		return deniedList;
	}
	public void showrecords()
	{
		ArrayList<request> list= deniedList();
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
