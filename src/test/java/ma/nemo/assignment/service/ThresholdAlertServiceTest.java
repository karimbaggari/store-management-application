package ma.nemo.assignment.service;

import static org.junit.jupiter.api.Assertions.*;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

public class ThresholdAlertServiceTest {

    @InjectMocks
    private ThresholdAlertService thresholdAlertService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProductsBelowThreshold() {
        // Arrange
        List<Product> products = new ArrayList<>();
        products.add(createProduct("ABC123", "Product 1", 10, 5)); // Quantity: 10, Threshold: 5
        products.add(createProduct("DEF456", "Product 2", 8, 4));  // Quantity: 8, Threshold: 4

        Mockito.when(productRepository.findProductsBelowThreshold()).thenReturn(products);

        // Act
        List<ProductDto> productDtos = thresholdAlertService.getProductsBelowThreshold();

        // Assert
        // Ensure that the productDtos contain the expected products below their set thresholds
        assertEquals(2, productDtos.size());
        assertEquals("ABC123", productDtos.get(0).getProductCode());
        assertEquals("DEF456", productDtos.get(1).getProductCode());
    }

    @Test
    public void testSetThreshold() {
        // Arrange
        String productCode = "ABC123";
        int newThreshold = 7;

        Product existingProduct = createProduct(productCode, "Product 1", 10, 5); // Quantity: 10, Threshold: 5

        Mockito.when(productRepository.findByProductCode(productCode)).thenReturn(existingProduct);

        // Act
        thresholdAlertService.setThreshold(productCode, newThreshold);

        // Assert
        // Ensure that the threshold for the product is updated
        assertEquals(newThreshold, existingProduct.getThresholdQuantity());
    }

    private Product createProduct(String productCode, String productName, int quantityInStock, int thresholdQuantity) {
        Product product = new Product();
        product.setProductCode(productCode);
        product.setProductName(productName);
        product.setQuantityInStock(quantityInStock);
        product.setThresholdQuantity(thresholdQuantity);
        return product;
    }
}
