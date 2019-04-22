package lbm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import lbm.model.Book;
import lbm.util.DButil;


/**
 * 数据库图书表信息数据访问对象类，包含增加图书信息、删除图书信息、查询图书信息、修改图书信息
 * 以及一些简便方法
 * @author 2017060105017 李泽宇
 *
 */
public class BookDao {

	/*
	 * 增加图书信息
	 */
	public void addBook(Book book) throws Exception{
		Connection con = DButil.getConnection();
		String sql = "insert into ibook"
				//sql语句进行插入操作
				+"(book_no,book_name,book_author,published,"
				+"borrower,subscribers)"
				+"values("
				/*
				 * 参数用？表示，相当于占位符，然后再对参数进行赋值。当真正执行时
				 * 这些参数会加载SQL与语句中，把SQL语句拼接完整才去执行
				 * 目的是为了减少对数据库的操作
				 */
				+"?,?,?,?,?,?)";
        /*
         * prepareStatement这个方法会将SQL语句加载到驱动程序conn集成程序中，
                 * 但是并不直接执行,而是当它调用execute()方法的时候才真正执行；
         */
		PreparedStatement psmt = con.prepareStatement(sql);
		
		psmt.setString(1, book.getID());
		psmt.setString(2, book.getName());
		psmt.setString(3, book.getAuthor());
		psmt.setString(4, book.getPublished());
		psmt.setString(5, null);
		psmt.setString(6, null);
		//执行sql语句
		psmt.execute();
	}
	
	/*
	 * 删除图书信息
	 */
	public void delBook(String ID) throws SQLException{
		Connection con = DButil.getConnection();
		String sql = "DELETE FROM ibook "
				+"where book_no=? ";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, ID);
		psmt.execute();
	}
	
	/*
	 * 修改图书信息
	 */
	public void changeBook(Book book) throws SQLException{
		Connection con = DButil.getConnection();
		String sql = "UPDATE ibook "
				+"SET book_name =?, book_author =?, published =?, "
				+"borrower =?,subscribers =? "
				+"WHERE book_no =?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, book.getName());
		psmt.setString(2, book.getAuthor());
		psmt.setString(3, book.getPublished());
		if(book.getBorrower() == "") {
			psmt.setString(4, null);
		}
		else psmt.setString(4, book.getBorrower());
		if(book.getSuber() == "") {
			psmt.setString(5, null);
		}
		else psmt.setString(5, book.getSuber());
		psmt.setString(6, book.getID());
		System.out.println(book.getID());
		psmt.execute();
	}
	
	/*
	 * 查询图书信息
	 */
	public List<Book> query(String aim) throws Exception{
		Connection con = DButil.getConnection();
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM ibook "
				+"where book_no='"+aim+"' "
				+"or book_name='"+aim+"' "
				+"or book_author='"+aim+"' "
				+"or published='"+aim+"' ");
		List<Book> booklist = new ArrayList<Book>();
		Book book = null;
		while(rs.next()) {
			book = new Book();
			book.setID(rs.getString("book_no"));
			book.setName(rs.getString("book_name"));
			book.setAuthor(rs.getString("book_author"));
			book.setPublished(rs.getString("published"));
			book.setBorrower(rs.getString("borrower"));
			book.setSuber(rs.getString("subscribers"));
			booklist.add(book);
		}
		return booklist;
	}
	/*
	 * 输出所有图书信息
	 */
	public List<Book> Allquery() throws Exception{
		Connection con = DButil.getConnection();
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM ibook "
				);
		List<Book> booklist = new ArrayList<Book>();
		Book book = null;
		while(rs.next()) {
			book = new Book();
			book.setID(rs.getString("book_no"));
			book.setName(rs.getString("book_name"));
			book.setAuthor(rs.getString("book_author"));
			book.setPublished(rs.getString("published"));
			book.setBorrower(rs.getString("borrower"));
			book.setSuber(rs.getString("subscribers"));
			booklist.add(book);
		}
		return booklist;
	}

	
	
	//用于之后操作的便利操作部分
	/*
	 * 修改图书信息，用于还书时方便修改
	 * 输入书号，至借书人为null
	 */
	public void returnBook(String bna) throws SQLException{
		Connection con = DButil.getConnection();
		String sql = "UPDATE ibook "
				+"SET "
				+"borrower=null "
				+"WHERE book_no =?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, bna);
		psmt.execute();
	}
	/*
	 * 修改图书信息，用于借书时方便修改
	 * 参数书号，学号，将该书的借阅人改为该学号
	 */
	public void lentBook(String bna,String sna) throws SQLException{
		Connection con = DButil.getConnection();
		String sql = "UPDATE ibook "
				+"SET "
				+"borrower=? "
				+"WHERE book_no =?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, sna);
		psmt.setString(2, bna);
		psmt.execute();
	}
	/*
	 * 修改图书消息，用于预约时方便修改
	 * 参数为书号，学号，将该书的预订人改为该学号
	 */
	public void subBook(String bna,String sna) throws SQLException{
		Connection con = DButil.getConnection();
		String sql = "UPDATE ibook "
				+"SET "
				+"subscribers=? "
				+"WHERE book_no =?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, sna);
		psmt.setString(2, bna);
		psmt.execute();
	}
	/*
	 * 修改图书消息，用于解除预约时方便修改
	 * 参数为书号，至订阅人为null
	 */
	public void nsubBook(String bna) throws SQLException{
		Connection con = DButil.getConnection();
		String sql = "UPDATE ibook "
				+"SET "
				+"subscribers=null "
				+"WHERE book_no =?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, bna);
		psmt.execute();
	}
	/*
	 * 查询图书的借阅人，返回借阅人
	 * 参数书号，返回借阅人
	 */
	public String getBower(String bna) throws SQLException{
		Connection con = DButil.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT borrower FROM ibook "
				+"where book_no='"+bna+"' ");
		String brower;
		if(rs.next()) {
			brower = rs.getString("borrower");
			}
		else {brower = null;}
		return brower;
	}
	/*
	 * 查询图书的订阅人，返回订阅人
	 * 参数书号，返回订阅人
	 */
	public String getsuber(String bna) throws SQLException{
		Connection con = DButil.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT subscribers FROM ibook "
				+"where book_no='"+bna+"' ");
		String suber;
		if(rs.next()) {
			suber = rs.getString("subscribers");
			}
		else {suber = null;}
		return suber;
	}
	
	/*
	 * 查询图书的名字，不存在返回error
	 */
	public static String getBname(String bna) throws SQLException{
		Connection con = DButil.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT book_name FROM ibook "
				+"where book_no='"+bna+"' ");
		if(rs.next()) {
			String Bname;
			Bname = rs.getString("book_name");
			return Bname;
		}
		else {
			return "error";
		}
	}
}
