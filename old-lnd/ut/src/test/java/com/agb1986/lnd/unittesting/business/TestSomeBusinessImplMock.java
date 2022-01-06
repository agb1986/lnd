package com.agb1986.lnd.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestSomeBusinessImplMock {

    @InjectMocks
    SomeBusinessImpl businessImpl = new SomeBusinessImpl();

    @Mock
    SomeDataSerive someDataSeriveMock;

    @Test
    void calculateSum_basic() {
        when(someDataSeriveMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
        assertEquals(6, businessImpl.calculateSumUsingDataService());
    }

    @Test
    void calculateSum_empty() {
        when(someDataSeriveMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(0, businessImpl.calculateSumUsingDataService());
    }

    @Test
    void calculateSum_oneValue() {
        when(someDataSeriveMock.retrieveAllData()).thenReturn(new int[] {5});
        assertEquals(5, businessImpl.calculateSumUsingDataService());
    }
}
