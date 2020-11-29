package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotServiceManagerTest {
    @Test
    public void should_add_parking_boy_to_management_list_when_add_into_list_given_parking_boys() {
        //given
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<>());
        ParkingBoy parkingBoy = new ParkingBoy(new ArrayList<>());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ArrayList<>());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ArrayList<>());

        //when
        parkingLotServiceManager.addToManagementList(parkingBoy);
        parkingLotServiceManager.addToManagementList(smartParkingBoy);
        parkingLotServiceManager.addToManagementList(superSmartParkingBoy);

        //then
        assertEquals(true,parkingLotServiceManager.getManagementList().contains(parkingBoy));
        assertEquals(true,parkingLotServiceManager.getManagementList().contains(smartParkingBoy));
        assertEquals(true,parkingLotServiceManager.getManagementList().contains(superSmartParkingBoy));
    }

    @Test
    public void should_return_ticket_when_specify_parking_boy_to_park_given_a_car_and_parking_boy() throws NotEnoughPositionException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<>());
        parkingLotServiceManager.addToManagementList(parkingBoy);
        Car car = new Car();

        //when
        Ticket ticket = parkingLotServiceManager.specifyParkingBoyToPark(car,parkingBoy);

        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_specify_parking_boy_to_fetch_given_a_valid_ticket_and_parking_boy() throws NotEnoughPositionException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<>());
        parkingLotServiceManager.addToManagementList(parkingBoy);
        Car car = new Car();
        Ticket ticket = parkingLotServiceManager.specifyParkingBoyToPark(car,parkingBoy);

        //when
        Car actual = parkingLotServiceManager.specifyParkingBoyToFetch(ticket,parkingBoy);

        //then
        assertEquals(car,actual);
    }
}
