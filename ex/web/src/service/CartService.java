package service;

import po.Book;
import po.CartItem;
import po.User;

import java.util.List;

public interface CartService {
    public List<CartItem> findAll();

    public CartItem findById(Integer id);

    public List<CartItem> findByUid(User user);

    public int insert(CartItem cartItem);

    public int update(CartItem cartItem);

    public int clearById(int uid);
}
