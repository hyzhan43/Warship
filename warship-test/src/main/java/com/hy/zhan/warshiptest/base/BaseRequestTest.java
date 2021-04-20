package com.hy.zhan.warshiptest.base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hy.zhan.warshiptest.IResponse;
import com.hy.zhan.warshiptest.url.Url;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * author :  HyJame
 * date  :   2019/12/31
 * desc :    ...
 */
@Transactional
@AutoConfigureMockMvc
public class BaseRequestTest extends BaseSpringTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private String url;

    private Object requestBody;

    private MediaType contentType = MediaType.APPLICATION_JSON;

    private Map<String, Object> uriParams;

    private HttpMethod httpMethod = HttpMethod.POST;

    private TypeReference<?> returnType;

    private boolean isMultipart = false;

    private List<MockMultipartFile> fileParams;

    public BaseRequestTest request(String url) {
        this.url = url;
        return this;
    }

    public BaseRequestTest param(Object requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public BaseRequestTest contentType(MediaType mediaType) {
        this.contentType = mediaType;
        return this;
    }

    public BaseRequestTest file(MockMultipartFile file) {
        if (fileParams == null) {
            fileParams = new ArrayList<>();
        }
        this.fileParams.add(file);
        return this;
    }

    public BaseRequestTest uriParams(String key, Object value) {
        if (uriParams == null) {
            uriParams = new HashMap<>();
        }
        this.uriParams.put(key, value);
        return this;
    }

    public BaseRequestTest requestMethod(HttpMethod method) {
        this.httpMethod = method;
        return this;
    }

    public BaseRequestTest multipart() {
        this.isMultipart = true;
        return this;
    }

    public <R> BaseRequestTest responseType(TypeReference<? extends IResponse<R>> returnType) {
        this.returnType = returnType;
        return this;
    }

    public <R> IResponse<R> getResponse() {
        IResponse<R> response = null;
        try {
            MockHttpServletRequestBuilder builder = getMockHttpServletRequestBuilder();

            builder.contentType(contentType);

            if (this.contentType.equals(MediaType.APPLICATION_JSON)) {
                builder.content(this.mapper.writeValueAsString(this.requestBody));
            } else {
                this.setupFormDataParam(builder);
            }

            response = getResponse(builder);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull(response);
        assertTrue(response.isSuccess());

        return response;
    }

    private MockHttpServletRequestBuilder getMockHttpServletRequestBuilder() {
        Url finalUrl = new Url(url, uriParams);
        if (isMultipart) {
            MockMultipartHttpServletRequestBuilder multipart = MockMvcRequestBuilders.multipart(finalUrl.buildUrl());
            fileParams.forEach(multipart::file);
            return multipart;
        }

        return MockMvcRequestBuilders.request(httpMethod, finalUrl.buildUrl());
    }

    public <T> T getData() {
        IResponse<T> kpcResponse = getResponse();
        assertNotNull(kpcResponse.getData());
        return kpcResponse.getData();
    }

    private <R> IResponse<R> getResponse(MockHttpServletRequestBuilder builder) throws Exception {
        String responseStr = mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        //noinspection unchecked
        return (IResponse<R>) mapper.readValue(responseStr, returnType);
    }

    private void setupFormDataParam(MockHttpServletRequestBuilder builder) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        @SuppressWarnings("unchecked")
        Map<String, String> keyValues = BeanUtils.describe(requestBody);
        keyValues.forEach(builder::param);
    }
}





