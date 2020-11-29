package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int CAPACITY;
    private Map<Ticket, Car> ticketCarMap;

    public ParkingLot(int capacity){
        this.CAPACITY = capacity;
        ticketCarMap = new HashMap<Ticket, Car>();
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        if(CAPACITY - this.ticketCarMap.size() <=0){
            throw new NotEnoughPositionException();
        }
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        Car car;
        if(ticketCarMap.containsKey(ticket)){
            car = this.ticketCarMap.remove(ticket);
            return car;
        }
        throw new UnrecognizedParkingTicketException();
    }

    public int getEmptyPositions(){
        return this.CAPACITY-this.ticketCarMap.size();
    }

    public double getAvailablePositionRate(){
        return (double)getEmptyPositions()/CAPACITY;
    }

}
