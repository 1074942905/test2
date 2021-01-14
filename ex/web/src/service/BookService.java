package service;

import java.util.List;
import java.util.Map;

import po.Book;



public interface BookService {

	public void save(Book book);

	public List queryAll();

	public void delete(Integer id);

	public Book get(Integer id);

	public void update(Book book);
	
	
	
}
