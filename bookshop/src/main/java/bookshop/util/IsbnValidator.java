package bookshop.util;

public class IsbnValidator {
    public boolean isValid(String isbn) {
        return isbn != null && !isbn.isBlank();
    }
}
