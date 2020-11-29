package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_park_in_second_parking_lot_when_park_the_car_given_second_parking_lot_has_larger_available_position_rate() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot2.park(new Car());  //parkingLot1 3/5    parkingLot2 1/2
        Car car = new Car();

        //when
        Ticket ticket = superSmartParkingBoy.park(car);

        //then
        assertEquals(car, parkingLot2.fetch(ticket));
    }
}
