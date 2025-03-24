package com.brian.books.Services.impl;

import com.brian.books.domain.Book;
import com.brian.books.domain.Bookentity;
import com.brian.books.repository.bookrepo;
import com.brian.books.service.impl.serviceimpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Servicetest {
    @Mock
    private bookrepo repo;
    @InjectMocks
    private serviceimpl tested;
    @Test
    public void saved(){
        final Book book = Book.builder().isbn("02345678").title("The Waves").author("Virginia wolf").build();
        final Bookentity bookenti = Bookentity.builder().isbn("02345678").title("The Waves").author("Virginia wolf").build();

        when(repo.save(eq(bookenti))).thenReturn(bookenti);

        final Book tester = tested.create(book);
        assertEquals(book,tester);

    }
}
