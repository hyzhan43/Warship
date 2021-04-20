package com.hy.zhan.warshiptest;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * author: HyJame
 * date:   2021/4/19
 * desc:
 */
public class Playground {

    @Test
    public void test() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        A a = new A();
        a.name = "zhangsan";
        a.file = new MockMultipartFile("1", "Hello".getBytes());
        Map describe = BeanUtils.describe(a);
        describe.forEach((key, value)-> System.out.println(key + "- " + value));
    }

    class  A {
        public String name;
        MultipartFile file;

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", file=" + file +
                    '}';
        }
    }
}
