package bookshop.service;

import bookshop.model.Book;
import java.util.List;

public class InventoryService {
    public List<Book> loadInventory() {
        return List.of();
    }

    public Book findBookByIsbn(String isbn) {
        return null;
    }

    public void updateStock(Book book, int quantity) {
    }
}
