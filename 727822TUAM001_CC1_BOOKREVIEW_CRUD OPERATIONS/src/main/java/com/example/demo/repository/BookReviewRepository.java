package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
}
