package bookshop;

import bookshop.util.IsbnValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsbnValidatorTest {
    @Test
    public void testIsbnValidation() {
        IsbnValidator validator = new IsbnValidator();
        assertTrue(validator.isValid("978-1234567897"));
        assertFalse(validator.isValid(""));
    }
}
