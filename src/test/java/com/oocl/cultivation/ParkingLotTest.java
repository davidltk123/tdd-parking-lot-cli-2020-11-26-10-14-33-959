package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void should_return_parking_ticket_when_park_the_car_given_a_car_and_parking_lot_has_available_capacity() throws NotEnoughPositionException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        Ticket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_only_one_car_parked_when_multiple_cars_given_and_parking_lot_has_1_capacity() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        Ticket ticket1 = parkingLot.park(car1);
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, ()-> {
            parkingLot.park(car2);
        });

        //then
        assertNotNull(ticket1);
        assertEquals("Not enough position.",notEnoughPositionException.getMessage());
    }

    @Test
    public void should_parked_multiple_cars_when_multiple_cars_given_and_parking_lot_has_available_capacity() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(2);

        //when
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotEquals(ticket1,ticket2);
    }

    @Test
    public void should_be_fetched_when_fetch_car_given_valid_parking_ticket_and_parking_lot_that_parked_the_car() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //when
        Car actual = parkingLot.fetch(ticket);

        //then
        assertEquals(car,actual);
    }

    @Test
    public void should_be_no_car_fetched_when_fetch_car_given_ticket_has_been_used() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()-> {
            parkingLot.fetch(ticket);
        });

        //then
        assertEquals("Unrecognized parking ticket.",unrecognizedParkingTicketException.getMessage());
    }

    @Test
    public void should_be_no_car_fetched_when_fetch_car_given_fake_parking_ticket() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        Ticket fakeTicket = new Ticket();

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()-> {
            parkingLot.fetch(fakeTicket);
        });

        //then
        assertEquals("Unrecognized parking ticket.",unrecognizedParkingTicketException.getMessage());
    }

    @Test
    public void should_throw_not_enough_position_exception_when_parking_car_given_not_enough_parking_lot_position() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        parkingLot.park(new Car());
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, ()-> {
            parkingLot.park(new Car());
        });

        //then
        assertEquals("Not enough position.",notEnoughPositionException.getMessage());
    }

    @Test
    public void should_throw_unrecognized_parking_ticket_exception_when_fetching_car_given_wrong_ticket() throws NotEnoughPositionException,UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        Ticket fakeTicket = new Ticket();

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()-> {
            parkingLot.fetch(fakeTicket);
        });

        //then
        assertEquals("Unrecognized parking ticket.",unrecognizedParkingTicketException.getMessage());
    }



}
