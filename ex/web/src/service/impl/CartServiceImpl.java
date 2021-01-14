package service.impl;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import po.CartItem;
import po.User;
import service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDao cartDao = new CartDaoImpl();
    @Override
    public List<CartItem> findAll() {
        return cartDao.findAll();
    }

    @Override
    public CartItem findById(Integer id) {
        return cartDao.findById(id);
    }

    @Override
    public List<CartItem> findByUid(User user) {
        return  cartDao.findByUid(user);
    }

    @Override
    public int insert(CartItem cartItem) {
        return cartDao.insert(cartItem);
    }

    @Override
    public int update(CartItem cartItem) {
        return cartDao.update(cartItem);
    }

    @Override
    public int clearById(int uid) {
        return cartDao.clearById(uid);
    }
}
