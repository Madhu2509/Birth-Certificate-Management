package admin;

import java.util.ArrayList;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import hospital.dbconfig;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
public class admin_updateadmin {

	public JFrame frame;
	private JTable table;
	private JTextField email;
	private JPasswordField password;

	
	Connection con=null;
	public static void main(String[] args)
	{
		
		admin_updateadmin upda = new admin_updateadmin();
		upda.frame.setVisible(true);
	}
	public admin_updateadmin() {
		con=dbconfig.dbconf();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 881, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
			}
		});
		scrollPane.setBounds(362, 25, 489, 341);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table.getSelectedRow();
				TableModel model = table.getModel();
				email.setText(model.getValueAt(i, 0).toString());
				password.setText(model.getValueAt(i, 1).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email", "Password"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnrefresh = new JButton("Refresh");
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				admin_updateadmin update = new admin_updateadmin();
				update.frame.setVisible(true);
			}
		});
		btnrefresh.setBounds(598, 392, 97, 25);
		frame.getContentPane().add(btnrefresh);
		
		email = new JTextField();
		email.setText("Email");
		email.setBounds(63, 120, 230, 35);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(63, 239, 230, 35);
		frame.getContentPane().add(password);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon(admin_updateadmin.class.getResource("/images/manage.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass=password.getText();
				if(email.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Email");
				}
				else if(pass.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Password");
					
				}
				else {
					
		
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String query="UPDATE admin SET Email= ?,Password= ? WHERE id= ?";
					PreparedStatement pstmt = con.prepareStatement(query);
					
					String query2="SELECT id FROM admin WHERE Email='"+email.getText()+"'";
					PreparedStatement pstmt2 =con.prepareStatement(query2);
					 
					
					
					ResultSet rs = pstmt2.executeQuery();
					while(rs.next())
					{
						String id;
						id=rs.getString("id");
						pstmt.setString(3, id);
					}
					pstmt.setString(1, email.getText());
					pstmt.setString(2, password.getText());
					
					pstmt.executeUpdate();
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		}
		});
		btnNewButton_1.setBounds(53, 310, 83, 56);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon(admin_updateadmin.class.getResource("/images/denied.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query="DELETE FROM admin WHERE id= ?";
					PreparedStatement pst = con.prepareStatement(query);
					String query2="SELECT id  FROM admin WHERE email='"+email.getText()+"'";
					PreparedStatement pst2 = con.prepareStatement(query2);
					ResultSet rstt =pst2.executeQuery();
					while(rstt.next())
					{
						String id=rstt.getString("id");
						pst.setString(1, id);
						
					}
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Deletion Success");
				}
				catch (Exception excep)
				{
					JOptionPane.showMessageDialog(null, excep);
				}
			}
		});
		btnNewButton_2.setBounds(167, 310, 83, 56);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				admin_managedash manage_dash = new admin_managedash();
				manage_dash.frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(admin_updateadmin.class.getResource("/images/tinyarrow.png")));
		btnNewButton.setBounds(12, 13, 44, 35);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Update");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_2.setBounds(63, 371, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Delete");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_3.setBounds(189, 371, 44, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(admin_updateadmin.class.getResource("/images/email.png")));
		lblNewLabel.setBounds(28, 120, 39, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(admin_updateadmin.class.getResource("/images/passwordd.png")));
		lblNewLabel_1.setBounds(33, 239, 34, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(admin_updateadmin.class.getResource("/images/adminloginbackground.jpg")));
		lblNewLabel_4.setBounds(0, 0, 863, 464);
		frame.getContentPane().add(lblNewLabel_4);
		showrecords();
		
	}
	
	ArrayList<add> updateadmin()
	{
		ArrayList<add> updateadmin = new ArrayList<>();
		try {
			String query="SELECT * FROM admin";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			add ad;
			while(rs.next())
			{
				ad=new add(rs.getString("email"),rs.getString("password"));
				updateadmin.add(ad);
			}
			
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(null, exc);
			
		}
		return updateadmin;
	}
	public void showrecords()
	{
		ArrayList<add> list =updateadmin();
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
