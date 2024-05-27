package org.organizzaeventi;

import org.organizzaeventi.exceptions.InvalidCapacityException;
import org.organizzaeventi.exceptions.InvalidDateException;
import org.organizzaeventi.exceptions.InvalidPriceException;
import org.organizzaeventi.exceptions.InvalidTitleException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
        validateDateTime(this.getDate(), time);
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = validatePrice(price);
    }

//    Metodi validazione
    public void validateDateTime(LocalDate date, LocalTime time){
        if(date.isEqual(LocalDate.now()) && time.isBefore(LocalTime.now())){
            throw new InvalidDateException("L'orario inserito per l'evento" + time+ " non può essere antecedente all'orario di adesso " + LocalTime.now());
        }
    }
    public BigDecimal validatePrice(BigDecimal price){
        if(price.compareTo(BigDecimal.ZERO) < 0){
            throw new InvalidPriceException("Il prezzo non può essere minore o uguale a zero.");
        }
        return price;
    }

    public String getFormattedDate(){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALIAN);
        return String.format(getDate().format(formatDate) + " - "+ getTime());
    }

    public String getFormattedPrice(){
        return String.format(getPrice().setScale(2, RoundingMode.HALF_EVEN) + "€");
    }

    public String toString(){
        return String.format(getFormattedDate()+" - "+getTitle()+" - "+getFormattedPrice());
    }

}
