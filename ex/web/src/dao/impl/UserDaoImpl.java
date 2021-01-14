package dao.impl;

import dao.UserDao;
import po.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int save(User user) {
        String sql = "insert into user(id,username,password) values(?,?,?)";
        return update(sql,null,user.getUsername(),user.getPassword());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password from user where username = ? and password = ?";
        return queryForOne(User.class, sql, username,password);
    }


    @Override
    public List<User> queryAll() {
        String sql = "select id,username,password from user";
        return queryForList(User.class,sql);
    }

    @Override
    public User get(int id) {
        String sql = "select id,username,password from user where id = ?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public int delete(int id) {
        String sql = "delete from user where id = ?";
        return update(sql,id);
    }

    @Override
    public int update(User user) {
        String sql = "update user set username = ?,password = ? where id = ?";
        return update(sql,user.getUsername(),user.getPassword(),user.getId());
    }
}
