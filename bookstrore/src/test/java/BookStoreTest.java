import jug.istanbul.BookStore;
import jug.istanbul.HarryPotterBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Arrays;
import java.util.List;



public class BookStoreTest {

    @Test
    public void testCheckoutWithOneBook() {

        List<HarryPotterBook> cart = Arrays.asList(HarryPotterBook.Book1);
        double actualPrice = BookStore.checkout(cart);
        assertEquals(8, actualPrice);
    }

    @Test
    public void testCheckoutWithTwoBook() {

        List<HarryPotterBook> cart = Arrays.asList(HarryPotterBook.Book1, HarryPotterBook.Book2);
        double actualPrice = BookStore.checkout(cart);
        assertEquals(15.2, actualPrice);
    }

    @Test
    public void testCheckoutWithThreeBook() {

        List<HarryPotterBook> cart = Arrays.asList(HarryPotterBook.Book1, HarryPotterBook.Book2, HarryPotterBook.Book3);
        double actualPrice = BookStore.checkout(cart);
        assertEquals(21.6, actualPrice);
    }

    @Test
    public void testCheckoutWithFourBook() {

        List<HarryPotterBook> cart = Arrays.asList(HarryPotterBook.Book1,
                HarryPotterBook.Book2,
                HarryPotterBook.Book3,
                HarryPotterBook.Book4);
        double actualPrice = BookStore.checkout(cart);
        assertEquals(25.6, actualPrice);
    }

    @Test
    public void testCheckoutWithFiveBook() {

        List<HarryPotterBook> cart = Arrays.asList(HarryPotterBook.Book1,
                HarryPotterBook.Book2,
                HarryPotterBook.Book3,
                HarryPotterBook.Book4,
                HarryPotterBook.Book5);
        double actualPrice = BookStore.checkout(cart);
        assertEquals(30, actualPrice);
    }

    @Test
    public void testCheckoutWithMixBook() {

        List<HarryPotterBook> cart = Arrays.asList(
                HarryPotterBook.Book1,
                HarryPotterBook.Book1,
                HarryPotterBook.Book2,
                HarryPotterBook.Book2,
                HarryPotterBook.Book3,
                HarryPotterBook.Book3,
                HarryPotterBook.Book4,
                HarryPotterBook.Book5);
        double actualPrice = BookStore.checkout(cart);
        assertEquals(48, actualPrice);
    }
}
