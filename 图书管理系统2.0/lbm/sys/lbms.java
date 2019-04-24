package lbm.sys;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import lbm.view.Login;
/**
 * 图书管理系统
 * @author 2017060105016 李泽宇
 *
 */

public class lbms {
	public lbms() {
		
		new Login();
	}
	public static void main(String[] args) {
		//调用UI
		try
		{
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		}
		catch(Exception e)
		{
			//TODO exception
		}		
		new lbms();
		
	}
}


