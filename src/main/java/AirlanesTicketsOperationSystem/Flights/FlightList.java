package AirlanesTicketsOperationSystem.Flights;

import AirlanesTicketsOperationSystem.Flights.Flight;
import AirlanesTicketsOperationSystem.Flights.FlightsDatabaseWriter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightList {
    public static void main(String[] args) {
    List<Flight> flightsDatabase = new ArrayList<>();

    Flight flight1 = new Flight("LOT", 1234, "Warsaw Chopin Airport", "Heathrow Airport",
            LocalDateTime.of(2023, 5, 15, 12, 0),
            LocalDateTime.of(2023, 5, 15, 14, 30),
            100, 500.0, false);

        flightsDatabase.add(flight1);

    Flight flight2 = new Flight("Ryanair", 5678, "Modlin Airport", "Stansted Airport",
            LocalDateTime.of(2023, 5, 16, 8, 0),
            LocalDateTime.of(2023, 5, 16, 10, 30),
            80, 100.0, true);

        flightsDatabase.add(flight2);

    Flight flight3 = new Flight("Ryanair", 5678, "Modlin Airport", "Stansted Airport",
            LocalDateTime.of(2023, 5, 16, 8, 0),
            LocalDateTime.of(2023, 5, 16, 10, 30),
            80, 100.0, true);

        flightsDatabase.add(flight3);

//        flightsDatabase.remove(flight2);
// dodaj loty do bazy danych

        FlightsDatabaseWriter.writeFlightsDatabase(flightsDatabase, "flightsDatabase.txt");
    }
}

