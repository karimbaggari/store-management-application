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
public class ThresholdAlertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetProductsBelowThreshold() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/threshold-alerts")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        // Verify the HTTP response status
        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        // Optionally, you can verify the response content
        String content = result.getResponse().getContentAsString();
    }

    @Test
    public void testSetThreshold() throws Exception {
        String requestBody = "{"
                + "\"productCode\": \"ABC123\","
                + "\"thresholdQuantity\": 50"
                + "}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/threshold-alerts")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        // Verify the HTTP response status for the setThreshold operation
        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        // Optionally, you can verify the response content
        String content = result.getResponse().getContentAsString();
        // Add assertions for the content if needed
    }
}
