package admin;
import java.sql.*;
import hospital.dbconfig;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class admin_addadmin {

	public JFrame frame;
	private JTable table;
	private JTextField email;
	private JPasswordField password;



	Connection con=null;
	
	
	public admin_addadmin() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 858, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnadd = new JButton("");
		btnadd.setBackground(Color.WHITE);
		btnadd.setIcon(new ImageIcon(admin_addadmin.class.getResource("/images/add admin.png")));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="INSERT INTO admin(email,password)VALUES(?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, email.getText());
					pstmt.setString(2, password.getText());
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfully Added");
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Add Admin");
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(349, 13, 135, 29);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				admin_managedash dash = new admin_managedash();
				dash.frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(admin_addadmin.class.getResource("/images/tinyarrow.png")));
		btnNewButton.setBounds(12, 13, 63, 38);
		frame.getContentPane().add(btnNewButton);
		btnadd.setBounds(133, 300, 117, 73);
		frame.getContentPane().add(btnadd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(362, 55, 466, 323);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email", "Password"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Refresh");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				admin_addadmin add = new admin_addadmin();
				add.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(621, 409, 97, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		email = new JTextField();
		email.setBounds(62, 121, 259, 38);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(admin_addadmin.class.getResource("/images/email.png")));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(30, 128, 32, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(admin_addadmin.class.getResource("/images/passwordd.png")));
		lblNewLabel_1.setBounds(30, 234, 32, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(66, 223, 255, 38);
		frame.getContentPane().add(password);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(admin_addadmin.class.getResource("/images/adminloginbackground.jpg")));
		lblNewLabel_2.setBounds(0, 0, 840, 466);
		frame.getContentPane().add(lblNewLabel_2);
		con=dbconfig.dbconf();
		showrecords();
	}

	public ArrayList<add>addadmin()
	{
		ArrayList<add> addadmin = new ArrayList<>();
		try {
			String query="SELECT * FROM admin";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			add ad;
			while(rs.next())
			{
				ad=new add(rs.getString("email"),rs.getString("password"));
				addadmin.add(ad);
			}
			
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(null, exc);
			
		}
		return addadmin;
	}
	public void showrecords()
	{
		ArrayList<add> list =addadmin();
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		Object[] row = new Object[2];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getEmail();
			row[1]=list.get(i).getPassword();
			model.addRow(row);
			
		}
	}
	

}
