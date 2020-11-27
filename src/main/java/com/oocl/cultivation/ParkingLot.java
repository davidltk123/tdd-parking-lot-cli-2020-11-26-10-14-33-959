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

    public Ticket park(Car car){
        if(CAPACITY - this.ticketCarMap.size() <=0){
            return null;
        }
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket){
        Car car =  this.ticketCarMap.get(ticket);
        this.ticketCarMap.remove(ticket);
        return car;
    }
}
