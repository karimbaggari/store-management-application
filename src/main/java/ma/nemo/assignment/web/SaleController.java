package ma.nemo.assignment.web;

import ma.nemo.assignment.dto.OperationResponseDTO;
import ma.nemo.assignment.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    @PostMapping
    public ResponseEntity<OperationResponseDTO> sellProduct(@RequestBody ProductDto productDto) {
        OperationResponseDTO response = new OperationResponseDTO("Product added to inventory: " + productDto.getProductCode());
        return ResponseEntity.ok(response);
    }
}