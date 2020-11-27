package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void should_return_parking_ticket_when_park_the_car_given_a_car_and_parking_lot_has_available_capacity() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        Ticket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_only_one_car_parked_when_multiple_cars_given_and_parking_lot_has_1_capacity() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        //then
        assertNotNull(ticket1);
        assertNull(ticket2);
    }

    @Test
    public void should_parked_multiple_cars_when_multiple_cars_given_and_parking_lot_has_available_capacity() {
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
    public void should_be_fetched_when_fetch_car_given_valid_parking_ticket_and_parking_lot_that_parked_the_car() {
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
    public void should_be_no_car_fetched_when_fetch_car_given_ticket_has_been_used() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);

        //when
        Car actual = parkingLot.fetch(ticket);

        //then
        assertNull(actual);
    }

    @Test
    public void should_be_no_car_fetched_when_fetch_car_given_fake_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        Ticket fakeTicket = new Ticket();

        //when
        Car actual = parkingLot.fetch(fakeTicket);

        //then
        assertNull(actual);
    }



}
