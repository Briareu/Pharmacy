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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DetailsFrame extends JFrame {

	private JPanel contentPane;
	private MainFrame mainFrame;
	public drugInfo drug_current;
	public Manufacture manu_current;
	public Storage sto_current;
	public Patient p_current;
	public Sell s_current;

	/**
	 * Create the frame.
	 */
	public DetailsFrame(MainFrame mainframe, view_type view, Object temp) {
		mainFrame = mainframe;
		setTitle("ÏêÇé");
		switch(view) {
		case DRUG:{
			drug_update((drugInfo)temp);
			drug_Info();
			break;
		}
		case MANUFACTURE:{
			manu_update((Manufacture)temp);
			manu_facture();
			break;
		}
		case PATIENT:{
			p_update((Patient)temp);
			pa_tient();
			break;
		}
		case SELL:{
			s_update((Sell)temp);
			sell_rebate();
			break;
		}
		case STORAGE:{
			sto_update((Storage)temp);
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
		lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u836F\u54C1\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u836F\u54C1\u5206\u7C7B");
		lblNewLabel_1_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_2 = new JLabel("\u836F\u54C1\u89C4\u683C");
		lblNewLabel_1_2.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_3 = new JLabel("\u5236\u836F\u5546\u7F16\u53F7");
		lblNewLabel_1_3.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_4 = new JLabel("\u836F\u54C1\u8FDB\u4EF7");
		lblNewLabel_1_4.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_5 = new JLabel("\u836F\u54C1\u552E\u4EF7");
		lblNewLabel_1_5.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_6 = new JLabel("\u751F\u4EA7\u65E5\u671F");
		lblNewLabel_1_6.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_7 = new JLabel("\u6709\u6548\u65E5\u671F");
		lblNewLabel_1_7.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		final JTextField textField_drug_C_no = new JTextField();
		textField_drug_C_no.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_drug_C_no.setColumns(10);
		textField_drug_C_no.setText(drug_current.getChemical_no());
		
		final JTextField textField_drug_C_name = new JTextField();
		textField_drug_C_name.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_drug_C_name.setColumns(10);
		textField_drug_C_name.setText(drug_current.getChemical_name());
		
		final JTextField textField_drug_C_type = new JTextField();
		textField_drug_C_type.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_drug_C_type.setColumns(10);
		textField_drug_C_type.setText(drug_current.getChemical_type());
		
		final JTextField textField_drug_C_standard = new JTextField();
		textField_drug_C_standard.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_drug_C_standard.setColumns(10);
		textField_drug_C_standard.setText(drug_current.getChemical_standard());
		
		final JTextField textField_drug_m_no = new JTextField();
		textField_drug_m_no.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_drug_m_no.setColumns(10);
		textField_drug_m_no.setText(drug_current.getChemical_manufacture_no());
		
		final JTextField textField_drug_buy = new JTextField();
		textField_drug_buy.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_drug_buy.setColumns(10);
		textField_drug_buy.setText(drug_current.getChemical_buy_price());
		
		final JTextField textField_drug_sell = new JTextField();
		textField_drug_sell.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_drug_sell.setColumns(10);
		textField_drug_sell.setText(drug_current.getChemical_sell_price());
		
		final JTextField textField_drug_p_date = new JTextField();
		textField_drug_p_date.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_drug_p_date.setColumns(10);
		textField_drug_p_date.setText(drug_current.getProduct_date());
		
		final JTextField textField_drug_v_date = new JTextField();
		textField_drug_v_date.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_drug_v_date.setColumns(10);
		textField_drug_v_date.setText(drug_current.getValidity_date());
		
		JButton btn_delete = new JButton("\u5220\u9664");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_delete.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		JButton btn_save = new JButton("\u786E\u8BA4");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Executor executor = new Executor();
				try {
					executor.drug_update(textField_drug_C_no.getText().toString(), 
							textField_drug_C_name.getText().toString(), 
							textField_drug_C_type.getText().toString(), 
							textField_drug_C_standard.getText().toString(), 
							textField_drug_m_no.getText().toString(), 
							textField_drug_buy.getText().toString(), 
							textField_drug_sell.getText().toString(), 
							textField_drug_p_date.getText().toString(), 
							textField_drug_v_date.getText().toString(), 
							drug_current.getChemical_no());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				back();
			}
		});
		btn_save.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		JButton btn_return = new JButton("\u8FD4\u56DE");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_return.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
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
										.addComponent(textField_drug_sell, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
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
					.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(147)
					.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btn_delete)
							.addGap(35))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(33))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
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
		lblNewLabel_2.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("\u5236\u836F\u5546\u540D\u79F0");
		lblNewLabel_2_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_2 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		lblNewLabel_2_2.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_3 = new JLabel("\u90AE\u7BB1");
		lblNewLabel_2_3.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JTextField textField_Manu_C_m_no = new JTextField();
		textField_Manu_C_m_no.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Manu_C_m_no.setColumns(10);
		textField_Manu_C_m_no.setText(manu_current.getChemical_menufacture_no());
		
		JTextField textField_Manu_C_m_name = new JTextField();
		textField_Manu_C_m_name.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Manu_C_m_name.setColumns(10);
		textField_Manu_C_m_name.setText(manu_current.getChemical_manufacture_name());
		
		JTextField textField_Manu_C_m_tel = new JTextField();
		textField_Manu_C_m_tel.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Manu_C_m_tel.setColumns(10);
		textField_Manu_C_m_tel.setText(manu_current.getChemical_manufacture_tel());
		
		JTextField textField_Manu_C_email = new JTextField();
		textField_Manu_C_email.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Manu_C_email.setColumns(10);
		textField_Manu_C_email.setText(manu_current.getChemical_manufacture_email());
		
		JButton btn_delete = new JButton("\u5220\u9664");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_delete.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		JButton btn_save = new JButton("\u4FEE\u6539");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_save.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		JButton btn_return = new JButton("\u8FD4\u56DE");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_return.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_Manu_C_email, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addGap(53))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
							.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_Manu_C_m_no, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Manu_C_m_name, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Manu_C_m_tel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(34)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_Manu_C_m_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_Manu_C_m_tel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_Manu_C_email, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_delete)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(textField_Manu_C_m_no, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	void sto_rage() {
		setBounds(100, 100, 460, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel_2 = new JLabel("Ò©Æ·±àºÅ");
		lblNewLabel_2.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("²Ö¿â±àºÅ");
		lblNewLabel_2_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_2 = new JLabel("Ò©Æ·ÊýÁ¿");
		lblNewLabel_2_2.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_3 = new JLabel("²Ö¿âÃû³Æ");
		lblNewLabel_2_3.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JTextField textField_Sto_C_no = new JTextField();
		textField_Sto_C_no.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Sto_C_no.setColumns(10);
		textField_Sto_C_no.setText(sto_current.getChemical_no());
		
		JTextField textField_Sto_W_no = new JTextField();
		textField_Sto_W_no.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Sto_W_no.setColumns(10);
		textField_Sto_W_no.setText(sto_current.getWarehouse_no());
		
		JTextField textField_Sto_C_num = new JTextField();
		textField_Sto_C_num.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Sto_C_num.setColumns(10);
		textField_Sto_C_num.setText(sto_current.getChemical_number() + "");
		
		JTextField textField_Sto_W_name = new JTextField();
		textField_Sto_W_name.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Sto_W_name.setColumns(10);
		textField_Sto_W_name.setText(sto_current.getWarehouse_name());
		
		JButton btn_delete = new JButton("\u5220\u9664");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_delete.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		JButton btn_save = new JButton("\u4FEE\u6539");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_save.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		JButton btn_return = new JButton("\u8FD4\u56DE");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_return.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_Sto_W_name, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addGap(53))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
							.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_Sto_C_no, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Sto_W_no, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Sto_C_num, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(34)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_Sto_W_no, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_Sto_C_num, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_Sto_W_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_delete)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(textField_Sto_C_no, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	void pa_tient() {
		setBounds(100, 100, 458, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		JLabel lblNewLabel_3 = new JLabel("\u75C5\u4EBA\u7F16\u53F7");
		lblNewLabel_3.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_3_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_2 = new JLabel("\u6027\u522B");
		lblNewLabel_3_2.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_3 = new JLabel("\u5E74\u9F84");
		lblNewLabel_3_3.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_4 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		lblNewLabel_3_4.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_5 = new JLabel("\u4F4F\u5740");
		lblNewLabel_3_5.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JTextField textField_P_no = new JTextField();
		textField_P_no.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_P_no.setColumns(10);
		textField_P_no.setText(p_current.getPatient_no());
		
		JTextField textField_P_name = new JTextField();
		textField_P_name.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_P_name.setColumns(10);
		textField_P_name.setText(p_current.getPatient_name());
		
		JTextField textField_P_sex = new JTextField();
		textField_P_sex.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_P_sex.setColumns(10);
		textField_P_sex.setText(p_current.getPatient_sex());
		
		JTextField textField_P_age = new JTextField();
		textField_P_age.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_P_age.setColumns(10);
		textField_P_age.setText(p_current.getPatient_age() + "");
		
		JTextField textField_P_tel = new JTextField();
		textField_P_tel.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_P_tel.setColumns(10);
		textField_P_tel.setText(p_current.getPatient_tel());
		
		JTextField textField_P_add = new JTextField();
		textField_P_add.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_P_add.setColumns(10);
		textField_P_add.setText(p_current.getPatient_add());
		
		JButton btn_delete = new JButton("\u5220\u9664");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_delete.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		JButton btn_save = new JButton("\u4FEE\u6539");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_save.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		JButton btn_return = new JButton("\u8FD4\u56DE");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_return.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
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
							.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
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
						.addComponent(btn_delete)
						.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	void sell_rebate() {
		setBounds(100, 100, 460, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel_2 = new JLabel("²¡ÈË±àºÅ");
		lblNewLabel_2.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("Ò©Æ·±àºÅ");
		lblNewLabel_2_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_2 = new JLabel("ÊôÁé");
		lblNewLabel_2_2.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_3 = new JLabel("´¦ÀíÊ±¼ä");
		lblNewLabel_2_3.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		JTextField textField_Sell_P_no = new JTextField();
		textField_Sell_P_no.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Sell_P_no.setColumns(10);
		textField_Sell_P_no.setText(s_current.getPatient_no());
		
		JTextField textField_Sell_C_no = new JTextField();
		textField_Sell_C_no.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Sell_C_no.setColumns(10);
		textField_Sell_C_no.setText(s_current.getChemical_no());
		
		JTextField textField_Sell_count = new JTextField();
		textField_Sell_count.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Sell_count.setColumns(10);
		textField_Sell_count.setText(s_current.getCount() + "");
		
		JTextField textField_Sell_Deal = new JTextField();
		textField_Sell_Deal.setFont(new Font("·ÂËÎ", Font.PLAIN, 14));
		textField_Sell_Deal.setColumns(10);
		textField_Sell_Deal.setText(s_current.getDeal_date());
		
		JButton btn_delete = new JButton("\u5220\u9664");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_delete.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		JButton btn_save = new JButton("\u4FEE\u6539");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_save.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		JButton btn_return = new JButton("\u8FD4\u56DE");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_return.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_Sell_Deal, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addGap(53))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
							.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_Sell_P_no, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Sell_C_no, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Sell_count, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(34)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_Sell_C_no, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_Sell_count, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_Sell_Deal, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_delete)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(textField_Sell_P_no, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public void drug_update(drugInfo temp) {
		drug_current = temp;
	}
	
	public void manu_update(Manufacture temp) {
		manu_current = temp;
	}
	
	public void p_update(Patient temp) {
		p_current = temp;
	}
	
	public void s_update(Sell temp) {
		s_current = temp;
	}
	
	public void sto_update(Storage temp) {
		sto_current = temp;
	}
	
	public void back() {
		mainFrame.setEnabled(true);
		this.dispose();
	}
}
