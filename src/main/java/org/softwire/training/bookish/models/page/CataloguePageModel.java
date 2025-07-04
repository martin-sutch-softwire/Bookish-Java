package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Book;

import java.util.List;

public class CataloguePageModel {
    private List<Book> book;

    public List<Book> getBooks() {
        return book;
    }
    public void setBooks(List<Book> book) {
        this.book = book;
    }
}
