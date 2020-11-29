package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPositionException {
        ParkingLot parkingLot = getParkingLots().stream().max(Comparator.comparing(ParkingLot::getEmptyPositions)).get();
        return parkingLot.park(car);
    }
}
