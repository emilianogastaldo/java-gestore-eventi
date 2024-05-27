package org.organizzaeventi;

import org.organizzaeventi.exceptions.InvalidDateException;
import org.organizzaeventi.exceptions.InvalidSeatsException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ciao crea un nuovo evento! ");
        Event event = null;
        while (event == null){
            try{
            System.out.println("Inserisci il titolo dell'evento");
            String title = scanner.nextLine();
            System.out.println("Inserisci la quantità di persone dell'evento");
            int capacity = Integer.parseInt(scanner.nextLine());
            System.out.println("Inserisci la data dell'evento nel formato yyyy-mm-dd");
            LocalDate date = LocalDate.parse(scanner.nextLine());
            event = new Event(title, date, capacity);
            }catch (DateTimeException e){
                System.out.println("Formato della data errato! Deve essere yyyy-mm-dd.");
            }catch (NumberFormatException e) {
                System.out.println("Non puoi inserire una stringa come numero di posti");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
//        Event event = new Event("Pippo evento", LocalDate.parse("2024-06-02"), 100);

        System.out.println(event);
        boolean stopMenu = false;
        while (!stopMenu){
            System.out.println("Cosa vuoi fare? 1-prenotare 2-disdire 3-uscire");
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    bookOrCancelSeats(scanner, event, "prenotare");
                    break;
                case "2":
                    bookOrCancelSeats(scanner, event, "disdire");
                    break;
                case "3":
                    System.out.println("Ciao Ciao");
                    stopMenu = true;
                    break;
                default:
                    System.out.println("Input non valido, 1-prenotare 2-disdire 3-uscire");
                    break;
            }
        }
    }
    private static void bookOrCancelSeats(Scanner scanner, Event event, String action){
        System.out.println("Quanti posti vuoi " + (action.equals("prenotare") ? "prenotare?" : "disdire?"));
        int seat = 0;
        try{
            seat = Integer.parseInt(scanner.nextLine());
            if (action.equals("prenotare")){
                event.bookSeat(seat);
                System.out.println("Posti totali evento " + event.getCapacity() + ". Posti che hai prenotato " + seat + ". Posti rimasti "+(event.getCapacity() - event.getNumBooked())+".");
            }
            else{
                event.cancelSeat(seat);
                System.out.println("Posti totali evento " + event.getCapacity() + ". Posti che hai disdetto " + seat + ". Posti rimasti "+(event.getCapacity() - event.getNumBooked())+".");
            }
        } catch (NumberFormatException e){
            System.out.println("Non puoi inserire una stringa come numero di posti");
        } catch (InvalidSeatsException | InvalidDateException e){
            System.out.println(e.getMessage());
        }
    }
}