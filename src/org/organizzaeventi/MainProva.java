package org.organizzaeventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class MainProva {
    public static void main(String[] args) {
        Concert concerto0 = new Concert("Pippo1", LocalDate.parse("2025-11-11"), 100, LocalTime.parse("21:00"), BigDecimal.valueOf(20.99));
        Concert concerto1 = new Concert("Pippo2", LocalDate.parse("2025-11-11"), 100, LocalTime.parse("21:00"), BigDecimal.valueOf(20.99));
        Concert concerto2 = new Concert("Pippo3", LocalDate.parse("2025-11-11"), 100, LocalTime.parse("21:00"), BigDecimal.valueOf(20.99));
        Concert concerto3 = new Concert("Pippo4", LocalDate.parse("2025-12-11"), 100, LocalTime.parse("21:00"), BigDecimal.valueOf(20.99));
        Concert concerto4 = new Concert("Pippo", LocalDate.parse("2025-12-11"), 100, LocalTime.parse("21:00"), BigDecimal.valueOf(20.99));
        Concert concerto5 = new Concert("Pippo34", LocalDate.parse("2025-11-11"), 100, LocalTime.parse("21:00"), BigDecimal.valueOf(20.99));
        Concert concerto6 = new Concert("Pippo23", LocalDate.parse("2025-11-11"), 100, LocalTime.parse("21:00"), BigDecimal.valueOf(20.99));
        /*System.out.println(concerto6.getFormattedDate());
        System.out.println(concerto6.getFormattedPrice());
        System.out.println(concerto6);*/
        ProgramEvents events = new ProgramEvents("Prove pippo");
        events.addEvent(concerto0);
        events.addEvent(concerto1);
        events.addEvent(concerto2);
        events.addEvent(concerto3);
        events.addEvent(concerto4);
        events.addEvent(concerto5);
        events.addEvent(concerto6);

        System.out.println(events.getEventsByDate(LocalDate.parse("2025-11-11")));
        System.out.println("Numero di eventi nel programma: " + events.getNumProgrammEvents());
        System.out.println(events);
        /*events.deleteAll();
        System.out.println("Numero di eventi nel programma: " + events.getNumProgrammEvents());*/
    }
}
