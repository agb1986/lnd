package com.agb1986.lnd.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestListMock {
    @Mock
    List<String> mock;

    @Test
    void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    void size_returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    void returnWithParameters() {
        when(mock.get(0)).thenReturn("HELLO WORLD");
        assertEquals("HELLO WORLD", mock.get(0));
    }

    @Test
    void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("HELLO WORLD");
        assertEquals("HELLO WORLD", mock.get(anyInt()));
    }

    @Test
    void verificationBasics() {
        // Invoke
        mock.get(0);
        mock.get(1);

        // Check if invoked
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    void argumentCapturing() {
        // Invoke
        mock.add("SomeString");

        // Check if invoked
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("SomeString", captor.getValue());
    }

    @Test
    void argumentCapturingMultiple() {
        // Invoke
        mock.add("SomeString1");
        mock.add("SomeString2");

        // Check if invoked
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    void mocking() {
        ArrayList<Object> arrayList = mock(ArrayList.class);
        System.out.println(arrayList.get(0)); // null
        System.out.println(arrayList.size()); // 0
        arrayList.add("Test");
        arrayList.add("Test2");
        System.out.println(arrayList.size()); // 0
        when(arrayList.size()).thenReturn(5);
        System.out.println(arrayList.size()); // 5
    }

    @Test
    void spying() {
        ArrayList<Object> arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0)); // Test0
        System.out.println(arrayListSpy.size()); // 1
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size()); // 3
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5

        // verify(arrayListSpy).add("Test4");
        // System.out.println(arrayListSpy.size()); // 6
    }
}
