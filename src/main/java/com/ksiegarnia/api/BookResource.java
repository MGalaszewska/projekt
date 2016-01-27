package com.ksiegarnia.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ksiegarnia.domain.Book;
import com.ksiegarnia.service.BookManager;

@Path("/books")
public class BookResource {
    @EJB
    BookManager bookStorage;

    @GET
    @Path("/showall")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return bookStorage.getAllBook();
    }

    @GET
    @Path("/books")
    public Book getR(@PathParam("id") Long id) {
        return bookStorage.get(id);
    }

    @POST
    @Path("/add")
    public Book addBookR(
            @FormParam("title") String title,
            @FormParam("author") String author) {

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        
        bookStorage.addBook(newBook);
        //bookStorage.addBook(newBook);
        return newBook;
    }

 /*   @DELETE
    @Path("/delete")
    public void deleteR(@PathParam("id") Long id) {
        bookStorage.deleteBook(id);
    }

    @POST
    @Path("/edit")
    public void editBookR(
            @PathParam("id") Long id,
            @FormParam("title") String title,
            @FormParam("author") String author) {

        Book book = bookStorage.get(id);

        if (book != null) {
        	book.setTitle(title);
            book.setAuthor(author);

            bookStorage.updateBook(id, title, author);
        }
    }
    */
}