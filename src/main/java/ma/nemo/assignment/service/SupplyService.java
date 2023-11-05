package ma.nemo.assignment.service;
import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.dto.OperationResponseDTO;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.repository.ProductRepository;
import ma.nemo.assignment.repository.SupplyRepository;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final ProductRepository productRepository;

    public SupplyService(SupplyRepository supplyRepository, ProductRepository productRepository) {
        this.supplyRepository = supplyRepository;
        this.productRepository = productRepository;
    }

    public OperationResponseDTO addProductToInventory(ProductDto productDto) {
        // Check if the expiration date is not today or before today
        Date today = new Date();
        if (productDto.getExpirationDate() != null && productDto.getExpirationDate().before(today)) {
            return new OperationResponseDTO("Expiration date cannot be today or in the past.");
        }

        // Check if the quantity does not exceed the maximum limit of 500 units
        if (productDto.getQuantityInStock() != null && productDto.getQuantityInStock() > 500) {
            return new OperationResponseDTO("Quantity exceeds the maximum limit of 500 units.");
        }

        // Save the product to the database
        Product product = mapProductDtoToProduct(productDto);
        productRepository.save(product);

        return new OperationResponseDTO("Product added to inventory: " + productDto.getProductCode());
    }

    // Implement a method to map the ProductDto to the Product entity for database storage
    private Product mapProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        // Map fields from productDto to product
        product.setProductCode(productDto.getProductCode());
        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setQuantityInStock(productDto.getQuantityInStock());
        product.setCreationDate(productDto.getCreationDate());
        product.setModificationDate(productDto.getModificationDate());
        product.setExpirationDate(productDto.getExpirationDate());
        return product;
    }
}