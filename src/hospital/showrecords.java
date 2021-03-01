package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class showrecords extends JFrame {

	private JPanel contentPane;
	public JTextField name;
	public JTextField fathername;
	public JTextField mothername;
	public JTextField date;
	public JTextField day;
	public JTextField hospitalname;
	public JTextField time;
	public JTextField placeofbirth;
	public JTextField weight;
	public JTextField height;


	private void printRecord(JPanel panel)
	{
		PrinterJob printerJob =PrinterJob.getPrinterJob();
		printerJob.setJobName("print record");
		
		printerJob.setPrintable(new Printable() {
			
			@Override
			public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

				if(pageIndex>0)
				{
					return Printable.NO_SUCH_PAGE;
				}
				
				Graphics2D graphics2d= (Graphics2D)graphics;
				graphics2d.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);
				graphics2d.scale(0.5, 0.5);
				
				panel.paint(graphics2d);
				return Printable.PAGE_EXISTS;
			
			}
		});
		
		boolean returningResult = printerJob.printDialog();
		
		if(returningResult)
		{
			  try{
	                // Now call print method inside printerJob to print
	                printerJob.print();
	            }catch (PrinterException printerException){
	                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
	            }
		}
		
		
		
	}
	
	
	
	
	
	public showrecords() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 819);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel certificate = new JPanel();
		certificate.setBackground(Color.WHITE);
		certificate.setBounds(12, 0, 836, 654);
		contentPane.add(certificate);
		certificate.setLayout(null);
		
		name = new JTextField();
		name.setFont(new Font("Calibri", Font.BOLD, 18));
		name.setOpaque(false);
		name.setBorder(null);
		name.setBounds(354, 209, 116, 22);
		certificate.add(name);
		name.setColumns(10);
		
		fathername = new JTextField();
		fathername.setFont(new Font("Calibri", Font.BOLD, 18));
		fathername.setOpaque(false);
		fathername.setBorder(null);
		fathername.setBounds(168, 305, 116, 22);
		certificate.add(fathername);
		fathername.setColumns(10);
		
		placeofbirth = new JTextField();
		placeofbirth.setFont(new Font("Calibri", Font.BOLD, 18));
		placeofbirth.setOpaque(false);
		placeofbirth.setBorder(null);
		placeofbirth.setText("");
		placeofbirth.setBounds(486, 475, 116, 22);
		certificate.add(placeofbirth);
		placeofbirth.setColumns(10);
		
		mothername = new JTextField();
		mothername.setFont(new Font("Calibri", Font.BOLD, 18));
		mothername.setOpaque(false);
		mothername.setBorder(null);
		mothername.setText("");
		mothername.setBounds(502, 305, 116, 22);
		certificate.add(mothername);
		mothername.setColumns(10);
		
		hospitalname = new JTextField();
		hospitalname.setFont(new Font("Calibri", Font.BOLD, 18));
		hospitalname.setOpaque(false);
		hospitalname.setBorder(null);
		hospitalname.setBounds(315, 424, 205, 23);
		certificate.add(hospitalname);
		hospitalname.setColumns(10);
		
		height = new JTextField();
		height.setFont(new Font("Calibri", Font.BOLD, 18));
		height.setOpaque(false);
		height.setBorder(null);
		height.setText("");
		height.setBounds(502, 534, 116, 22);
		certificate.add(height);
		height.setColumns(10);
		
		date = new JTextField();
		date.setFont(new Font("Calibri", Font.BOLD, 18));
		date.setOpaque(false);
		date.setBorder(null);
		date.setBounds(209, 362, 116, 22);
		certificate.add(date);
		date.setColumns(10);
		
		day = new JTextField();
		day.setFont(new Font("Calibri", Font.BOLD, 18));
		day.setOpaque(false);
		day.setBorder(null);
		day.setText("");
		day.setBounds(502, 362, 116, 22);
		certificate.add(day);
		day.setColumns(10);
		
		time = new JTextField();
		time.setFont(new Font("Calibri", Font.BOLD, 18));
		time.setOpaque(false);
		time.setBorder(null);
		time.setText("");
		time.setBounds(227, 475, 116, 22);
		certificate.add(time);
		time.setColumns(10);
		
		weight = new JTextField();
		weight.setFont(new Font("Calibri", Font.BOLD, 18));
		weight.setOpaque(false);
		weight.setBorder(null);
		weight.setText("");
		weight.setBounds(227, 534, 116, 22);
		certificate.add(weight);
		weight.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(showrecords.class.getResource("/images/birth_certificate_model.jpg")));
		lblNewLabel.setBounds(0, 13, 859, 642);
		certificate.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(396, 693, 96, 66);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(0, 0, 96, 66);
		btnNewButton.setIcon(new ImageIcon(showrecords.class.getResource("/images/print.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printRecord(certificate);
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
	}

}
