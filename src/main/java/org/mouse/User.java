package org.mouse;

import org.cactoos.list.ListOf;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

/**
 * Entity that takes books, maybe even reads
 */
public final class User extends LibraryOwner {
    /**
     * Processes the list of books
     *
     * @param books for selecting
     * @return selected book or Optional.empty()
     */
    public Optional<Book> select(ListOf<Book> books) {
        if (books.isEmpty()) {
            return Optional.empty();
        }
        if (books.size() == 1) {
            return Optional.of(books.get(0));
        }
        System.out.println("There are several books with this title, choose one:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + " - " + books.get(i));
        }
        Scanner reader = new Scanner(System.in);
        int num;
        do {
            System.out.println("Enter number from 0 to " + (books.size() - 1));
            // It is more efficient to use reader.next() and try to parse manually
            try {
                num = reader.nextInt();
            } catch (InputMismatchException ex) {
                num = -1;
            }
        } while (num < 0 || num >= books.size());
        return Optional.of(books.get(num));
    }

    /* or ...
    public Optional<Book> select(ListOf<Book> books) {
        if (books.isEmpty()) {
            return Optional.empty();
        } else if (books.size() == 1) {
            return Optional.of(books.get(0));
        } else {
            System.out.println("There are several books with this title, choose one:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println(i + " - " + books.get(i));
            }
            Scanner reader = new Scanner(System.in);
            int num;
            do {
                System.out.println("Enter number from 0 to " + (books.size() - 1));
                try {
                    num = reader.nextInt();
                } catch (InputMismatchException ex) {
                    num = -1;
                }
            } while (num < 0 || num >= books.size());
            return Optional.of(books.get(num));
        }
     }
     */
}
