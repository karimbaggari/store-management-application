package ma.nemo.assignment.service;
import ma.nemo.assignment.dto.SupplyRequestDTO;
import ma.nemo.assignment.dto.SupplyResponseDTO;
import ma.nemo.assignment.exceptions.ResourceNotFoundException;
import ma.nemo.assignment.repository.ProductRepository;
import ma.nemo.assignment.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.nemo.assignment.domain.*;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SupplyService(SupplyRepository supplyRepository, ProductRepository productRepository) {
        this.supplyRepository = supplyRepository;
        this.productRepository = productRepository;
    }

    public SupplyResponseDTO addProductToInventory(SupplyRequestDTO request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Supply supply = new Supply();
        supply.setProduct(product);
        supply.setQuantity(request.getQuantity());
        supply.setSupplyDate(request.getSupplyDate());

        supplyRepository.save(supply);

        return new SupplyResponseDTO("Product added to inventory: " + product.getProductName());
    }
}