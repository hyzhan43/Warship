package com.hy.zhan.warshiptest.base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hy.zhan.warshiptest.IResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * author :  HyJame
 * date  :   2019/12/31
 * desc :    ...
 */
@AutoConfigureMockMvc
public class BaseRequestTest extends BaseSpringTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private String url;

    private Object requestBody;

    private MediaType mediaType = MediaType.APPLICATION_JSON;

    public BaseRequestTest request(String url) {
        this.url = url;
        return this;
    }

    public BaseRequestTest param(Object requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public BaseRequestTest contentType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public <R> IResponse<R> responseType(TypeReference<? extends IResponse<R>> returnType) {
        IResponse<R> IResponse = null;
        try {
            MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(url)
                    .contentType(mediaType);

            if (mediaType.equals(MediaType.APPLICATION_JSON)) {
                builder.content(mapper.writeValueAsString(requestBody));
            } else {
                setupFormDataParam(builder);
            }

            String IResponseStr = mockMvc.perform(builder)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(print())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();

            IResponse = mapper.readValue(IResponseStr, returnType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull(IResponse);
        assertTrue(IResponse.isSuccess());

        return IResponse;
    }

    private void setupFormDataParam(MockHttpServletRequestBuilder builder) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        @SuppressWarnings("unchecked")
        Map<String, String> keyValues = BeanUtils.describe(requestBody);
        keyValues.forEach(builder::param);
    }
}





