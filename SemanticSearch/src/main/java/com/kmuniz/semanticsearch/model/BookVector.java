package com.kmuniz.semanticsearch.model;

import jakarta.persistence.*;
import org.springframework.ai.vectorstore.Vector;

@Entity
@Table(name = "book_vectors")
public class BookVector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Vector
    @Column(columnDefinition = "vector(768)") // PGVector uses 768 dimensions
    private float[] embedding;

    // Constructors
    public BookVector() {}

    public BookVector(String title, String author, String description, float[] embedding) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.embedding = embedding;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getDescription() { return description; }
    public float[] getEmbedding() { return embedding; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setDescription(String description) { this.description = description; }
    public void setEmbedding(float[] embedding) { this.embedding = embedding; }
}