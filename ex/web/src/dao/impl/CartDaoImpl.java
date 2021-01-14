package dao.impl;

import dao.CartDao;
import po.CartItem;
import po.User;

import java.util.List;

public class CartDaoImpl extends BaseDao implements CartDao {
    @Override
    public List<CartItem> findAll() {
        String sql = "select * from cart";
        return queryForList(CartItem.class,sql);
    }

    @Override
    public CartItem findById(Integer id) {
        String sql = "select * from cart where id = ?";
        return queryForOne(CartItem.class,sql,id);
    }

    @Override
    public List<CartItem> findByUid(User user) {
        String sql = "select * from cart where uid = ?";
        return queryForList(CartItem.class,sql,user.getId());
    }

    @Override
    public int insert(CartItem cartItem) {
        String sql = "insert into cart values(?,?,?,?,?,?)";
        return update(sql,null,cartItem.getUid(),cartItem.getPrice(),cartItem.getBookName(),cartItem.getSum(),cartItem.getQuantity());
    }

    @Override
    public int update(CartItem cartItem) {
        String sql = "update cart set uid = ?,price = ?,bookName = ? , sum = ?,quantity = ? where id = ?";
        return update(sql,cartItem.getUid(),cartItem.getPrice(),cartItem.getBookName(),cartItem.getSum(),cartItem.getQuantity(),cartItem.getId());
    }

    @Override
    public int clearById(int uid) {
        String sql = "delete from cart where uid = ?";
        return update(sql,uid);
    }
}
