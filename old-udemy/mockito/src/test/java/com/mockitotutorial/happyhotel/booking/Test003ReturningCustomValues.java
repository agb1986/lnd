package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Test003ReturningCustomValues {
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
    void should_count_avialable_rooms_with_one_room_aviable() {
        when(this.roomServiceMock.getAvailableRooms()).thenReturn(Collections.singletonList(new Room("Room 1", 5)));

        int expected = 5;
        int actual = bookingService.getAvailablePlaceCount();

        assertEquals(expected, actual);
    }

    @Test
    void should_count_avialable_rooms_with_multiple_rooms_aviable() {
        List<Room> rooms = Arrays.asList(
            new Room("Room 1", 5),
            new Room("Room 2", 4),
            new Room("Room 3", 3),
            new Room("Room 4", 2)
        );
        when(this.roomServiceMock.getAvailableRooms()).thenReturn(rooms);

        int expected = 14;
        int actual = bookingService.getAvailablePlaceCount();

        assertEquals(expected, actual);
    }
}
