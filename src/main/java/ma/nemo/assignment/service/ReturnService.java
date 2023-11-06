package ma.nemo.assignment.service;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.dto.ReturnRequestDTO;
import ma.nemo.assignment.dto.ReturnResponseDTO;
import ma.nemo.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnService {

    @Autowired
    private ProductRepository productRepository;

    public ReturnResponseDTO returnProduct(ReturnRequestDTO request) {
        // Validate the request payload
        String productCode = request.getProductCode();
        int quantityToReturn = request.getQuantity();
        String reason = request.getReason();

        // Retrieve the product from the database using the product code
        Product product = productRepository.findByProductCode(productCode);
        if (product == null) {
            return new ReturnResponseDTO("Product not found for product code: " + productCode);
        }

        // Check if the product is in stock and has sufficient quantity for the return
        int currentQuantityInStock = product.getQuantityInStock();

        if (quantityToReturn <= 0 || quantityToReturn > currentQuantityInStock) {
            return new ReturnResponseDTO("Invalid quantity to return for product code: " + productCode);
        }

        // Add the returned quantity back to the stock
        int updatedQuantityInStock = currentQuantityInStock + quantityToReturn;
        product.setQuantityInStock(updatedQuantityInStock);

        // Save the updated product information to the database
        productRepository.save(product);

        return new ReturnResponseDTO("Product returned successfully for product code: " + productCode);
    }
}
