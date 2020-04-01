package com.hy.zhan.springbootwarship;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hy.zhan.springbootwarship.bean.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * author :  hyzhan
 * date  :   2019/12/31
 * desc :    ...
 */
@AutoConfigureMockMvc
public class BaseRequestTest extends BaseSpringTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public ObjectMapper mapper;

    public <R> R request(String url, Object requestBody, TypeReference<Response<R>> returnType) {

        Response<R> response = null;
        try {
            MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(requestBody));

            String responseStr = mockMvc.perform(builder)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(print())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            response = mapper.readValue(responseStr, returnType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertNotNull(response.getData());

        return response.getData();
    }

    public Response request(String url, Object requestBody) {

        Response response = null;
        try {
            MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(requestBody));

            String responseStr = mockMvc.perform(builder)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(print())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            response = mapper.readValue(responseStr, Response.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull(response);
        return response;
    }
}
