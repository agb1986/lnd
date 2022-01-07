package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Test004MultipleReturnCalls {
    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    void beforeEach() {
        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);
    }

    @Test
    void should_count_avialable_places_when_called_multiple_times() {
        when(this.roomServiceMock.getAvailableRooms()).thenReturn(Collections.singletonList(new Room("Room 1", 5)))
                .thenReturn(Collections.emptyList());

        int expected = 5;
        int actual = bookingService.getAvailablePlaceCount();

        int expected2 = 0;
        int actual2 = bookingService.getAvailablePlaceCount();

        assertAll(() -> assertEquals(expected, actual), () -> assertEquals(expected2, actual2));
    }
}
