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
        this.managementList.add(parkingBoy);
    }

    public List<ParkingBoy> getManagementList(){
        return this.managementList;
    }

    public Ticket specifyParkingBoyToPark(Car car, ParkingBoy parkingBoy) throws NotEnoughPositionException {
        if(this.managementList.contains(parkingBoy)){
            return parkingBoy.park(car);
        }
        return null;
    }

    public Car specifyParkingBoyToFetch(Ticket ticket, ParkingBoy parkingBoy) throws UnrecognizedParkingTicketException {
        if(this.managementList.contains(parkingBoy)){
            return parkingBoy.fetch(ticket);
        }
        return null;
    }
}
