package codes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import classes.*;
import java.util.Vector;
import connections.*;

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

	private JRadioButton radio_1;
	private JRadioButton radio_2;
	private JRadioButton radio_3;
	private JRadioButton radio_4;
	
	private JButton btn_exit;
	private JButton btn_add;
	private JButton btn_select;
	private JButton btn_detail;
	
	enum view_type{STORAGE, DRUG, MANUFACTURE, SELL, PATIENT, SELL_OUTLINE};
	public view_type current_type = view_type.STORAGE;

	private JTextField text_1;
	private JTextField text_2;
	private JTextField text_3;
	private JTextField text_4;
	
	private Executor executor;
	
	public String current_title;
	
	private JLabel lblNewLabel;
	private JButton btnNewButton_2_1_2;
	private JButton btn_sell_outline;

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
				"药品编号", "仓库编号", "药品数量", "仓库名称"
			}){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
            {
                return false;
            }
		};
		
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
		
		JButton btn_storage = new JButton("  仓库存储管理  ");
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
		
		JButton btn_drug = new JButton("  \u836F\u54C1\u4FE1\u606F\u7BA1\u7406  ");
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
		
		JButton btn_manu = new JButton(" \u5236\u836F\u5546\u4FE1\u606F\u7BA1\u7406 ");
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
		
		JButton btn_sell = new JButton("  药品销售管理  ");
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
		
		btn_sell_outline = new JButton("  \u836F\u54C1\u9500\u552E\u603B\u89C8  ");
		btn_sell_outline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_sell_outline();
			}
		});
		btn_sell_outline.setForeground(Color.WHITE);
		btn_sell_outline.setFont(new Font("宋体", Font.PLAIN, 25));
		btn_sell_outline.setBorderPainted(false);
		btn_sell_outline.setBackground(new Color(0, 64, 0));
		toolBar.add(btn_sell_outline);
		
		btnNewButton_2_1_2 = new JButton("    ");
		btnNewButton_2_1_2.setForeground(Color.WHITE);
		btnNewButton_2_1_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2_1_2.setEnabled(false);
		btnNewButton_2_1_2.setBorderPainted(false);
		btnNewButton_2_1_2.setBackground(new Color(0, 64, 0));
		toolBar.add(btnNewButton_2_1_2);
		
		JButton btn_patient = new JButton("  \u75C5\u4EBA\u4FE1\u606F\u7BA1\u7406  ");
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
		
		lblNewLabel = new JLabel("仓库存储管理");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
		
		btn_exit = new JButton("退出");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				return_login();
			}
		});
		btn_exit.setFont(new Font("宋体", Font.PLAIN, 20));
		
		btn_add = new JButton("增加");
		btn_add.setFont(new Font("宋体", Font.PLAIN, 20));
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
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

		radio_1 = new JRadioButton("药品编号");
		radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_1.setBackground(new Color(219, 255, 251));

		radio_2 = new JRadioButton("仓库编号");
		radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_2.setBackground(new Color(219, 255, 251));
		
		radio_3 = new JRadioButton("仓库名称");
		radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_3.setBackground(new Color(219, 255, 251));
		
		btn_select = new JButton("查找");
		btn_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select();
			}
		});
		btn_select.setFont(new Font("宋体", Font.PLAIN, 17));
		
		radio_4 = new JRadioButton("待定");
		radio_4.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_4.setBackground(new Color(219, 255, 251));
		
		text_4 = new JTextField();
		text_4.setFont(new Font("宋体", Font.PLAIN, 16));
		text_4.setColumns(10);
		
		radio_4.setVisible(false);
		text_4.setVisible(false);
		
		btn_detail = new JButton("详情");
		btn_detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object temp = new Object();
				int target = table.getSelectedRow();
				if(target == -1) {
					JOptionPane.showMessageDialog(null, "请先进行选择！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				switch(current_type) {
				case DRUG:{
					drugInfo current = new drugInfo(table.getValueAt(target, 0).toString(), table.getValueAt(target, 1).toString(), table.getValueAt(target, 2).toString(), table.getValueAt(target, 3).toString(), table.getValueAt(target, 4).toString(), 
							table.getValueAt(target, 5).toString(), table.getValueAt(target, 6).toString(), table.getValueAt(target, 7).toString(), table.getValueAt(target, 8).toString());
					temp = current;
					detail(temp);
				}
					break;
				case MANUFACTURE:{
					Manufacture current = new Manufacture(table.getValueAt(target, 0).toString(), table.getValueAt(target, 1).toString(), table.getValueAt(target, 2).toString(), table.getValueAt(target, 3).toString());
					temp = current;
					detail(temp);
				}
					break;
				case PATIENT:{
					Patient current = new Patient(table.getValueAt(target, 0).toString(), table.getValueAt(target, 1).toString(), table.getValueAt(target, 2).toString(), Integer.parseInt(table.getValueAt(target, 3).toString()), table.getValueAt(target, 4).toString(), table.getValueAt(target, 5).toString());
					temp = current;
					detail(temp);
				}
					break;
				case SELL:{
					Sell current = new Sell(table.getValueAt(target, 0).toString(), table.getValueAt(target, 1).toString(), Integer.parseInt(table.getValueAt(target, 2).toString()), table.getValueAt(target, 3).toString());
					temp = current;
					detail(temp);
				}
					break;
				case STORAGE:{
					Storage current = new Storage(table.getValueAt(target, 0).toString(), table.getValueAt(target, 1).toString(), 
							Integer.parseInt(table.getValueAt(target, 2).toString()), table.getValueAt(target, 3).toString());
					temp = current;
					detail(temp);
				}
					break;
				default:
					break;
				}
			}
		});
		btn_detail.setFont(new Font("宋体", Font.PLAIN, 20));
		

		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(94)
									.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(227)
									.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
									.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(106))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(79)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(39)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(339)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio_4)
						.addComponent(radio_1)
						.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio_2)
						.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio_3)
						.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_select))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_exit)
						.addComponent(btn_add)
						.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
		);
		
		table = new JTable();
		table.setModel(model);
		table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 15));
		table.setBackground(new Color(255, 255, 255));
		table.setRowHeight(25);
		table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
		scrollPane.setViewportView(table);
		
		table_update();
		
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
					"药品编号", "仓库编号", "药品数量", "仓库名称"
			}){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column)
	            {
	                return false;
	            }
			};
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("仓库存储管理");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
			
			radio_1.setSelected(false);
			radio_2.setSelected(false);
			radio_3.setSelected(false);
			radio_4.setSelected(false);
			text_1.setText("");
			text_2.setText("");
			text_3.setText("");
			text_4.setText("");

			radio_1 = new JRadioButton("药品编号");
			radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_1.setBackground(new Color(219, 255, 251));
			radio_1.setVisible(true);
			text_1.setVisible(true);
			
			radio_2 = new JRadioButton("仓库编号");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("仓库名称");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(true);
			text_3.setVisible(true);
			
			radio_4.setVisible(false);
			text_4.setVisible(false);
			
			btn_add.setVisible(true);
			btn_detail.setVisible(true);
			btn_select.setVisible(true);
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(94)
										.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(227)
										.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
										.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(106))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(2)
										.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(79)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(39)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
									.addContainerGap()))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(339)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(30)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_4)
							.addComponent(radio_1)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_2)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_3)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_select))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_exit)
							.addComponent(btn_add)
							.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
			);
			
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 15));
			table.setBackground(new Color(255, 255, 255));
			table.setRowHeight(25);
			table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
			scrollPane.setViewportView(table);
			
			table_update();
			
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
					"药品编号", "药品名称", "药品分类", "药品规格", "制药商编号", "药品进价", "药品售价", "生产日期", "有效日期"
			}){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column)
	            {
	                return false;
	            }
			};
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("药品信息管理");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
			
			radio_1.setSelected(false);
			radio_2.setSelected(false);
			radio_3.setSelected(false);
			radio_4.setSelected(false);
			text_1.setText("");
			text_2.setText("");
			text_3.setText("");
			text_4.setText("");
			
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
			
			radio_2 = new JRadioButton("药品分类");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("制药商");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(true);
			text_3.setVisible(true);

			btn_add.setVisible(true);
			btn_detail.setVisible(true);
			btn_select.setVisible(true);
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(94)
										.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(227)
										.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
										.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(106))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(2)
										.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(79)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(39)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
									.addContainerGap()))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(339)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(30)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_4)
							.addComponent(radio_1)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_2)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_3)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_select))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_exit)
							.addComponent(btn_add)
							.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
			);
			
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 15));
			table.setBackground(new Color(255, 255, 255));
			table.setRowHeight(25);
			table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
			scrollPane.setViewportView(table);
			
			table_update();
			
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
			
			model = new DefaultTableModel(new Object[][] {}, new String[] {"制药商编号", "制药商名称", "联系电话", "邮箱"}) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column)
	            {
	                return false;
	            }
			};
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("制药商信息管理");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));


			radio_1.setSelected(false);
			radio_2.setSelected(false);
			radio_3.setSelected(false);
			radio_4.setSelected(false);
			text_1.setText("");
			text_2.setText("");
			text_3.setText("");
			text_4.setText("");
			
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

			btn_add.setVisible(true);
			btn_detail.setVisible(true);
			btn_select.setVisible(true);
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(94)
										.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(227)
										.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
										.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(106))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(2)
										.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(79)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(39)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
									.addContainerGap()))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(339)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(30)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_4)
							.addComponent(radio_1)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_2)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_3)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_select))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_exit)
							.addComponent(btn_add)
							.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
			);
			
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 15));
			table.setBackground(new Color(255, 255, 255));
			table.setRowHeight(25);
			table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
			scrollPane.setViewportView(table);
			
			table_update();
			
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
					"病人编号", "药品编号", "数量", "处理时间"
			}){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column)
	            {
	                return false;
	            }
			};
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("药品销售管理");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));


			radio_1.setSelected(false);
			radio_2.setSelected(false);
			radio_3.setSelected(false);
			radio_4.setSelected(false);
			text_1.setText("");
			text_2.setText("");
			text_3.setText("");
			text_4.setText("");
			
			radio_4 = new JRadioButton("病人编号");
			radio_4.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_4.setBackground(new Color(219, 255, 251));
			radio_4.setVisible(false);
			text_4.setVisible(false);
			
			radio_1 = new JRadioButton("病人编号");
			radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_1.setBackground(new Color(219, 255, 251));
			radio_1.setVisible(false);
			text_1.setVisible(false);
			
			radio_2 = new JRadioButton("病人编号");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("药品编号");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(true);
			text_3.setVisible(true);

			btn_add.setVisible(true);
			btn_detail.setVisible(true);
			btn_select.setVisible(true);
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(94)
										.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(227)
										.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
										.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(106))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(2)
										.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(79)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(39)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
									.addContainerGap()))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(339)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(30)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_4)
							.addComponent(radio_1)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_2)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_3)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_select))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_exit)
							.addComponent(btn_add)
							.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
			);
			
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 15));
			table.setBackground(new Color(255, 255, 255));
			table.setRowHeight(25);
			table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
			scrollPane.setViewportView(table);
			
			table_update();
			
			contentPane.setLayout(gl_contentPane);
			
			contentPane.revalidate();
			
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(2);
		}
	}
	
	void view_sell_outline() {
		if(this.current_type == view_type.SELL_OUTLINE) {
			//just stay
		}else {
			this.current_type = view_type.SELL_OUTLINE;

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
					"药品编号", "数量"
			}){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column)
	            {
	                return false;
	            }
			};
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("药品销售总览");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));

			radio_1.setSelected(false);
			radio_2.setSelected(false);
			radio_3.setSelected(false);
			radio_4.setSelected(false);
			text_1.setText("");
			text_2.setText("");
			text_3.setText("");
			text_4.setText("");
			
			radio_4 = new JRadioButton("病人编号");
			radio_4.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_4.setBackground(new Color(219, 255, 251));
			radio_4.setVisible(false);
			text_4.setVisible(false);
			
			radio_1 = new JRadioButton("病人编号");
			radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_1.setBackground(new Color(219, 255, 251));
			radio_1.setVisible(false);
			text_1.setVisible(false);
			
			radio_2 = new JRadioButton("病人编号");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(false);
			text_2.setVisible(false);
			
			radio_3 = new JRadioButton("药品编号");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(false);
			text_3.setVisible(false);
			
			btn_add.setVisible(false);
			btn_detail.setVisible(false);
			btn_select.setVisible(false);
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(94)
										.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(227)
										.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
										.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(106))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(2)
										.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(79)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(39)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
									.addContainerGap()))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(339)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(30)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_4)
							.addComponent(radio_1)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_2)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_3)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_select))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_exit)
							.addComponent(btn_add)
							.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
			);
			
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 15));
			table.setBackground(new Color(255, 255, 255));
			table.setRowHeight(25);
			table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
			scrollPane.setViewportView(table);
			
			table_update();
			
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
					"病人编号", "姓名", "性别", "年龄", "联系电话", "住址"
			}){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column)
	            {
	                return false;
	            }
			};
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("病人信息管理");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));


			radio_1.setSelected(false);
			radio_2.setSelected(false);
			radio_3.setSelected(false);
			radio_4.setSelected(false);
			text_1.setText("");
			text_2.setText("");
			text_3.setText("");
			text_4.setText("");
			
			radio_1.setVisible(false);
			text_1.setVisible(false);
			
			radio_2 = new JRadioButton("病人编号");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("姓名");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(true);
			text_3.setVisible(true);

			radio_4.setVisible(false);
			text_4.setVisible(false);

			btn_add.setVisible(true);
			btn_detail.setVisible(true);
			btn_select.setVisible(true);
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(94)
										.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(227)
										.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
										.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(106))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(2)
										.addComponent(radio_4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radio_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(79)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(39)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)
									.addContainerGap()))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(339)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(30)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(text_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_4)
							.addComponent(radio_1)
							.addComponent(text_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_2)
							.addComponent(text_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radio_3)
							.addComponent(text_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_select))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_exit)
							.addComponent(btn_add)
							.addComponent(btn_detail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
			);
			
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 15));
			table.setBackground(new Color(255, 255, 255));
			table.setRowHeight(25);
			table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 35));
			scrollPane.setViewportView(table);
			
			table_update();
			
			contentPane.setLayout(gl_contentPane);
			
			contentPane.revalidate();
			
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(2);
		}
	}
	
	Vector<Storage> Storage_getall(){
		executor = new Executor();
		Vector<Storage> res = new Vector<Storage>();
		try {
			res = executor.Storage_getdata();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	Vector<drugInfo> drug_getall(){
		executor = new Executor();
		Vector<drugInfo> res = new Vector<drugInfo>();
		try {
			res = executor.drug_getdata();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	Vector<Manufacture> Manufacture_getall(){
		executor = new Executor();
		Vector<Manufacture> res = new Vector<Manufacture>();
		try {
			res = executor.Manufacture_getdata();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	Vector<Sell> Sell_getall(){
		executor = new Executor();
		Vector<Sell> res = new Vector<Sell>();
		try {
			res = executor.Sell_getdata();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	Vector<Sell> Sell_Outline_getall(){
		executor = new Executor();
		Vector<Sell> res = new Vector<Sell>();
		try {
			res = executor.Sell_selectsum();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	Vector<Patient> Patient_getall(){
		executor = new Executor();
		Vector<Patient> res = new Vector<Patient>();
		try {
			res = executor.Patient_getdata();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	void table_update() {
		while(model.getRowCount() > 0) {
			model.removeRow(model.getRowCount() - 1);
		}
		
		switch(current_type) {
		case STORAGE:
		{
			Vector<Storage> res = Storage_getall();
			Object [] arr = new Object[4];
			for(int i = 0; i < res.size(); i++) {
				arr[0] = res.get(i).getChemical_no();
				arr[1] = res.get(i).getWarehouse_no();
				arr[2] = res.get(i).getChemical_number();
				arr[3] = res.get(i).getWarehouse_name();
				
				model.addRow(arr);
			}
			table.setModel(model);
			break;
		}
		case DRUG:
		{
			Vector<drugInfo> res = drug_getall();
			Object [] arr = new Object[9];
			for(int i = 0; i < res.size(); i++) {
				arr[0] = res.get(i).getChemical_no();
				arr[1] = res.get(i).getChemical_name();
				arr[2] = res.get(i).getChemical_type();
				arr[3] = res.get(i).getChemical_standard();
				arr[4] = res.get(i).getChemical_manufacture_no();
				arr[5] = res.get(i).getChemical_buy_price();
				arr[6] = res.get(i).getChemical_sell_price();
				arr[7] = res.get(i).getProduct_date();
				arr[8] = res.get(i).getValidity_date();
				
				model.addRow(arr);
			}
			table.setModel(model);
			break;
		}
		case MANUFACTURE:
		{
			Vector<Manufacture> res = Manufacture_getall();
			Object [] arr = new Object[4];
			for(int i = 0; i < res.size(); i++) {
				arr[0] = res.get(i).getChemical_menufacture_no();
				arr[1] = res.get(i).getChemical_manufacture_name();
				arr[2] = res.get(i).getChemical_manufacture_tel();
				arr[3] = res.get(i).getChemical_manufacture_email();
				
				model.addRow(arr);
			}
			table.setModel(model);
			break;
		}
		case SELL:
		{
			Vector<Sell> res = Sell_getall();
			Object [] arr = new Object[4];
			for(int i = 0; i < res.size(); i++) {
				arr[0] = res.get(i).getPatient_no();
				arr[1] = res.get(i).getChemical_no();
				arr[2] = res.get(i).getCount();
				arr[3] = res.get(i).getDeal_date();
				
				model.addRow(arr);
			}
			table.setModel(model);
			break;
		}
		case PATIENT:
		{
			Vector<Patient> res = Patient_getall();
			Object [] arr = new Object[6];
			for(int i = 0; i < res.size(); i++) {
				arr[0] = res.get(i).getPatient_no();
				arr[1] = res.get(i).getPatient_name();
				arr[2] = res.get(i).getPatient_sex();
				arr[3] = res.get(i).getPatient_age();
				arr[4] = res.get(i).getPatient_tel();
				arr[5] = res.get(i).getPatient_add();
				
				model.addRow(arr);
			}
			table.setModel(model);
			break;
		}
		case SELL_OUTLINE:{
			Vector<Sell> res = Sell_Outline_getall();
			Object [] arr = new Object[2];
			for(int i = 0; i < res.size(); i++) {
				arr[0] = res.get(i).getChemical_no();
				arr[1] = res.get(i).getCount();
				
				model.addRow(arr);
			}
			table.setModel(model);
			break;
		}
		default:
			break;
		}
	}
	
	public void set_title(String t) {
		current_title = t;
		setTitle(t);
	}
	
	public void return_login() {
		LoginFrame c = new LoginFrame();
		c.setVisible(true);
		
		this.dispose();
	}
	
	public void select() {
		while(model.getRowCount() > 0) {
			model.removeRow(model.getRowCount() - 1);
		}
		
		switch(current_type) {
		case STORAGE:
		{
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
			String v1 = text_1.getText().toString();
			String v2 = text_2.getText().toString();
			String v3 = text_3.getText().toString();
			String v4 = text_4.getText().toString();
			if(radio_1.isSelected() == false) c1 = -1;
			if(radio_2.isSelected() == false) c2 = -1;
			if(radio_3.isSelected() == false) c3 = -1;
			if(radio_4.isSelected() == false) c4 = -1;

			executor = new Executor();
			Vector<Storage> res = new Vector<Storage>();
			try {
				res = executor.Storage_selectdata(v1, v2, v3, c1, c2, c3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object [] arr = new Object[4];
			for(int i = 0; i < res.size(); i++) {
				arr[0] = res.get(i).getChemical_no();
				arr[1] = res.get(i).getWarehouse_no();
				arr[2] = res.get(i).getChemical_number();
				arr[3] = res.get(i).getWarehouse_name();
				
				model.addRow(arr);
			}
			table.setModel(model);
			break;
		}
		case DRUG:
		{
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
			String v1 = text_4.getText().toString();
			String v2 = text_1.getText().toString();
			String v3 = text_2.getText().toString();
			String v4 = text_3.getText().toString();
			if(radio_4.isSelected() == false) c1 = -1;
			if(radio_1.isSelected() == false) c2 = -1;
			if(radio_2.isSelected() == false) c3 = -1;
			if(radio_3.isSelected() == false) c4 = -1;

			executor = new Executor();
			Vector<drugInfo> res = new Vector<drugInfo>();
			try {
				res = executor.drugInfo_selectdata(v1, v2, v3, v4, c1, c2, c3, c4);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object [] arr = new Object[9];
			for(int i = 0; i < res.size(); i++) {
				arr[0] = res.get(i).getChemical_no();
				arr[1] = res.get(i).getChemical_name();
				arr[2] = res.get(i).getChemical_type();
				arr[3] = res.get(i).getChemical_standard();
				arr[4] = res.get(i).getChemical_manufacture_no();
				arr[5] = res.get(i).getChemical_buy_price();
				arr[6] = res.get(i).getChemical_sell_price();
				arr[7] = res.get(i).getProduct_date();
				arr[8] = res.get(i).getValidity_date();
				
				model.addRow(arr);
			}
			table.setModel(model);
			break;
		}
		case MANUFACTURE:
		{
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
			String v1 = text_1.getText().toString();
			String v2 = text_2.getText().toString();
			String v3 = text_3.getText().toString();
			String v4 = text_4.getText().toString();
			if(radio_1.isSelected() == false) c1 = -1;
			if(radio_2.isSelected() == false) c2 = -1;
			if(radio_3.isSelected() == false) c3 = -1;
			if(radio_4.isSelected() == false) c4 = -1;

			executor = new Executor();
			Vector<Manufacture> res = new Vector<Manufacture>();
			try {
				res = executor.Manufacture_selectdata(v2, v3, c2, c3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object [] arr = new Object[4];
			for(int i = 0; i < res.size(); i++) {
				arr[0] = res.get(i).getChemical_menufacture_no();
				arr[1] = res.get(i).getChemical_manufacture_name();
				arr[2] = res.get(i).getChemical_manufacture_tel();
				arr[3] = res.get(i).getChemical_manufacture_email();
				
				model.addRow(arr);
			}
			table.setModel(model);
			break;
		}
		case SELL:
		{
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
			String v1 = text_1.getText().toString();
			String v2 = text_2.getText().toString();
			String v3 = text_3.getText().toString();
			String v4 = text_4.getText().toString();
			if(radio_1.isSelected() == false) c1 = -1;
			if(radio_2.isSelected() == false) c2 = -1;
			if(radio_3.isSelected() == false) c3 = -1;
			if(radio_4.isSelected() == false) c4 = -1;

			executor = new Executor();
			Vector<Sell> res = new Vector<Sell>();
			try {
				res = executor.Sell_selectdata(v2, v3, c2, c3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object [] arr = new Object[4];
			for(int i = 0; i < res.size(); i++) {
				arr[0] = res.get(i).getPatient_no();
				arr[1] = res.get(i).getChemical_no();
				arr[2] = res.get(i).getCount();
				arr[3] = res.get(i).getDeal_date();
				
				model.addRow(arr);
			}
			table.setModel(model);
			break;
		}
		case PATIENT:
		{
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
			String v1 = text_1.getText().toString();
			String v2 = text_2.getText().toString();
			String v3 = text_3.getText().toString();
			String v4 = text_4.getText().toString();
			if(radio_1.isSelected() == false) c1 = -1;
			if(radio_2.isSelected() == false) c2 = -1;
			if(radio_3.isSelected() == false) c3 = -1;
			if(radio_4.isSelected() == false) c4 = -1;

			executor = new Executor();
			Vector<Patient> res = new Vector<Patient>();
			try {
				res = executor.Patient_selectdata(v2, v3, c2, c3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object [] arr = new Object[6];
			for(int i = 0; i < res.size(); i++) {
				arr[0] = res.get(i).getPatient_no();
				arr[1] = res.get(i).getPatient_name();
				arr[2] = res.get(i).getPatient_sex();
				arr[3] = res.get(i).getPatient_age();
				arr[4] = res.get(i).getPatient_tel();
				arr[5] = res.get(i).getPatient_add();
				
				model.addRow(arr);
			}
			table.setModel(model);
			break;
		}
		case SELL_OUTLINE:
			break;
		default:
			break;
		}
	}
	
	public void detail(Object temp) {
		this.setEnabled(false);
		this.setModalExclusionType(ModalExclusionType.NO_EXCLUDE);
		
		DetailsFrame frame = new DetailsFrame(this, current_type, temp);
		frame.setVisible(true);
	}
	
	public void add() {
		this.setEnabled(false);
		this.setModalExclusionType(ModalExclusionType.NO_EXCLUDE);
		
		AddFrame frame = new AddFrame(this, current_type);
		frame.setVisible(true);
	}
}
