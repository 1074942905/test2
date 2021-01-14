package controller.cart;

import controller.book.BookController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/cart/*")
public class CartDispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CartController controller= new CartController();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        int lastIndex = url.lastIndexOf("/");
        url = url.substring(lastIndex+1);
        Method method = null;
        try {
            method = CartController.class.getMethod(url, HttpServletRequest.class,HttpServletResponse.class);
        } catch (NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(url);
        String traget="";
        try {
            traget = (String) method.invoke(controller, request,response);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        if(traget.endsWith("jsp")) {
            request.getRequestDispatcher(traget).forward(request, response);
        }else {
            response.sendRedirect(traget);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
