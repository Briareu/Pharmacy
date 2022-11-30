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
	private JButton btn_add;
	private JButton btn_select;
	private JButton btn_detail;
	
	enum view_type{STORAGE, DRUG, MANUFACTURE, SELL, PATIENT};
	public view_type current_type = view_type.STORAGE;

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
		setTitle("ҩ�����ϵͳ");
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
				"ҩƷ���", "�ֿ���", "ҩƷ����", "�ֿ�����"
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
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(0, 64, 0));
		btnNewButton.setBorderPainted(false);
		
		JButton btn_storage = new JButton("  �ֿ�洢����  ");
		btn_storage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_storage();
			}
		});
		
		JButton btnNewButton_4 = new JButton("    ");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(new Color(0, 64, 0));
		toolBar.add(btnNewButton_4);
		btn_storage.setForeground(Color.WHITE);
		btn_storage.setFont(new Font("����", Font.PLAIN, 25));
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
		btn_drug.setFont(new Font("����", Font.PLAIN, 25));
		btn_drug.setBackground(new Color(0, 64, 0));
		btn_drug.setBorderPainted(false);
		toolBar.add(btn_drug);
		
		JButton btnNewButton_2 = new JButton("    ");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 20));
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
		btn_manu.setFont(new Font("����", Font.PLAIN, 25));
		btn_manu.setBackground(new Color(0, 64, 0));
		btn_manu.setBorderPainted(false);
		toolBar.add(btn_manu);
		
		JButton btnNewButton_2_1 = new JButton("    ");
		btnNewButton_2_1.setEnabled(false);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_2_1.setBackground(new Color(0, 64, 0));
		btnNewButton_2_1.setBorderPainted(false);
		toolBar.add(btnNewButton_2_1);
		
		JButton btn_sell = new JButton("  ҩƷ���۹���  ");
		btn_sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_sell();
			}
		});
		btn_sell.setForeground(Color.WHITE);
		btn_sell.setFont(new Font("����", Font.PLAIN, 25));
		btn_sell.setBackground(new Color(0, 64, 0));
		btn_sell.setBorderPainted(false);
		toolBar.add(btn_sell);
		
		JButton btnNewButton_2_1_1 = new JButton("    ");
		btnNewButton_2_1_1.setEnabled(false);
		btnNewButton_2_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_2_1_1.setBackground(new Color(0, 64, 0));
		btnNewButton_2_1_1.setBorderPainted(false);
		toolBar.add(btnNewButton_2_1_1);
		
		JButton btn_patient = new JButton("  \u75C5\u4EBA\u4FE1\u606F\u7BA1\u7406  ");
		btn_patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_patient();
			}
		});
		btn_patient.setForeground(Color.WHITE);
		btn_patient.setFont(new Font("����", Font.PLAIN, 25));
		btn_patient.setBackground(new Color(0, 64, 0));
		btn_patient.setBorderPainted(false);
		toolBar.add(btn_patient);
		
		lblNewLabel = new JLabel("�ֿ�洢����");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 28));
		
		btn_exit = new JButton("�˳�");
		btn_exit.setFont(new Font("����", Font.PLAIN, 20));
		
		btn_add = new JButton("����");
		btn_add.setFont(new Font("����", Font.PLAIN, 20));
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		text_1 = new JTextField();
		text_1.setFont(new Font("����", Font.PLAIN, 16));
		text_1.setColumns(10);
		
		text_2 = new JTextField();
		text_2.setFont(new Font("����", Font.PLAIN, 16));
		text_2.setColumns(10);

		text_3 = new JTextField();
		text_3.setFont(new Font("����", Font.PLAIN, 16));
		text_3.setColumns(10);

		radio_1 = new JRadioButton("ҩƷ���");
		radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_1.setBackground(new Color(219, 255, 251));

		radio_2 = new JRadioButton("�ֿ���");
		radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_2.setBackground(new Color(219, 255, 251));
		
		radio_3 = new JRadioButton("�ֿ�����");
		radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_3.setBackground(new Color(219, 255, 251));
		
		btn_select = new JButton("����");
		btn_select.setFont(new Font("����", Font.PLAIN, 17));
		
		radio_4 = new JRadioButton("����");
		radio_4.setHorizontalAlignment(SwingConstants.TRAILING);
		radio_4.setBackground(new Color(219, 255, 251));
		
		text_4 = new JTextField();
		text_4.setFont(new Font("����", Font.PLAIN, 16));
		text_4.setColumns(10);
		
		radio_4.setVisible(false);
		text_4.setVisible(false);
		
		btn_detail = new JButton("����");
		btn_detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_detail.setFont(new Font("����", Font.PLAIN, 20));
		
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
		table.setFont(new Font("Adobe ���� Std R", Font.PLAIN, 17));
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
					"ҩƷ���", "�ֿ���", "ҩƷ����", "�ֿ�����"
			});
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("�ֿ�洢����");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("����", Font.PLAIN, 28));

			radio_1 = new JRadioButton("ҩƷ���");
			radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_1.setBackground(new Color(219, 255, 251));
			radio_1.setVisible(true);
			text_1.setVisible(true);
			
			radio_2 = new JRadioButton("�ֿ���");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("�ֿ�����");
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
			table.setFont(new Font("Adobe ���� Std R", Font.PLAIN, 17));
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
					"ҩƷ���", "ҩƷ����", "ҩƷ����", "ҩƷ���", "��ҩ�̱��", "ҩƷ����", "ҩƷ�ۼ�", "��������", "��Ч����"
			});
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("ҩƷ��Ϣ����");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("����", Font.PLAIN, 28));
			
			radio_4 = new JRadioButton("ҩƷ���");
			radio_4.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_4.setBackground(new Color(219, 255, 251));
			radio_4.setVisible(true);
			text_4.setVisible(true);
			
			radio_1 = new JRadioButton("ҩƷ����");
			radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_1.setBackground(new Color(219, 255, 251));
			radio_1.setVisible(true);
			text_1.setVisible(true);
			
			radio_2 = new JRadioButton("ҩƷ����");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("��ҩ��");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(true);
			text_3.setVisible(true);
			
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
			table.setFont(new Font("Adobe ���� Std R", Font.PLAIN, 17));
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
					"��ҩ�̱��", "��ҩ������", "��ϵ�绰", "����"
			});
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("��ҩ����Ϣ����");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("����", Font.PLAIN, 28));

			radio_1.setVisible(false);
			text_1.setVisible(false);
			
			radio_2 = new JRadioButton("���");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("����");
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
			table.setFont(new Font("Adobe ���� Std R", Font.PLAIN, 17));
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
					"���˱��", "ҩƷ���", "����", "����ʱ��"
			});
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("ҩƷ���۹���");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("����", Font.PLAIN, 28));

			radio_4 = new JRadioButton("���˱��");
			radio_4.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_4.setBackground(new Color(219, 255, 251));
			radio_4.setVisible(false);
			text_4.setVisible(false);
			
			radio_1 = new JRadioButton("���˱��");
			radio_1.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_1.setBackground(new Color(219, 255, 251));
			radio_1.setVisible(false);
			text_1.setVisible(false);
			
			radio_2 = new JRadioButton("���˱��");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("ҩƷ���");
			radio_3.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_3.setBackground(new Color(219, 255, 251));
			radio_3.setVisible(true);
			text_3.setVisible(true);
			
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
			table.setFont(new Font("Adobe ���� Std R", Font.PLAIN, 17));
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
					"���˱��", "����", "�Ա�", "����", "��ϵ�绰", "סַ"
			});
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("������Ϣ����");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("����", Font.PLAIN, 28));

			radio_1.setVisible(false);
			text_1.setVisible(false);
			
			radio_2 = new JRadioButton("���˱��");
			radio_2.setHorizontalAlignment(SwingConstants.TRAILING);
			radio_2.setBackground(new Color(219, 255, 251));
			radio_2.setVisible(true);
			text_2.setVisible(true);
			
			radio_3 = new JRadioButton("����");
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
			table.setFont(new Font("Adobe ���� Std R", Font.PLAIN, 17));
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
