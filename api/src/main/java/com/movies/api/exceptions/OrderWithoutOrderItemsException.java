package com.movies.api.exceptions;

public class OrderWithoutOrderItemsException extends RuntimeException{
    public OrderWithoutOrderItemsException(String message){
        super(message);
    }
}
