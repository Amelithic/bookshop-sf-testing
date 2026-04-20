package bookshop;

import bookshop.service.SalesService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalesServiceTest {
    @Test
    public void testRecordSaleReturnsSale() {
        SalesService service = new SalesService();
        assertNotNull(service.recordSale(null));
    }
}
