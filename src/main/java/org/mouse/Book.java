package org.mouse;

import org.cactoos.list.ListOf;

/**
 * Book edition
 *
 * @param title       of the book       -   I don't know
 * @param description of the book       -   what comment to write
 * @param authors     of the book       -   in such an obvious case
 * @param year        publication
 */
public record Book(String title, String description, ListOf<String> authors, Integer year) {
}
