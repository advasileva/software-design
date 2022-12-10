package org.mouse;

import org.cactoos.func.FuncOf;
import org.cactoos.iterable.Mapped;
import org.cactoos.iterator.Filtered;
import org.cactoos.list.ListOf;
import org.cactoos.map.MapEnvelope;
import org.cactoos.map.MapOf;

import java.util.Objects;
import java.util.Optional;

/**
 * Library collection
 */
public class Library extends MapEnvelope<Book, Integer> {
    /**
     * Ctor
     */
    public Library() {
        super(new MapOf<Book, Integer>());
    }

    /**
     * Searches for books by title
     *
     * @param title of the book
     * @return list of books with title
     */
    public final ListOf<Book> books(String title) {
        return new ListOf<Book>(
                new Filtered<Book>(
                        book -> Objects.equals(book.title(), title),
                        this.keySet().iterator()
                )
        );
    }

    /**
     * Removes a book copy from the library, if it exists
     *
     * @param book copy
     * @return book if exists else empty()
     */
    public final Optional<Book> book(Book book) {
        if (!this.containsKey(book)) {
            return Optional.empty();
        }
        int count = this.get(book);
        if (count > 1) {
            this.put(book, count - 1);
        } else {
            this.remove(book);
        }
        return Optional.of(book);
    }

    /**
     * Adds a book to the library
     *
     * @param book new book
     */
    public final void put(Book book) {
        if (this.containsKey(book)) {
            this.put(book, this.get(book) + 1);
        } else {
            this.put(book, 1);
        }
    }

    /**
     * Wraps all the books in the library to the DTO
     *
     * @return list of copies
     */
    public final ListOf<BookCopy> copies() {
        return new ListOf<BookCopy>(
                new Mapped<BookCopy>(
                        new FuncOf<Book, BookCopy>(
                                key -> new BookCopy(key, this.get(key))
                        ),
                        this.keySet()
                )
        );
    }
}
