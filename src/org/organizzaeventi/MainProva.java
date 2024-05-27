package org.organizzaeventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class MainProva {
    public static void main(String[] args) {
        Concert concerto = new Concert("Pippo", LocalDate.parse("2025-11-11"), 100, LocalTime.parse("21:00"), BigDecimal.valueOf(20.99));
        System.out.println(concerto.getFormattedDate());
        System.out.println(concerto.getFormattedPrice());
        System.out.println(concerto);
    }
}
