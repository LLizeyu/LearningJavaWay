package lbm.view;

import java.awt.Container;

import javax.swing.JFrame;
import lbm.util.*;
/**
 * 创建程序主窗口，登陆界面登陆后打开主窗口
 * @author 2017060105017 李泽宇
 *
 */
public class MainFrame {
	JFrame frame = new JFrame("图书管理系统");
	Container container = frame.getContentPane();
	
	public MainFrame(){
		// 添加工具栏以及各组件和监听事件
		new MenuBar(frame);
		// 设置窗口大小、位置、可视、默认关闭方式等
		new FrameOption(frame);
	}
}
