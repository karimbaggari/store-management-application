package ma.nemo.assignment.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class SupplyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddProductToInventory() throws Exception {
        String requestBody = "{"
                + "\"productId\": 1,"
                + "\"productCode\": \"ABC123\","
                + "\"productName\": \"Sample Product\","
                + "\"description\": \"Product description\","
                + "\"unitPrice\": 10.0,"
                + "\"quantityInStock\": 100"
                + "}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/supply")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        // Verify the HTTP response status
        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        // Optionally, you can verify the response content
        String content = result.getResponse().getContentAsString();
        // Add assertions for the content if needed

        // You can also verify the response DTO if available
        // OperationResponseDTO response = objectMapper.readValue(content, OperationResponseDTO.class);
        // Add assertions for the response DTO
    }
}
