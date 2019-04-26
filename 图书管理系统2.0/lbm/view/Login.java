package lbm.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import lbm.util.KeyListener;
/**
 * 创建登陆界面
 * @author 2017060105017 李泽宇
 *
 */
@SuppressWarnings("serial")
public class Login extends JFrame{
	private final JFrame frame = new JFrame("图书管理系统");
	private final Container container = frame.getContentPane();
	
	// 用户名框
	private JTextField texFieldtUserName  = new JTextField();
	// 密码框
	private JPasswordField textFieldPasswd = new JPasswordField();
	// 重置按钮
	private JButton buttonReset = new JButton("重置");
	// 登录按钮
	private JButton buttonLogin = new JButton("登陆");
	// 显示标签
	private JLabel Labelusername = new JLabel("姓名");
	private JLabel Labelpasswd = new JLabel("密码");
	private JLabel Labeltitle = new JLabel("图书管理系统");
	public Login() {
		
		container.setLayout(null);
		
		//设置三个标签
		setLabelusername();
		setLabelpasswd();
		setLabeltitle();
		// 设置用户名框以及监听事件
		setTextFieldUserName();
		
		// 设置密码框以及监听事件
		setPasswdField();
		
		// 设置登录按钮以及添加监听事件
		setButtonLogin();
		
		// 设置重置按钮以及添加监听事件
		setButtonReset();
			
		container.add(texFieldtUserName);
		container.add(textFieldPasswd);
		container.add(buttonLogin);
		container.add(buttonReset);
		container.add(Labelusername);
		container.add(Labelpasswd);
		container.add(Labeltitle);
		// 设置窗口大小、位置、可视、默认关闭方式等
		frame.setVisible(true);
		// 窗口不可调整大小
		frame.setResizable(false);
		frame.setSize(550, 388);
		frame.setLocation(300,150);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	}
	private void setButtonReset() {
		buttonReset.setBounds(310,280,90,30);
		buttonReset.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				texFieldtUserName.setText("");
				textFieldPasswd.setText("");
			}
		});
	}
	/*
	 * 设置按钮事件，并制定修改密码
	 */
	private void setButtonLogin() {
		
		buttonLogin.setBounds(150,280,90,30);
		buttonLogin.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				// TODO Auto-generated method stub
				String username = texFieldtUserName.getText();
				String passwd = new String(textFieldPasswd.getPassword());
				String un = "1";
				String pw = "1";
				if(un.equals(username) && pw.equals(passwd)) {
					frame.setVisible(false);
					new BookInformation();
				}
				else if(username.equals("")||passwd.equals("") ) {
	        		JOptionPane.showMessageDialog(null,"用户名或密码不能为空","错误"
							,JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,"用户名或密码错误","错误"
							,JOptionPane.PLAIN_MESSAGE);
				} 
			}
		});
	}
	/**
	 * 设置密码框
	 */
	private void setPasswdField() {
		textFieldPasswd.setBounds(220,210,180,30);
	}

		
	/**
	 * 设置用户名框
	 */
	private void setTextFieldUserName() {
		texFieldtUserName.setBounds(220,145,180,30);
		// 键盘事件，如果按下回车则模拟鼠标点击登录按钮
		new KeyListener(texFieldtUserName,buttonLogin);
	}
	private void setLabelusername() {
		Labelusername.setBounds(170, 145, 40, 30);
		Labelusername.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	private void setLabelpasswd() {
		Labelpasswd.setBounds(170, 210, 40, 30);
		Labelpasswd.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	private void setLabeltitle() {
		Labeltitle.setBounds(210,50,180,70);
		Labeltitle.setFont(new java.awt.Font("Dialog", 1, 25));
	}
}
