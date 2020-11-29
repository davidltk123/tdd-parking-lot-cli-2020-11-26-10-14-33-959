package com.oocl.cultivation;

import com.oocl.cultivation.strategy.SuperSmartParking;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingStrategy = new SuperSmartParking();
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPositionException {
        return this.parkingStrategy.park(car,this.getParkingLots());
    }
}
