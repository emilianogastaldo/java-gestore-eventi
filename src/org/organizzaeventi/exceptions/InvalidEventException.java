package org.organizzaeventi.exceptions;

public class InvalidEventException extends IllegalArgumentException{
    public InvalidEventException(String s){
        super(s);
    }
}
