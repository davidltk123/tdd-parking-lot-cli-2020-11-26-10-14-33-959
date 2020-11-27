package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class ParkingBoyTest {
    @Test
    public void should_parking_boy_calling_parking_lot_park_function_when_park_the_car_given_parking_lot_has_available_capacity() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        parkingBoy.park(car);

        //then
        verify(parkingLot, times(1)).park(car);

    }

    @Test
    public void should_parking_boy_calling_fetch_car_when_fetch_the_car_given_parking_ticket_is_valid() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingLot.park(new Car());

        //when
        parkingLot.fetch(ticket);

        //then
        verify(parkingLot, times(1)).fetch(ticket);
    }



}
