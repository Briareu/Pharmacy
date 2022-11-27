package codes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
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

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private GroupLayout gl_contentPane;
	private JToolBar toolBar;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	enum view_type{STORAGE, DRUG, MANUFACTURE, SELL, PATIENT};
	private view_type current_type = view_type.STORAGE;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 800);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(64, 128, 128));
		contentPane.setBackground(new Color(219, 255, 251));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		
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
		
		lblNewLabel = new JLabel("药品信息");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
		
		btnNewButton_1 = new JButton("退出");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(394)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 822, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(38))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(lblNewLabel)
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1))
		);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setColumnHeaderView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	void view_storage() {
		if(this.current_type == view_type.STORAGE) {
			//just stay
		}else {
			this.current_type = view_type.STORAGE;
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1130, 800);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(64, 128, 128));
			contentPane.setBackground(new Color(219, 255, 251));
			contentPane.setBorder(null);

			setContentPane(contentPane);
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("库存信息");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(394)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(60)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 822, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(38))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(58)
						.addComponent(lblNewLabel)
						.addGap(34)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnNewButton_1))
			);
			
			table = new JTable();
			table.setBackground(new Color(255, 255, 255));
			scrollPane.setColumnHeaderView(table);
			contentPane.setLayout(gl_contentPane);
		}
	}
	
	void view_drug() {
		if(this.current_type == view_type.DRUG) {
			//just stay
		}else {
			this.current_type = view_type.DRUG;
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1130, 800);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(64, 128, 128));
			contentPane.setBackground(new Color(219, 255, 251));
			contentPane.setBorder(null);

			setContentPane(contentPane);
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("药品信息");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(394)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(60)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 822, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(38))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(58)
						.addComponent(lblNewLabel)
						.addGap(34)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnNewButton_1))
			);
			
			table = new JTable();
			table.setBackground(new Color(255, 255, 255));
			scrollPane.setColumnHeaderView(table);
			contentPane.setLayout(gl_contentPane);
		}
	}
	
	void view_manu() {
		if(this.current_type == view_type.MANUFACTURE) {
			//just stay
		}else {
			this.current_type = view_type.MANUFACTURE;
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1130, 800);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(64, 128, 128));
			contentPane.setBackground(new Color(219, 255, 251));
			contentPane.setBorder(null);

			setContentPane(contentPane);
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("制药商信息");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(394)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(60)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 822, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(38))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(58)
						.addComponent(lblNewLabel)
						.addGap(34)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnNewButton_1))
			);
			
			table = new JTable();
			table.setBackground(new Color(255, 255, 255));
			scrollPane.setColumnHeaderView(table);
			contentPane.setLayout(gl_contentPane);
		}
	}
	
	void view_sell() {
		if(this.current_type == view_type.SELL) {
			//just stay
		}else {
			this.current_type = view_type.SELL;
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1130, 800);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(64, 128, 128));
			contentPane.setBackground(new Color(219, 255, 251));
			contentPane.setBorder(null);

			setContentPane(contentPane);
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("销售信息");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(394)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(60)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 822, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(38))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(58)
						.addComponent(lblNewLabel)
						.addGap(34)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnNewButton_1))
			);
			
			table = new JTable();
			table.setBackground(new Color(255, 255, 255));
			scrollPane.setColumnHeaderView(table);
			contentPane.setLayout(gl_contentPane);
		}
	}
	
	void view_patient() {
		if(this.current_type == view_type.PATIENT) {
			//just stay
		}else {
			this.current_type = view_type.PATIENT;
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1130, 800);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(64, 128, 128));
			contentPane.setBackground(new Color(219, 255, 251));
			contentPane.setBorder(null);

			setContentPane(contentPane);
			
			scrollPane = new JScrollPane();
			
			lblNewLabel = new JLabel("顾客信息");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
			
			gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(394)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(60)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 822, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(38))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(58)
						.addComponent(lblNewLabel)
						.addGap(34)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnNewButton_1))
			);
			
			table = new JTable();
			table.setBackground(new Color(255, 255, 255));
			scrollPane.setColumnHeaderView(table);
			contentPane.setLayout(gl_contentPane);
		}
	}
}
