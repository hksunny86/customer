package com.example.demo.service;


import com.example.demo.dto.BookLocationRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.model.Book;
import com.example.demo.model.BookLocation;
import com.example.demo.model.Location;
import com.example.demo.model.repo.BookLocationRepository;
import com.example.demo.model.repo.BookRepository;
import com.example.demo.model.repo.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final LocationRepository locationRepository;
    private final BookLocationRepository bookLocationRepository;

    public BookService(BookRepository bookRepository, LocationRepository locationRepository, BookLocationRepository bookLocationRepository) {
        this.bookRepository = bookRepository;
        this.locationRepository = locationRepository;
        this.bookLocationRepository = bookLocationRepository;
    }

    public void addBookToLocation(BookLocationRequest request) {
        Book book = bookRepository.findById(request.getBookId()).orElseThrow(() -> new RuntimeException("Book not found: " + request.getBookId()));
        Location location = locationRepository.findById(request.getLocationId()).orElseThrow(() -> new RuntimeException("Location not found: " + request.getLocationId()));
        BookLocation bookLocation = new BookLocation();
        bookLocation.setBook(book);
        bookLocation.setLocation(location);
        bookLocation.setQuantity(request.getQuantity());
        bookLocationRepository.saveAndFlush(bookLocation);
    }

    public List<BookResponse> getAvailableBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(book -> {
            List<BookLocation> availableLocations = bookLocationRepository.findAvailableLocationForBooks(book.getBook_id());

            List<BookResponse.LocationQuantity> locationQuantities = availableLocations.stream()
                    .map(bl -> new BookResponse.LocationQuantity(bl.getLocation().getName(), bl.getQuantity()))
                    .collect(Collectors.toList());

            return new BookResponse(book.getName(), locationQuantities);
        }).collect(Collectors.toList());

    }
}
