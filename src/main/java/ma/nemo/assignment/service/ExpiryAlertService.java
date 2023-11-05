package ma.nemo.assignment.service;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExpiryAlertService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getExpiringProducts() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Calculate the date 2 weeks from now
        calendar.add(Calendar.WEEK_OF_YEAR, 2);
        Date expirationDateThreshold = calendar.getTime();

        // Retrieve products nearing the expiration date
        List<Product> expiringProducts = productRepository.findByExpirationDateBetween(currentDate, expirationDateThreshold);

        // Convert the Product entities to ProductDto objects
        List<ProductDto> expiringProductDtos = expiringProducts.stream()
                .map(this::mapProductToProductDto)
                .collect(Collectors.toList());

        return expiringProductDtos;
    }

    private ProductDto mapProductToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        // Map fields from Product entity to ProductDto
        productDto.setProductId(product.getProductId());
        productDto.setProductCode(product.getProductCode());
        productDto.setProductName(product.getProductName());
        // Add other fields as needed
        return productDto;
    }
}

