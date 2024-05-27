package org.organizzaeventi;

import org.organizzaeventi.exceptions.InvalidCapacityException;
import org.organizzaeventi.exceptions.InvalidDateException;
import org.organizzaeventi.exceptions.InvalidPriceException;
import org.organizzaeventi.exceptions.InvalidTitleException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{
//    ATTRIBUTI
    private LocalTime time;
    private BigDecimal price;
//COSTRUTTORE
    public Concert(String title, LocalDate date, int capacity, LocalTime time, BigDecimal price) throws InvalidTitleException, InvalidDateException, InvalidCapacityException {
        super(title, date, capacity);
        this.time = time;
        this.price = validatePrice(price);
        validateDateTime(date,time);
    }
//    METODI
//    Metodi getter e setter
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

//    Metodi validazione
    public void validateDateTime(LocalDate date, LocalTime time){
        if(date.isEqual(LocalDate.now()) && time.isBefore(LocalTime.now())){
            throw new InvalidDateException("L'orario inserito per l'evento" + time+ " non può essere antecedente all'orario di adesso " + LocalTime.now());
        }
    }
    public BigDecimal validatePrice(BigDecimal price){
        if(price.compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidPriceException("Il prezzo non può essere minore o uguale a zero.");
        }
        return price;
    }

}
