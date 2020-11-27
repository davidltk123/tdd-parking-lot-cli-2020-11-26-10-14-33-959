package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class ParkingBoyTest {
    @Test
    public void should_parking_boy_calling_parking_lot_park_function_when_park_the_car_given_parking_lot_has_available_capacity() {

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
    public void should_parking_boy_calling_parking_lot_park_function_when_park_the_car_given_parking_lot_has_1_capacity() {


    }



}
