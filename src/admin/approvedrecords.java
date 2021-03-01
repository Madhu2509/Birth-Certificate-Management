package admin;
import java.sql.*;
import java.util.ArrayList;
import hospital.dbconfig;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class approvedrecords {

	public JFrame frame;
	private JTable table;



	Connection con =null;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	public approvedrecords() {
	
		con=dbconfig.dbconf();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1107, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 52, 1077, 462);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index=table.getSelectedRow();
				TableModel model=table.getModel();
				String name=model.getValueAt(index, 0).toString();
				String place=model.getValueAt(index, 1).toString();
				String dob=model.getValueAt(index, 2).toString();
				String gender=model.getValueAt(index, 3).toString();
				String address=model.getValueAt(index, 4).toString();
				String phone=model.getValueAt(index, 5).toString();
				String email=model.getValueAt(index, 6).toString();
				rec.setVisible(true);
				rec.pack();
				rec.setLocationRelativeTo(null);
				rec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				rec.name_field.setText(name);
				rec.place_textfield.setText(place);
				rec.dob_textfield.setText(dob);
				rec.gender_field.setText(gender);
				rec.address_textfield.setText(address);
				rec.phone_textfield.setText(phone);
				rec.email_textfield.setText(email);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hospital Name", "Name", "Father Name", "Mother Name", "Place of Birth", "Date of Birth", "Gender", "Address", "Phone", "Email", "Height", "Weight", "Day", "Time"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(102);
		table.getColumnModel().getColumn(2).setPreferredWidth(99);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(98);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(approvedrecords.class.getResource("/images/refresh.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(539, 527, 73, 49);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				approvedrecords app =new approvedrecords();
				app.frame.setVisible(true);
				
			}
		});
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Approved Records");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(462, 5, 219, 34);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(scrollPane);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new admin_dash().frame.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(approvedrecords.class.getResource("/images/tinyarrow.png")));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(23, 5, 62, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		showrecords();
	}

	public ArrayList<request>approvedList()
	{
		ArrayList<request> approvedList= new ArrayList<>();
		try {
		
			String query="SELECT register.*,birthcerti.* FROM register INNER JOIN birthcerti ON hosp_nameid =hospita_id";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			request req;
			while(rs.next())
			{
				req=new request(rs.getString("hosp_name"),rs.getString("name"),rs.getString("fathers_name"),rs.getString("mothers_name"),rs.getString("birth_place"),rs.getString("dob"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("email"),rs.getString("height"),rs.getString("weight"),rs.getString("day"),rs.getString("time"));
				approvedList.add(req);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return approvedList;
	}
	
	public void showrecords()
	{
		ArrayList<request> list= approvedList();
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
	showapproved rec = new showapproved();
	
	
}
