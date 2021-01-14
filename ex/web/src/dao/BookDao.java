package dao;

import po.Book;

import java.util.List;

public interface BookDao {
    public int save(Book book);

    public List<Book> queryAll();

    public Book get(int id);

    public int delete(int id);

    public int update(Book book);
}
