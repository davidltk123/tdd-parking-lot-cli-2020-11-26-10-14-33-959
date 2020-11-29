package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    public ParkingBoy(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }
    public Ticket park(Car car) throws NotEnoughPositionException {
        return null;
    }
}
