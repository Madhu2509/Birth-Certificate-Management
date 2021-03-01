package admin;

import java.sql.*;
import hospital.dbconfig;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class hospital_denied {

	public JFrame frame;
	private JTable table;
	


	Connection con =null;
	
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
	
	public void showrecords()
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
	
	public hospital_denied() {
		con=dbconfig.dbconf();
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Denied Hospitals");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(296, 13, 220, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 106, 802, 255);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hospital Name", "Email"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(113);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				hospital_dash manage = new hospital_dash();
				manage.frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(hospital_approved.class.getResource("/images/tinyarrow.png")));
		btnNewButton.setBounds(10, 13, 60, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				hospital_denied den =new hospital_denied();
				den.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(350, 374, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(hospital_denied.class.getResource("/images/adminloginbackground.jpg")));
		lblNewLabel_2.setBounds(0, 0, 802, 434);
		frame.getContentPane().add(lblNewLabel_2);
		showrecords();
		
	}


	

}
