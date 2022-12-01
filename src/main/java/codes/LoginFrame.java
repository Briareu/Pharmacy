package codes;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connections.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text_name;
	private JPasswordField text_pswd;
	private JButton brn_register;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("µÇÂ¼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 374);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(64, 128, 128));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\u79F0");
		lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		text_name = new JTextField();
		text_name.setFont(new Font("·ÂËÎ", Font.PLAIN, 15));
		text_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		text_pswd = new JPasswordField();
		text_pswd.setFont(new Font("·ÂËÎ", Font.PLAIN, 15));
		
		JButton brn_login = new JButton("\u767B\u5F55");
		brn_login.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		
		brn_register = new JButton("\u6CE8\u518C");
		brn_register.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(87)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(text_pswd, Alignment.TRAILING)
						.addComponent(text_name, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
					.addGap(171))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addComponent(brn_register, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
					.addComponent(brn_login, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(53)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(text_pswd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(brn_register, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(brn_login))
					.addGap(53))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
