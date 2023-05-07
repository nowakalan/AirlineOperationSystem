package AirlanesTicketsOperationSystem;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLoginSystem {
    private static Map<String, String> users = new HashMap<>();
    Menu menu = new Menu();
    public void userFileReader() {

        Map<String, String> users = new HashMap<>(); // Przechowuje pary login - hasło
        try {
            File file = new File("/Users/alannowak/Desktop/JAVA/Airlanes/src/main/java/AirlanesTicketsOperationSystem/users");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String username = parts[0];
                String password = parts[1];

                users.put(username, password);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie można znaleźć pliku.");
        }
    }


    public void registerUser(String username, String password) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Rejestracja użytkownika");
        System.out.print("Podaj login: ");
        username = scanner.nextLine();

        System.out.print("Podaj hasło: ");
        password = scanner.nextLine();

        users.put(username, password);

        // Logika rejestracji użytkownika
        // ... TODO

        System.out.println("Zarejestrowano użytkownika.");
        System.out.println();
        saveUsersToFile(); // Zapisz użytkowników do pliku po rejestracji
        menu.mainMenu();
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/alannowak/Desktop/JAVA/Airlanes/src/main/java/AirlanesTicketsOperationSystem/users", true))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                String username = entry.getKey();
                String password = entry.getValue();

                writer.write(username + "," + password); // Format: login,hasło
                writer.newLine();
                writer.close();
            }
            System.out.println("Dane użytkowników zostały zapisane do pliku.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania danych użytkowników do pliku.");
        }
    }

    public void loginUser(String username, String password) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Logowanie użytkownika");
        System.out.print("Podaj login: ");
        username = scanner.nextLine();

        System.out.print("Podaj hasło: ");
        password = scanner.nextLine();

        // Logika logowania użytkownika
        // ... TODO

        System.out.println("Zalogowano użytkownika.");
        System.out.println();
    }
}
