package jug.istanbul;
import jug.istanbul.HarryPotterBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStore {

    private static final double ONE_BOOK_PRICE = 8.0;
    private static final double TWO_DIFFERENT_BOOKS_DISCOUNT = 0.05;
    private static final double THREE_DIFFERENT_BOOKS_DISCOUNT = 0.1;
    private static final double FOUR_DIFFERENT_BOOKS_DISCOUNT = 0.2;
    private static final double FIVE_DIFFERENT_BOOKS_DISCOUNT = 0.25;


    public static double checkout(List<HarryPotterBook> cart) {
        Map<HarryPotterBook, Integer> booksGroupedByBookNumber = groupBooks(cart);
        return calculatePriceBasedOnTheNumberOfBooks(booksGroupedByBookNumber);
    }

    private static Map<HarryPotterBook, Integer> groupBooks(List<HarryPotterBook> cart) {
        Map<HarryPotterBook, Integer> groupedBooks = new HashMap<>();
        for (HarryPotterBook book : cart) {
            groupedBooks.put(book, groupedBooks.getOrDefault(book, 0) + 1);
        }
        return groupedBooks;
    }

    private static double calculatePriceBasedOnTheNumberOfBooks(Map<HarryPotterBook, Integer> booksGroupedByBookNumber) {
        int numberOfDifferentBooks = (int) booksGroupedByBookNumber.values().stream()
                .filter(count -> count > 0)
                .count();

        double discount = 0.0;
        switch (numberOfDifferentBooks) {
            case 2:
                discount = TWO_DIFFERENT_BOOKS_DISCOUNT;
                break;
            case 3:
                discount = THREE_DIFFERENT_BOOKS_DISCOUNT;
                break;
            case 4:
                discount = FOUR_DIFFERENT_BOOKS_DISCOUNT;
                break;
            case 5:
                discount = FIVE_DIFFERENT_BOOKS_DISCOUNT;
                break;
            default:
                break;
        }

        int totalBooks = booksGroupedByBookNumber.values().stream() // Use stream on values (number of books)
                .mapToInt(Integer::intValue) // Convert to int
                .sum();

        return ONE_BOOK_PRICE * totalBooks * (1 - discount);
    }


}