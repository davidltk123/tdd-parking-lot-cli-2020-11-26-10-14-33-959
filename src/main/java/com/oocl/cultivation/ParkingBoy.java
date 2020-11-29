package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    public ParkingBoy(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }
    public Ticket park(Car car) throws NotEnoughPositionException {
        for(ParkingLot parkinglot : parkingLots){
            try{
                return parkinglot.park(car);
            }catch(NotEnoughPositionException notEnoughPositionException){
                //ignored
            }
        }
        throw new NotEnoughPositionException();
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        return this.parkingLots.get(0).fetch(ticket);
    }
}
