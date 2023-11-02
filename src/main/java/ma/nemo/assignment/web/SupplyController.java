package ma.nemo.assignment.web;

import ma.nemo.assignment.dto.OperationResponseDTO;
import ma.nemo.assignment.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {

    @PostMapping
    public ResponseEntity<OperationResponseDTO> addProductToInventory(@RequestBody ProductDto productDto) {
        if (productDto.getQuantityInStock() > 500) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new OperationResponseDTO("Quantity exceeds the maximum limit of 500 units."));
        }
        OperationResponseDTO response = new OperationResponseDTO("Product added to inventory: " + productDto.getProductCode());
        return ResponseEntity.ok(response);
    }
}
