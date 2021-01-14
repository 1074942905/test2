package dao;

import po.Book;
import po.User;

import java.util.List;

public interface UserDao {
    public int save(User user);

    public User queryUserByUsernameAndPassword(String username, String password);
    public List<User> queryAll();

    public User get(int id);

    public int delete(int id);

    public int update(User user);
}
