package com.mokylin.tool;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.mokylin.tool.ui.database.DatabasePanel;
import com.mokylin.tool.ui.excel.ExcelPanel;
import com.mokylin.tool.ui.message.MessagePanel;

public class MainWindow {

	private JFrame frame;
	private ExcelPanel excelPanel;
	private MessagePanel messagePanel;
	private DatabasePanel databasePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public MainWindow() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton excelButton = new JButton("Excel");
		excelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messagePanel.hidden();
				databasePanel.hidden();
				excelPanel.show();
			}
		});
		excelButton.setBounds(10, 10, 93, 23);
		frame.getContentPane().add(excelButton);
		
		JButton databaseButton = new JButton("Database");
		databaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excelPanel.hidden();
				messagePanel.hidden();
				databasePanel.show();
			}
		});
		databaseButton.setBounds(10, 43, 93, 23);
		frame.getContentPane().add(databaseButton);
		
		JButton messageButton = new JButton("Message");
		messageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excelPanel.hidden();
				databasePanel.hidden();
				messagePanel.show();
			}
		});
		messageButton.setBounds(10, 76, 93, 23);
		frame.getContentPane().add(messageButton);
		
		excelPanel = new ExcelPanel(frame);
		messagePanel = new MessagePanel(frame);
		databasePanel = new DatabasePanel(frame);
	}
}
