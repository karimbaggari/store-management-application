package ma.nemo.assignment.web;

import io.swagger.v3.oas.annotations.Operation;
import ma.nemo.assignment.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import ma.nemo.assignment.service.ExpiryAlertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
@RestController
    @RequestMapping("/api/expiry-alerts")
public class ExpiryAlertController {

    @Autowired
    private ExpiryAlertService expiryAlertService;

    @GetMapping
    @Operation(summary = "Track and fetch products nearing their expiration date.")
    public ResponseEntity<List<ProductDto>> getExpiryAlerts() {
        List<ProductDto> expiringProducts = expiryAlertService.getExpiringProducts();
        return ResponseEntity.ok(expiringProducts);
    }
}

