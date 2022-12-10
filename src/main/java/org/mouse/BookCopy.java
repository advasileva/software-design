package org.mouse;

/**
 * DTO class
 *
 * @param book     edition
 * @param quantity number of copies
 */
public record BookCopy(Book book, Integer quantity) {
}
