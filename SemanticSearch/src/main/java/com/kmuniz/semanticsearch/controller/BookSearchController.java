package com.kmuniz.semanticsearch.controller;


import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.Document;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookSearchController {

    private final VectorStore vectorStore;

    public BookSearchController(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @PostMapping("/search")
    public List<String> semanticSearch(@RequestBody String query) {
        return vectorStore.similaritySearch(SearchRequest.builder()
                        .query(query)
                        .topK(3) // Retrieve the top 3 most relevant books
                        .build())
                .stream()
                .map(Document::getText)
                .toList();
    }
}