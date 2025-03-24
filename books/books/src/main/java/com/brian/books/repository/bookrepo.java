package com.brian.books.repository;

import com.brian.books.domain.Bookentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookrepo extends JpaRepository<Bookentity, String> {
}
