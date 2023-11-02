package ma.nemo.assignment.service;

import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpiryAlertService {

    @Autowired
    private ProductRepository productRepository; // Assuming you have a repository to fetch product data

    public List<ProductDto> getExpiringProducts() {
        // Implement logic to fetch products nearing their expiration date.
        // You can use productRepository or any data source to filter products with expiration dates within a certain range.

        List<ProductDto> expiringProducts = new ArrayList<>();

        // Filter and add products with expiration dates within a certain range to expiringProducts list.

        return expiringProducts;
    }
}

