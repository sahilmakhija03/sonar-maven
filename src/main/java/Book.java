package com.example.library;

import java.util.Objects;

/**
 * A simple class representing a book.
 */
public class Book {
    private String title;
    private String author;
    private int publicationYear;

    /**
     * Constructs a Book with the specified title, author, and publication year.
     * @param title the title of the book
     * @param author the author of the book
     * @param publicationYear the year the book was published
     */
    public Book(String title, String author, int publicationYear) {
        if (publicationYear < 1440) { // Magic number (invention of printing press year)
            throw new IllegalArgumentException("Publication year cannot be before 1440.");
        }
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        if (publicationYear < 1440) {
            throw new IllegalArgumentException("Publication year cannot be before 1440.");
        }
        this.publicationYear = publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }

    public static void main(String[] args) {
        Book book = new Book("1984", "George Orwell", 1949);
        System.out.println(book);

        // Deliberate issue: Using a magic number
        if (book.getPublicationYear() == 1949) {
            System.out.println("This book was published in 1949.");
        }
    }
}

