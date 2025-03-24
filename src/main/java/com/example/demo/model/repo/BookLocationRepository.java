package com.example.demo.model.repo;

import com.example.demo.model.BookLocation;
import com.example.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLocationRepository extends JpaRepository<BookLocation, Long> {

    @Query("Select bl from BookLocation bl where bl.book.id=: bookId AND bl.quantity >0 ")
    List<BookLocation> findAvailableLocationForBooks (@Param("bookId") Long bookId);
}
