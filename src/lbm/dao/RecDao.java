package lbm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import lbm.model.Record;
import lbm.util.DButil;

/**
 * 记录表信息数据访问对象类，包含增加记录信息，删除记录信息，更改记录信息
 * 查询记录信息以及一些便捷操作
 * @author 2017060105017 李泽宇
 *
 */
public class RecDao {
	/**
	 * 计算java.sql.Date格式三个月后的时间
	 */
	public java.sql.Date getMon(java.sql.Date x1) {
		 Calendar cal = new GregorianCalendar();
		 cal.setTime(x1);
		 cal.add(Calendar.MONTH, 3);
		 java.util.Date pt = (java.util.Date)cal.getTime();
		 java.sql.Date x2= new java.sql.Date(pt.getTime()) ;
		 return x2;
	}
	/**
	 * 增加一个RECID
	 */
	public String getNextId() {
		Calendar c =Calendar.getInstance();
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH);    
		int date = c.get(Calendar.DATE);    
		int hour = c.get(Calendar.HOUR_OF_DAY);    
		int minute = c.get(Calendar.MINUTE);    
		int second = c.get(Calendar.SECOND); 
		month += 1;
		String recid =""+ year + month + date + hour + minute + second; 
		return recid;
	}

	/**
	 * 增加借阅信息
	 */
	public void addRec(String bn,String sn,String tip) throws Exception{
		Connection con =DButil.getConnection();
		String sql = "INSERT into record"
				+"(Rec_no,stu_no, book_no, note, date)"
				+"values("
				+"?,?,?,?,?)";
		PreparedStatement psmt = con.prepareStatement(sql);
		String recid = getNextId();
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		
		psmt.setString(1, recid);
		psmt.setString(2, sn);
		psmt.setString(3, bn);
		psmt.setString(4, tip);
		psmt.setDate(5, currentDate);
		psmt.execute();
	}
	
	/**
	 * 删除记录信息
	 */
	public void delRec(String RecID) throws SQLException{
		Connection con = DButil.getConnection();
		String sql=""+
				 "DELETE FROM record"
				+" WHERE rec_no = ?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, RecID);
		psmt.execute();
	}
	
	/**
	 * 修改记录信息
	 */
	public void changeRec(Record rec) throws SQLException{
		Connection con = DButil.getConnection();
		String sql = "UPDATE record "
				+"SET stu_no =?, book_no =?, note =?, "
				+"date =?  "
				+"WHERE rec_no =?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, rec.getID());
		psmt.setString(2, rec.getbID());
		psmt.setString(3, rec.getNote());
		psmt.setDate(4, rec.getRedate());
		psmt.setString(5, rec.getRecID());
		psmt.execute();
	}
	/**
	 * 查询记录信息
	 */
	public List<Record> recquery(String aim) throws Exception{
		Connection con = DButil.getConnection();
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM record "
				+"where stu_no='"+aim+"' "
				+"or rec_no='"+aim+"' "
				+"or book_no='"+aim+"' "
				+"or note='"+aim+"' ");
		List<Record> reclist = new ArrayList<Record>();
		Record rec = null;
		while(rs.next()) {
			rec = new Record();
			rec.setRecID(rs.getString("rec_no"));
			rec.setID(rs.getString("stu_no"));
			rec.setName(StuDao.getSname(rs.getString("stu_no")));
			rec.setbID(rs.getString("book_no"));
			rec.setNote(rs.getString("note"));
			rec.setRedate(rs.getDate("date"));
			if(rs.getString("note").equals("借书") || rs.getString("note").equals("预约")) {
				rec.setRedate2(getMon(rs.getDate("date")));
			}
			else rec.setRedate2(null);
			reclist.add(rec);
		}
		return reclist;
	}
	
	/**
	 *查阅记录信息by date 
	 */
	public List<Record> recquery2(Date x) throws Exception{
		Connection con = DButil.getConnection();
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM record "
				+"where date='"+x+"' ");
		List<Record> reclist = new ArrayList<Record>();
		Record rec = null;
		while(rs.next()) {
			rec = new Record();
			rec.setRecID(rs.getString("rec_no"));
			rec.setID(rs.getString("stu_no"));
			rec.setName(StuDao.getSname(rs.getString("stu_no")));
			rec.setbID(rs.getString("book_no"));
			rec.setNote(rs.getString("note"));
			rec.setRedate(rs.getDate("date"));
			if(rs.getString("note").equals("借书") || rs.getString("note").equals("预约")) {
				rec.setRedate2(getMon(rs.getDate("date")));
			}
			else rec.setRedate2(null);
			reclist.add(rec);
		}
		return reclist;
	}
	/*
	 * 查询记录的编号，不存在返回error
	 */
	public static String getRecId(String RecID) throws SQLException{
		Connection con = DButil.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT rec_no FROM record "
				+"where rec_no='"+RecID+"' ");
		if(rs.next()) {
			String recid;
			recid = rs.getString("rec_no");
			return recid;
		}
		else {
			return "error";
		}
	}
}
