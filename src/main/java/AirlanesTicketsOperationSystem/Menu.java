package AirlanesTicketsOperationSystem;

import AirlanesTicketsOperationSystem.Flights.FlightsMethods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    UserLoginSystem userLoginSystem = new UserLoginSystem();
    FlightsMethods flightsMethods = new FlightsMethods();

    protected void mainMenu(){
        UserLoginSystem loginSystem = new UserLoginSystem();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Logowanie");
            System.out.println("2. Rejestracja");
            System.out.println("3. Wyjście");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    loginSystem.loginUser();
                    break;
                case 2:
                    loginSystem.registerUser();
                    break;
                case 3:
                    System.exit(100);
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Wybierz ponownie.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Nieprawidłowy wybór. Wybierz ponownie");
            mainMenu();
        }
    }

    public void administratorMenu() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("1. Dodaj lot");
            System.out.println("2. Usuń lot");
            System.out.println("3. Edytuj lot");
            System.out.println("4. Wyswietl liste lotow");
            System.out.println("5. Dodaj asystenta");
            System.out.println("6. Wyjdź z programu");

            int choose = input.nextInt();
            input.nextLine();

            switch (choose) {
                case 1:
                    flightsMethods.addFlightToDatabase();
                    flightsMethods.saveFlightsToFile();
                    administratorMenu();
                    break;
                case 2:
                    flightsMethods.removeFlightFromDatabase();
                    flightsMethods.saveFlightsToFile();
                    administratorMenu();
                    break;
                case 3:
                    flightsMethods.editFlightInDatabase();
                    flightsMethods.saveFlightsToFile();
                    administratorMenu();
                    break;
                case 4:
                    flightsMethods.displayFlights();
                    administratorMenu();
                    break;
                case 5:
                    userLoginSystem.registerUser();
                    administratorMenu();
                    break;
                case 6:
                    System.out.println("Do widzenia!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Nieprawidłowy wybór. Wybierz ponownie");
            administratorMenu();
        }
    }
    public void assistantMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("1. Wyswietl liste lotow");
        System.out.println("2. Edytuj lot");
        System.out.println("3. Odwolaj lot");
        System.out.println("4. Ustaw info o opoznieniu");
        System.out.println("5. Zmien swoje dane logowania");
        System.out.println("6. Wyjdź z programu");

        int choose = input.nextInt();
        input.nextLine();

        switch (choose) {
            case 1:
                flightsMethods.displayFlights();
                assistantMenu();
                break;
            case 2:
                //flight.editFlightInDatabase(flightDatabase);
                break;
            case 3:
                //flight.removeFlightFromDatabase();
                break;
            case 4:
                //flight.setDelayed();
                break;
            case 5:
                userLoginSystem.updateUser();
                assistantMenu();
                break;
            case 6:
                System.out.println("Do widzenia!");
                System.exit(0);
                break;
            default:
                System.out.println("Nieprawidłowy wybór!");
                break;
        }
    }

    public void clientMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("1. Wyswietl liste lotow");
        System.out.println("2. Kup bilet");
        System.out.println("3. Eksportuj bilet do pliku");
        System.out.println("4. Dodaj srodki do swojego portfela");
        System.out.println("5. Zwroc bilet");
        System.out.println("6. Skontaktuj sie z asystentem");
        System.out.println("7. Zmien swoje dane logowania");
        System.out.println("8. Wyjdź z programu");

        int choose = input.nextInt();
        input.nextLine();

        switch (choose) {
            case 1:
                //flight.displayFlightDetails();
                break;
            case 2:
                //TODO
                break;
            case 3:
                //TODO
                break;
            case 4:
                //TODO
                break;
            case 5:
                //TODO
                break;
            case 6:
                //TODO
                break;
            case 7:
                userLoginSystem.updateUser();
                clientMenu();
                break;
            case 8:
                System.out.println("Do widzenia!");
                System.exit(0);
                break;
            default:
                System.out.println("Nieprawidłowy wybór!");
                break;
        }
    }
}
