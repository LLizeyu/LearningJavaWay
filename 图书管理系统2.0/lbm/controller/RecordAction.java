package lbm.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;

import lbm.dao.RecDao;
import lbm.model.Record;

/**
 * 记录信息表控制类，包含增加记录，删除记录，修改记录以及查询记录
 * 以及初始化记录窗体表格
 * @author 2017060105017 李泽宇
 *
 */
public class RecordAction {
	
	RecDao recDao = new RecDao();
	/**
	 * 初始化窗体表格
	 * @return
	 * 返回了return二维数组，储存了record
	 */
	@SuppressWarnings("rawtypes")
	public Object[][] CreateRecTable(String[] columnNames,JTextField textFieldaim) throws Exception{
		RecDao recDao = new RecDao();
		List list=null;
		if(textFieldaim.getText().length() == 0) {
			list = recDao.Allrecquery();
		}
		else if(Testdate(textFieldaim.getText())) {
			java.sql.Date aimDate = java.sql.Date.valueOf(textFieldaim.getText());
			list =recDao.recquery2(aimDate);
		}
		else {
			list =recDao.recquery(textFieldaim.getText());
		}
		Object[][] results = new Object[list.size()][columnNames.length];
		
		for(int i = 0;i < list.size();i++) {
			Record record =(Record)list.get(i);
			
			results[i][0] = record.getRecID();
			results[i][1] = record.getbID();
			results[i][2] = record.getName();
			results[i][3] = record.getID();
			results[i][4] = record.getNote();
			results[i][5] = record.getRedate();
			if(record.getRedate2() == null) {
				results[i][6] = "";
			}
			else {
				results[i][6] = record.getRedate2();
			}
		}
		return results;
	}
	/*
	 * 增加一条记录
	 */
	public void addaRec(JTextField aim1,JTextField aim2,String x1) {
		try {
			recDao.addRec(aim1.getText(), aim2.getText(),x1);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/*
	 * 删除一条记录
	 */
	public void DelaRec(JTextField aim1) {
		try {
			recDao.delRec(aim1.getText());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/*
	 * 修改一条记录
	 */
	public void ChangeaRec(JTextField RecID,JTextField RecSid,JTextField RecBid,
			JTextField RecNote,JTextField RecDate) {
		Record record = new Record();
		
		record.setRecID(RecID.getText());
		record.setID(RecSid.getText());
		record.setbID(RecBid.getText());
		record.setNote(RecNote.getText());
		java.sql.Date Datetemp = java.sql.Date.valueOf(RecDate.getText());
		record.setRedate(Datetemp);
		
		try {
			recDao.changeRec(record);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/*
	 * 加入判断是否存在该记录 
	 */
	public Boolean checkRecexist(JTextField aim1) throws SQLException {
		@SuppressWarnings("static-access")
		String test = recDao.getRecId(aim1.getText());
		if(test.equals("error")) {
			return false;
		}
		else return true;
	}
	/**
	 * 测试字符串是否满足Date格式
	 */
	public boolean Testdate(String s) {
		java.sql.Date x=null;
		try {
			x = java.sql.Date.valueOf(s);
			}catch(Exception e) {}
		if(x==null) return false;
		else return true;
	}
}
