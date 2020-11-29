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

    @Test
    public void should_park_in_first_parking_lot_when_park_the_car_given_both_parking_lots_has_same_available_position_rate() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(4);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        parkingLot1.park(new Car());
        parkingLot2.park(new Car());
        parkingLot2.park(new Car());   //parkingLot1 1/2    parkingLot2 2/4
        Car car = new Car();

        //when
        Ticket ticket = superSmartParkingBoy.park(car);

        //then
        assertEquals(car, parkingLot1.fetch(ticket));
    }

    @Test
    public void should_throw_not_enough_position_exception_when_park_the_car_given_both_parking_lots_are_full(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, ()-> {
            superSmartParkingBoy.park(new Car());
        });

        //then
        assertEquals("Not enough position.",notEnoughPositionException.getMessage());
    }

    @Test
    public void should_fetch_from_second_parking_lot_when_fetch_the_car_given_the_car_parked_in_second_lot() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
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
        Ticket ticket = superSmartParkingBoy.park(car);

        //when
        Car actual = superSmartParkingBoy.fetch(ticket);

        //then
        assertEquals(car,actual);
    }
}
