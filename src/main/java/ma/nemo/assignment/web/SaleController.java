package ma.nemo.assignment.web;

import io.swagger.v3.oas.annotations.Operation;
import ma.nemo.assignment.dto.OperationResponseDTO;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @PostMapping
    @Operation(summary = "API endpoint to handle the sale of products.")
    public ResponseEntity<OperationResponseDTO> addProductToInventory(@RequestBody ProductDto productDto) {
        OperationResponseDTO response = saleService.saleProductFromInventory(productDto);
        return ResponseEntity.ok(response);
    }
}