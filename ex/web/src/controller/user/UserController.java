package controller.user;

import po.User;
import service.BookService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserController {
    UserService userService = new UserServiceImpl();
    public boolean notNull(String... binfo) {

        for (String info : binfo) {
            if (info == null || info.length() == 0) {

                return false;
            }
        }
        return true;
    }
    public String index(HttpServletRequest req, HttpServletResponse resp){
        BookService bookService = new BookServiceImpl();
        List list = bookService.queryAll();
        req.setAttribute("books",list);
        return "/index.jsp";
    }
    public String login(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null,username,password));
        if (loginUser == null){
            return "/WEB-INF/login.jsp";
        }else {
            req.getSession().setAttribute("loginUser",loginUser);
            if (loginUser.getUsername().equals("admin")){
                return "/bookJdbc/book/list";
            }else {
                return "index";
            }
        }
    }
    public String logout(HttpServletRequest req, HttpServletResponse resp){
        req.getSession().removeAttribute("loginUser");
        return "index";
    }
}
