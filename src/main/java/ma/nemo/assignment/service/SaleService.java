package ma.nemo.assignment.service;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.dto.OperationResponseDTO;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    private ProductRepository productRepository;

    public OperationResponseDTO saleProductFromInventory(ProductDto productDto) {
        // Retrieve the product from the database using the product code
        String productCode = productDto.getProductCode();
        Product product = productRepository.findByProductCode(productCode);

        if (product == null) {
            return new OperationResponseDTO("Product not found for product code: " + productCode);
        }

        int requestedQuantity = productDto.getQuantityInStock(); // Requested quantity
        int availableQuantity = product.getQuantityInStock();

        if (requestedQuantity > availableQuantity) {
            return new OperationResponseDTO("Insufficient stock for product code: " + productCode);
        }

        return new OperationResponseDTO("Sale confirmed for product code: " + productCode);
    }

}