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
                                {"fileBase64" : "MSswLjU=",
                                "extension" : "txt",
                                "commands": []
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
                                {"fileBase64" : "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pg0KPGFsZ2VicmFpY0V4cHJlc3Npb24+DQogICAgPGV4cHJlc3Npb24+MSswLjU8L2V4cHJlc3Npb24+DQo8L2FsZ2VicmFpY0V4cHJlc3Npb24+",
                                "extension" : "xml",
                                "commands":[]
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("resultValue", is(1.5)))
                .andReturn();
    }

    @Test
    public void allGoodTest() throws Exception {
        compareResponseToRequestInJsonFiles(
                "rest/CalculateRequest_correct.json",
                "rest/CalculateResponse_correct.json"
        );
    }

    @Test
    public void allWrongTest() throws Exception {
        compareResponseToRequestInJsonFiles(
                "rest/CalculateRequest_allWrong.json",
                "rest/CalculateResponse_allWrong.json"
        );
    }

    @Test
    public void fileIsEmpty() throws Exception {
        compareResponseToRequestInJsonFiles(
                "rest/CalculateRequest_fileEmpty.json",
                "rest/CalculateResponse_fileEmpty.json"
        );
    }
    @Test
    public void wrongExtension() throws Exception {
        compareResponseToRequestInJsonFiles(
                "rest/CalculateRequest_wrongExtension.json",
                "rest/CalculateResponse_wrongExtension.json"
        );
    }

    @Test
    public void extensionIsMissing() throws Exception {
        compareResponseToRequestInJsonFiles(
                "rest/CalculateRequest_extensionIsMissing.json",
                "rest/CalculateResponse_extensionIsMissing.json"
        );
    }

    @Test
    public void wrongCommands() throws Exception {
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

        System.out.println(jsonResponse);
        System.out.println(responseBodyContent);

        assertJson(responseBodyContent)
                .where()
                .keysInAnyOrder()
                .arrayInAnyOrder()
                .isEqualTo(jsonResponse);
    }
}
