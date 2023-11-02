package ma.nemo.assignment.web;

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
    public ResponseEntity<List<ProductDto>> getProductsBelowThreshold() {
        List<ProductDto> productsBelowThreshold = thresholdAlertService.getProductsBelowThreshold();
        return ResponseEntity.ok(productsBelowThreshold);
    }

    @PostMapping
    public ResponseEntity<Void> setThreshold(@RequestBody ProductDto productDto) {
        thresholdAlertService.setThreshold(productDto.getProductCode(), productDto.getThresholdQuantity());
        return ResponseEntity.ok().build();
    }
}

