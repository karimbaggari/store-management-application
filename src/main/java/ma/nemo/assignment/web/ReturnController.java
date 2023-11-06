package ma.nemo.assignment.web;

import io.swagger.v3.oas.annotations.Operation;
import ma.nemo.assignment.dto.ReturnRequestDTO;
import ma.nemo.assignment.dto.ReturnResponseDTO;
import ma.nemo.assignment.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/return")
public class ReturnController {
    @Autowired
    private ReturnService returnService;

    @PostMapping
    @Operation(summary = "API endpoint to handle the return of products.")
    public ResponseEntity<ReturnResponseDTO> returnProduct(@RequestBody ReturnRequestDTO request) {
        ReturnResponseDTO response = returnService.returnProduct(request);
        return ResponseEntity.ok(response);
    }
}
