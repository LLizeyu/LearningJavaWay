package lbm.model;

/**
 * 图书模型类,包含数据库图书表各对应的字段get、set方法
 * @author 2017060105017 李泽宇
 */
public class Book {
	private String ID;
	// 书的ID号
	private String name;
	// 书的名字
	private String author;
	// 书的作者
	private String published;
	// 书的出版商
	private String borrower;
	// 借阅人
	private String suber;
	// 预订人
	
	//获取ID
	public String getID() {
		return ID;
	}
	//设置ID
	public void setID(String iD) {
		ID = iD;
	}
	//获取书名
	public String getName() {
		return name;
	}
	//设置书名
	public void setName(String name) {
		this.name = name;
	}
	//获取作者名
	public String getAuthor() {
		return author;
	}
	//设置作者名
	public void setAuthor(String author) {
		this.author = author;
	}
	//获取出版商
	public String getPublished() {
		return published;
	}
	//设置出版社
	public void setPublished(String published) {
		this.published = published;
	}
	//获取借书人
	public String getBorrower() {
		return borrower;
	}
	//设置借书人
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	//获取预约人
	public String getSuber() {
		return suber;
	}
	//设置预约人
	public void setSuber(String suber) {
		this.suber = suber;
	}
	
	
}
