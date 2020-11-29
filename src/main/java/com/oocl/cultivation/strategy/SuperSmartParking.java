package com.oocl.cultivation.strategy;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.NotEnoughPositionException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParking implements ParkingStrategy{
    @Override
    public Ticket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        ParkingLot parkingLot = parkingLots.stream().max(Comparator.comparing(ParkingLot::getAvailablePositionRate)).get();
        return parkingLot.park(car);
    }
}
