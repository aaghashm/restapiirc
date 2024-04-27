package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookReview;
import com.example.demo.service.BookReviewService;

@RestController
@RequestMapping("/api/book-reviews")
public class BookReviewController {

    @Autowired
    private BookReviewService bookReviewService;

    @GetMapping("/getall")
    public List<BookReview> getAllBookReviews() {
        return bookReviewService.getAllBookReviews();
    }

    @GetMapping("getid/{id}")
    public ResponseEntity<BookReview> getBookReviewById(@PathVariable Long id) {
        BookReview bookReview = bookReviewService.getBookReviewById(id);
        if (bookReview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookReview, HttpStatus.OK);
    }

    @PostMapping("/addbook")
    public ResponseEntity<BookReview> createBookReview(@RequestBody BookReview bookReview) {
        BookReview createdBookReview = bookReviewService.createBookReview(bookReview);
        return new ResponseEntity<>(createdBookReview, HttpStatus.CREATED);
    }

    @PutMapping("updatebook/{id}")
    public ResponseEntity<BookReview> updateBookReview(@PathVariable Long id, @RequestBody BookReview bookReview) {
        BookReview updatedBookReview = bookReviewService.updateBookReview(id, bookReview);
        if (updatedBookReview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedBookReview, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBookReview(@PathVariable Long id) {
        boolean deleted = bookReviewService.deleteBookReview(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
