package org.mouse;

import org.cactoos.list.ListOf;

import java.util.Optional;

/**
 * Entity that has a library
 */
public abstract class LibraryOwner {
    /**
     * Composed library
     */
    Library library;

    /**
     * Ctor
     */
    protected LibraryOwner() {
        library = new Library();
    }

    /**
     * Searches for books by title
     *
     * @param title of the book
     * @return list of unique books
     */
    public final ListOf<Book> get(String title) {
        return library.books(title);
    }

    /**
     * Removes a book copy from the library, if it exists
     *
     * @param book copy
     * @return Optional of this book
     */
    public final Optional<Book> get(Book book) {
        return library.book(book);
    }

    /**
     * Adds a book to the library
     *
     * @param book copy
     */
    public final void put(Book book) {
        library.put(book);
    }

    /**
     * Prints a list of copies in the library
     */
    public final void print() {
        for (BookCopy copy : library.copies()) {
            System.out.println("Book: " + copy.book() + "; quantity: " + copy.quantity());
        }
    }
}
