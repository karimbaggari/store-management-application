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
public class ExpiryAlertControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetExpiryAlerts() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/expiry-alerts")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        // Verify the HTTP response status
        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        // Optionally, you can verify the response content
        String content = result.getResponse().getContentAsString();

    }
}
