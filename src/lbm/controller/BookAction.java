package lbm.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;

import lbm.dao.BookDao;
import lbm.model.Book;

/**
 * 图书表控制类，包含增加书目信息，删除书目信息，修改以及查询书目信息
 * 以及初始化记录窗体表格
 * @author 2017060105017 李泽宇
 *
 */
public class BookAction {
	
	BookDao bookDao = new BookDao();
	/**
	 * 初始化窗体表格
	 * @return
	 * 返回了return二维数组，储存了record
	 */
	@SuppressWarnings("rawtypes")
	public Object[][] CreateBookTable1(String[] columnNames,JTextField textFieldaim) throws Exception{
		List list =bookDao.query(textFieldaim.getText());
		Object[][] results = new Object[list.size()][columnNames.length];
		
		
		for(int i = 0;i < list.size();i++) {
			Book record =(Book)list.get(i);
			
			results[i][0] = record.getID();
			results[i][1] = record.getName();
			results[i][2] = record.getAuthor();
			results[i][3] = record.getPublished();
			if(record.getBorrower() == null) {
				results[i][4] = "";
			}
			else {
				results[i][4] = record.getBorrower();
			}
			if(record.getSuber() == null) {
				results[i][5] = "";
			}
			else {
				results[i][5] = record.getSuber();
			}
		}
		return results;
	}
	
	/*
	 * 增加一本书
	 */
	public void AddBook(JTextField textid, JTextField textname, JTextField textau, JTextField textpub) throws Exception{
		Book book = new Book();
		
		book.setID(textid.getText());
		book.setName(textname.getText());
		book.setAuthor(textau.getText());
		book.setPublished(textpub.getText());
		
		bookDao.addBook(book);
	}
	/*
	 * 删除一本书
	 */
	public void DelaBook(JTextField aim) throws Exception{
		bookDao.delBook(aim.getText());
	}
	/*
	 * 修改一本书
	 */
	public void ChangeABook(JTextField textid, JTextField textname, JTextField textau, JTextField textpub,
							 JTextField textbo,JTextField textsub) throws Exception{
		Book book = new Book();
		
		book.setID(textid.getText());
		book.setName(textname.getText());
		book.setAuthor(textau.getText());
		book.setPublished(textpub.getText());
		book.setBorrower(textbo.getText());
		book.setSuber(textsub.getText());
		
		bookDao.changeBook(book);
	}
	/*
	 * 输入书号返回借阅人
	 */
	public String CheckBrowwer(JTextField jtextFieldaim) throws Exception{
		String s = bookDao.getBower(jtextFieldaim.getText());
		return s;
	}
	
	/*
	 * 输入书号返回预定人
	 */
	public String CheckSuber(JTextField jtextFieldaim) throws Exception{
		String s = bookDao.getsuber(jtextFieldaim.getText());
		return s;
	}
	
	/*
	 * 预约人变为null，加入借书选项
	 */
	public void whenSubLent(JTextField aim1,JTextField aim2) {
		try {
			bookDao.lentBook(aim1.getText(), aim2.getText());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			bookDao.nsubBook(aim1.getText());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/*
	 * 加入借书选项
	 */
	public void whenLent(JTextField aim1,JTextField aim2) {
		try {
			bookDao.lentBook(aim1.getText(),aim2.getText() );
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/*
	 * 加入还书选项
	 */
	public void Lent(JTextField aim1) {
		try {
			bookDao.returnBook(aim1.getText());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/*
	 * 加入预约选项
	 */
	public void subabook(JTextField aim1,JTextField aim2) {
		try {
			bookDao.subBook(aim1.getText(), aim2.getText());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/*
	 * 加入判断是否存在该书
	 */
	public Boolean checkbookexist(JTextField aim1) throws SQLException {
		@SuppressWarnings("static-access")
		String test = bookDao.getBname(aim1.getText());
		if(test.equals("error")) {
			return false;
		}
		else return true;
	}

}
