package AirlanesTicketsOperationSystem;


import AirlanesTicketsOperationSystem.Flights.FlightsMethods;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        UserLoginSystem loginSystem = new UserLoginSystem();
        FlightsMethods flightsMethods = new FlightsMethods();


        loginSystem.loadUsersFromFile();
        flightsMethods.loadFlightsFromFile();
        menu.mainMenu();
    }
}
