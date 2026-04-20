package bookshop;

import bookshop.model.User;
import bookshop.service.AuthService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {
    @Test
    public void testAuthenticateReturnsFalseByDefault() {
        AuthService service = new AuthService();
        assertFalse(service.authenticate(new User("1", "Test", "test@example.com"), "password"));
    }
}
