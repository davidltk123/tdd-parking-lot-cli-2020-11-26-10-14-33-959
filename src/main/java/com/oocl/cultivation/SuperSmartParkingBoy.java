package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPositionException {
        return super.park(car);
    }
}
