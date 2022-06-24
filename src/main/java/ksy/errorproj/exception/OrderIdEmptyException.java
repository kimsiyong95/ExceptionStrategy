package ksy.errorproj.exception;

public class OrderIdEmptyException extends RuntimeException{


    public OrderIdEmptyException(){

    }

    public OrderIdEmptyException(String message) {
        super(message);
    }
}
