package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class admin_dash {

	public  JFrame frame;


	public admin_dash() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 934, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnapproverecords = new JButton("");
		btnapproverecords.setIcon(new ImageIcon(admin_dash.class.getResource("/images/approved.png")));
		btnapproverecords.setBackground(new Color(255, 255, 255));
		btnapproverecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				approvedrecords appr = new approvedrecords();
				appr.frame.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login lgn =new login();
				lgn.framelogin.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(admin_dash.class.getResource("/images/logout.png")));
		btnNewButton.setBounds(817, 13, 87, 64);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Admin Management");
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_6.setBounds(549, 508, 133, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Hospital Management");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_5.setBounds(281, 505, 152, 24);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Certificates Denied");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_4.setBounds(712, 290, 121, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Certificates Approved");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_3.setBounds(429, 288, 143, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel(" Certificate Requests");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_1.setBounds(158, 287, 133, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Admin DashBoard");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(316, 56, 244, 44);
		frame.getContentPane().add(lblNewLabel);
		btnapproverecords.setBounds(429, 176, 143, 110);
		frame.getContentPane().add(btnapproverecords);
		
		JButton btnRequests = new JButton("");
		btnRequests.setBackground(new Color(255, 255, 255));
		btnRequests.setIcon(new ImageIcon(admin_dash.class.getResource("/images/req.png")));
		btnRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				requestedrecords rq = new requestedrecords();
				rq.frame.setVisible(true);
			}
		});
		btnRequests.setBounds(148, 176, 143, 110);
		frame.getContentPane().add(btnRequests);
		
		JButton btnRejected = new JButton("");
		btnRejected.setBackground(new Color(255, 255, 255));
		btnRejected.setIcon(new ImageIcon(admin_dash.class.getResource("/images/denied.png")));
		btnRejected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				deniedrecords dnr = new deniedrecords();
				dnr.frame.setVisible(true);
			}
		});
		btnRejected.setBounds(702, 176, 143, 110);
		frame.getContentPane().add(btnRejected);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon(admin_dash.class.getResource("/images/hosmanage.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				hospital_dash hsp =new hospital_dash();
				hsp.frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(271, 395, 143, 110);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setIcon(new ImageIcon(admin_dash.class.getResource("/images/adminicon.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				admin_managedash dash = new admin_managedash();
				dash.frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(539, 395, 143, 110);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setIcon(new ImageIcon(admin_dash.class.getResource("/images/6906.jpg")));
		lblNewLabel_2.setBounds(0, 0, 916, 572);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
