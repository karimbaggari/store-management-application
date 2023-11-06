package ma.nemo.assignment.web;


import io.swagger.v3.oas.annotations.Operation;
import ma.nemo.assignment.dto.OperationResponseDTO;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supply")
@Api(value = "Example Controller", description = "Sample endpoints")
public class SupplyController {
    @Autowired
    private SupplyService supplyService;


    @PostMapping
    @Operation(summary = "API endpoint to handle the addition of products to the inventory.")
    public ResponseEntity<OperationResponseDTO> addProductToInventory(@RequestBody ProductDto productDto) {
        OperationResponseDTO response = supplyService.addProductToInventory(productDto);
        return ResponseEntity.ok(response);
    }
}
