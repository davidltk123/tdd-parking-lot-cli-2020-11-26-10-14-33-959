package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotServiceManagerTest {
    @Test
    public void should_add_parking_boy_to_management_list_when_add_into_list_given_manager_add_a_parking_boy() {
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
}
