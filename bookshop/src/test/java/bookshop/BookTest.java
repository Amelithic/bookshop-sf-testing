package bookshop;

import bookshop.model.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    public void testBookCreation() {
        Book book = new Book("978-1234567897", "Test", "Author", 15.0);
        assertEquals("978-1234567897", book.getIsbn());
        assertEquals("Test", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals(15.0, book.getPrice());
    }
}
