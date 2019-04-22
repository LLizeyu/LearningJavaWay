package lbm.view;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import lbm.util.*;
import lbm.controller.BookAction;
import lbm.controller.RecordAction;
import lbm.controller.StuAction;

/**
 * 图书信息管理界面类
 * 
 * @author 2017060105017 李泽宇
 */
@SuppressWarnings("serial")
public class BookInformation extends JFrame{
	JFrame frame = new JFrame("图书管理系统");
	Container container = frame.getContentPane();
	
	// 确定 ，查询按钮
	JButton  buttonSure, buttonSearch; 
	
	//学生学号，图书编号文本框
	JTextField textFieldStuno, textFieldBookno;
	// 图书信息文本框
	JTextField textFieldInformation;
	//ComboBox确定操作
	JComboBox<String> comboBoxnote;
	// 提示信息
	JLabel LabelSearch;
	JLabel LabelSno;
	JLabel LabelBno;
	JLabel LabelNote;
	// 表格
	JTable table;
	// 显示表格的滚动面板
	JScrollPane scrollPane;
	
	BookAction bookAction;
	RecordAction recAction;
	StuAction stuAction;
	public BookInformation() {
		frame.setLayout(null);
		new MenuBar(frame);
		
		bookAction = new BookAction();
		recAction = new RecordAction();
		stuAction = new StuAction();
		
		//设置文本框
		textFieldInformation = new JTextField();
		setTextFieldInformation();
		
		textFieldBookno = new JTextField();
		setTextFieldBookno();
		
		textFieldStuno = new JTextField();
		setTextFieldStuno();
			
		//设置按钮
		buttonSearch = new JButton("查询");
		setButtonSearch();
		
		buttonSure = new JButton("确定");
		setButtonSure();
		
		//设置标签
		LabelSearch = new JLabel("输入关键字");
		setLabelSearch();
		
		LabelSno = new JLabel("学生ID");
		setLabelSno();
		
		LabelBno = new JLabel("书籍ID");
		setLabelBno();
		
		LabelNote = new JLabel("操作");
		setLabelNote();
		
		//设置滚动条
		scrollPane = new JScrollPane();
		
		
		//设置comboBox
		setcomboBoxnote();
		
		container.add(LabelSearch);
		container.add(LabelBno);
		container.add(LabelSno);
		container.add(LabelNote);
		
		container.add(buttonSearch);
		container.add(buttonSure);
		
		container.add(textFieldInformation);
		container.add(textFieldBookno);
		container.add(textFieldStuno);
		
		container.add(scrollPane);
		container.add(comboBoxnote);
		
		new FrameOption(frame);
		}
	
