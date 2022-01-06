package com.agb1986.lnd.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestSomeBusinessImpl {

    @Test
    void calculateSum_basic() {
        SomeBusinessImpl businessImpl = new SomeBusinessImpl();
        int actualResult = businessImpl.calculateSum(new int[] {1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_empty() {
        SomeBusinessImpl businessImpl = new SomeBusinessImpl();
        int actualResult = businessImpl.calculateSum(new int[] {});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_oneValue() {
        SomeBusinessImpl businessImpl = new SomeBusinessImpl();
        int actualResult = businessImpl.calculateSum(new int[] {5});
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}
