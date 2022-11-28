package codes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Button;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private GroupLayout gl_contentPane;
	private JToolBar toolBar;
	private JLabel lblNewLabel;

	private JRadioButton radio_1;
	private JRadioButton radio_2;
	private JRadioButton radio_3;
	
	private JButton btn_exit;
	private JButton btn_detail;
	private JButton btn_select;
	
	enum view_type{STORAGE, DRUG, MANUFACTURE, SELL, PATIENT};
	private view_type current_type = view_type.STORAGE;

	private JTextField text_1;
	private JTextField text_2;
	private JTextField text_3;
	private JRadioButton radio_4;
	private JTextField text_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("药店管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 800);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(64, 128, 128));
		contentPane.setBackground(new Color(219, 255, 251));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		
		model = new DefaultTableModel(new Object[][] {
			},
			new String[] {
				"\u4ED3\u5E93\u7F16\u53F7", "\u4ED3\u5E93\u540D\u79F0", "\u836F\u54C1\u7F16\u53F7", "\u836F\u54C1\u6570\u91CF"
			});
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setEnabled(false);
		toolBar.setRollover(true);
		toolBar.setBackground(new Color(0, 64, 0));
		toolBar.setForeground(new Color(64, 128, 128));
		toolBar.setOrientation(SwingConstants.VERTICAL);
		
		scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("    ");
		btnNewButton.setEnabled(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(0, 64, 0));
		btnNewButton.setBorderPainted(false);
		
		JButton btn_storage = new JButton("  库存信息  ");
		btn_storage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_storage();
			}
		});
		
		JButton btnNewButton_4 = new JButton("    ");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(new Color(0, 64, 0));
		toolBar.add(btnNewButton_4);
		btn_storage.setForeground(Color.WHITE);
		btn_storage.setFont(new Font("宋体", Font.PLAIN, 25));
		btn_storage.setBackground(new Color(0, 64, 0));
		btn_storage.setBorderPainted(false);
		toolBar.add(btn_storage);
		toolBar.add(btnNewButton);
		
		JButton btn_drug = new JButton("  药品信息  ");
		btn_drug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_drug();
			}
		});
		btn_drug.setForeground(Color.WHITE);
		btn_drug.setFont(new Font("宋体", Font.PLAIN, 25));
		btn_drug.setBackground(new Color(0, 64, 0));
		btn_drug.setBorderPainted(false);
		toolBar.add(btn_drug);
		
		JButton btnNewButton_2 = new JButton("    ");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2.setBackground(new Color(0, 64, 0));
		btnNewButton_2.setBorderPainted(false);
		toolBar.add(btnNewButton_2);
		
		JButton btn_manu = new JButton(" 制药商信息 ");
		btn_manu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_manu();
			}
		});
		btn_manu.setForeground(Color.WHITE);
		btn_manu.setFont(new Font("宋体", Font.PLAIN, 25));
		btn_manu.setBackground(new Color(0, 64, 0));
		btn_manu.setBorderPainted(false);
		toolBar.add(btn_manu);
		
		JButton btnNewButton_2_1 = new JButton("    ");
		btnNewButton_2_1.setEnabled(false);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2_1.setBackground(new Color(0, 64, 0));
		btnNewButton_2_1.setBorderPainted(false);
		toolBar.add(btnNewButton_2_1);
		
		JButton btn_sell = new JButton("  销售信息  ");
		btn_sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_sell();
			}
		});
		btn_sell.setForeground(Color.WHITE);
		btn_sell.setFont(new Font("宋体", Font.PLAIN, 25));
		btn_sell.setBackground(new Color(0, 64, 0));
		btn_sell.setBorderPainted(false);
		toolBar.add(btn_sell);
		
		JButton btnNewButton_2_1_1 = new JButton("    ");
		btnNewButton_2_1_1.setEnabled(false);
		btnNewButton_2_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2_1_1.setBackground(new Color(0, 64, 0));
		btnNewButton_2_1_1.setBorderPainted(false);
		toolBar.add(btnNewButton_2_1_1);
		
		JButton btn_patient = new JButton("  顾客信息  ");
		btn_patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_patient();
			}
		});
		btn_patient.setForeground(Color.WHITE);
		btn_patient.setFont(new Font("宋体", Font.PLAIN, 25));
		btn_patient.setBackground(new Color(0, 64, 0));
		btn_patient.setBorderPainted(false);
		toolBar.add(btn_patient);
		
		lblNewLabel = new JLabel("库存信息");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
		
		btn_exit = new JButton("退出");
		btn_exit.setFont(new Font("宋体", Font.PLAIN, 20));
		
		btn_detail = new JButton("详情");
		btn_detail.setFont(new Font("宋体", Font.PLAIN, 20));
		btn_detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		text_1 = new JTextField();
		text_1.setFont(new Font("宋体", Font.PLAIN, 16));
		text_1.setColumns(10);
		
		text_2 = new JTextField();
		text_2.setFont(new Font("宋体", Font.PLAIN, 16));
		text_2.setColumns(10);

		text_3 = new JTextField();
		text_3.setFont(new Font("宋体", Font.PLAIN, 16));
		text_3.setColumns(10);

		radio_1 = new JRadioButton("仓库编号");
		radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_1.setBackground(new Color(219, 255, 251));

		radio_2 = new JRadioButton("仓库名称");
		radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_2.setBackground(new Color(219, 255, 251));
		
		radio_3 = new JRadioButton("药品编号");
		radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_3.setBackground(new Color(219, 255, 251));
		
		btn_select = new JButton("查找");
		btn_select.setFont(new Font("宋体", Font.PLAIN, 17));
		
		radio_4 = new JRadioButton("仓库编号");
		radio_4.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_4.setBackground(new Color(219, 255, 251));
		
		text_4 = new JTextField();
		text_4.setFont(new Font("宋体", Font.PLAIN, 16));
		text_4.setColumns(10);
		
		radio_4.setVisible(false);
		text_4.setVisible(false);
		
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(55))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
							.addGap(44))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addGap(383))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(137)
							.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
							.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(106))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_select)
						.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio_3)
						.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio_2)
						.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio_1)
						.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio_4))
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_exit)
						.addComponent(btn_detail)))
		);
		
		table = new JTable();
		table.setModel(model);
		table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 17));
		table.setBackground(new Color(255, 255, 255));
		table.setRowHeight(25);
		table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(2);
	}
	
	void view_storage() {
		if(this.current_type == view_type.STORAGE) {
			//just stay
		}else {
			this.current_type = view_type.STORAGE;
			
			contentPane.removeAll();
			contentPane.repaint();
			
			/*setBounds(100, 100, 1130, 800);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(64, 128, 128));
			contentPane.setBackground(new Color(219, 255, 251));
			contentPane.setBorder(null);

			setContentPane(contentPane);*/
			
			model = new DefaultTableModel(new Object[][] {
			},
			new String[] {
				"\u4ED3\u5E93\u7F16\u53F7", "\u4ED3\u5E93\u540D\u79F0", "\u836F\u54C1\u7F16\u53F7", "\u836F\u54C1\u6570\u91CF"
			});
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("库存信息");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));

			radio_1 = new JRadioButton("仓库编号");
			radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_1.setBackground(new Color(219, 255, 251));
			radio_1.setVisible(true);
			text_1.setVisible(true);
			
			radio_2 = new JRadioButton("仓库名称");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("药品编号");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(true);
			text_3.setVisible(true);
			
			radio_4.setVisible(false);
			text_4.setVisible(false);
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(11)
								.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
								.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(55))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
								.addGap(44))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addGap(383))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(137)
								.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
								.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(106))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(30)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_select)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_3)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_2)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_1)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_4))
						.addGap(6)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_exit)
							.addComponent(btn_detail)))
			);
			
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 17));
			table.setBackground(new Color(255, 255, 255));
			table.setRowHeight(25);
			table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
			scrollPane.setViewportView(table);
			contentPane.setLayout(gl_contentPane);
			
			contentPane.revalidate();
			
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(2);
		}
	}
	
	void view_drug() {
		if(this.current_type == view_type.DRUG) {
			//just stay
		}else {
			this.current_type = view_type.DRUG;
			
			contentPane.removeAll();
			contentPane.repaint();
			
			/*setBounds(100, 100, 1130, 800);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(64, 128, 128));
			contentPane.setBackground(new Color(219, 255, 251));
			contentPane.setBorder(null);

			setContentPane(contentPane);*/
			
			model = new DefaultTableModel(new Object[][] {
			},
			new String[] {
					"\u836F\u54C1\u7F16\u53F7", "\u836F\u54C1\u540D\u79F0", "\u836F\u54C1\u5206\u7C7B", "\u836F\u54C1\u89C4\u683C", "\u5236\u836F\u5546\u7F16\u53F7", "\u836F\u54C1\u8FDB\u4EF7", "\u836F\u54C1\u552E\u4EF7", "\u751F\u4EA7\u65E5\u671F", "\u6709\u6548\u65E5\u671F"
			});
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("药品信息");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
			
			radio_4 = new JRadioButton("药品编号");
			radio_4.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_4.setBackground(new Color(219, 255, 251));
			radio_4.setVisible(true);
			text_4.setVisible(true);
			
			radio_1 = new JRadioButton("药品名称");
			radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_1.setBackground(new Color(219, 255, 251));
			radio_1.setVisible(true);
			text_1.setVisible(true);
			
			radio_2 = new JRadioButton("制药商");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("药品分类");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(true);
			text_3.setVisible(true);
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(11)
								.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
								.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(55))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
								.addGap(44))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addGap(383))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(137)
								.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
								.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(106))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(30)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_select)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_3)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_2)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_1)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_4))
						.addGap(6)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_exit)
							.addComponent(btn_detail)))
			);
			
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 17));
			table.setBackground(new Color(255, 255, 255));
			table.setRowHeight(25);
			table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
			scrollPane.setViewportView(table);
			contentPane.setLayout(gl_contentPane);
			
			contentPane.revalidate();
			
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(2);
		}
	}
	
	void view_manu() {
		if(this.current_type == view_type.MANUFACTURE) {
			//just stay
		}else {
			this.current_type = view_type.MANUFACTURE;

			contentPane.removeAll();
			contentPane.repaint();
			
			/*setBounds(100, 100, 1130, 800);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(64, 128, 128));
			contentPane.setBackground(new Color(219, 255, 251));
			contentPane.setBorder(null);

			setContentPane(contentPane);*/
			
			model = new DefaultTableModel(new Object[][] {
			},
			new String[] {
					"\u5236\u836F\u5546\u7F16\u53F7", "\u5236\u836F\u5546\u540D\u79F0", "\u8054\u7CFB\u7535\u8BDD", "\u90AE\u7BB1"
			});
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("制药商信息");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));

			radio_1.setVisible(false);
			text_1.setVisible(false);
			
			radio_2 = new JRadioButton("编号");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("名称");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(true);
			text_3.setVisible(true);
			
			radio_4.setVisible(false);
			text_4.setVisible(false);
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(11)
								.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
								.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(55))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
								.addGap(44))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addGap(383))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(137)
								.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
								.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(106))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(30)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_select)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_3)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_2)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_1)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_4))
						.addGap(6)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_exit)
							.addComponent(btn_detail)))
			);
			
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 17));
			table.setBackground(new Color(255, 255, 255));
			table.setRowHeight(25);
			table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
			scrollPane.setViewportView(table);
			contentPane.setLayout(gl_contentPane);
			
			contentPane.revalidate();
			
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(2);
		}
	}
	
	void view_sell() {
		if(this.current_type == view_type.SELL) {
			//just stay
		}else {
			this.current_type = view_type.SELL;

			contentPane.removeAll();
			contentPane.repaint();
			
			/*setBounds(100, 100, 1130, 800);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(64, 128, 128));
			contentPane.setBackground(new Color(219, 255, 251));
			contentPane.setBorder(null);

			setContentPane(contentPane);*/
			
			model = new DefaultTableModel(new Object[][] {
			},
			new String[] {
					"\u75C5\u4EBA\u7F16\u53F7", "\u836F\u54C1\u7F16\u53F7", "\u6570\u91CF", "\u5904\u7406\u65F6\u95F4", "\u9500\u9000\u65B9\u5F0F"
			});
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("销售信息");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));

			radio_4 = new JRadioButton("病人编号");
			radio_4.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_4.setBackground(new Color(219, 255, 251));
			radio_4.setVisible(true);
			text_4.setVisible(true);
			
			radio_1 = new JRadioButton("药品编号");
			radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_1.setBackground(new Color(219, 255, 251));
			radio_1.setVisible(true);
			text_1.setVisible(true);
			
			radio_2 = new JRadioButton("处理时间");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("销退方式");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(true);
			text_3.setVisible(true);
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(11)
								.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
								.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(55))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
								.addGap(44))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addGap(383))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(137)
								.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
								.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(106))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(30)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_select)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_3)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_2)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_1)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_4))
						.addGap(6)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_exit)
							.addComponent(btn_detail)))
			);
			
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 17));
			table.setBackground(new Color(255, 255, 255));
			table.setRowHeight(25);
			table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
			scrollPane.setViewportView(table);
			contentPane.setLayout(gl_contentPane);
			
			contentPane.revalidate();
			
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(2);
		}
	}
	
	void view_patient() {
		if(this.current_type == view_type.PATIENT) {
			//just stay
		}else {
			this.current_type = view_type.PATIENT;

			contentPane.removeAll();
			contentPane.repaint();
			
			/*setBounds(100, 100, 1130, 800);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(64, 128, 128));
			contentPane.setBackground(new Color(219, 255, 251));
			contentPane.setBorder(null);

			setContentPane(contentPane);*/
			
			model = new DefaultTableModel(new Object[][] {
			},
			new String[] {
					"\u75C5\u4EBA\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u8054\u7CFB\u7535\u8BDD", "\u4F4F\u5740"
			});
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("顾客信息");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));

			radio_1.setVisible(false);
			text_1.setVisible(false);
			
			radio_2 = new JRadioButton("病人编号");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("药品姓名");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(true);
			text_3.setVisible(true);

			radio_4.setVisible(false);
			text_4.setVisible(false);
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(11)
								.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
								.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(55))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
								.addGap(44))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addGap(383))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(137)
								.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
								.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(106))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(30)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_select)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_3)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_2)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_1)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_4))
						.addGap(6)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_exit)
							.addComponent(btn_detail)))
			);
			
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 17));
			table.setBackground(new Color(255, 255, 255));
			table.setRowHeight(25);
			table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
			scrollPane.setViewportView(table);
			contentPane.setLayout(gl_contentPane);
			
			contentPane.revalidate();
			
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(2);
		}
	}
}
