package com.brian.books.controller;

import com.brian.books.domain.Book;
import com.brian.books.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final Service bookservice;
    @Autowired
    public BookController(Service service){
        this.bookservice = service;
    }
    @PutMapping(path = "/book/{isbn}")
    public ResponseEntity<Book> Createbooks(@PathVariable final String isbn,  @RequestBody final Book book){
        book.setIsbn(isbn);
        final Book saved = bookservice.create(book);
        final ResponseEntity<Book> re = new ResponseEntity<Book>(saved, HttpStatus.CREATED);
        return re;
    }

}
