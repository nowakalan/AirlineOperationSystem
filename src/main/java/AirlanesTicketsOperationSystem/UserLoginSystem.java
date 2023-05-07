package AirlanesTicketsOperationSystem;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLoginSystem {
    private static final String USERS_FILE_PATH = "users.txt";
    private static Map<String, User> users = new HashMap<>();
    private User currentUser;
    Menu menu = new Menu();


    public void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                String password = parts[1];
                String status = parts[2];

                User user = new User(username, password, status);
                users.put(username, user);
            }

            System.out.println("Dane użytkowników zostały wczytane z pliku.");
        } catch (FileNotFoundException e) {
            System.out.println("Nie można znaleźć pliku.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytywania danych z pliku.");
        }
    }



    public void registerUser() {

        User admin = new User("admin", "admin", "admin");
        users.put("admin", admin);


        Scanner scanner = new Scanner(System.in);


        System.out.println("Rejestracja użytkownika");
        System.out.print("Podaj login: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Użytkownik o podanej nazwie już istnieje.");
            menu.mainMenu();
        }

        System.out.print("Podaj hasło: ");
        String password = scanner.nextLine();

        System.out.print("Podaj status (admin, assistant, client): ");
        String status = scanner.nextLine();



        if (username.isEmpty() || password.isEmpty() || status.isEmpty()) {
            System.out.println("Nazwa użytkownika i hasło nie mogą być puste");

        } else if (status.equals("admin")) {
            System.out.println("Nie można utworzyć konta administratora. Konto jest już utworzone.");

        } else if (status.equals("assistant")) {
            String adminUsername = "admin";
            String adminPassword = admin.getPassword();

            // Sprawdź, czy administrator istnieje
            if (adminPassword != null) {
                System.out.print("Podaj hasło administratora: ");
                String enteredAdminPassword = scanner.nextLine();

                // Sprawdź poprawność hasła administratora
                if (enteredAdminPassword.equals(adminPassword)) {
                    // Dodaj asystenta do mapy users
                    User newUser = new User(username, password, status);
                    users.put(username, newUser);
                    System.out.println("Konto asystenta zostało utworzone.");
                } else {
                    System.out.println("Nieprawidłowe hasło administratora. Nie można utworzyć konta asystenta.");
                }
            } else {
                System.out.println("Błąd: Konto administratora nie istnieje.");
            }
        } else if (status.equals("client")) {
            // Dodaj klienta do mapy users
            User newUser = new User(username, password, status);
            users.put(username, newUser);
            System.out.println("Konto klienta zostało utworzone.");
        } else {
            System.out.println("Nieprawidłowy status.");
        }

        saveUsersToFile(); // Zapisz użytkowników do pliku po rejestracji
        menu.mainMenu();
    }


    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", false))) {
            for (Map.Entry<String, User> entry : users.entrySet()) {
                String username = entry.getKey();
                User newUser = entry.getValue();

                writer.write(username + "," + newUser.getPassword() + "," + newUser.getStatus()); // Format: username,password,status
                writer.newLine();
            }
            writer.close();
            System.out.println("Dane użytkowników zostały zapisane do pliku.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania danych użytkowników do pliku.");
        }
    }

    public void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Logowanie użytkownika");
        System.out.print("Podaj login: ");
        String username = scanner.nextLine();

        System.out.print("Podaj hasło: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        // Sprawdź, czy użytkownik o podanej nazwie istnieje
        if (users.containsKey(username)) {
            // Sprawdź poprawność hasła
            if (user.getPassword().equals(password)) {
                System.out.println("Zalogowano użytkownika: " + username);

                // Pobierz status zalogowanego użytkownika
                String status = user.getStatus();

                // Wywołaj odpowiednią metodę w zależności od statusu
                if (status.equals("admin")) {
                    System.out.println("Jestes zalogowany jako ADMINISTRATOR");
                    Administrator administrator = new Administrator();
                    administrator.wyswietlMenu();
                } else if (status.equals("assistant")) {
                    System.out.println("Jestes zalogowany jako ASYSTENT");
                    Assistant assistant = new Assistant();
                    //assistant.menuAssistant();    TODO    //STWORZYC METODE WYSWIETLAJACA MENU DLA ASYSTENTA
                } else if (status.equals("client")) {
                    System.out.println("Jestes zalogowany jako klient");
                    Client client = new Client();
                    //client.menuClient();      TODO     //STWORZYC METODE WYSWIETLAJACA MENU DLA KLIENTA/PASAZERA
                } else {
                    System.out.println("Nieznany status użytkownika.");
                }
            } else {
                System.out.println("Nieprawidłowe hasło.");
                menu.mainMenu();
            }
        } else {
            System.out.println("Użytkownik o podanej nazwie nie istnieje.");
            menu.mainMenu();
        }
    }
}