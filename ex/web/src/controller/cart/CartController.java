package controller.cart;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import po.CartItem;
import po.User;
import service.CartService;
import service.impl.CartServiceImpl;
import tools.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class CartController {
    CartService service = new CartServiceImpl();

    public boolean notNull(String... binfo) {

        for (String info : binfo) {
            if (info == null || info.length() == 0) {

                return false;
            }
        }
        return true;
    }

    public String addCart(HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession = request.getSession();

        String price1 = request.getParameter("price");
        double price = WebUtils.parseDouble(price1,0);

        String sum1 = request.getParameter("sum");
        double sum = WebUtils.parseDouble(sum1,0);

        String quantity1 = request.getParameter("quantity");
        int quantity = WebUtils.parseInt(quantity1,0);

        String bookName = request.getParameter("bookName");

        CartItem cartItem = new CartItem(null,null,price,bookName,sum,quantity);
        //获取购物车的cookie
        Cookie[] cookies = request.getCookies();
        Cookie cartCookie = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cartCookie")){
                cartCookie = cookie;
                break;
            }
        }
        //检查是否已经登录
        User user = (User) httpSession.getAttribute("loginUser");
        //创建商品清单
        List<CartItem> cartItemList = new ArrayList<CartItem>();
        //持久层中的商品清单
        List<CartItem> oldCartItemList = new ArrayList<CartItem>();
        //如果没有用户登陆，则创建一个临时的购物车
        if(user == null){
            if (cartCookie==null){
                cartItemList.add(cartItem);
            }else {
                Gson gson = new Gson();
                cartItemList = gson.fromJson(cartCookie.getValue(), new TypeToken<List<CartItem>>() {}.getType());
                System.out.println(cartItemList.toString());
                boolean isNew = isNewCart(cartItemList,cartItem);
                if (isNew){
                    cartItemList.add(cartItem);
                }else {
                    for (int i = 0;i<cartItemList.size();i++){
                        if(cartItemList.get(i).getId()==cartItem.getId()) {
                            cartItemList.get(i).setQuantity(cartItemList.get(i).getQuantity() + 1);
                            cartItemList.get(i).setSum(cartItemList.get(i).getSum() + cartItemList.get(i).getPrice());
                        }
                    }
                }
            }
            //更新cookie
            Gson gson2=new Gson();
            String tr = gson2.toJson(cartItemList);
            System.out.println(tr);
            //COOKIE中含有单引号 待解决
/*          Cookie listCartCookie = new Cookie("cartCookie",tr);
            listCartCookie.setMaxAge(60*60*24);
            response.addCookie(listCartCookie);
  */      }else {
            //有用户登陆
            cartItemList = (List<CartItem>) httpSession.getAttribute("listCartSession");
            if(cartItemList==null){
                oldCartItemList = service.findByUid(user);
                System.out.println(oldCartItemList);
                cartItemList = oldCartItemList;
                httpSession.setAttribute("listCartSession",cartItemList);
                boolean isNew = isNewCart(cartItemList,cartItem);
                if(isNew){
                    String uid = request.getParameter("uid");
                    cartItem.setUid(Integer.parseInt(uid));
                    service.insert(cartItem);
                    cartItemList.add(cartItem);
                    httpSession.setAttribute("listCartSession",cartItemList);
                }else {
                    double newSum = 0;
                    for (int i = 0;i<cartItemList.size();i++){
                        if(cartItemList.get(i).getBookName().equals(cartItem.getBookName())) {
                            cartItemList.get(i).setQuantity(cartItemList.get(i).getQuantity() + 1);
                            cartItemList.get(i).setSum(cartItemList.get(i).getSum() + cartItemList.get(i).getPrice());
                            cartItemList.set(i,cartItemList.get(i));
                            newSum = cartItemList.get(i).getSum();
                        }
                    }
                    String uid = request.getParameter("uid");
                    cartItem.setUid(Integer.parseInt(uid));
                    service.insert(cartItem);
                    httpSession.setAttribute("listCartSession",cartItemList);
                    System.out.println(cartItemList.toString());
                }
            }else {
                boolean isNew = isNewCart(cartItemList,cartItem);
                if(isNew){
                    String uid = request.getParameter("uid");
                    cartItem.setUid(Integer.parseInt(uid));
                    service.insert(cartItem);
                    cartItemList.add(cartItem);
                    httpSession.setAttribute("listCartSession",cartItemList);
                }else {
                    for (int i = 0;i<cartItemList.size();i++){
                        if(cartItemList.get(i).getBookName().equals(cartItem.getBookName())) {
                            cartItemList.get(i).setQuantity(cartItemList.get(i).getQuantity() + 1);
                            cartItemList.get(i).setSum(cartItemList.get(i).getSum() + cartItemList.get(i).getPrice());
                            cartItemList.set(i,cartItemList.get(i));
                        }
                    }
                    String uid = request.getParameter("uid");
                    cartItem.setUid(Integer.parseInt(uid));
                    service.insert(cartItem);
                    httpSession.setAttribute("listCartSession",cartItemList);
                    System.out.println(cartItemList.toString());
                }
            }
        }
        return "/WEB-INF/cart.jsp";
    }
    private boolean isNewCart(List<CartItem> cartItemList, CartItem cartItem) {
        boolean flag = true;
        for(int i = 0;i<cartItemList.size();i++){
            if(cartItem.getBookName().equals(cartItemList.get(i).getBookName())){
                flag=false;
            }
        }
        return flag;
    }

    public String clear(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        List<CartItem> list = (List<CartItem>) session.getAttribute("listCartSession");
        list.clear();
        service.clearById(loginUser.getId());
        return "/WEB-INF/cart.jsp";
    }

    public String Continue(HttpServletRequest request,HttpServletResponse response){
        return "/bookJdbc/user/index";
    }
}
