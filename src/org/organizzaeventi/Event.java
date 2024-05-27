package org.organizzaeventi;

import org.organizzaeventi.exceptions.InvalidCapacityException;
import org.organizzaeventi.exceptions.InvalidDateException;
import org.organizzaeventi.exceptions.InvalidSeatsException;
import org.organizzaeventi.exceptions.InvalidTitleException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Event {
// ATTRIBUTI
    private String title;
    private LocalDate date;
    private int capacity;
    private int numBooked;
// COSTRUTTORI
    Event(String title, LocalDate date, int capacity) throws InvalidTitleException, InvalidDateException, InvalidCapacityException {
        this.title = validateTitle(title);
        this.date = validateDate(date);
        this.capacity = validateCapacity(capacity);
        this.numBooked = 0;
    }
//  METODI
//    Getter e setter

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumBooked() {
        return numBooked;
    }

    public void setTitle(String title) throws InvalidTitleException{
        this.title = validateTitle(title);
    }

    public void setDate(LocalDate date) throws InvalidDateException{
        this.date = validateDate(date);
    }
// Metodi della milestone
//    Metodo prenota
    public void bookSeat(int num) throws InvalidSeatsException, InvalidDateException{
        if(num <= 0){
            throw new InvalidSeatsException("I posti che vuoi prenotare non possono essere uguali o inferiori a zero.");
        }
        if(num + numBooked > capacity){
            throw new InvalidSeatsException("Sono rimasti " + (capacity - numBooked) +" biglietti. Hai provato a prenotare "+num+" biglietti.");
        }
        if(this.date.isBefore(LocalDate.now())){
            throw new InvalidDateException("L'evento è scaduto");
        }
        this.numBooked += num;
    }
//    Metodo disdici
    public void cancelSeat(int num) throws InvalidSeatsException, InvalidDateException{
        if(num <= 0){
            throw new InvalidSeatsException("I posti che vuoi disdire non possono essere uguali o inferiori a zero.");
        }
        if(numBooked - num < 0){
            throw new InvalidSeatsException("Ci sono " + numBooked + " posti prenotati. Non puoi cancellare "+num+" posti.");
        }
        if(this.date.isBefore(LocalDate.now())){
            throw new InvalidDateException("L'evento è scaduto");
        }
        this.numBooked -= num;
    }
    //    Metodi di controllo
    private LocalDate validateDate (LocalDate date) throws InvalidDateException{
        if(date==null||date.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La data inserita " + date +" non può essere antecedente a quella odierna "+LocalDate.now());
        }
        return date;
    }

    private int validateCapacity (int num) throws InvalidCapacityException{
        if (num <=0 ){
            throw new InvalidCapacityException("La capacità dell'evento non può essere uguale o inferiore a zero.");
        }
        return num;
    }

    private String validateTitle (String title) throws InvalidTitleException{
        if(title == null || title.isEmpty() || title.equals(" ")){
            throw new InvalidTitleException("L'evento deve avere un titolo");
        }
        return title;
    }
//    Metodi override
    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALIAN);
        return String.format(date.format(formatter) + " - "+ title);
    }
}
