package com.oocl.cultivation;

public class ParkingBoy {
    private ParkingLot parkingLot;
    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    public Ticket park(Car car) throws NotEnoughPositionException {
        return this.parkingLot.park(car);
    }
}
