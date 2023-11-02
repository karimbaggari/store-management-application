package ma.nemo.assignment.web;

import ma.nemo.assignment.dto.SupplyRequestDTO;
import ma.nemo.assignment.dto.SupplyResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {

    @PostMapping
    public ResponseEntity<SupplyResponseDTO> addProductToInventory(@RequestBody SupplyRequestDTO request) {
        System.out.println("test");
        String successMessage = "Product added to inventory: " + request.getProductId();
        SupplyResponseDTO response = new SupplyResponseDTO(successMessage);

        return ResponseEntity.ok(response);
    }
}
