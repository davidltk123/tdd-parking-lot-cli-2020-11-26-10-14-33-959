package com.oocl.cultivation.strategy;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.NotEnoughPositionException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import java.util.List;

public class StandardParking implements ParkingStrategy{
    @Override
    public Ticket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        for(ParkingLot parkinglot : parkingLots){
            try{
                return parkinglot.park(car);
            }catch(NotEnoughPositionException notEnoughPositionException){
                //ignored
            }
        }
        throw new NotEnoughPositionException();
    }
}
