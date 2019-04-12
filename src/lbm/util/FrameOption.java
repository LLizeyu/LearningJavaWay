package lbm.util;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
/**
 * 窗口设置类，包含每个窗口所必须设置的大小、位置、默认关闭方式等
 * 
 * @author 2017060105017 李泽宇
 */
public class FrameOption {
	public FrameOption(JFrame frame) {
		
		frame.setVisible(true);
		// 窗口不可调整大小
		frame.setResizable(false);
		frame.setSize(800, 508);
		frame.setLocation(200,100);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
		
	}
}
