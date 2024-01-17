package org.blackberry020.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.org.webcompere.modelassert.json.JsonAssertions.assertJson;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void simpleRestControllerTestExample() throws Exception {
        mockMvc.perform(post("/calculator/calculate/")
                        .content("""
                                {"file" : "smth",
                                "extension" : "txt",
                                "commands": ["DECRYPT"]
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("resultValue", is(1.5)))
                .andReturn();
    }

    @Test
    public void simpleRestControllerTest() throws Exception {
        mockMvc.perform(post("/calculator/calculate/")
                        .content("""
                                {"file" : "smth",
                                "extension" : "xml",
                                "commands":["DECRYPT", "DECOMPRESS"]
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("resultValue", is(1.5)))
                .andReturn();
    }

    @Test
    public void jsonFilesTest() throws Exception {

        compareResponseToRequestInJsonFiles(
                "rest/CalculateRequest_correct.json",
                "rest/CalculateResponse_correct.json"
        );

        compareResponseToRequestInJsonFiles(
                "rest/CalculateRequest_allWrong.json",
                "rest/CalculateResponse_allWrong.json"
        );

        compareResponseToRequestInJsonFiles(
                "rest/CalculateRequest_fileEmpty.json",
                "rest/CalculateResponse_fileEmpty.json"
        );

        compareResponseToRequestInJsonFiles(
                "rest/CalculateRequest_wrongExtension.json",
                "rest/CalculateResponse_wrongExtension.json"
        );

        compareResponseToRequestInJsonFiles(
                "rest/CalculateRequest_extensionIsMissing.json",
                "rest/CalculateResponse_extensionIsMissing.json"
        );

        compareResponseToRequestInJsonFiles(
                "rest/CalculateRequest_wrongCommands.json",
                "rest/CalculateResponse_wrongCommands.json"
        );
    }

    public void compareResponseToRequestInJsonFiles(
            String fileNameRequest, String fileNameResponse
    ) throws Exception {
        String jsonRequest = JsonReader.read(fileNameRequest);

        MvcResult result = mockMvc.perform(post("/calculator/calculate/")
                        .content(jsonRequest)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String responseBodyContent = result.getResponse().getContentAsString();

        String jsonResponse = JsonReader.read(fileNameResponse);

        assertJson(responseBodyContent)
                .where()
                .keysInAnyOrder()
                .arrayInAnyOrder()
                .isEqualTo(jsonResponse);
    }
}
