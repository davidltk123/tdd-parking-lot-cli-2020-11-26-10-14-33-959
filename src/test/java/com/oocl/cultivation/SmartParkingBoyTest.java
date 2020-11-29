package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {
    @Test
    public void should_park_in_second_parking_lot_when_park_the_car_given_second_parking_lot_has_more_empty_positions() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket ticket = smartParkingBoy.park(car);

        //then
        assertEquals(car, parkingLot2.fetch(ticket));
    }
}
