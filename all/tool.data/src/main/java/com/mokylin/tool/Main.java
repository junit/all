package com.mokylin.tool;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.mokylin.tool.core.util.FileUtil;
import com.mokylin.tool.db.DbOpt;
import com.mokylin.tool.excel.ExcelOpt;

public class Main extends JFrame {
	private static final long serialVersionUID = 7975473610009954340L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JRadioButton config;
	private JRadioButton data;
	private JRadioButton excel;
	private JButton genButton;
	private JButton genButton0;
	private JButton genButton2;
	private JButton genButton3;
	@SuppressWarnings("rawtypes")
	private JList list;
	private Generator generator;
	private ExcelOpt excelOpt;

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Main() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream("config.properties"));
		generator = new Generator(properties);
		excelOpt = new ExcelOpt();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 793);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		data = new JRadioButton("数据");
		data.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					config.setSelected(false);
					excel.setSelected(false);
					list.setListData(DbOpt.getInstance().getDataTables());

					genButton.setVisible(true);
					genButton2.setVisible(true);
					genButton3.setVisible(true);
					genButton0.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		data.setBounds(16, 6, 121, 23);
		contentPane.add(data);

		config = new JRadioButton("配置");
		config.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					data.setSelected(false);
					excel.setSelected(false);
					list.setListData(DbOpt.getInstance().getConfigTables());

					genButton.setVisible(true);
					genButton2.setVisible(true);
					genButton3.setVisible(true);
					genButton0.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		config.setBounds(139, 6, 121, 23);
		contentPane.add(config);

		excel = new JRadioButton("excel");
		excel.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					data.setSelected(false);
					config.setSelected(false);
					File excelDir = new File(properties.getProperty("excel"));
					list.setListData(excelDir.list());

					genButton.setVisible(false);
					genButton2.setVisible(false);
					genButton3.setVisible(false);
					genButton0.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		excel.setBounds(262, 6, 121, 23);
		contentPane.add(excel);

		list = new JList();

		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setBounds(16, 35, 692, 680);
		scrollBar.setViewportView(list);
		contentPane.add(scrollBar);
		
		genButton0 = new JButton("import");
		genButton0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				for (Object table : list.getSelectedValuesList()) {
					try {
						if (excel.isSelected()) {
							excelOpt.process(FileUtil.getFilePath(properties.getProperty("excel"), (String)table));
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "操作成功");
			}
		});
		genButton0.setBounds(615, 722, 93, 23);
		contentPane.add(genButton0);
		genButton0.setVisible(false);

		genButton = new JButton("server");
		genButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				for (Object table : list.getSelectedValuesList()) {
					try {
						if (data.isSelected()) {
							generator.generateData((String) table, FtlType.SERVER);
						}
						if (config.isSelected()) {
							generator.generateConfig((String) table, FtlType.SERVER);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "操作成功");
			}
		});
		genButton.setBounds(615, 722, 93, 23);
		contentPane.add(genButton);

		genButton2 = new JButton("robot");
		genButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				for (Object table : list.getSelectedValuesList()) {
					try {
						if (data.isSelected()) {
							generator.generateData((String) table, FtlType.ROBOT);
						}
						if (config.isSelected()) {
							generator.generateConfig((String) table, FtlType.ROBOT);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "操作成功");
			}
		});
		genButton2.setBounds(522, 722, 93, 23);
		contentPane.add(genButton2);

		genButton3 = new JButton("client");
		genButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				for (Object table : list.getSelectedValuesList()) {
					try {
						if (data.isSelected()) {
							generator.generateData((String) table, FtlType.CLIENT);
						}
						if (config.isSelected()) {
							generator.generateConfig((String) table, FtlType.CLIENT);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "操作成功");
			}
		});
		genButton3.setBounds(429, 722, 93, 23);
		contentPane.add(genButton3);
	}
}
