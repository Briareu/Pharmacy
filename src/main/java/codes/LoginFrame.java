package codes;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connections.*;
import classes.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text_name;
	private JPasswordField text_pswd;
	private JButton btn_register;
	Executor executor;
	
	private JButton btn_login;
	private JLabel lb_name;
	private JLabel lb_pswd;
	private JLabel lb_nickname;
	
	enum types{LOGIN, REGISTER};
	private types current_type = types.LOGIN;
	private JTextField text_nickname;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 374);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(64, 128, 128));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		lb_name = new JLabel("\u7528\u6237\u540D\u79F0");
		lb_name.setFont(new Font("宋体", Font.PLAIN, 20));
		
		text_name = new JTextField();
		text_name.setFont(new Font("仿宋", Font.PLAIN, 15));
		text_name.setColumns(10);
		
		lb_pswd = new JLabel("\u5BC6\u7801");
		lb_pswd.setFont(new Font("宋体", Font.PLAIN, 20));
		
		text_pswd = new JPasswordField();
		text_pswd.setFont(new Font("仿宋", Font.PLAIN, 15));
		
		btn_login = new JButton("\u767B\u5F55");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(current_type == types.LOGIN)
					check();
				else {
					//register 
					insert();
				}
			}
		});
		btn_login.setFont(new Font("宋体", Font.PLAIN, 20));
		
		btn_register = new JButton("\u6CE8\u518C");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(current_type == types.LOGIN)
					register();
				else
					return_login();
			}
		});
		btn_register.setFont(new Font("宋体", Font.PLAIN, 20));
		
		lb_nickname = new JLabel("\u6635\u79F0");
		lb_nickname.setFont(new Font("宋体", Font.PLAIN, 20));
		
		text_nickname = new JTextField();
		text_nickname.setFont(new Font("仿宋", Font.PLAIN, 15));
		text_nickname.setColumns(10);

		lb_nickname.setVisible(false);
		text_nickname.setVisible(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(87)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lb_name, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(lb_pswd, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(text_pswd, Alignment.TRAILING)
						.addComponent(text_name, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
					.addGap(171))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addComponent(btn_register, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
					.addComponent(btn_login, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lb_name, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(53)
							.addComponent(lb_pswd))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(text_pswd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_register, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_login))
					.addGap(53))
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null);
	}
	
	void register() {
		current_type = types.REGISTER;
		
		setTitle("注册");
		
		lb_name.setText("\u7528\u6237\u540D\u79F0");
		lb_pswd.setText("\u5BC6\u7801");
		lb_nickname.setText("\u6635\u79F0");
		btn_login.setText("\u6CE8\u518C");
		btn_register.setText("\u8FD4\u56DE");
		lb_nickname.setVisible(true);
		text_nickname.setVisible(true);
		
		text_name.setText("");
		text_pswd.setText("");
		text_nickname.setText("");
		
		contentPane.removeAll();
		setBounds(100, 100, 578, 434);
		//contentPane.repaint();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(87)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lb_name, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(lb_nickname, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(lb_pswd, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(text_pswd)
						.addComponent(text_nickname, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
						.addComponent(text_name))
					.addGap(135))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addComponent(btn_register, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
					.addComponent(btn_login, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(82))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(lb_nickname, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addComponent(text_nickname, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lb_name, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lb_pswd)
						.addComponent(text_pswd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_register, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_login))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		contentPane.revalidate();
		
		this.setLocationRelativeTo(null);
	}
	
	void return_login() {
		current_type = types.LOGIN;
		
		setTitle("登录");
		
		btn_login.setText("\u767B\u5F55");
		btn_register.setText("\u6CE8\u518C");
		lb_name.setText("\u7528\u6237\u540D\u79F0");
		lb_pswd.setText("\u5BC6\u7801");
		lb_nickname.setVisible(false);
		text_nickname.setVisible(false);
		
		text_name.setText("");
		text_pswd.setText("");
		text_nickname.setText("");
		
		contentPane.removeAll();
		setBounds(100, 100, 578, 374);
		//contentPane.repaint();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(87)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lb_name, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(lb_pswd, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(text_pswd, Alignment.TRAILING)
						.addComponent(text_name, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
					.addGap(171))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addComponent(btn_register, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
					.addComponent(btn_login, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lb_name, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(53)
							.addComponent(lb_pswd))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(text_pswd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_register, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_login))
					.addGap(53))
		);
		contentPane.setLayout(gl_contentPane);

		contentPane.revalidate();
		
		this.setLocationRelativeTo(null);
	}
	
	void check() {
		String no = text_name.getText();
		String pswd = new String(text_pswd.getPassword());
		
		executor = new Executor();
		Vector<AdminInfo> res = new Vector<AdminInfo>();
		try {
			res = executor.AdminInfo_selectdata(no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res.size() == 0) {
			JOptionPane.showMessageDialog(null, "不存该用户，请检查用户名称！", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(res.get(0).getPass_word().compareTo(pswd) == 0) {
			log_in(res.get(0).getAdmin_name());
		}else {
			JOptionPane.showMessageDialog(null, "密码错误！", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	
	void insert() {
		String no = text_name.getText();
		String pswd = new String(text_pswd.getPassword());
		String name = text_nickname.getText();
		
		executor = new Executor();
		int res = 1;
		try {
			res = executor.AdminInfo_insertdata(no, name, pswd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res == -1) {
			JOptionPane.showMessageDialog(null, "存在相同的用户名称，请重新命名！", "错误", JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "成功注册！", "成功", JOptionPane.INFORMATION_MESSAGE);
			return_login();
		}
	}
	
	void log_in(String name) {
		MainFrame c = new MainFrame();
		c.set_title(name);
		c.setVisible(true);
		
		this.dispose();
	}
}
