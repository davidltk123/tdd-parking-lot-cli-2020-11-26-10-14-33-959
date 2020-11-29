package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager extends ParkingBoy{
    private List<ParkingBoy>managementList;
    public ParkingLotServiceManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.managementList = new ArrayList<>();
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPositionException {
        return super.park(car);
    }

    public void addToManagementList(ParkingBoy parkingBoy) {
    }

    public List<ParkingBoy> getManagementList(){
        return this.managementList;
    }
}
