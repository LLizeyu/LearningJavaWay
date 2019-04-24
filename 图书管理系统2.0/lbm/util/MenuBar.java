package lbm.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import lbm.view.*;

/**
 * 菜单栏类，包含图书类别管理、图书信息管理、更改密码、退出系统菜单项以及进入各窗体触发事件
 * 
 * @author 2017060105017 李泽宇
 */
public class MenuBar {
	JMenuBar menuBar;
	JMenuItem menuItemBookInformation;
	JMenuItem menuItemRecordInformation;
	JMenuItem menuItemChangetable;
	JMenuItem menuItemExit;
	public MenuBar(JFrame frame) {
		
		menuBar = new JMenuBar();
		
		// 图书信息管理与借阅功能菜单项
		menuItemBookInformation = new JMenuItem("信息管理中心");	 
		setMenuItemBookInformationn(frame);
	
		// 借阅记录管理菜单项
		menuItemRecordInformation = new JMenuItem("记录查询");
		setMenuItemRecordInformation(frame);
		
		// 数据库表更改菜单项
		menuItemChangetable = new JMenuItem("增删改");
		setMenuItemChangetable(frame);
		
		// 退出系统菜单项
		menuItemExit = new JMenuItem("注销");
		setMenuItemExit(frame);
		menuBar.add(menuItemBookInformation);	
		menuBar.add(menuItemRecordInformation);
		menuBar.add(menuItemChangetable);
		menuBar.add(menuItemExit);
		
		frame.setJMenuBar(menuBar);
	}
	
	/**
	 * 设置退出系统菜单项
	 */
	private void setMenuItemExit(JFrame frame) {
		menuItemExit.setFont(new java.awt.Font("Dialog", 1, 18));
		menuItemExit.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemExit.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// 关闭父窗体
				frame.dispose();
				new Login();
			}
		});
	}
	/*
	 * 设置修改表菜单项
	 */
	private void setMenuItemChangetable(JFrame frame) {
		menuItemChangetable.setFont(new java.awt.Font("Dialog", 1, 18));
		menuItemChangetable.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemChangetable.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// 关闭父窗体
				frame.dispose();
				new SupplementInformation();
			}
		});
	}
	/*
	 * 设置记录查询菜单项
	 */
	private void setMenuItemRecordInformation(JFrame frame) {
		menuItemRecordInformation.setFont(new java.awt.Font("Dialog", 1, 18));
		menuItemRecordInformation.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemRecordInformation.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// 关闭父窗体
				frame.dispose();
				new RecordInformation();
			}
		});
	}
	/*
	 * 设置信息菜单项
	 */
	private void setMenuItemBookInformationn(JFrame frame) {
		menuItemBookInformation.setFont(new java.awt.Font("Dialog", 1, 18));
		menuItemBookInformation.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemBookInformation.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// 关闭父窗体
				frame.dispose();
				new BookInformation();
			}
		});
	}
}
