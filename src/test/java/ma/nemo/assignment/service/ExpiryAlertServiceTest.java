package ma.nemo.assignment.service;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.repository.ProductRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.Test;
import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class ExpiryAlertServiceTest {

    @InjectMocks
    private ExpiryAlertService expiryAlertService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testGetExpiringProducts() {
        // Create a list of Product entities with various expiration dates
        Date currentDate = new Date();
        Date twoWeeksFromNow = calculateDateInWeeks(currentDate, 2);

        List<Product> products = new ArrayList<>();
        // Set up the products with expiration dates
        products.add(createProduct("DEF456", "Product 1", currentDate));
        products.add(createProduct("GHI789", "Product 2", twoWeeksFromNow));
        products.add(createProduct("JKL012", "Product 3", twoWeeksFromNow));

        when(productRepository.findByExpirationDateBetween(any(), any())).thenReturn(products);

// Perform the getExpiringProducts operation
        List<ProductDto> expiringProducts = expiryAlertService.getExpiringProducts();

// Verify the number of expiring products and their correctness
        assertEquals(3, expiringProducts.size());
        assertEquals("DEF456", expiringProducts.get(0).getProductCode());
        assertEquals("GHI789", expiringProducts.get(1).getProductCode());
        assertEquals("JKL012", expiringProducts.get(2).getProductCode());

    }

    private Date calculateDateInWeeks(Date currentDate, int weeks) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.WEEK_OF_YEAR, weeks);
        return (Date) calendar.getTime();
    }

    private Product createProduct(String productCode, String productName, Date expirationDate) {
        Product product = new Product();
        product.setProductCode(productCode);
        product.setProductName(productName);
        product.setExpirationDate(expirationDate);
        // Set other fields as needed
        return product;
    }
}
