package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class ParkingBoyTest {
    @Test
    public void should_parking_boy_calling_parking_lot_park_function_when_park_the_car_given_parking_lot_has_available_capacity() throws NotEnoughPositionException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        parkingBoy.park(car);

        //then
        verify(parkingLot, times(1)).park(car);

    }

    @Test
    public void should_parking_boy_calling_fetch_car_when_fetch_the_car_given_parking_ticket_is_valid() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingLot.park(new Car());

        //when
        parkingBoy.fetch(ticket);

        //then
        verify(parkingLot, times(1)).fetch(ticket);
    }

    @Test
    public void should_park_in_first_parking_lot_when_park_the_car_given_both_parking_lots_are_not_full() throws NotEnoughPositionException{
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket ticket1 = parkingBoy.park(car);

        //then
        assertNotNull(ticket1);
    }

    @Test
    public void should_park_in_second_parking_lot_when_park_the_car_given_first_parking_lots_is_full() throws NotEnoughPositionException{
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);

        //then
        assertNotNull(ticket2);
    }

    @Test
    public void should_throw_not_enough_position_exception_when_park_the_car_given_both_parking_lots_are_full(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, ()-> {
            parkingBoy.park(new Car());
        });

        //then
        assertEquals("Not enough position.",notEnoughPositionException.getMessage());
    }

    @Test
    public void should_fetch_from_second_parking_lot_when_fetch_the_car_given_the_car_is_parked_in_second_parking_lot() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        //when
        Car actual = parkingBoy.fetch(ticket);

        //then
        assertEquals(car,actual);
    }

    @Test
    public void should_throw_unrecognized_ticket_exception_when_fetch_the_car_given_ticket_is_used() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.park(new Car());
        parkingBoy.fetch(ticket);

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()-> {
            parkingBoy.fetch(ticket);
        });

        //then
        assertEquals("Unrecognized parking ticket.",unrecognizedParkingTicketException.getMessage());
    }

    @Test
    public void should_throw_unrecognized_ticket_exception_when_fetch_the_car_given_ticket_is_fake() throws NotEnoughPositionException{
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(new Car());
        Ticket fakeTicket = new Ticket();

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()-> {
            parkingBoy.fetch(fakeTicket);
        });

        //then
        assertEquals("Unrecognized parking ticket.",unrecognizedParkingTicketException.getMessage());
    }





}
