package ma.nemo.assignment.service;

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
        return new ReturnResponseDTO("Product returned: " + request.getProductCode());
    }
}

