package AirlanesTicketsOperationSystem;

import java.util.Scanner;

public class Menu {
    protected void mainMenu(){
        UserLoginSystem loginSystem = new UserLoginSystem();
        Scanner scanner = new Scanner(System.in);

        loginSystem.userFileReader();  // wczytywanie uzytkownikow z pliku do hashMap
        try {


            System.out.println("Wybierz opcję:");
            System.out.println("1. Logowanie");
            System.out.println("2. Rejestracja");
            System.out.println("3. Wyjście");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Pobranie znaku nowej linii po wprowadzeniu liczby

            switch (choice) {
                case 1:
                    loginSystem.loginUser("username", "password");
                    break;
                case 2:
                    loginSystem.registerUser("username", "password");
                    break;
                case 3:
                    System.exit(100);
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Wybierz ponownie.");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Wybierz ponownie");
            mainMenu();
        }

    }

}
