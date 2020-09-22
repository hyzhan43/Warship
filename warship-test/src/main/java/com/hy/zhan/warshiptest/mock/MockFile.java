package com.hy.zhan.warshiptest.mock;

import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * author: HyJame
 * date:   2020/9/2
 * desc:   TODO
 */
public class MockFile {

    public static MockMultipartFile createHtml(String path) {
        File file = new File(path);

        MockMultipartFile mockMultipartFile = null;
        try {
            mockMultipartFile = new MockMultipartFile(
                    "test",
                    file.getName(),
                    MediaType.TEXT_HTML_VALUE,
                    new FileInputStream(file)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mockMultipartFile;
    }
}
