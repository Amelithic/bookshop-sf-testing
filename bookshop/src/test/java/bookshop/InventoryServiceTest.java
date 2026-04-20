package bookshop;

import bookshop.service.InventoryService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceTest {
    @Test
    public void testLoadInventory() {
        InventoryService service = new InventoryService();
        assertNotNull(service.loadInventory());
    }
}
