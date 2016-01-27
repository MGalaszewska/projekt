package com.ksiegarnia.web;
import com.ksiegarnia.service.BookManager;
import com.ksiegarnia.domain.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addbook")
public class AddBookServlet extends HttpServlet{
	@EJB
    private BookManager bookStorage = new BookManager();
/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);

        bookStorage.addBook(newBook);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }
*/
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/book/add.jsp").forward(request, response);
    }
}