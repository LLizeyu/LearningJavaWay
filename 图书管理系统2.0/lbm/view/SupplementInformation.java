package lbm.view;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import lbm.controller.BookAction;
import lbm.controller.RecordAction;
import lbm.controller.StuAction;
import lbm.util.FrameOption;
import lbm.util.MenuBar;

/**
 * 补充其他功能界面类
 * 补充功能：增加书籍信息，修改删除书籍信息，删除修改记录信息
 * @author 2017060105017 李泽宇
 *
 */
@SuppressWarnings("serial")
public class SupplementInformation extends JFrame{
	JFrame frame = new JFrame("图书管理系统");
	Container container = frame.getContentPane();
	
	//创建按钮
	JButton buttonBook,buttonRec;
	//创建文本框'
	JTextField textFieldBid, textFieldBna, textFieldBau, textFieldBpu, textFieldBbo, textFieldBsu;
	JTextField textFieldRid, textFieldSid, textFieldBid2, textFieldNote, textFieldDate;
	//创建标签
	JLabel labelBid, labelBna, labelBau, labelBpu, labelBbo, labelBsu;
	JLabel labelRid, labelSid, labelBid2, labelNote, labelDate;
	JLabel tip1,tip2;
	//创建comboBox
	JComboBox<String> comboBoxBook;
	JComboBox<String> comboBoxRec;
	
	BookAction bookAction;
	RecordAction recAction;
	StuAction stuAction;
	
	public SupplementInformation() {
		frame.setLayout(null);
		new MenuBar(frame);
		
		bookAction = new BookAction();
		recAction = new RecordAction();
		stuAction = new StuAction();
		
		//设置文本框
		textFieldBid = new JTextField();
		setTextFieldBid();
		
		textFieldBna = new JTextField();
		setTextFieldBna();
		
		textFieldBau = new JTextField();
		setTextFieldBau();
		
		textFieldBpu = new JTextField();
		setTextFieldBpu();
		
		textFieldBbo = new JTextField();
		setTextFieldBbo();
		
		textFieldBsu = new JTextField();
		setTextFieldBsu();
		
		textFieldRid = new JTextField();
		setTextFieldRid();
		
		textFieldSid = new JTextField();
		setTextFieldSid();
		
		textFieldBid2 = new JTextField();
		setTextFieldBid2();
		
		textFieldNote = new JTextField();
		setTextFieldNote();
		
		textFieldDate = new JTextField();
		setTextFieldDate();
		//设置按钮
		buttonBook = new JButton("确定");
		setButtonBook();
		
		buttonRec = new JButton("确定");
		setButtonRec();
		//设置标签
		labelBid = new JLabel("书籍编号");
		setLabelBid();
		
		labelBna = new JLabel("书名");
		setLabelBna();
		
		labelBau = new JLabel("作者");
		setLabelBau();
		
		labelBpu = new JLabel("出版社");
		setLabelBpu();
		
		labelBbo = new JLabel("借阅人");
		setLabelBbo();
		
		labelBsu = new JLabel("预订人");
		setLabelBsu();
		
		labelRid = new JLabel("记录编号");
		setLabelRid();
		
		labelSid = new JLabel("学生ID");
		setLabelSid();
		
		labelBid2 = new JLabel("书籍编号");
		setLabelBid2();
		
		labelNote = new JLabel("操作项目");
		setLabelNote();
		
		labelDate = new JLabel("操作日期");
		setLabelDate();
		
		tip1 = new JLabel("tip:删除时仅需输入书籍编号,增加或修改时必须输入全部");
		setTip1();
		
		tip2 = new JLabel("tip:删除时仅需输入记录编号,修改时需输入全部信息");
		setTip2();
		//设置comboBox
		comboBoxBook = new JComboBox<String>();
		setComboBoxBook();
		
		comboBoxRec = new JComboBox<String>();
		setComboBoxRec();
		
		container.add(textFieldBid);
		container.add(textFieldBna);
		container.add(textFieldBau);
		container.add(textFieldBpu);
		container.add(textFieldBbo);
		container.add(textFieldBsu);
		container.add(textFieldRid);
		container.add(textFieldSid);
		container.add(textFieldBid2);
		container.add(textFieldNote);
		container.add(textFieldDate);
		
		container.add(buttonBook);
		container.add(buttonRec);
		
		container.add(comboBoxBook);
		container.add(comboBoxRec);
		
		container.add(labelBid);
		container.add(labelBna);
		container.add(labelBau);
		container.add(labelBpu);
		container.add(labelBbo);
		container.add(labelBsu);
		container.add(labelRid);
		container.add(labelSid);
		container.add(labelBid2);
		container.add(labelNote);
		container.add(labelDate);
		container.add(tip1);
		container.add(tip2);
		new FrameOption(frame);
	}
	/*
	 * 设置文本框
	 */
	private void setTextFieldBid() {
		textFieldBid.setBounds(170, 30, 150, 30);	
	}

