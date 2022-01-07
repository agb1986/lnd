package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Test02DefaultReturnValues {
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

        System.out.println("RETURNED LIST: " + roomServiceMock.getAvailableRooms());
        System.out.println("Object: " + roomServiceMock.findAvailableRoomId(null));
        System.out.println("Rooms: " + roomServiceMock.getRoomCount());
    }

    @Test
    void should_count_avialable_rooms() {
        // Given
        int expectedValue = 0;

        // When
        int actualValue = bookingService.getAvailablePlaceCount();

        // Then
        assertEquals(expectedValue, actualValue);
    }
}
