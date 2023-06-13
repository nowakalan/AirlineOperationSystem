package AirlanesTicketsOperationSystem.Flights;

import AirlanesTicketsOperationSystem.*;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FlightsMethods {
    public static List<Flight> flightsDatabase = new ArrayList<>();
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    static Scanner scanner = new Scanner(System.in);
    User user = new User();
    UserLoginSystem userLoginSystem = new UserLoginSystem();


    public void addFlightToDatabase() {

        System.out.print("Airline Name: ");
        String airlineName = scanner.nextLine();

        System.out.print("Flight Number: ");
        int flightNumber = scanner.nextInt();
        if (flightsDatabase.contains(flightNumber)) {
            System.out.println("Lot o podanym numerze juz istnieje.");
            addFlightToDatabase();
        } else {

            System.out.print("Departure Airport: ");
            String departureAirport = scanner.nextLine();

            System.out.print("Arrival Airport: ");
            String arrivalAirport = scanner.nextLine();

            System.out.print("Departure Date and Time (yyyy-MM-dd HH:mm): ");
            String departureDateTimeStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime departureDateTime = null;

            try {
                departureDateTime = LocalDateTime.parse(departureDateTimeStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Niepoprawny format daty i czasu. Spróbuj ponownie.");
                addFlightToDatabase();
            }

            System.out.print("Arrival Date and Time (yyyy-MM-dd HH:mm): ");
            String arrivalDateTimeStr = scanner.nextLine();
            LocalDateTime arrivalDateTime = null;

            try {
                arrivalDateTime = LocalDateTime.parse(arrivalDateTimeStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Niepoprawny format daty i czasu. Spróbuj ponownie.");
                addFlightToDatabase();
            }
            if (arrivalDateTime.isBefore(departureDateTime)) {
                System.out.println("Data przylotu nie moze byc wczesniejsza niz data wylotu. Wprowadz poprawne dane.");
                addFlightToDatabase();

            } else if (departureDateTime.isBefore(LocalDateTime.now())) {
                System.out.println("Data wylotu nie moze byc wczesniejsza niz aktualny czas. Wprowadz poprawne dane.");
                addFlightToDatabase();

            } else {
                System.out.print("Available Seats: ");
                int availableSeats = scanner.nextInt();

                System.out.print("Ticket Price: ");
                double ticketPrice = scanner.nextDouble();

                System.out.print("Is Delayed (true/false): ");
                boolean isDelayed = scanner.nextBoolean();

                Flight flight = new Flight(airlineName, flightNumber, departureAirport, arrivalAirport,
                        departureDateTime, arrivalDateTime, availableSeats, ticketPrice, isDelayed);
                flightsDatabase.add(flight);
                System.out.println("Lot o numerze " + flightNumber + " został dodany bazy");
            }
        }
    }

    public void saveFlightsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("flightsDatabase.txt"))) {
            for (Flight flight : flightsDatabase) {
                writer.write(flight.getAirlineName() + ";");
                writer.write(flight.getFlightNumber() + ";");
                writer.write(flight.getDepartureAirport() + ";");
                writer.write(flight.getArrivalAirport() + ";");
                writer.write(flight.getDepartureDateTime().format(DATE_TIME_FORMATTER) + ";");
                writer.write(flight.getArrivalDateTime().format(DATE_TIME_FORMATTER) + ";");
                writer.write(flight.getAvailableSeats() + ";");
                writer.write(flight.getTicketPrice() + ";");
                writer.write(flight.isDelayed() + "\n");
            }
            System.out.println("Dane zostały zapisane do pliku.");
        } catch (IOException e) {
            System.out.println("Nie udało się zapisać pliku" + e.getMessage());
        }
    }
    public void editFlightInDatabase() {
        System.out.print("Podaj numer lotu, który chcesz edytować: ");
        int flightNumber = scanner.nextInt();
        scanner.nextLine();

        int index = -1;
        for (int i = 0; i < flightsDatabase.size(); i++) {
            if (flightsDatabase.get(i).getFlightNumber() == flightNumber) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Nie znaleziono lotu o podanym numerze.");
            return;
        }

        Flight flight = flightsDatabase.get(index);
        try {
            System.out.println("1. Change airline name");
            System.out.println("2. Change departure airport");
            System.out.println("3. Change arrival airport");
            System.out.println("4. Change departure date time");
            System.out.println("5. Change arrival date time");
            System.out.println("6. Change available seats");
            System.out.println("7. Change ticket price");
            System.out.println("8. Change delayed information");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nowa nazwa linii lotniczej: ");
                    String airline = scanner.nextLine();
                    flight.setAirlineName(airline);
                    break;
                case 2:
                    System.out.print("Nowe lotnisko wylotu: ");
                    String departureAirport = scanner.nextLine();
                    flight.setDepartureAirport(departureAirport);
                    break;
                case 3:
                    System.out.print("Nowe lotnisko przylotu: ");
                    String arrivalAirport = scanner.nextLine();
                    flight.setArrivalAirport(arrivalAirport);
                    break;
                case 4:
                    System.out.print("Nowa data i czas wylotu (yyyy-MM-dd HH:mm): ");
                    String departureDateTimeStr = scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime departureDateTime = LocalDateTime.parse(departureDateTimeStr, formatter);
                    flight.setDepartureDateTime(departureDateTime);
                    break;
                case 5:
                    System.out.print("Nowa data i czas przylotu (yyyy-MM-dd HH:mm): ");
                    String arrivalDateTimeStr = scanner.nextLine();
                    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDateTimeStr, formatter);
                    flight.setArrivalDateTime(arrivalDateTime);
                    break;
                case 6:
                    System.out.print("Nowa liczba dostępnych miejsc: ");
                    int availableSeats = scanner.nextInt();
                    flight.setAvailableSeats(availableSeats);
                    break;
                case 7:
                    System.out.print("Nowa cena biletu: ");
                    double ticketPrice = scanner.nextDouble();
                    flight.setTicketPrice(ticketPrice);
                    break;
                case 8:
                    System.out.print("Czy lot został opóźniony (true/false): ");
                    boolean delayed = scanner.nextBoolean();
                    flight.setDelayed(delayed);
                    break;
                default:
                    System.out.println("Niepoprawna opcja.");
                    return;
            }
            System.out.println("Lot został zaktualizowany.");

        } catch (InputMismatchException e) {
            System.out.println("Niepoprawny format danych wejściowych.");
        } catch (DateTimeParseException e) {
            System.out.println("Niepoprawny format daty i czasu.");
        } finally {
            scanner.nextLine();
        }
    }
    public void removeFlightFromDatabase() {
        System.out.print("Podaj numer lotu, który chcesz usunąć: ");
        int flightNumber = scanner.nextInt();
        boolean flightRemoved = false;

        for (int i = 0; i < flightsDatabase.size(); i++) {
            if (flightsDatabase.get(i).getFlightNumber() == flightNumber) {
                flightsDatabase.remove(i);
                flightRemoved = true;
                break;
            }
        }

        if (flightRemoved) {
            System.out.println("Lot o numerze " + flightNumber + " został usunięty z bazy");
        } else {
            System.out.println("Lot o numerze " + flightNumber + " nie został znaleziony w bazie");
        }
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

    public void displayFlights() {
        for (Flight flight : flightsDatabase) {
            System.out.println("Airline:           " + flight.getAirlineName());
            System.out.println("Flight number:     " + flight.getFlightNumber());
            System.out.println("Departure airport: " + flight.getDepartureAirport());
            System.out.println("Arrival airport:   " + flight.getArrivalAirport());
            System.out.println("Departure time:    " + flight.getDepartureDateTime());
            System.out.println("Arrival time:      " + flight.getArrivalDateTime());
            System.out.println("avaible seats:     " + flight.getAvailableSeats());
            System.out.println("Ticket price:      " + flight.getTicketPrice());
            System.out.println("Is delayed?        " + flight.isDelayed());
            System.out.println("------------------------------------------------");
        }
    }
    public void loadFlightsFromFile() {
        try {
            File file = new File("/Users/alannowak/Desktop/JAVA/System-obslugi-biletow-lotniczych/flightsDatabase.txt");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");

                // Tworzenie obiektu Flight na podstawie danych z pliku
                String airlineName = parts[0];
                int flightNumber = Integer.parseInt(parts[1]);
                String departureAirport = parts[2];
                String arrivalAirport = parts[3];
                String departureDateTimeStr = parts[4];
                String arrivalDateTimeStr = parts[5];
                int availableSeats = Integer.parseInt(parts[6]);
                double ticketPrice = Double.parseDouble(parts[7]);
                boolean isDelayed = Boolean.parseBoolean(parts[8]);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime departureDateTime = LocalDateTime.parse(departureDateTimeStr, formatter);
                LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDateTimeStr, formatter);

                Flight flight = new Flight(airlineName, flightNumber, departureAirport, arrivalAirport,
                        departureDateTime, arrivalDateTime, availableSeats, ticketPrice, isDelayed);
                flightsDatabase.add(flight);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Nie można znaleźć pliku.");
        }
    }
}
