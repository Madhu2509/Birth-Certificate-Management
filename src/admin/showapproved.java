package admin;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

public class showapproved extends JFrame {

	private JPanel contentPane;
	public JTextField name_field;
	public JTextField place_textfield;
	public JTextField dob_textfield;
	public JTextField gender_field;
	public JTextField address_textfield;
	public JTextField phone_textfield;
	public JTextField email_textfield;


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
	public showapproved() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel paneltoprint = new JPanel();
		paneltoprint.setBounds(22, 13, 788, 393);
		contentPane.add(paneltoprint);
		paneltoprint.setLayout(null);
		
		name_field = new JTextField();
		name_field.setBorder(null);
		name_field.setBounds(45, 51, 241, 32);
		name_field.setOpaque(false);
		paneltoprint.add(name_field);
		name_field.setColumns(10);
		
		place_textfield = new JTextField();
		place_textfield.setBounds(45, 147, 227, 32);
		paneltoprint.add(place_textfield);
		place_textfield.setColumns(10);
		
		dob_textfield = new JTextField();
		dob_textfield.setBounds(30, 214, 270, 39);
		paneltoprint.add(dob_textfield);
		dob_textfield.setColumns(10);
		
		gender_field = new JTextField();
		gender_field.setBounds(45, 288, 270, 39);
		paneltoprint.add(gender_field);
		gender_field.setColumns(10);
		
		address_textfield = new JTextField();
		address_textfield.setBounds(369, 64, 270, 39);
		paneltoprint.add(address_textfield);
		address_textfield.setColumns(10);
		
		phone_textfield = new JTextField();
		phone_textfield.setBounds(383, 144, 270, 39);
		paneltoprint.add(phone_textfield);
		phone_textfield.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 409, 795, 68);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("print");
		panel.add(btnNewButton);
		
		email_textfield = new JTextField();
		email_textfield.setColumns(10);
		email_textfield.setBounds(470, 144, 270, 39);
		contentPane.add(email_textfield);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				printRecord(paneltoprint);
			}
		});
	}
}
