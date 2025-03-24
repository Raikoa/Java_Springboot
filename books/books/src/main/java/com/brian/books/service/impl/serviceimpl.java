package com.brian.books.service.impl;

import com.brian.books.domain.Book;
import com.brian.books.domain.Bookentity;
import com.brian.books.repository.bookrepo;
import com.brian.books.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class serviceimpl implements Service {

    private final bookrepo repo;
    @Autowired
    public serviceimpl(final bookrepo repo){
        this.repo = repo;
    }
    @Override
    public Book create(final Book book) {
        final Bookentity bookentity = booktoentity(book);
        final Bookentity savedbook =  repo.save(bookentity);
        return bookentitytobook(savedbook);
    }

    private Bookentity booktoentity(Book book){
        return Bookentity.builder().isbn(book.getIsbn()).author(book.getAuthor()).title(book.getTitle()).build();
    }

    private Book bookentitytobook(Bookentity book){
        return Book.builder().isbn(book.getIsbn()).author(book.getAuthor()).title(book.getTitle()).build();
    }

}
