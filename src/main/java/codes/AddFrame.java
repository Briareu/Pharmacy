package codes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codes.MainFrame.view_type;
import connections.Executor;
import classes.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private MainFrame mainFrame;

	/**
	 * Create the frame.
	 */
	public AddFrame(MainFrame mainframe, view_type view) {
		mainFrame = mainframe;
		setTitle("增加");
		switch(view) {
		case DRUG:{
			drug_Info();
			break;
		}
		case MANUFACTURE:{
			manu_facture();
			break;
		}
		case PATIENT:{
			pa_tient();
			break;
		}
		case SELL:{
			sell_rebate();
			break;
		}
		case STORAGE:{
			sto_rage();
			break;
		}
		default:
			break;
		}
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(2);
	}
	
	void drug_Info() {
		setBounds(100, 100, 665, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u7F16\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u836F\u54C1\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u836F\u54C1\u5206\u7C7B");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_2 = new JLabel("\u836F\u54C1\u89C4\u683C");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_3 = new JLabel("\u5236\u836F\u5546\u7F16\u53F7");
		lblNewLabel_1_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_4 = new JLabel("\u836F\u54C1\u8FDB\u4EF7");
		lblNewLabel_1_4.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_5 = new JLabel("\u836F\u54C1\u552E\u4EF7");
		lblNewLabel_1_5.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_6 = new JLabel("\u751F\u4EA7\u65E5\u671F");
		lblNewLabel_1_6.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_7 = new JLabel("\u6709\u6548\u65E5\u671F");
		lblNewLabel_1_7.setFont(new Font("宋体", Font.PLAIN, 20));
		
		final JTextField textField_drug_C_no = new JTextField();
		textField_drug_C_no.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_drug_C_no.setColumns(10);
		
		final JTextField textField_drug_C_name = new JTextField();
		textField_drug_C_name.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_drug_C_name.setColumns(10);
		
		final JTextField textField_drug_C_type = new JTextField();
		textField_drug_C_type.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_drug_C_type.setColumns(10);
		
		final JTextField textField_drug_C_standard = new JTextField();
		textField_drug_C_standard.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_drug_C_standard.setColumns(10);
		
		final JTextField textField_drug_m_no = new JTextField();
		textField_drug_m_no.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_drug_m_no.setColumns(10);
		
		final JTextField textField_drug_buy = new JTextField();
		textField_drug_buy.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_drug_buy.setColumns(10);
		
		final JTextField textField_drug_sell = new JTextField();
		textField_drug_sell.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_drug_sell.setColumns(10);
		
		final JTextField textField_drug_p_date = new JTextField();
		textField_drug_p_date.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_drug_p_date.setColumns(10);
		
		final JTextField textField_drug_v_date = new JTextField();
		textField_drug_v_date.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_drug_v_date.setColumns(10);
		
		JButton btn_add = new JButton("\u4FDD\u5B58");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Executor executor = new Executor();
				int res = 0;
				try {
					res = executor.drug_insert(textField_drug_C_no.getText().toString(), 
								textField_drug_C_name.getText().toString(), 
								textField_drug_C_type.getText().toString(), 
								textField_drug_C_standard.getText().toString(), 
								textField_drug_m_no.getText().toString(), 
								textField_drug_buy.getText().toString(), 
								textField_drug_sell.getText().toString(), 
								textField_drug_p_date.getText().toString(), 
								textField_drug_v_date.getText().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				switch(res) {
				case 0:{
					JOptionPane.showMessageDialog(null, "插入成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
					textField_drug_C_no.setText("");
					textField_drug_C_name.setText("");
					textField_drug_C_type.setText("");
					textField_drug_C_standard.setText("");
					textField_drug_m_no.setText("");
					textField_drug_buy.setText("");
					textField_drug_sell.setText("");
					textField_drug_p_date.setText("");
					textField_drug_v_date.setText("");
					break;
				}
				case -1:{
					//unique
					JOptionPane.showMessageDialog(null, "存在相同的药物编号！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case -2:{
					//do not have the Manufacture_no
					JOptionPane.showMessageDialog(null, "不存在该制药商编号！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case -3:{
					//C_type wrong-----only 注射、内服、外用
					JOptionPane.showMessageDialog(null, "药品分类错误，只能填写注射、内服、外用！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case -4:{
					//buy and sell price should larger than 0
					JOptionPane.showMessageDialog(null, "药品进价和药品售价应大于0！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case -5:{
					//standard wrong-----only 处方、非处方
					JOptionPane.showMessageDialog(null, "药品规格错误，只能填写处方、非处方！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case -6:{
					//date
					JOptionPane.showMessageDialog(null, "日期格式错误，格式应为yyyy-mm-dd hh:mm:ss！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				}
			}
		});
		btn_add.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btn_return = new JButton("\u8FD4\u56DE");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_return.setFont(new Font("宋体", Font.PLAIN, 15));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_drug_m_no, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addGap(1)
											.addComponent(textField_drug_C_no, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addGap(1)
											.addComponent(textField_drug_C_name, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(27)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_drug_C_type, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(27)
									.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(textField_drug_C_standard, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(textField_drug_buy, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(textField_drug_sell, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addComponent(lblNewLabel_1_6, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(textField_drug_p_date, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1_7, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_drug_v_date, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(77, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 384, Short.MAX_VALUE)
					.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addComponent(lblNewLabel)
							.addGap(32)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(textField_drug_C_no, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(textField_drug_C_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(textField_drug_C_type, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(textField_drug_C_standard, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(textField_drug_m_no, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(lblNewLabel_1_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addGap(35)
									.addComponent(lblNewLabel_1_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(textField_drug_buy, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(textField_drug_sell, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(textField_drug_p_date, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(35)
									.addComponent(textField_drug_v_date, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_add)
							.addGap(35))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(33))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	void manu_facture() {
		setBounds(100, 100, 460, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel_2 = new JLabel("\u5236\u836F\u5546\u7F16\u53F7");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("\u5236\u836F\u5546\u540D\u79F0");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_2 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		lblNewLabel_2_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_3 = new JLabel("\u90AE\u7BB1");
		lblNewLabel_2_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		final JTextField textField_Manu_C_m_no = new JTextField();
		textField_Manu_C_m_no.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Manu_C_m_no.setColumns(10);
		
		final JTextField textField_Manu_C_m_name = new JTextField();
		textField_Manu_C_m_name.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Manu_C_m_name.setColumns(10);
		
		final JTextField textField_Manu_C_m_tel = new JTextField();
		textField_Manu_C_m_tel.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Manu_C_m_tel.setColumns(10);
		
		final JTextField textField_Manu_C_email = new JTextField();
		textField_Manu_C_email.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Manu_C_email.setColumns(10);
		
		JButton btn_add = new JButton("\u4FDD\u5B58");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = 0;
				Executor executor = new Executor();
				try {
					res = executor.Manufacture_insert(textField_Manu_C_m_no.getText().toString(), 
							textField_Manu_C_m_name.getText().toString(), 
							textField_Manu_C_m_tel.getText().toString(), 
							textField_Manu_C_email.getText().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				switch(res) {
				case 0:{
					JOptionPane.showMessageDialog(null, "插入成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
					textField_Manu_C_m_no.setText("");
					textField_Manu_C_m_name.setText("");
					textField_Manu_C_m_tel.setText("");
					textField_Manu_C_email.setText("");
					return;
				}
				case -1:{
					//already exist M_no = new.M_no
					JOptionPane.showMessageDialog(null, "存在相同的制药商编号！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				default:
					break;
				}
			}
		});
		btn_add.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btn_return = new JButton("\u8FD4\u56DE");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_return.setFont(new Font("宋体", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btn_return, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_Manu_C_m_no, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_Manu_C_m_name, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_Manu_C_m_tel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_Manu_C_email, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Manu_C_m_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Manu_C_m_tel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(textField_Manu_C_m_no, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Manu_C_email, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_add)
						.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	void sto_rage() {
		setBounds(100, 100, 460, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel_2 = new JLabel("药品编号");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("仓库编号");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_2 = new JLabel("药品数量");
		lblNewLabel_2_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_3 = new JLabel("仓库名称");
		lblNewLabel_2_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		final JTextField textField_Sto_C_no = new JTextField();
		textField_Sto_C_no.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Sto_C_no.setColumns(10);
		
		final JTextField textField_Sto_W_no = new JTextField();
		textField_Sto_W_no.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Sto_W_no.setColumns(10);
		
		final JTextField textField_Sto_C_num = new JTextField();
		textField_Sto_C_num.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Sto_C_num.setColumns(10);
		
		final JTextField textField_Sto_W_name = new JTextField();
		textField_Sto_W_name.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Sto_W_name.setColumns(10);
		
		JButton btn_add = new JButton("\u4FDD\u5B58");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Executor executor = new Executor();
				int res = 0;
				try {
					res = executor.Storage_insert(textField_Sto_C_no.getText().toString(), 
							textField_Sto_W_no.getText().toString(), 
							Integer.parseInt(textField_Sto_C_num.getText().toString()), 
							textField_Sto_W_name.getText().toString());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				switch(res) {
				case 0:{
					JOptionPane.showMessageDialog(null, "插入成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
					textField_Sto_C_no.setText("");
					textField_Sto_W_no.setText("");
					textField_Sto_C_num.setText("");
					textField_Sto_W_name.setText("");
					return;
				}
				case -1:{
					//no match C_no
					JOptionPane.showMessageDialog(null, "不存在该编号的药品，请重新进行确认！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case -2:{
					//already exists C_no with W_no
					JOptionPane.showMessageDialog(null, "该仓库中已存在该药品，请重新进行确认！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case -3:{
					//num should >=0
					JOptionPane.showMessageDialog(null, "药品数量需要非负，请进行确认！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				default:
					break;
				}
			}
		});
		btn_add.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btn_return = new JButton("\u8FD4\u56DE");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_return.setFont(new Font("宋体", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btn_return, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_Sto_C_no, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_Sto_W_no, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_Sto_C_num, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_Sto_W_name, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Sto_W_no, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Sto_C_num, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Sto_W_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_add)
								.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(textField_Sto_C_no, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	void pa_tient() {
		setBounds(100, 100, 458, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		JLabel lblNewLabel_3 = new JLabel("\u75C5\u4EBA\u7F16\u53F7");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_2 = new JLabel("\u6027\u522B");
		lblNewLabel_3_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_3 = new JLabel("\u5E74\u9F84");
		lblNewLabel_3_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_4 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		lblNewLabel_3_4.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_5 = new JLabel("\u4F4F\u5740");
		lblNewLabel_3_5.setFont(new Font("宋体", Font.PLAIN, 20));
		
		final JTextField textField_P_no = new JTextField();
		textField_P_no.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_P_no.setColumns(10);
		
		final JTextField textField_P_name = new JTextField();
		textField_P_name.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_P_name.setColumns(10);
		
		final JTextField textField_P_sex = new JTextField();
		textField_P_sex.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_P_sex.setColumns(10);
		
		final JTextField textField_P_age = new JTextField();
		textField_P_age.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_P_age.setColumns(10);
		
		final JTextField textField_P_tel = new JTextField();
		textField_P_tel.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_P_tel.setColumns(10);
		
		final JTextField textField_P_add = new JTextField();
		textField_P_add.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_P_add.setColumns(10);
		
		JButton btn_add = new JButton("\u4FDD\u5B58");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Executor executor = new Executor();
				int res = 0;
				try {
					res = executor.Patient_insert(textField_P_no.getText().toString(), 
							textField_P_name.getText().toString(), 
							textField_P_sex.getText().toString(), 
							Integer.parseInt(textField_P_age.getText().toString()), 
							textField_P_tel.getText().toString(), 
							textField_P_add.getText().toString());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				switch(res) {
				case 0:{
					JOptionPane.showMessageDialog(null, "插入成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
					textField_P_no.setText("");
					textField_P_name.setText("");
					textField_P_sex.setText("");
					textField_P_age.setText("");
					textField_P_tel.setText("");
					textField_P_add.setText("");
					return;
				}
				case -1:{
					//unique
					JOptionPane.showMessageDialog(null, "存在相同的病人编号！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case -2:{
					//gender-----only “男”,“女”
					JOptionPane.showMessageDialog(null, "性别错误，只能填写男、女！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case -3:{
					//age 0-150
					JOptionPane.showMessageDialog(null, "年龄应在0-150岁之间！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				default:
					break;
				}
			}
		});
		btn_add.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btn_return = new JButton("\u8FD4\u56DE");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_return.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3_5, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_P_add, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_P_tel, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_P_age, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_P_sex, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_P_name, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_P_no, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
							.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_P_no, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_P_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_P_sex, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_P_age, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_P_tel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_P_add, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_add)
						.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	void sell_rebate() {
		setBounds(100, 100, 460, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel_2 = new JLabel("病人编号");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("药品编号");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_2 = new JLabel("数量");
		lblNewLabel_2_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_3 = new JLabel("处理时间");
		lblNewLabel_2_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		final JTextField textField_Sell_P_no = new JTextField();
		textField_Sell_P_no.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Sell_P_no.setColumns(10);
		
		final JTextField textField_Sell_C_no = new JTextField();
		textField_Sell_C_no.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Sell_C_no.setColumns(10);
		
		final JTextField textField_Sell_count = new JTextField();
		textField_Sell_count.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Sell_count.setColumns(10);
		
		final JTextField textField_Sell_Deal = new JTextField();
		textField_Sell_Deal.setFont(new Font("仿宋", Font.PLAIN, 14));
		textField_Sell_Deal.setColumns(10);
		
		JButton btn_add = new JButton("\u4FDD\u5B58");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Executor executor = new Executor();
				int res = 0;
				try {
					res = executor.Sell_insert(textField_Sell_P_no.getText().toString(), 
							textField_Sell_C_no.getText().toString(), 
							Integer.parseInt(textField_Sell_count.getText().toString()), 
							textField_Sell_Deal.getText().toString());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				switch(res) {
				case 0:{
					JOptionPane.showMessageDialog(null, "插入成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
					textField_Sell_P_no.setText("");
					textField_Sell_C_no.setText("");
					textField_Sell_count.setText("");
					textField_Sell_Deal.setText("");
					return;
				}
				case -1:{
					//no match patient
					JOptionPane.showMessageDialog(null, "不存在该编号的病人，请重新确认！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case -2:{
					//no match chemical
					JOptionPane.showMessageDialog(null, "不存在该编号的药品，请重新确认！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case 1:{
					//unique
					JOptionPane.showMessageDialog(null, "该病人已购买过该药品，请重新确认！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case -3:{
					//date
					JOptionPane.showMessageDialog(null, "日期格式错误，格式应为yyyy-mm-dd hh:mm:ss！", "错误", JOptionPane.ERROR_MESSAGE);
					break;
				}
				default:
					break;
				}
			}
		});
		btn_add.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btn_return = new JButton("\u8FD4\u56DE");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_return.setFont(new Font("宋体", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btn_return, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_Sell_P_no, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_Sell_C_no, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_Sell_count, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_Sell_Deal, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Sell_C_no, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Sell_count, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Sell_Deal, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_add)
								.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(textField_Sell_P_no, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public void back() {
		mainFrame.table_update();
		mainFrame.setEnabled(true);
		this.dispose();
	}
}
