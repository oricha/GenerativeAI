package com.kmuniz.semanticsearch.repository;

import com.kmuniz.semanticsearch.model.BookVector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookVectorRepository extends JpaRepository<BookVector, Long> {
}