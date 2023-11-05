package ma.nemo.assignment.service;

import static org.junit.jupiter.api.Assertions.*;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.dto.OperationResponseDTO;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.repository.ProductRepository;
import ma.nemo.assignment.repository.SupplyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SupplyServiceTest {

    @InjectMocks
    private SupplyService supplyService;

    @Mock
    private SupplyRepository supplyRepository;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testAddProductToInventory_Success() {
        // Arrange
        ProductDto productDto = new ProductDto();
        // Set fields in productDto

        Mockito.when(productRepository.save(Mockito.any())).thenReturn(new Product());

        // Act
        OperationResponseDTO response = supplyService.addProductToInventory(productDto);

        // Assert
        assertEquals("Product added to inventory: " + productDto.getProductCode(), response.getMessage());
    }

    @Test
    public void testAddProductToInventory_ExpirationDateInPast() {
        // Arrange
        ProductDto productDto = new ProductDto();
        // Set fields in productDto
        productDto.setExpirationDate(new Date(System.currentTimeMillis() - 100000)); // Date in the past

        // Act
        OperationResponseDTO response = supplyService.addProductToInventory(productDto);

        // Assert
        assertEquals("Expiration date cannot be today or in the past.", response.getMessage());
    }

    @Test
    public void testAddProductToInventory_ExceedsQuantityLimit() {
        // Arrange
        ProductDto productDto = new ProductDto();
        // Set fields in productDto
        productDto.setQuantityInStock(501); // Exceeds the limit

        // Act
        OperationResponseDTO response = supplyService.addProductToInventory(productDto);

        // Assert
        assertEquals("Quantity exceeds the maximum limit of 500 units.", response.getMessage());
    }
}
