package lbm.model;

/**
 *  记录类,包含状态记录表各对应的字段get、set方法
 * @author 2017060105017 李泽宇
 *
 */
public class Record {
	private String RecID;
	//创建记录编号
	private	String name;
	// 创建记录的学生的姓名
	private String ID;
	// 创建记录的学生的学号
	private String note;
	// 创建发生事件的对象
	private String bID;
	// 创建记录的类型
	private java.sql.Date redate;
	// 创建记录发生的时间
	private java.sql.Date redate2;
	
	//获取创建记录的学生的姓名
	public String getName() {
		return name;
	}
	//设置创建记录的学生的姓名
	public void setName(String name) {
		this.name = name;
	}
	//获取创建记录的学生的学号
	public String getID() {
		return ID;
	}
	//设置创建记录的学生的学号
	public void setID(String iD) {
		ID = iD;
	}
	//获取记录类型
	public String getNote() {
		return note;
	}
	//建立记录类型
	public void setNote(String note) {
		this.note = note;
	}
	//获取记录日期
	public java.sql.Date getRedate() {
		return redate;
	}
	//建立记录日期
	public void setRedate(java.sql.Date redate) {
		this.redate = redate;
	}
	//建立对象
	public String getbID() {
		return bID;
	}
	//获取对象
	public void setbID(String bID) {
		this.bID = bID;
	}
	//获取记录日期2
	public java.sql.Date getRedate2() {
		return redate2;
	}
	//建立记录日期2
	public void setRedate2(java.sql.Date redate) {
		this.redate2 = redate;
	}
	//获取记录编号
	public String getRecID() {
		return RecID;
	}
	//建立记录编号
	public void setRecID(String recID) {
		RecID = recID;
	}
}
