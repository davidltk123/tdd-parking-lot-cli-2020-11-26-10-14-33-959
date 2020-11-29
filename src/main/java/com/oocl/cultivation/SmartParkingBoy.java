package com.oocl.cultivation;

import com.oocl.cultivation.strategy.SmartParking;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingStrategy = new SmartParking();
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPositionException {
        return this.parkingStrategy.park(car,this.getParkingLots());
    }
}
