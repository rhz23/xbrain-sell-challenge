package com.rzaninelli.xbrain_sell_challenge.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found exception . Id " + id );
    }

}
