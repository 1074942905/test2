package dao.impl;

import dao.BookDao;
import po.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int save(Book book) {
        String sql = "insert into book(id,title,author,price,description) values(?,?,?,?,?)";
        return update(sql,null,book.getTitle(),book.getAuthor(),book.getPrice(),book.getDescription());
    }

    @Override
    public List<Book> queryAll() {
        String sql = "select id,title,author,price,description from book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Book get(int id) {
        String sql = "select id,title,author,price,description from book where id = ?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public int delete(int id) {
        String sql = "delete from book where id = ?";
        return update(sql,id);
    }

    @Override
    public int update(Book book) {
        String sql = "update book set title=?,author=?,price=?,description=? where id = ?";
        return update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getDescription(),book.getId());
    }
}
