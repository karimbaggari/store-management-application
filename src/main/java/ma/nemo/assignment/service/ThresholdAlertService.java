package ma.nemo.assignment.service;

import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ThresholdAlertService {

    @Autowired
    private ProductRepository productRepository; // Assuming you have a repository to fetch and update product data

    public List<ProductDto> getProductsBelowThreshold() {
        // Implement logic to fetch products below their set threshold.
        // You can use productRepository or any data source to filter products based on the thresholdQuantity field.

        List<ProductDto> productsBelowThreshold = new ArrayList<>();

        // Filter and add products below their set threshold to the list.

        return productsBelowThreshold;
    }

    public void setThreshold(String productCode, int thresholdQuantity) {
        // Implement logic to set the threshold for a specific product based on the provided productCode.
        // Update the thresholdQuantity field for the product in the data source.
    }
}

