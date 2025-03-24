package com.brian.books;

import com.brian.books.domain.Book;
import com.brian.books.domain.Bookentity;

public final class testdata {
    public testdata(){

    }
    public static Book test_book(){
        return  Book.builder().isbn("02345678").title("The Waves").author("Virginia wolf").build();
    }

    public static Bookentity test_booken(){
        return Bookentity.builder().isbn("02345678").title("The Waves").author("Virginia wolf").build();
    }

}
