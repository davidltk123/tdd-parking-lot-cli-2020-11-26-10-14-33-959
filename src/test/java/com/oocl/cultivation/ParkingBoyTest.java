package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyTest {
    @Test
    public void should_parking_boy_calling_parking_lot_park_function_when_park_the_car_given_parking_lot_has_available_capacity() {

        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }


}
