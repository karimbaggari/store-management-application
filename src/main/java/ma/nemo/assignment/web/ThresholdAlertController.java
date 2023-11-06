package ma.nemo.assignment.web;

import io.swagger.v3.oas.annotations.Operation;
import ma.nemo.assignment.dto.ProductDto;
import ma.nemo.assignment.service.ThresholdAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/threshold-alerts")
public class ThresholdAlertController {

    @Autowired
    private ThresholdAlertService thresholdAlertService;
    @GetMapping
    @Operation(summary = "Api endpoit to fetch products below the threshold.")
    public ResponseEntity<List<ProductDto>> getProductsBelowThreshold() {
        List<ProductDto> productsBelowThreshold = thresholdAlertService.getProductsBelowThreshold();
        return ResponseEntity.ok(productsBelowThreshold);
    }

    @PostMapping
    @Operation(summary = "Api endpoint to Set thresholds ")
    public ResponseEntity<Void> setThreshold(@RequestBody ProductDto productDto) {
        thresholdAlertService.setThreshold(productDto.getProductCode(), productDto.getThresholdQuantity());
        return ResponseEntity.ok().build();
    }
}

