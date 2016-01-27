package com.ksiegarnia.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksiegarnia.service.BookManager;

/**
 * Servlet implementation class RemoveBookServlet
 */
@WebServlet(urlPatterns = "/review/removeReview/*")
public class RemoveReviewServlet extends HttpServlet{
    @EJB
    private BookManager bookStorage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long reviewID = WebUtils.getReviewID(request);
        
        bookStorage.deleteReview(reviewID);

        WebUtils.redirectToMainPage(request, response);
    }
}