package org.softwire.training.bookish.models.database;

public class Book {
    private int book_id;
    private String title;
    private String author;
    private String isbn ;

    public int getBook_id() { return book_id; }
    public void setBook_id(int book_id) { this.book_id = book_id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    @Override
    public String toString() {
        return book_id + " " + title + " " + author + " " + isbn;
    }
//    public Book(int book_id, String title, String author, String isbn) {
//        this.book_id = book_id;
//        this.title = title;
//        this.author = author;
//        this.isbn = isbn;
//    }
}
