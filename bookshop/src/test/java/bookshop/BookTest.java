package bookshop;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import bookshop.model.Book;
import bookshop.service.InventoryService;

public class BookTest {
    //test case 1: book creation
    @Test
    public void testBookAddToStock() throws IOException {
        InventoryService inventory = new InventoryService("data/books.csv");
        Book testBook = new Book("\nJava How to Program Tenth Edition - Early Objects", "Harvey Deitel", "9780133807806", "JAV001", 37.5f, 135, 1);

        int before = inventory.getTotalStockCount(); //taking stock count before change
        inventory.addBook(testBook);
        int after = inventory.getTotalStockCount(); //taking stock count after change

        assertEquals(before + testBook.getStockCount(), after, "Stock count should increase by 1");
    }
}
