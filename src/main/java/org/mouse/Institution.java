package org.mouse;

import org.cactoos.list.ListOf;

/**
 * Institution issuing books
 */
public final class Institution extends LibraryOwner {
    /**
     * Ctor
     */
    public Institution() {
        this.put(new Book("Harry Potter", "and the Philosopher's Stone", new ListOf<>("J.K. Rowling"), 1997));
        this.put(new Book("Harry Potter", "and the Chamber of Secrets", new ListOf<>("J.K. Rowling"), 1998));
        this.put(new Book("Harry Potter", "and the Prisoner of Azkaban", new ListOf<>("J.K. Rowling"), 1999));
        this.put(new Book("Java: The Complete Reference", "Seventh Edition", new ListOf<>("Herbert Schildt"), 2006));
        this.put(new Book("Clean Code", "Writing clean code...", new ListOf<>("Robert C. Martin"), 2008));
        this.put(new Book("Clean Code", "Writing clean code...", new ListOf<>("Robert C. Martin"), 2008));
    }
}
