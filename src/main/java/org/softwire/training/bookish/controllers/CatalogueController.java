package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.CataloguePageModel;
import org.softwire.training.bookish.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {

    private final BookService bookService;

    @Autowired
    public CatalogueController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("")
    ModelAndView catalogue() {

        List<Book> allBooks = bookService.getAllBooks();

        CataloguePageModel cataloguePageModel = new CataloguePageModel();
        cataloguePageModel.setBooks(allBooks);

        return new ModelAndView("catalogue", "model", cataloguePageModel);
    }

    @GetMapping("/{bookId}")
    ModelAndView bookDetail(@PathVariable int bookId) {
        Book book = bookService.getBook(bookId);
        return new ModelAndView("bookdetail", "book", book);
    }

    @RequestMapping("/add-book")
    RedirectView addBook(@ModelAttribute Book book) {

        bookService.addBook(book);

        return new RedirectView("/catalogue");
    }

    @PostMapping("/{bookId}/edit")
    RedirectView editBook(@PathVariable int bookId, @ModelAttribute Book book) {
        book.setBookId(bookId);
        bookService.updateBook(book);
        return new RedirectView("/catalogue/" + bookId);
    }

    @PostMapping("/delete-book")
    RedirectView deleteBook(@RequestParam int bookId) {

        bookService.deleteBook(bookId);

        return new RedirectView("/catalogue");
    }

}
