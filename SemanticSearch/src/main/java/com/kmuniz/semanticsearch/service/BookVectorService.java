package com.kmuniz.semanticsearch.service;

import com.kmuniz.semanticsearch.model.Book;
import com.kmuniz.semanticsearch.model.BookVector;
import com.kmuniz.semanticsearch.repository.BookVectorRepository;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookVectorService {

    private final BookVectorRepository bookVectorRepository;
    private final EmbeddingClient embeddingClient;

    public BookVectorService(BookVectorRepository bookVectorRepository, EmbeddingClient embeddingClient) {
        this.bookVectorRepository = bookVectorRepository;
        this.embeddingClient = embeddingClient;
    }

    public void saveBooks(List<Book> books) {
        List<BookVector> bookVectors = books.stream().map(book -> {
            float[] embedding = embeddingClient.embed(book.description()); // Generate embedding
            return new BookVector(book.title(), book.author(), book.description(), embedding);
        }).toList();

        bookVectorRepository.saveAll(bookVectors);
    }
}