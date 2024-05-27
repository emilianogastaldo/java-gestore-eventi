package organizzaeventi;

import java.time.LocalDate;

public class Event {
// ATTRIBUTI
    private String title;
    private LocalDate date;
    private int capacity;
    private int numBooked;
// COSTRUTTORI
    Event(String title, LocalDate date, int capacity) throws InvalidTitleException, InvalidDateException, InvalidCapacityException{
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
    public void bookSeat(int num){
        if(num <= 0){
            throw new InvalidBookSeatsException("Reserved seats can't be equal or less to zero");
        }
        if(num + numBooked > capacity){
            throw new InvalidBookSeatsException("There are only " + (capacity - numBooked) +" tickets left. You tried to book "+num+" tickets");
        }
        if(numBooked == capacity){
            throw new InvalidBookSeatsException("There aren't any seats left");
        }
        this.numBooked += num;
    }
//    Metodo disdici
    public void cancelSeat(int num){

    }
    //    Metodi di controllo
    private LocalDate validateDate (LocalDate date) throws InvalidDateException{
        if(date==null||date.isBefore(LocalDate.now())) {
            throw new InvalidDateException("Invalid date: " + date);
        }
        return date;
    }

    private int validateCapacity (int num) throws InvalidCapacityException{
        if (num <=0 ){
            throw new InvalidCapacityException("Capacity can't be less or equal to zero");
        }
        return num;
    }

    private String validateTitle (String title) throws InvalidTitleException{
        if(title == null || title.isEmpty() || title.equals(" ")){
            throw new InvalidTitleException("The title cannot be null or empty");
        }
        return title;
    }
}
