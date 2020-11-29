package com.oocl.cultivation;

import com.oocl.cultivation.strategy.ParkingStrategy;
import com.oocl.cultivation.strategy.StandardParking;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    protected ParkingStrategy parkingStrategy;

    public ParkingBoy(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
        this.parkingStrategy = new StandardParking();
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        return this.parkingStrategy.park(car, parkingLots);
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        for(ParkingLot parkinglot : parkingLots){
            try{
                return parkinglot.fetch(ticket);
            }catch(UnrecognizedParkingTicketException unrecognizedParkingTicketException){
                //ignored
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

    public List<ParkingLot> getParkingLots(){
        return this.parkingLots;
    }
}