	/*
	 * 设置提示标签
	 */
	private void setLabelSearch() {
		LabelSearch.setBounds(20, 30, 100, 30);
		LabelSearch.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	
	private void setLabelBno() {
		LabelBno.setBounds(20, 360, 70, 30);
		LabelBno.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	
	private void setLabelSno() {
		LabelSno.setBounds(260, 360, 70, 30);
		LabelSno.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	
	private void setLabelNote() {
		LabelNote.setBounds(500, 360, 70, 30);
		LabelNote.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	
	/*
	 * 设置查询文本框
	 */
	private void setTextFieldInformation() {
		textFieldInformation.setBounds(150, 30, 500, 30);
	}
	
	/*
	 * 设置学号添加文本框
	 */
	private void setTextFieldBookno() {
		textFieldBookno.setBounds(90,360 ,150, 30);
	}
	
	/*
	 *设置书籍号添加文本框 
	 */
	private void setTextFieldStuno() {
		textFieldStuno.setBounds(330, 360, 150, 30);
	}
	/*
	 * 设置查询按钮
	 */
	private void setButtonSearch() {
		buttonSearch.setBounds(670,30, 60, 30);
		buttonSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setTable();
			}
		});	
	}

	/*
	 * 设置确定按钮
	 */
	private void setButtonSure() {
		buttonSure.setBounds(660, 360, 60, 30);
		buttonSure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textFieldBookno.getText().length() == 0 || textFieldStuno.getText().length()==0) {
					JOptionPane.showMessageDialog(null,"请输入所有信息","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(comboBoxnote.getSelectedItem().equals("借书")) {
					try {
						if(bookAction.CheckSuber(textFieldBookno) != null
							&& ! textFieldStuno.getText().equals(bookAction.CheckSuber(textFieldBookno))) {
							JOptionPane.showMessageDialog(null,"这本书已被他人预约","错误"
									, JOptionPane.PLAIN_MESSAGE);
						}
						else if(!stuAction.checkexist(textFieldStuno)) {
							JOptionPane.showMessageDialog(null,"学号不存在","错误"
									, JOptionPane.PLAIN_MESSAGE);
						}
						else if(!bookAction.checkbookexist(textFieldBookno)) {
							JOptionPane.showMessageDialog(null,"该书不存在","错误"
									, JOptionPane.PLAIN_MESSAGE);
						}
						else if(bookAction.CheckBrowwer(textFieldBookno)!=null) {
							JOptionPane.showMessageDialog(null,"这本书已被借阅","错误"
									,JOptionPane.PLAIN_MESSAGE);
						}
						else if(bookAction.CheckSuber(textFieldBookno) != null
							&& textFieldStuno.getText().equals(bookAction.CheckSuber(textFieldBookno))){
							bookAction.whenSubLent(textFieldBookno, textFieldStuno);
							recAction.addaRec(textFieldBookno, textFieldStuno, "借书");
							JOptionPane.showMessageDialog(null,"借书成功","提示"
									, JOptionPane.PLAIN_MESSAGE);
						}
						else {
							bookAction.whenLent(textFieldBookno, textFieldStuno);
							recAction.addaRec(textFieldBookno, textFieldStuno, "借书");
							JOptionPane.showMessageDialog(null,"借书成功","提示"
									, JOptionPane.PLAIN_MESSAGE);
						}
					} catch (HeadlessException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
				else if(comboBoxnote.getSelectedItem().equals("还书")) {
					try {
						if(bookAction.CheckBrowwer(textFieldBookno)==null) {
							JOptionPane.showMessageDialog(null,"这本书未被借","错误"
									, JOptionPane.PLAIN_MESSAGE);	
						}
						else if(bookAction.CheckBrowwer(textFieldBookno).equals(textFieldStuno.getText())) {
							bookAction.Lent(textFieldBookno);
							recAction.addaRec(textFieldBookno, textFieldStuno, "还书");
							JOptionPane.showMessageDialog(null,"还书成功","提示"
									, JOptionPane.PLAIN_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null,"您未借这本书","错误"
									, JOptionPane.PLAIN_MESSAGE);
						}
					} catch (HeadlessException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
						
				}
				else {
					try {
						if(bookAction.CheckSuber(textFieldBookno)!=null || bookAction.CheckBrowwer(textFieldBookno)!=null) {
							JOptionPane.showMessageDialog(null,"这本书已被他人预约或借阅","错误"
									, JOptionPane.PLAIN_MESSAGE);
						}
						else {
							bookAction.subabook(textFieldBookno, textFieldStuno);
							recAction.addaRec(textFieldBookno, textFieldStuno, "预约");
							JOptionPane.showMessageDialog(null,"预约成功","提示"
									, JOptionPane.PLAIN_MESSAGE);
						}
					} catch (HeadlessException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
				
			}
		});
	}
	
	/*
	 * 设置comboBox
	 */
	private void setcomboBoxnote() {
		String[] s = {"借书","还书","预约"};
		comboBoxnote = new JComboBox<String>(s);
		comboBoxnote.setBounds(560, 360, 70, 30);
	}
	
	/*
	 * 设置表格
	 */
	private void setTable() {
		String[] columnNames = {"ID","图书名称","图书作者","出版商","借书","预约"};
		Object[][] results = null;
		try {
			results = bookAction.CreateBookTable1(columnNames, textFieldInformation);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(results.length==0) {
			JOptionPane.showMessageDialog(null,"本书库无此书","错误"
					, JOptionPane.PLAIN_MESSAGE);
		}
		table = new JTable(results,columnNames);
		new SetTableColumnCenter(table);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(20, 80, 760, 270);
	}
	
}

