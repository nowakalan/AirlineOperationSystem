package AirlanesTicketsOperationSystem;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;// Klasa Flight - przechowująca informacje o locie
public class Flight {
    private String airlineName;
    private int flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private int availableSeats;
    private double ticketPrice;
    private boolean isDelayed;
    public Flight(String airlineName, int flightNumber, String departureAirport,
                  String arrivalAirport, LocalDateTime departureDateTime,
                  LocalDateTime arrivalDateTime, int availableSeats,
                  double ticketPrice, boolean isDelayed) {
        this.airlineName = airlineName;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
        this.isDelayed = isDelayed;
    }

    public Flight() {

    }

    public String getAirlineName() {
        return airlineName;
    }    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }    public int getFlightNumber() {
        return flightNumber;
    }    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }    public String getDepartureAirport() {
        return departureAirport;
    }    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }    public String getArrivalAirport() {
        return arrivalAirport;
    }    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }    public int getAvailableSeats() {
        return availableSeats;
    }    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }    public double getTicketPrice() {
        return ticketPrice;
    }    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }    public boolean isDelayed() {
        return isDelayed;
    }    public void setDelayed(boolean delayed) {
        isDelayed = delayed;
    }    // Metody umożliwiające dodawanie, edytowanie i usuwanie lotów z bazy danych
    public void addFlightToDatabase(List<Flight> flightsDatabase) {
        flightsDatabase.add(this);
        System.out.println("Lot został dodany do bazy");
    }
    public void editFlightInDatabase(List<Flight> flightsDatabase, int flightNumber) {
        for (Flight flight : flightsDatabase) {
            if (flight.getFlightNumber() == flightNumber) {
                flight.setAirlineName(this.getAirlineName());
                flight.setDepartureAirport(this.getDepartureAirport());
                flight.setArrivalAirport(this.getArrivalAirport());
                flight.setDepartureDateTime(this.getDepartureDateTime());
                flight.setArrivalDateTime(this.getArrivalDateTime());
                flight.setAvailableSeats(this.getAvailableSeats());
                flight.setTicketPrice(this.getTicketPrice());
                flight.setDelayed(this.isDelayed());
                System.out.println("Lot z numerem " + flightNumber + " został edytowany");
                return;
            }
        }
        System.out.println("Lot z numerem " + flightNumber + " nie został znaleziony w bazie");
    }
    public void removeFlightFromDatabase(List<Flight> flightsDatabase, int flightNumber) {
        for (int i = 0; i < flightsDatabase.size(); i++) {
            if (flightsDatabase.get(i).getFlightNumber() == flightNumber) {
                flightsDatabase.remove(i);
                System.out.println("Lot z numerem " + flightNumber + " został usunięty z bazy");
                return;
            }
        }
        System.out.println("Lot z numerem " + flightNumber + " nie został znaleziony w bazie");
    }    // Metoda wyświetlająca informacje o locie
    public void displayFlightInfo() {
        System.out.println("Numer lotu: " + this.flightNumber);
        System.out.println("Linia lotnicza: " + this.airlineName);
        System.out.println("Lotnisko odlotu: " + this.departureAirport);
        System.out.println("Lotnisko przylotu: " + this.arrivalAirport);
        System.out.println("Data i godzina odlotu: " + this.departureDateTime);
        System.out.println("Data i godzina przylotu: " + this.arrivalDateTime);
        System.out.println("Dostępne miejsca: " + this.availableSeats);
        System.out.println("TCena biletu: " + this.ticketPrice);
        System.out.println("Jest opóźniony: " + this.isDelayed);
    }    // Metoda zwracająca opóźnienie lotu w minutach
    public int getDelayInMinutes() {
        if (isDelayed) {
            Duration delayDuration = Duration.between(departureDateTime, arrivalDateTime);
            return (int) delayDuration.toMinutes();
        } else {
            return 0;
        }
    }    // Metoda zwracająca czas trwania lotu w minutach
    public int getFlightDurationInMinutes() {
        Duration flightDuration = Duration.between(departureDateTime, arrivalDateTime);
        return (int) flightDuration.toMinutes();
    }    // Metoda zwracająca czas od teraz do daty wylotu lotu w minutach
    public int getTimeToDepartureInMinutes() {
        LocalDateTime now = LocalDateTime.now();
        Duration timeToDeparture = Duration.between(now, departureDateTime);
        return (int) timeToDeparture.toMinutes();
    }    // Metoda zwracająca czas od teraz do daty przylotu lotu w minutach
    public int getTimeToArrivalInMinutes() {
        LocalDateTime now = LocalDateTime.now();
        Duration timeToArrival = Duration.between(now, arrivalDateTime);
        return (int) timeToArrival.toMinutes();
    }
    // Metody umożliwiające rezerwację i odwołanie rezerwacji miejsc na locie
    public void reserveSeats(int numSeatsToReserve) {
        if (numSeatsToReserve <= availableSeats) {
            availableSeats -= numSeatsToReserve;
            System.out.println(numSeatsToReserve + " miejsce(a) zarezerwowane na lot " + flightNumber);
        } else {
            System.out.println("Brak wystarczającej liczby miejsc na pokładzie samolotu " + flightNumber);
        }
    }
    public void cancelSeatReservation(int numSeatsToCancel) {
        if (numSeatsToCancel > 0) {
            availableSeats += numSeatsToCancel;
            System.out.println(numSeatsToCancel + " miejsce(a) odwołane w locie " + flightNumber);
        } else {
            System.out.println("Niewłaściwa liczba miejsc do anulowania");
        }
    }    public void displayFlightDetails() {
    }
}