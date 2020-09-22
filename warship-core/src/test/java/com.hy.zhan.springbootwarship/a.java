package com.hy.zhan.springbootwarship;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hy.zhan.springbootwarship.bean.PageRsp;
import com.hy.zhan.springbootwarship.bean.Response;
import com.hy.zhan.warshiptest.IResponse;
import com.hy.zhan.warshiptest.base.BaseRequestTest;
import org.junit.jupiter.api.Test;

/**
 * author: HyJame
 * date:   2020/9/22
 * desc:   TODO
 */
public class a extends BaseRequestTest {

    @Test
    public void test(){
        Object param = new Object();
        Object resourceRsp = request("/resource/query")
                .param(param)
                .responseType(new TypeReference<Response<Object>>() {
                })
                .getData();

        b(Response.success(1));
    }

    public <T> void b(IResponse<T> iResponse){

    }
}
