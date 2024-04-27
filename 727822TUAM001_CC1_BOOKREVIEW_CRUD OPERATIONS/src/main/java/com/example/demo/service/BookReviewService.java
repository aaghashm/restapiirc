package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookReview;
import com.example.demo.repository.BookReviewRepository;

@Service
public class BookReviewService {

    @Autowired
    private BookReviewRepository bookReviewRepository;

    public List<BookReview> getAllBookReviews() {
        return bookReviewRepository.findAll();
    }

    public BookReview getBookReviewById(Long id) {
        return bookReviewRepository.findById(id).orElse(null);
    }

    public BookReview createBookReview(BookReview bookReview) {
        return bookReviewRepository.save(bookReview);
    }

    public BookReview updateBookReview(Long id, BookReview bookReview) {
        if (!bookReviewRepository.existsById(id)) {
            return null;
        }
        bookReview.setId(id);
        return bookReviewRepository.save(bookReview);
    }

    public boolean deleteBookReview(Long id) {
        if (!bookReviewRepository.existsById(id)) {
            return false;
        }
        bookReviewRepository.deleteById(id);
        return true;
    }
}
