package com.agb1986.lnd.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SomeDataServiceStub implements SomeDataSerive {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1, 2, 3};
    }
}


class SomeDataServiceStubEmpty implements SomeDataSerive {

    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}


class SomeDataServiceStubSingle implements SomeDataSerive {

    @Override
    public int[] retrieveAllData() {
        return new int[] {5};
    }
}


public class TestSomeBusinessImplStub {

    @Test
    void calculateSum_basic() {
        SomeBusinessImpl businessImpl = new SomeBusinessImpl();
        businessImpl.setSomeDataSerive(new SomeDataServiceStub());
        int actualResult = businessImpl.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_empty() {
        SomeBusinessImpl businessImpl = new SomeBusinessImpl();
        businessImpl.setSomeDataSerive(new SomeDataServiceStubEmpty());
        int actualResult = businessImpl.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_oneValue() {
        SomeBusinessImpl businessImpl = new SomeBusinessImpl();
        businessImpl.setSomeDataSerive(new SomeDataServiceStubSingle());
        int actualResult = businessImpl.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}
