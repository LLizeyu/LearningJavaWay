package lbm.dao;

import java.sql.*;

import lbm.util.DButil;

/**
 * 学生表不可操作，只可转化学生姓名与学号
 * @author 2017060105017 李泽宇
 *
 */
public class StuDao {
	//输入学号获得学生姓名，若不存在该学生则返回error
	public static String getSname(String bna) throws SQLException{
		Connection con = DButil.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT stu_name FROM stu "
				+"where stu_no='"+bna+"' ");
		if(rs.next()) {
			String Sname;
			Sname = rs.getString("stu_name");
			return Sname;
		}
		else {
			return "error";
		}
	}
}
