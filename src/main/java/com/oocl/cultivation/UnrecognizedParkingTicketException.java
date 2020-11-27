package com.oocl.cultivation;

public class UnrecognizedParkingTicketException extends Exception{
    public UnrecognizedParkingTicketException(){
        super("Unrecognized parking ticket.");
    }
}
