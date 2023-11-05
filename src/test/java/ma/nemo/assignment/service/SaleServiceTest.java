package ma.nemo.assignment.service;

import static org.junit.jupiter.api.Assertions.*;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.dto.OperationResponseDTO;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SaleServiceTest {

    @InjectMocks
    private SaleService saleService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testAddProductToInventory_Success() {
        // Arrange
        ProductDto productDto = new ProductDto();
        productDto.setQuantityInStock(10);
        // Set fields in productDto
        String productCode = "ABC123";
        productDto.setProductCode(productCode);

        Product mockProduct = new Product();
        mockProduct.setProductCode(productCode);
        mockProduct.setQuantityInStock(10); // Sufficient stock

        Mockito.when(productRepository.findByProductCode(productCode)).thenReturn(mockProduct);

        // Act
        OperationResponseDTO response = saleService.addProductToInventory(productDto);

        // Assert
        assertEquals("Sale confirmed for product code: " + productCode, response.getMessage());
    }

    @Test
    public void testAddProductToInventory_ProductNotFound() {
        // Arrange
        ProductDto productDto = new ProductDto();
        // Set fields in productDto
        String productCode = "XYZ789";
        productDto.setProductCode(productCode);

        Mockito.when(productRepository.findByProductCode(productCode)).thenReturn(null);

        // Act
        OperationResponseDTO response = saleService.addProductToInventory(productDto);

        // Assert
        assertEquals("Product not found for product code: " + productCode, response.getMessage());
    }

    @Test
    public void testAddProductToInventory_InsufficientStock() {
        // Arrange
        ProductDto productDto = new ProductDto();
        // Set fields in productDto
        String productCode = "DEF456";
        productDto.setProductCode(productCode);

        Product mockProduct = new Product();
        mockProduct.setProductCode(productCode);
        mockProduct.setQuantityInStock(5); // Insufficient stock

        Mockito.when(productRepository.findByProductCode(productCode)).thenReturn(mockProduct);

        OperationResponseDTO response = saleService.addProductToInventory(productDto);

        assertEquals("Sale confirmed for product code: " + productCode, response.getMessage());
    }
}
