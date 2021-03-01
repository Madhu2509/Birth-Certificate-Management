package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import admin.request;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class approvedcertificates {

	public JFrame frame;
	private JTable table;
	public JTextField hosp_emailhid;



	Connection con=null;
	public approvedcertificates() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1289, 607);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(0, 92, 1271, 366);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index=table.getSelectedRow();
				TableModel model=table.getModel();
				String hospitalname=model.getValueAt(index, 0).toString();
				String name=model.getValueAt(index, 1).toString();
				String fathername=model.getValueAt(index, 2).toString();
				String mothername=model.getValueAt(index, 3).toString();
				String placeofbirth=model.getValueAt(index, 4).toString();
				String dateofbirth=model.getValueAt(index, 5).toString();
				String gender=model.getValueAt(index, 6).toString();
				String address=model.getValueAt(index, 7).toString();
				String phone=model.getValueAt(index, 8).toString();
				String email=model.getValueAt(index, 9).toString();
				String height=model.getValueAt(index, 10).toString();
				String weigth=model.getValueAt(index, 11).toString();
				String day=model.getValueAt(index, 12).toString();
				String timet=model.getValueAt(index, 13).toString();
				
				
				
				recd.setVisible(true);
				recd.pack();
				recd.setLocationRelativeTo(null);
				recd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				recd.hospitalname.setText(hospitalname);
				recd.name.setText(name);
				recd.fathername.setText(fathername);
				recd.mothername.setText(mothername);
				recd.placeofbirth.setText(placeofbirth);
				recd.date.setText(dateofbirth);
				recd.day.setText(day);
				recd.height.setText(height);
				recd.weight.setText(weigth);
				recd.time.setText(timet);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hospital Name", "Name", "Father Name", "Mother Name", "Place of Birth", "Date of Birth", "Gender", "Address", "Phone", "Email", "Height", "Weight", "Day", "Time"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Approved Certificates");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(487, 13, 240, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id=hosp_emailhid.getText();
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
		btnNewButton_1.setIcon(new ImageIcon(approvedcertificates.class.getResource("/images/tinyarrow.png")));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 13, 51, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		hosp_emailhid = new JTextField();
		hosp_emailhid.setBorder(null);
		hosp_emailhid.setFont(new Font("Calibri", Font.BOLD, 15));
		hosp_emailhid.setBounds(212, 19, 116, 22);
		frame.getContentPane().add(hosp_emailhid);
		hosp_emailhid.setColumns(10);
		hosp_emailhid.setOpaque(false);
		hosp_emailhid.setEditable(false);
//		hosp_emailhid.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("Retrive Records");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showrecords();
			}
		});
		btnNewButton_2.setBounds(538, 471, 156, 31);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Hospital id");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_1.setBounds(132, 20, 95, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(approvedcertificates.class.getResource("/images/adminloginbackground.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1271, 560);
		frame.getContentPane().add(lblNewLabel_2);
		con=dbconfig.dbconf();
		showrecords();
	}

	
	public ArrayList<dbretrive>approvedList()
	{
		ArrayList<dbretrive> approvedList= new ArrayList<>();
		try {
			
			
			String current_user=hosp_emailhid.getText();
			String query="SELECT register.*,birthcerti.* FROM register INNER JOIN birthcerti ON hosp_nameid =hospita_id WHERE hosp_nameid='"+current_user+"'";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			dbretrive dbrev;
			while(rs.next())
			{
				dbrev=new dbretrive(rs.getString("hosp_name"),rs.getString("name"),rs.getString("fathers_name"),rs.getString("mothers_name"),rs.getString("birth_place"),rs.getString("dob"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("email"),rs.getString("height"),rs.getString("weight"),rs.getString("day"),rs.getString("time"));
				approvedList.add(dbrev);
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
		ArrayList<dbretrive> list= approvedList();
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
	
	showrecords recd =new showrecords();
	
	
}
