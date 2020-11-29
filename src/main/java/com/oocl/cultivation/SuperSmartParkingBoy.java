package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPositionException {
        ParkingLot parkingLot = getParkingLots().stream().max(Comparator.comparing(ParkingLot::getAvailablePositionRate)).get();
        return parkingLot.park(car);
    }
}
