package ma.nemo.assignment.service;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
@Service
public class ThresholdAlertService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getProductsBelowThreshold() {
        List<Product> products = productRepository.findProductsBelowThreshold();

        List<ProductDto> productDtos = products.stream()
                .map(this::mapProductToProductDto)
                .collect(Collectors.toList());

        return productDtos;
    }

    public void setThreshold(String productCode, int thresholdQuantity) {
        Product product = productRepository.findByProductCode(productCode);

        if (product != null) {
            // Set the threshold quantity for the product
            product.setThresholdQuantity(thresholdQuantity);
            productRepository.save(product);
        }
    }

    private ProductDto mapProductToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductCode(product.getProductCode());
        productDto.setProductName(product.getProductName());
        // Add other fields as needed
        return productDto;
    }
}

