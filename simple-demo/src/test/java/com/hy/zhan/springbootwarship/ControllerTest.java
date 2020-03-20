package com.hy.zhan.springbootwarship;

import com.hy.zhan.springbootwarship.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * author :  HyJame
 * date  :   2020/3/9
 * desc :    tell me what
 */
@SpringBootTest
public class ControllerTest {

    @Autowired
    private Log log;

    @Test
    public void show_log() {
        Log.show("Hello");
    }
}
