package com.ksiegarnia.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ksiegarnia.domain.Book;
import com.ksiegarnia.domain.Review;
import com.ksiegarnia.web.ViewBookServlet;

@Stateless
public class BookManager {
	@PersistenceContext
	EntityManager em;

	public Book get(Long id) {
		return em.find(Book.class, id);
	}

	public void addBook(Book book) {
		book.setId(null);
		em.persist(book);
		em.flush(); //rest
	}

	public void updateBook(Long id, String title, String author) {
		Book book = em.find(Book.class, id);
		book.setTitle(title);
		book.setAuthor(author);

		em.merge(book);
	}

	public void deleteBook(Long id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> getAllBook() {
		return em.createNamedQuery("book.all").getResultList();
	}
	
//REVIEWS
	
	public Review getRev(Long id) {
        return em.find(Review.class, id);
    }
    
	public void addReview(Book book, Review review) {
		List<Review> reviews = book.getReviews();
		reviews.add(review);
		book.setReviews(reviews);
		em.merge(book);
		
	}

	public void updateReview(Long id, String revAuthor, String text) {
		Review review= em.find(Review.class, id);
		review.setRevAuthor(revAuthor);
		review.setText(text);
		
        em.merge(review);
    }
	
	public void deleteReview(Long id) {
		Long bookID = ViewBookServlet.idToDelete;
		Review review = em.find(Review.class, id);
		Book book = em.find(Book.class, bookID);
		book.getReviews().remove(review);
		List<Review> reviews = book.getReviews();
		reviews.remove(review);
		book.setReviews(reviews);
		em.merge(book);
		em.remove(review);
	}

	@SuppressWarnings("unchecked")
	public List<Review> getAllReview() {
		return em.createNamedQuery("review.all").getResultList();
	}
}

