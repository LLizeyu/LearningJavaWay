package lbm.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import lbm.controller.RecordAction;
import lbm.util.FrameOption;
import lbm.util.MenuBar;
import lbm.util.SetTableColumnCenter;
/**
 * 记录信息管理界面类
 * 
 * @author 2017060105017 李泽宇
 */
@SuppressWarnings("serial")
public class RecordInformation extends JFrame{
	JFrame frame = new JFrame("图书管理系统");
	Container container = frame.getContentPane();
	
	//创建按钮
	JButton buttonSure;
	//创建文本框
	JTextField textFieldSearch,textFieldDate;
	//提示信息
	JLabel labelSearch;
	JLabel labelDate;
	//设置表格
	JTable table;
	// 显示表格的滚动面板
	JScrollPane scrollPane;
	
	RecordAction recAction;
	
	public RecordInformation() {
		frame.setLayout(null);
		new MenuBar(frame);
		
		recAction = new RecordAction();
		
		//设置文本框
		textFieldSearch = new JTextField();
		setTextFieldSearch();
		textFieldDate = new JTextField();
		setTextFieldDate();
		
		//设置按钮
		buttonSure = new JButton("查询");
		setButtonSure();
		
		//设置标签
		labelSearch = new JLabel("输入关键字");
		setLabelSearch();
		labelDate = new JLabel("输入查询日期");
		setLabelDate();
		//设置滚动条
		scrollPane = new JScrollPane();
		
		container.add(buttonSure);
		
		container.add(textFieldDate);
		container.add(textFieldSearch);
		
		container.add(labelSearch);
		container.add(labelDate);
		
		container.add(scrollPane);
		
		new FrameOption(frame);
	}
	
	/*
	 * 设置提示标签
	 */
	public void setLabelSearch() {
		labelSearch.setBounds(20, 30, 100, 30);
		labelSearch.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	public void setLabelDate() {
		labelDate.setBounds(380, 30, 120, 30);
		labelDate.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	
	/*
	 * 设置文本框
	 */
	public void setTextFieldSearch() {
		textFieldSearch.setBounds(120, 30, 250, 30);
	}
	public void setTextFieldDate() {
		textFieldDate.setBounds(510, 30, 150, 30);
	}
	
	/*
	 * 设置按钮
	 */
	public void setButtonSure() {
		buttonSure.setBounds(680, 30, 70, 30);
		buttonSure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*if(textFieldSearch.getText().length() == 0 && textFieldDate.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"请输入查询信息","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}*/
				if(textFieldSearch.getText().length() != 0 && textFieldDate.getText().length() != 0) {
					JOptionPane.showMessageDialog(null,"一次只能查询一项数据","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				if(textFieldSearch.getText().length() == 0 && textFieldDate.getText().length() != 0 && !recAction.Testdate(textFieldDate.getText())) {
					JOptionPane.showMessageDialog(null,"请输入(年-月-日)类型的日期","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else {
					setTable();
				}
			}
		});
	}
	
	/*
	 * 设置表格
	 */
	public void setTable() {
		String[] columnNames = {"记录编号","书号","姓名","学号","操作","操作时间","到期时间"};
		Object[][] results = null;
		if(textFieldSearch.getText().length() != 0) {
			try {
				results = recAction.CreateRecTable(columnNames, textFieldSearch);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		else {
			try {
				results = recAction.CreateRecTable(columnNames, textFieldDate);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(results.length==0) {
			JOptionPane.showMessageDialog(null,"未查询到记录或输入错误","错误"
					, JOptionPane.PLAIN_MESSAGE);
		}
		table = new JTable(results,columnNames);
		new SetTableColumnCenter(table);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(20, 80, 760, 270);
	}
}