	private void setTextFieldBna() {
		textFieldBna.setBounds(170, 80, 150, 30);	
	}

	private void setTextFieldBau() {
		textFieldBau.setBounds(170, 130, 150, 30);	
	}

	private void setTextFieldBpu() {
		textFieldBpu.setBounds(170, 180, 150, 30);	
	}

	private void setTextFieldBbo() {
		textFieldBbo.setBounds(170, 230, 150, 30);	
	}

	private void setTextFieldBsu() {
		textFieldBsu.setBounds(170, 280, 150, 30);	
	}
	
	private void setTextFieldRid() {
		textFieldRid.setBounds(500, 30, 150, 30);
	}
	
	private void setTextFieldSid() {
		textFieldSid.setBounds(500, 80, 150, 30);
	}
	
	private void setTextFieldBid2() {
		textFieldBid2.setBounds(500, 130, 150, 30);
	}
	
	private void setTextFieldNote() {
		textFieldNote.setBounds(500, 180, 150, 30);
	}
	
	private void setTextFieldDate() {
		textFieldDate.setBounds(500, 230, 150, 30);
	}
	/*
	 * 设置按钮
	 */
	private void setButtonBook() {
		buttonBook.setBounds(170, 380, 150, 30);
		buttonBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBoxBook.getSelectedItem().equals("增加")) {
					if(textFieldBid.getText().length()==0 ||textFieldBna.getText().length()==0 
						|| textFieldBau.getText().length()==0 || textFieldBpu.getText().length()==0) {
						JOptionPane.showMessageDialog(null,"请输入全部信息(借阅人,预定人除外)","错误"
								, JOptionPane.PLAIN_MESSAGE);
					}
					else {
						try {
							bookAction.AddBook(textFieldBid, textFieldBna, textFieldBau, textFieldBpu);
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"添加成功","提示"
								, JOptionPane.PLAIN_MESSAGE);
					}
				}
				else if(comboBoxBook.getSelectedItem().equals("删除")) {
					if(textFieldBid.getText().length()==0) {
						JOptionPane.showMessageDialog(null,"请输入需要删除的书籍编号","错误"
								, JOptionPane.PLAIN_MESSAGE);
					} else
						try {
							if(!bookAction.checkbookexist(textFieldBid)) {
								JOptionPane.showMessageDialog(null,"该书不存在","错误"
										, JOptionPane.PLAIN_MESSAGE);
							}
							else {
								bookAction.DelaBook(textFieldBid);
								JOptionPane.showMessageDialog(null,"删除成功","提示"
										, JOptionPane.PLAIN_MESSAGE);
							}
						} catch (HeadlessException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
				}
				else if(comboBoxBook.getSelectedItem().equals("修改")) {
					if(textFieldBid.getText().length()==0 ||textFieldBna.getText().length()==0 
							|| textFieldBau.getText().length()==0 || textFieldBpu.getText().length()==0
							|| (textFieldBbo.getText().length()!=0 && textFieldBsu.getText().length()!=0)) {
							JOptionPane.showMessageDialog(null,"请输入全部信息(借阅人,订阅人选一)","错误"
									, JOptionPane.PLAIN_MESSAGE);
						} else
						try {
							if((textFieldBsu.getText().length()==0 &&!stuAction.checkexist(textFieldBbo))
								|| (textFieldBbo.getText().length()==0 &&!stuAction.checkexist(textFieldBsu))) {
								JOptionPane.showMessageDialog(null,"学生不存在","错误"
										, JOptionPane.PLAIN_MESSAGE);
							}
							else if(!bookAction.checkbookexist(textFieldBid)) {
								JOptionPane.showMessageDialog(null,"该书不存在","错误"
										, JOptionPane.PLAIN_MESSAGE);
							}
							else {
								try {
									bookAction.ChangeABook(textFieldBid, textFieldBna, textFieldBau, textFieldBpu, textFieldBbo, textFieldBsu);
								} catch (Exception e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(null,"修改成功","提示"
										, JOptionPane.PLAIN_MESSAGE);
							}
						} catch (HeadlessException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
				}
			}
		});
	}
	
	private void setButtonRec() {
		buttonRec.setBounds(500, 380, 150, 30);
		buttonRec.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(comboBoxRec.getSelectedItem().equals("删除")) {
					if(textFieldRid.getText().length() == 0) {
						JOptionPane.showMessageDialog(null,"请输入需要删除的记录编号","错误"
								, JOptionPane.PLAIN_MESSAGE);
					} else
						try {
							if(!recAction.checkRecexist(textFieldRid)) {
								JOptionPane.showMessageDialog(null,"该记录不存在","错误"
										, JOptionPane.PLAIN_MESSAGE);
							}
							else {
								recAction.DelaRec(textFieldRid);
								JOptionPane.showMessageDialog(null,"删除成功","提示"
										, JOptionPane.PLAIN_MESSAGE);
							}
						} catch (HeadlessException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
				}
				else if(comboBoxRec.getSelectedItem().equals("修改")) {
					if(textFieldRid.getText().length()==0 || textFieldSid.getText().length()==0
							|| textFieldBid2.getText().length()==0 || textFieldNote.getText().length()==0
							|| textFieldDate.getText().length()==0) {
						JOptionPane.showMessageDialog(null,"请输入全部信息","错误"
								, JOptionPane.PLAIN_MESSAGE);
					} else
						try {
							if(!recAction.checkRecexist(textFieldRid)) {
								JOptionPane.showMessageDialog(null,"该记录不存在","错误"
										, JOptionPane.PLAIN_MESSAGE);
							}
						} catch (HeadlessException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
					if(!textFieldNote.getText().equals("借书") && !textFieldNote.getText().equals("还书")
							&& !textFieldNote.getText().equals("预约")) {
						JOptionPane.showMessageDialog(null,"请输入(借书，还书，预约)操作中的一种","错误"
								, JOptionPane.PLAIN_MESSAGE);
					}
					else if(!recAction.Testdate(textFieldDate.getText())) {
						JOptionPane.showMessageDialog(null,"请输入(年-月-日)类型的日期","错误"
								, JOptionPane.PLAIN_MESSAGE);
					}
					else {
						recAction.ChangeaRec(textFieldRid, textFieldSid, textFieldBid2, textFieldNote, textFieldDate);
						JOptionPane.showMessageDialog(null,"修改成功","提示"
								, JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
	}
	/*
	 * 设置ComboBox
	 */
	private void setComboBoxBook() {
		String[] S = {"增加","删除","修改"};
		comboBoxBook = new JComboBox<String>(S);
		comboBoxBook.setBounds(170, 330, 150, 30);
	}
	
	private void setComboBoxRec() {
		String[] S = {"删除","修改"};
		comboBoxRec = new JComboBox<String>(S);
		comboBoxRec.setBounds(500, 330, 150, 30);
	}
	
	/*
	 * 设置标签
	 */
	private void setLabelBid() {
		labelBid.setBounds(80, 30, 80, 30);
		labelBid.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	
	private void setLabelBna() {
		labelBna.setBounds(80, 80, 70, 30);
		labelBna.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	
	private void setLabelBau() {
		labelBau.setBounds(80, 130, 70, 30);
		labelBau.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	
	private void setLabelBpu() {
		labelBpu.setBounds(80, 180, 70, 30);
		labelBpu.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	private void setLabelBbo() {
		labelBbo.setBounds(80, 230, 70, 30);
		labelBbo.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	private void setLabelBsu() {
		labelBsu.setBounds(80, 280, 70, 30);
		labelBsu.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	private void setLabelRid() {
		labelRid.setBounds(400, 30, 100, 30);
		labelRid.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	private void setLabelSid() {
		labelSid.setBounds(400, 80, 100, 30);
		labelSid.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	private void setLabelBid2() {
		labelBid2.setBounds(400, 130, 100, 30);
		labelBid2.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	private void setLabelNote() {
		labelNote.setBounds(400, 180, 100, 30);
		labelNote.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	private void setLabelDate() {
		labelDate.setBounds(400, 230, 100, 30);
		labelDate.setFont(new java.awt.Font("Dialog", 1, 18));
	}
	private void setTip1() {
		tip1.setBounds(20, 423, 400, 18);
	}
	private void setTip2() {
		tip2.setBounds(420, 423, 400, 18);
	}
}
