package com.hy.zhan.springbootwarship;

import com.hy.zhan.springbootwarship.common.Precondition;
import org.junit.jupiter.api.Test;

/**
 * author: HyJame
 * date:   2020/1/3
 * desc:   TODO
 */
public class HelloTest {

    @Test
    public void test_hello() {

    }

    public static void main(String[] args) {
        Precondition.ifTrue(true, () -> {
            System.out.println("hello World");
        });
    }
}
