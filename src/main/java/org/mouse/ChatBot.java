package org.mouse;

import org.cactoos.list.ListOf;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

/**
 * Library chatbot
 */
public final class ChatBot {
    /**
     * Flag for the next command
     */
    private Boolean hasNext;

    /**
     * The institution that serves bot
     */
    private final Institution hogwarts;

    /**
     * The user who makes requests to the bot
     */
    private final User user;

    /**
     * Ctor
     */
    public ChatBot() {
        hasNext = true;
        hogwarts = new Institution();
        user = new User();
    }

    /**
     * Getting started
     */
    public void exec() {
        printCommands();
        while (hasNext) {
            try {
                command();
                // This catch handles excess errors
            } catch (IndexOutOfBoundsException | InputMismatchException ex) {
                System.out.println("Incorrect input, repeat please");
                printCommands();
            }
            /*
            Maybe fail-safe is better for end-users:
            } catch (Throwable t){
                System.out.println("Something goes wrong");
            }
            */
        }
        System.out.println("Exited");
    }

    /**
     * Command handler
     *
     * @throws IndexOutOfBoundsException
     * @throws InputMismatchException
     */
    private void command() throws IndexOutOfBoundsException, InputMismatchException {
        System.out.println("Enter command:");
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        // It is also possible to use "\\s+" in regex, but I think it is superfluous
        ListOf<String> input = new ListOf<>(line.split(" ", 2));
        switch (input.get(0)) {
            case "get" -> get(input.get(1));
            case "put" -> put(input.get(1));
            case "list" -> list();
            case "all" -> all();
            case "exit" -> hasNext = false;
            default -> throw new InputMismatchException();
        }
    }

    /**
     * Prints available commands
     */
    private void printCommands() {
        System.out.println("""
                Available commands:
                get <title> - get a book from the library
                put <title> - return a book to the library
                list - show the taken books
                all - show available books in the library
                exit - finish working with the bot
                """);
    }

    /**
     * Exec "get" command
     *
     * @param title of the book
     */
    private void get(String title) {
        Optional<Book> selectBook = user.select(hogwarts.get(title));
        if (selectBook.isPresent()) {
            hogwarts.get(selectBook.get());
            user.put(selectBook.get());
            System.out.println("Enjoy reading!");
        } else {
            System.out.println("There is no such book in the library");
        }
    }

    /**
     * Exec "put" command
     *
     * @param title of the book
     */
    private void put(String title) {
        Optional<Book> selectBook = user.select(user.get(title));
        if (selectBook.isPresent()) {
            user.get(selectBook.get());
            hogwarts.put(selectBook.get());
            System.out.println("The book has been returned");
        } else {
            System.out.println("You didn't take this book");
        }
    }

    /**
     * Exec "list" command
     */
    private void list() {
        // Maybe it was worth putting it in switch,
        // but the method still encapsulates the logic of the call
        user.print();
    }

    /**
     * Exec "all" command
     */
    private void all() {
        hogwarts.print();
    }
}
