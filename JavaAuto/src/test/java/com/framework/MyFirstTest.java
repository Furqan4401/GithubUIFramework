package com.framework;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyFirstTest {

    @Test
    void myFirstTest() {
    int result = sum(2, 3);

        Assertions.assertEquals(5, result);

    }

        static int sum (int a, int b) {
            return a + b;
        }


    }


