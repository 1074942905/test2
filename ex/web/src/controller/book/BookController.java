package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Book;
import service.BookService;
import service.impl.BookServiceImpl;

public class BookController {
	BookService service = new BookServiceImpl();
	
	public boolean notNull(String... binfo) {

        for (String info : binfo) {
            if (info == null || info.length() == 0) {

                return false;
            }
        }
        return true;
    }
	
	/**
	 * request.getParameterNames()
	 * @param request
	 * @param response
	 * @return
	 */
	public String save(HttpServletRequest request,HttpServletResponse response) {
		   String bname = request.getParameter("bname");
			String bauthor = request.getParameter("bauthor");
			String bprice = request.getParameter("bprice");
			String bdesc = request.getParameter("bdesc");
			System.out.println(bdesc);
			if(notNull(bname,bauthor,bprice,bdesc)){
				Book book = new Book(null,bname,bauthor,Double.parseDouble(bprice),bdesc);
				service.save(book);		
			}
		return "list";
	}
	
	public String list(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("books", service.queryAll());

		return "/WEB-INF/bookList.jsp";
	}
	
	public String delete(HttpServletRequest request,HttpServletResponse response) {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		service.delete(id);
		return "list";
	}
	
	public String get(HttpServletRequest request,HttpServletResponse response) {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		request.setAttribute("book", service.get(id));
		return "/WEB-INF/bookInfo.jsp";
	}
	
	public String update(HttpServletRequest request,HttpServletResponse response) {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
	    String bname = request.getParameter("bname");
		String bauthor = request.getParameter("bauthor");
		String bprice = request.getParameter("bprice");
		String bdesc = request.getParameter("bdesc");

		if(notNull(bname,bauthor,bprice,bdesc)){
			Book book = new Book(id,bname,bauthor,Double.parseDouble(bprice),bdesc);
			service.update(book);
			
		}
		return "get?id="+id;

	}
	
	public String form(HttpServletRequest request,HttpServletResponse response) {
		
		return "/WEB-INF/addBook.jsp";
	}
	
}
