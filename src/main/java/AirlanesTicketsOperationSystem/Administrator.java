package AirlanesTicketsOperationSystem;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Administrator {
    /*public static void main(String[] args) {
        String username = "admin";
        String password = "admin123";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Witamy w panelu administracyjnym");

        System.out.println("Podaj login");
        String login = scanner.nextLine();

        System.out.println("Podaj hasło");
        String adminPassword = scanner.nextLine();

        if (login.equals(username) && adminPassword.equals(password)) {
            System.out.println("Logowanie udane!");
        } else {
            System.out.println("błąd logowania");
        }*/
        public static void wyswietlMenu() {
            Scanner input = new Scanner(System.in);

            System.out.println("Witaj w panelu administracyjnym linii lotniczych");
            System.out.println("1. Dodaj lot");
            System.out.println("2. Usuń lot");
            System.out.println("3. Zmień godzinę lotu");
            System.out.println("4. Zmień miejsce lotu");
            System.out.println("5. Dodaj asystenta");
            System.out.println("6. Usuń asystenta");
            System.out.println("7. Dodaj użytkownika");
            System.out.println("8. Usuń użytkownika");
            System.out.println("9. Wyjdź z programu");

            int wybor = input.nextInt();
            input.nextLine(); // konsumujemy znak nowej linii

            switch (wybor) {
                case 1:
                    //dodajLot();
                    break;
                case 2:
                    //usunLot();
                    break;
                case 3:
                    //zmienGodzineLotu();
                    break;
                case 4:
                    dodajAsystenta();
                    break;
                case 5:
                    usunAsystenta();
                    break;
                case 6:
                    dodajUzytkownika();
                    break;
                case 7:
                    usunUzytkownika();
                    break;
                case 8:
                    System.out.println("Do widzenia!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór!");
                    break;
            }

         //   wyswietlMenu();
        }

    private static void usunUzytkownika() {
    }

    private static void dodajUzytkownika() {

    }

    private static void usunAsystenta() {

    }

    private static void dodajAsystenta(){
            UserLoginSystem loginSystem = new UserLoginSystem();
            loginSystem.registerUser();
    }



    /*private static void zmienGodzineLotu() {
        Scanner input = new Scanner(System.in);

        System.out.println("Podaj nazwę lotu: ");
        String nazwaLotu = input.nextLine();

        System.out.println("Podaj nową godzinę wylotu (format HH:mm): ");
        String nowaGodzina = input.nextLine();

        for (Lot lot : listaLotow) {
            if (lot.getNazwa().equals(nazwaLotu)) {
                lot.setdepartureTime(nowaGodzina);
                System.out.println("Godzina wylotu dla lotu " + nazwaLotu + " została zmieniona na " + nowaGodzina);
                return;
            }
        }

        System.out.println("Nie znaleziono lotu o nazwie " + nazwaLotu);
    }

}

    private static void usunLot() {
        Scanner input = new Scanner(System.in);

        System.out.println("Podaj datę wylotu (format yyyy-MM-dd): ");
        String dataWylotu = input.nextLine();

        for (int i = 0; i < listaLotow.size(); i++) {
            Flight lot = listaLotow.get(i);
            if (lot.getDepartureTime().equals(dataWylotu)) {
                listaLotow.remove(i);
                System.out.println("Lot usunięty pomyślnie!");
                return;
            }
        }

        System.out.println("Nie znaleziono lotu o podanej dacie wylotu.");
    }

    private static void dodajLot() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj model samolotu: ");
        String model = scanner.nextLine();

        System.out.println("Podaj miejsce wylotu: ");
        String departureAirport = scanner.nextLine();

        System.out.println("Podaj miejsce docelowe: ");
        String arrivalAirport = scanner.nextLine();

        System.out.println("Podaj godzinę wylotu (format HH:mm): ");
        LocalDateTime departureTime = LocalDateTime.parse(scanner.nextLine());

        System.out.println("Podaj datę przylotu (format yyyy-MM-dd): ");
        LocalDateTime arrivalTime = LocalDateTime.parse(scanner.nextLine());

        System.out.println("Podaj ID lotu : ");
        int flightNumber = scanner.nextInt();

        Flight nowyLot = new Flight(model, departureAirport, arrivalAirport, departureTime, arrivalTime, flightNumber );
        listaLotow.add(nowyLot);

        System.out.println("Lot dodany pomyślnie!");
    }*/
}