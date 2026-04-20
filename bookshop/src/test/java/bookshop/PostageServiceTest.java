package bookshop;

import bookshop.service.PostageService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PostageServiceTest {
    @Test
    public void testCalculatePostage() {
        PostageService service = new PostageService();
        assertEquals(0.0, service.calculatePostage(1.0, "US"));
    }
}
