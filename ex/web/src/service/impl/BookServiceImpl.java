package service.impl;

import java.util.List;
import java.util.Map;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import po.Book;
import service.BookService;


public class BookServiceImpl implements BookService {

	private BookDao dao = new BookDaoImpl();
	

	
	@Override
	public void save(Book book) {
		dao.save(book);	
	}

	@Override
	public List queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

	@Override
	public void delete(Integer id) {
	
		dao.delete(id);
		
		
	}

	@Override
	public Book get(Integer id) {
		
		return dao.get(id);
	}

	@Override
	public void update(Book book) {
		dao.update(book);
	}

}
