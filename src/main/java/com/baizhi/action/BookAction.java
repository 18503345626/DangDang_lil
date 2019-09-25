package com.baizhi.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BookAction extends ActionSupport {
	private List<Book> list;
	private String key;
	private String content;
	private Book book;
	private File cover;
	private String coverFileName;
	private String coverContentType;
	private String bookId;
	private List<Category> listCategory;
	private List<Book> recommend;// 编辑推荐
	private List<Book> newBook;// 新书榜
	private List<Book> hot;// 热卖
	private List<Book> hotBoard;// 新书热卖
	private String fid;//向二级界面传入的一级Id
	private String sid;//向二级界面传入的一级Id
	private Category cate;
	private Integer pageCode;//页码
	private Integer pageNum=4;//每页展示的数量
	private Integer count;//总页数
	public Integer getPageCode() {
		return pageCode;
	}

	public void setPageCode(Integer pageCode) {
		this.pageCode = pageCode;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Category getCate() {
		return cate;
	}

	public void setCate(Category cate) {
		this.cate = cate;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public List<Book> getRecommend() {
		return recommend;
	}

	public void setRecommend(List<Book> recommend) {
		this.recommend = recommend;
	}

	public List<Book> getNewBook() {
		return newBook;
	}

	public void setNewBook(List<Book> newBook) {
		this.newBook = newBook;
	}

	public List<Book> getHot() {
		return hot;
	}

	public void setHot(List<Book> hot) {
		this.hot = hot;
	}

	public List<Book> getHotBoard() {
		return hotBoard;
	}

	public void setHotBoard(List<Book> hotBoard) {
		this.hotBoard = hotBoard;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public String getCoverFileName() {
		return coverFileName;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	public String getCoverContentType() {
		return coverContentType;
	}

	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	/**
	 * 展示所有图书
	 * 
	 * @return
	 */
	public String selectAll() {
		BookService bsi = new BookServiceImpl();
		list = bsi.selectAll();
		return Action.SUCCESS;
	}

	/**
	 * 模糊查询
	 * 
	 * @return
	 */
	public String selectByKey() {
		BookService bsi = new BookServiceImpl();
		list = bsi.selectByKey(key, content);
		return Action.SUCCESS;
	}

	/**
	 * 添加一本书
	 * 
	 * @return
	 */
	public String addOneBook() {
		BookService bsi = new BookServiceImpl();
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/back/img");
		File f = new File(realPath + "//" + coverFileName);
		try {
			f.createNewFile();
			FileUtils.copyFile(cover, f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		book.setCover(coverFileName);
		bsi.addOneBook(book);
		return Action.SUCCESS;
	}

	/**
	 * 删除一本书
	 * 
	 * @return
	 */
	public String deleteOne() {
		BookService bsi = new BookServiceImpl();
		bsi.deleteOne(bookId);
		return Action.SUCCESS;
	}

	/**
	 * 获取一本书的详细信息和所有分类的二级类型
	 * 
	 * @return
	 */
	public String selectOneById() {
		BookService bsi = new BookServiceImpl();
		CategoryService csi = new CategoryServiceImpl();
		listCategory = csi.selectAllSecond();
		book = bsi.selectOneById(bookId);
		return Action.SUCCESS;
	}

	/**
	 * 修改一本书
	 * 
	 * @return
	 */
	public String updateOneBook() {
		BookService bsi = new BookServiceImpl();
		if (coverFileName != null) {
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/back/img");
			File f = new File(realPath + "//" + coverFileName);
			try {
				f.createNewFile();
				FileUtils.copyFile(cover, f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			book.setCover(coverFileName);
		}
		bsi.updateOneBook(book);
		return Action.SUCCESS;
	}

	/**
	 * 前台首页展示
	 */
	public String main() {
		BookService bsi = new BookServiceImpl();
		CategoryService csi = new CategoryServiceImpl();
		listCategory = csi.selectFirst();
		recommend = bsi.selectRecommend();
		newBook = bsi.selectByCreateDate();
		hot = bsi.selectBySale();
		hotBoard = bsi.selectByCreateDateAndSale();
		return Action.SUCCESS;
	}

	/**
	 * 前台查询一本书的详细信息
	 * 
	 * @return
	 */
	public String selectByBookId() {
		BookService bsi = new BookServiceImpl();
		book = bsi.selectOneById(bookId);
		return Action.SUCCESS;
	}
	
	/**
	 * 获取到二级页面的一些数据
	 */
	public String second(){
		CategoryService csi = new CategoryServiceImpl();
		BookService bsi = new BookServiceImpl();
		cate = csi.selectOneFirst(fid);
		list=bsi.selectSecond(fid,sid,pageCode,pageNum);
		count=bsi.selectCountById(fid,sid,pageNum);
		return Action.SUCCESS;
	}
}
