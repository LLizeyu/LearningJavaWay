package lbm.controller;

import java.sql.SQLException;

import javax.swing.JTextField;

import lbm.dao.StuDao;

/**
 * 学生控制类
 * 仅用来判断该学生是否存在
 * @author 2017060105017 李泽宇
 *
 */
public class StuAction {
	StuDao stuDao = new StuDao();
	@SuppressWarnings("static-access")
	public Boolean checkexist(JTextField aim1) throws SQLException {
		String test = stuDao.getSname(aim1.getText());
		if(test.equals("error")) {
			return false;
		}
		else return true;
	}
}
