package org.organizzaeventi;

import org.organizzaeventi.exceptions.InvalidTitleException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProgramEvents {
//  ATTRIBUTI
    private String title;
    private List<Event> events;
//  COSTRUTTORI
    public ProgramEvents(String title) {
        this.title = validateTitle(title);
        this.events = new ArrayList<>();
    }
//  METODI
//  Metodi getter e setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = validateTitle(title);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
//  Metodo per validare il titolo
    private String validateTitle (String title) throws InvalidTitleException {
        if(title == null || title.isEmpty() || title.equals(" ")){
            throw new InvalidTitleException("L'evento deve avere un titolo");
        }
        return title;
    }
//  Metodo per aggiungere un evento
    public void addEvent(Event e){
        this.events.add(e);
    }
//  Metodo per la lista di eventi in una certa data
    public String getEventsByDate(LocalDate date){
        String message = "Eventi che sono in data " + date + ":\n";
        for(Event e: this.events){
            if(e.getDate().isEqual(date)){
                message += e.getTitle() + "\n";
            }
        }
        return message;
    }
//  Metodo che restituisce quanti eventi ci sono in programma
    public int getNumProgrammEvents(){
        return this.events.size();
    }
//  Metodo per svuotare la lista eventi
    public void deleteAll(){
        this.events.clear();
    }

    public String toString(){
        Collections.sort(events);
        String message = "";
        for(Event e : this.events){
            message += e.getDate() +" - " + e.getTitle() + "\n";
        }
        return message;
    }
}
