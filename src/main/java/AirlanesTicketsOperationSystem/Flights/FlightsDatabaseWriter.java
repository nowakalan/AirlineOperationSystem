package AirlanesTicketsOperationSystem.Flights;

import AirlanesTicketsOperationSystem.Flights.Flight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
public class FlightsDatabaseWriter {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static void writeFlightsDatabase(List<Flight> flightsDatabase, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
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
            System.out.println("Plik " + filePath + " został zapisany.");
        } catch (IOException e) {
            System.out.println("Nie udało się zapisać pliku " + filePath + ": " + e.getMessage());
        }
    }
}