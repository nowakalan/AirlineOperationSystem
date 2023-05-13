package AirlanesTicketsOperationSystem.Flights;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightsMethods {

    private static List<Flight> flightsDatabase = new ArrayList<>();

    // Metody umożliwiające dodawanie, edytowanie i usuwanie lotów z bazy danych
    public static void addFlightToDatabase(Flight flight) {
        flightsDatabase.add(flight);
        System.out.println("Lot został dodany do bazy");
    }

    public static void editFlightInDatabase(int flightNumber) {
        for (Flight flight : flightsDatabase) {
            if (flight.getFlightNumber() == flightNumber) {
                flight.setAirlineName(flight.getAirlineName());
                flight.setDepartureAirport(flight.getDepartureAirport());
                flight.setArrivalAirport(flight.getArrivalAirport());
                flight.setDepartureDateTime(flight.getDepartureDateTime());
                flight.setArrivalDateTime(flight.getArrivalDateTime());
                flight.setAvailableSeats(flight.getAvailableSeats());
                flight.setTicketPrice(flight.getTicketPrice());
                flight.setDelayed(flight.isDelayed());
                System.out.println("Lot z numerem " + flightNumber + " został edytowany");
                return;
            }
        }
        System.out.println("Lot z numerem " + flightNumber + " nie został znaleziony w bazie");
    }

    public static void removeFlightFromDatabase(int flightNumber) {
        for (int i = 0; i < flightsDatabase.size(); i++) {
            if (flightsDatabase.get(i).getFlightNumber() == flightNumber) {
                flightsDatabase.remove(i);
                System.out.println("Lot z numerem " + flightNumber + " został usunięty z bazy");
                return;
            }
        }
        System.out.println("Lot z numerem " + flightNumber + " nie został znaleziony w bazie");
    }

    // Metoda wyświetlająca informacje o locie
    public static void displayFlightInfo(Flight flight) {
        System.out.println("Numer lotu: " + flight.getFlightNumber());
        System.out.println("Linia lotnicza: " + flight.getAirlineName());
        System.out.println("Lotnisko odlotu: " + flight.getDepartureAirport());
        System.out.println("Lotnisko przylotu: " + flight.getArrivalAirport());
        System.out.println("Data i godzina odlotu: " + flight.getDepartureDateTime());
        System.out.println("Data i godzina przylotu: " + flight.getArrivalDateTime());
        System.out.println("Dostępne miejsca: " + flight.getAvailableSeats());
        System.out.println("Cena biletu: " + flight.getTicketPrice());
        System.out.println("Jest opóźniony: " + flight.isDelayed());
    }

    // Metoda zwracająca opóźnienie lotu w minutach
    public static int getDelayInMinutes(Flight flight) {
        if (flight.isDelayed()) {
            Duration delayDuration = Duration.between(flight.getDepartureDateTime(), flight.getArrivalDateTime());
            return (int) delayDuration.toMinutes();
        } else {
            return 0;
        }
    }

    // Metoda zwracająca czas trwania lotu w minutach
    public static int getFlightDurationInMinutes(Flight flight) {
        Duration flightDuration = Duration.between(flight.getDepartureDateTime(), flight.getArrivalDateTime());
        return (int) flightDuration.toMinutes();
    }

    // Metoda zwracająca czas od teraz do daty wylotu lotu w minutach
    public static int getTimeToDepartureInMinutes(Flight flight) {
        LocalDateTime now = LocalDateTime.now();
        Duration timeToDeparture = Duration.between(now, flight.getDepartureDateTime());
        return (int) timeToDeparture.toMinutes();
    }

    // Metoda zwracająca czas od teraz do daty przylotu lotu w minutach
    public static int getTimeToArrivalInMinutes(Flight flight) {
        LocalDateTime now = LocalDateTime.now();
        Duration timeToArrival = Duration.between(now, flight.getArrivalDateTime());
        return (int) timeToArrival.toMinutes();
    }
    // Metody umożliwiające rezerwację i odwołanie rezerwacji miejsc na locie
    public static void reserveSeats(int numSeatsToReserve, Flight flight) {
        if (numSeatsToReserve <= flight.getAvailableSeats()) {
            flight.setAvailableSeats(flight.getAvailableSeats() - numSeatsToReserve);
            System.out.println(numSeatsToReserve + " miejsce(a) zarezerwowane na lot " + flight.getFlightNumber());
        } else {
            System.out.println("Brak wystarczającej liczby miejsc na pokładzie samolotu " + flight.getFlightNumber());
        }
    }
    public static void cancelSeatReservation(int numSeatsToCancel, Flight flight) {
        if (numSeatsToCancel > 0) {
            flight.setAvailableSeats(flight.getAvailableSeats() + numSeatsToCancel);
            System.out.println(numSeatsToCancel + " miejsce(a) odwołane w locie " + flight.getFlightNumber());
        } else {
            System.out.println("Niewłaściwa liczba miejsc do anulowania");
        }
    }

    public static void displayFlightDetails(Flight flight) {
        System.out.println("Szczegóły lotu: ");
        System.out.println("Numer lotu: " + flight.getFlightNumber());
        System.out.println("Linia lotnicza: " + flight.getAirlineName());
        System.out.println("Lotnisko wylotu: " + flight.getDepartureAirport());
        System.out.println("Lotnisko przylotu: " + flight.getArrivalAirport());
        System.out.println("Data i czas wylotu: " + flight.getDepartureDateTime());
        System.out.println("Data i czas przylotu: " + flight.getArrivalDateTime());
        System.out.println("Dostępne miejsca: " + flight.getAvailableSeats());
        System.out.println("Cena biletu: " + flight.getTicketPrice());
        System.out.println("Czy lot opóźniony: " + flight.isDelayed());
    }

}
