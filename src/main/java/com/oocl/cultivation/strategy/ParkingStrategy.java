package com.oocl.cultivation.strategy;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.NotEnoughPositionException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import java.util.List;

public interface ParkingStrategy {
    public Ticket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException;
}
