package ma.nemo.assignment.service;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.dto.ReturnRequestDTO;
import ma.nemo.assignment.dto.ReturnResponseDTO;
import ma.nemo.assignment.repository.ProductRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class ReturnServiceTest {

    @InjectMocks
    private ReturnService returnService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testReturnProductValidQuantity() {
        // Create a Product object with initial quantity
        Product product = new Product();
        product.setProductCode("ABC123");
        product.setQuantityInStock(10); // Initial quantity

        // Prepare the request
        ReturnRequestDTO request = new ReturnRequestDTO();
        request.setProductCode("ABC123");
        request.setQuantity(5); // Valid quantity to return
        request.setReason("Defective");

        when(productRepository.findByProductCode("ABC123")).thenReturn(product);

        // Perform the return operation
        ReturnResponseDTO response = returnService.returnProduct(request);

        // Verify that the quantity is correctly updated and a success message is returned
        assertEquals("Product returned successfully for product code: ABC123", response.getMessage());
        assertEquals(15, product.getQuantityInStock()); // Quantity should be updated

        // Verify that the productRepository.save() method was called
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testReturnProductInvalidQuantity() {
        // Create a Product object with initial quantity
        Product product = new Product();
        product.setProductCode("DEF456");
        product.setQuantityInStock(10); // Initial quantity

        // Prepare the request
        ReturnRequestDTO request = new ReturnRequestDTO();
        request.setProductCode("DEF456");
        request.setQuantity(15); // Invalid quantity to return
        request.setReason("Defective");

        when(productRepository.findByProductCode("DEF456")).thenReturn(product);

        // Perform the return operation
        ReturnResponseDTO response = returnService.returnProduct(request);

        // Verify that an error message is returned and the quantity is not updated
        assertEquals("Invalid quantity to return for product code: DEF456", response.getMessage());
        assertEquals(10, product.getQuantityInStock()); // Quantity should not be updated

        // Verify that the productRepository.save() method was not called
        verify(productRepository, never()).save(product);
    }

    @Test
    public void testReturnProductNonExistentProduct() {
        // Prepare the request for a non-existent product
        ReturnRequestDTO request = new ReturnRequestDTO();
        request.setProductCode("NON123");
        request.setQuantity(5);
        request.setReason("Defective");

        when(productRepository.findByProductCode("NON123")).thenReturn(null);

        // Perform the return operation
        ReturnResponseDTO response = returnService.returnProduct(request);

        // Verify that an error message is returned
        assertEquals("Product not found for product code: NON123", response.getMessage());

        // Verify that the productRepository.save() method was not called
        verify(productRepository, never()).save(any(Product.class));
    }
}
