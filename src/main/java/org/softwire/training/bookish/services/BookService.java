package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends DatabaseService {

    public List<Book> getAllBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM books")
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public void addBook(Book book) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO books (title, author, isbn) VALUES (:title, :author, :isbn)")
                        .bind("title", book.getTitle())
                        .bind("author", book.getAuthor())
                        .bind("isbn", book.getIsbn())
                        .execute()
        );
    }

    public void deleteBook(int bookId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM books WHERE book_id = :id")
                        .bind("id", bookId)
                        .execute()
        );
    }
}
