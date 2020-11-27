package com.oocl.cultivation;

public class NotEnoughPositionException extends  Exception{
    public NotEnoughPositionException(){
        super("Not enough position.");
    }
}
