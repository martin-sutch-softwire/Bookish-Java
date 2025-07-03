package org.softwire.training.bookish.models.database;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String isbn ;

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    @Override
    public String toString() {
        String myStr = "%s %s %s %s";
        return String.format(myStr, bookId, title, author, isbn);
    }
}
