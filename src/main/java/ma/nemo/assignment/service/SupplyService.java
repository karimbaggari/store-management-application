package ma.nemo.assignment.service;
import ma.nemo.assignment.dto.OperationResponseDTO;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.repository.ProductRepository;
import ma.nemo.assignment.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SupplyService(SupplyRepository supplyRepository, ProductRepository productRepository) {
        this.supplyRepository = supplyRepository;
        this.productRepository = productRepository;
    }

    public OperationResponseDTO addProductToInventory(ProductDto productDto) {
        return new OperationResponseDTO("Product added to inventory: " + productDto.getProductCode());
    }
}