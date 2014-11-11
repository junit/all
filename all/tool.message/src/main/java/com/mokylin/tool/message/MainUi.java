package com.mokylin.tool.message;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class MainUi extends JFrame implements ActionListener {
	private static final long serialVersionUID = -6067261849886344860L;
	@SuppressWarnings("rawtypes")
	private JList list;
	private List<CheckBox> checkBoxes = new ArrayList<>();
	private Properties properties;
	
	private HashMap<String, String> messagePathes = new HashMap<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUi frame = new MainUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainUi() throws Exception {
		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		for (CheckBox box : checkBoxes) {
			contentPane.add(box);
		}

		list = new JList(messagePathes.keySet().toArray());

		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setBounds(115, 10, 635, 509);
		scrollBar.setViewportView(list);
		contentPane.add(scrollBar);

		JButton create = new JButton("create");
		create.addActionListener(this);
		create.setBounds(681, 529, 93, 23);
		contentPane.add(create);
	}

	public boolean init() throws Exception {
		properties = new Properties();
		properties.load(new FileReader("config.properties"));
		File dir = new File(properties.getProperty("message_xml_path"));
		for (File file : dir.listFiles()) {
			if (!file.getName().endsWith("xml")) {
				continue;
			}
			messagePathes.put(file.getName(), file.getPath());
		}
		
		File configDir = new File("config");
		int count = 0;
		for (File file : configDir.listFiles()) {
			CheckBox checkBox = new CheckBox(file.getName());
			checkBox.getConfig().init(file);
			checkBox.setBounds(6, 6 + count * 26, 103, 23);
			checkBoxes.add(checkBox);
			++count;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (list.getSelectedValuesList().isEmpty()) {
			JOptionPane.showMessageDialog(null, "没有选择xml文件");
			return ;
		}
		
		for (CheckBox box : checkBoxes) {
			if (!box.isSelected()) {
				continue;
			}
			for (Object value : list.getSelectedValuesList()) {
				String path = messagePathes.get(value);
				try {
					Generator.generate(path, box.getConfig());
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "出错了，看日志");
					return ;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "操作成功");
	}
}
