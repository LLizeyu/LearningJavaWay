package lbm.model;

/**
 *  学生模型类,包含学生信息表各对应的字段get、set方法
 * @author 2017060105017 李泽宇
 *
 */
public class Stu {
	private String ID;
	// 学生的学号
	private String name;
	// 学生的姓名
	
	
	//获得学生的ID
	public String getID() {
		return ID;
	}
	//设置学生的ID
	public void setID(String iD) {
		ID = iD;
	}
	
	//获得学生的姓名
	public String getName() {
		return name;
	}
	//设置学生的姓名
	public void setName(String name) {
		this.name = name;
	}
	
	
}
