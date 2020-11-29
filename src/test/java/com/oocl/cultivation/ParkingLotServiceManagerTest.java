package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        parkingLots.add(new ParkingLot(1));
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
    public void should_return_null_when_specify_parking_boy_to_park_given_a_car_and_a_not_exist_parking_boy() throws NotEnoughPositionException {
        //given
        List<ParkingLot> parkingBoy1ParkingLots = new ArrayList<>();
        List<ParkingLot> parkingBoy2ParkingLots = new ArrayList<>();
        parkingBoy1ParkingLots.add(new ParkingLot(1));
        parkingBoy2ParkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingBoy1ParkingLots);
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingBoy2ParkingLots);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<>());
        parkingLotServiceManager.addToManagementList(parkingBoy1);
        Car car = new Car();

        //when
        Ticket ticket = parkingLotServiceManager.specifyParkingBoyToPark(car,parkingBoy2);

        //then
        assertNull(ticket);
    }

    @Test
    public void should_return_car_when_specify_parking_boy_to_fetch_given_a_valid_ticket_and_parking_boy() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
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

    @Test
    public void should_null_car_when_specify_parking_boy_to_fetch_given_not_exist_parking_boy() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingBoy1ParkingLots = new ArrayList<>();
        List<ParkingLot> parkingBoy2ParkingLots = new ArrayList<>();
        parkingBoy1ParkingLots.add(new ParkingLot(1));
        parkingBoy2ParkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingBoy1ParkingLots);
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingBoy2ParkingLots);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<>());
        parkingLotServiceManager.addToManagementList(parkingBoy1);
        Car car = new Car();
        Ticket ticket = parkingLotServiceManager.specifyParkingBoyToPark(car,parkingBoy1);

        //when
        Car actual = parkingLotServiceManager.specifyParkingBoyToFetch(ticket,parkingBoy2);

        //then
        assertNull(actual);
    }

    @Test
    public void should_manager_calling_parking_lot_park_function_when_park_the_car_given_parking_lot_has_available_capacity() throws NotEnoughPositionException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        parkingLots.add(parkingLot);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingLots);
        Car car = new Car();

        //when
        parkingLotServiceManager.park(car);

        //then
        verify(parkingLot, times(1)).park(car);

    }

    @Test
    public void should_parking_boy_calling_fetch_car_when_fetch_the_car_given_parking_ticket_is_valid() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        parkingLots.add(parkingLot);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingLots);
        Ticket ticket = parkingLot.park(new Car());

        //when
        parkingLotServiceManager.fetch(ticket);

        //then
        verify(parkingLot, times(1)).fetch(ticket);
    }

    @Test
    public void should_throw_not_enough_position_exception_when_speicify_parking_boy_to_park_given_parking_lot_is_full(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(0));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<>());
        parkingLotServiceManager.addToManagementList(parkingBoy);
        Car car = new Car();

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, ()-> {
            parkingLotServiceManager.specifyParkingBoyToPark(car,parkingBoy);
        });

        //then
        assertEquals("Not enough position.",notEnoughPositionException.getMessage());
    }

    @Test
    public void should_throw_unrecognized_exception_when_speicify_parking_boy_to_fetch_given_the_ticket_is_used() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<>());
        parkingLotServiceManager.addToManagementList(parkingBoy);
        Car car = new Car();
        Ticket ticket = parkingLotServiceManager.specifyParkingBoyToPark(car,parkingBoy);
        parkingLotServiceManager.specifyParkingBoyToFetch(ticket,parkingBoy);

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()-> {
            parkingLotServiceManager.specifyParkingBoyToFetch(ticket,parkingBoy);
        });

        //then
        assertEquals("Unrecognized parking ticket.",unrecognizedParkingTicketException.getMessage());
    }

    @Test
    public void should_throw_unrecognized_exception_when_speicify_parking_boy_to_fetch_given_the_ticket_is_fake() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(new ArrayList<>());
        parkingLotServiceManager.addToManagementList(parkingBoy);
        Car car = new Car();
        parkingLotServiceManager.specifyParkingBoyToPark(car,parkingBoy);
        Ticket fakeTicket = new Ticket();

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()-> {
            parkingLotServiceManager.specifyParkingBoyToFetch(fakeTicket,parkingBoy);
        });

        //then
        assertEquals("Unrecognized parking ticket.",unrecognizedParkingTicketException.getMessage());
    }
}
