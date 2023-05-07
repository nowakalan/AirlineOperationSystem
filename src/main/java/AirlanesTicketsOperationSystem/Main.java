package AirlanesTicketsOperationSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        UserLoginSystem loginSystem = new UserLoginSystem();

        loginSystem.loadUsersFromFile();
        menu.mainMenu();
        List<Flight> flightsDatabase = new ArrayList<>();
// dodaj loty do bazy danych
        FlightsDatabaseWriter.writeFlightsDatabase(flightsDatabase, "flightsDatabase.txt");        }
}

