package AirlanesTicketsOperationSystem;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLoginSystem {
    private static final String USERS_FILE_PATH = "users.txt";
    private static Map<String, User> users = new HashMap<>();
    //private User loggedInUser;
    public String loggedInUsername;
    public User currentUser;
    public UserStatus loggedInUserStatus;


    public void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                String password = parts[1];
                String statusString = parts[2];

                UserStatus status = UserStatus.valueOf(statusString.toUpperCase());

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

        Menu menu = new Menu();
        User admin = new User("admin", "admin", UserStatus.ADMINISTRATOR);
        users.put("admin", admin);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Rejestracja użytkownika");
        System.out.print("Podaj login: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Użytkownik o podanej nazwie już istnieje.");
            registerUser();
        }

        System.out.print("Podaj hasło: ");
        String password = scanner.nextLine();

        System.out.print("Podaj status (assistant, client): ");
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
                    // Dodaj asystenta
                    User newUser = new User(username, password, UserStatus.ASSISTANT);
                    users.put(username, newUser);
                    System.out.println("Konto asystenta zostało utworzone.");
                    saveUsersToFile();
                } else {
                    System.out.println("Nieprawidłowe hasło administratora. Nie można utworzyć konta asystenta.");
                }
            } else {
                System.out.println("Błąd: Konto administratora nie istnieje.");
            }
        } else if (status.equals("client")) {
            // Dodaj clienta
            User newUser = new User(username, password, UserStatus.CLIENT);
            users.put(username, newUser);
            System.out.println("Konto klienta zostało utworzone.");
            saveUsersToFile();
        } else {
            System.out.println("Nieprawidłowy status.");
        }
        menu.mainMenu();
    }


    public void saveUsersToFile() {
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

    public User loginUser() {

        Menu menu = new Menu();
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
                loggedInUserStatus = user.getStatus();
                loggedInUsername = username;
                currentUser = user;


                // Wywołaj odpowiednią metodę w zależności od statusu
                if (loggedInUserStatus == UserStatus.ADMINISTRATOR) {
                    System.out.println("Witaj " + loggedInUsername + ". Jestes zalogowany jako ADMINISTRATOR");
                    menu.administratorMenu();
                } else if (loggedInUserStatus == UserStatus.ASSISTANT) {
                    System.out.println("Witaj " + loggedInUsername + ". Jestes zalogowany jako ASYSTENT");
                    menu.assistantMenu();
                    return currentUser;
                } else if (loggedInUserStatus == UserStatus.CLIENT) {
                    System.out.println("Witaj " + loggedInUsername + ". Jestes zalogowany jako klient");

                    //menu.clientMenu();     // TODO     //STWORZYC METODE WYSWIETLAJACA MENU DLA KLIENTA/PASAZERA
                    //updateUser(user.getUsername());
                    //saveUsersToFile();
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
        return user;
    }

    public void updateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aktualne dane użytkownika:");

        // Pobierz aktualne dane użytkownika
        currentUser = users.get(loggedInUsername);
        String currentUsername = currentUser.getUsername();
        String currentPassword = currentUser.getPassword();
        UserStatus currentStatus = currentUser.getStatus();

        System.out.println("Login: " + currentUsername);
        System.out.println("Hasło: " + currentPassword);
        System.out.println("Status: " + currentStatus);

        System.out.println("Co chcesz zmienić? (1 - login, 2 - hasło):");
        int choice = scanner.nextInt();

        // Zmiana loginu
        if (choice == 1) {
            scanner.nextLine();
            System.out.println("Podaj nowy login:");
            String newUsername = scanner.nextLine();

            if (users.containsKey(newUsername)) {
                System.out.println("Podany login już istnieje. Spróbuj ponownie.");
                updateUser(); // Wróć do początku metody
                return;
            }

            // Zaktualizuj dane użytkownika w mapie
            users.remove(loggedInUsername);
            users.put(newUsername, new User(newUsername, currentPassword, currentStatus));
            saveUsersToFile();
            System.out.println("Login został zmieniony na: " + newUsername);
        }
        // Zmiana hasła
        else if (choice == 2) {
            scanner.nextLine(); // Pobierz znak nowej linii po wczytaniu liczby
            System.out.println("Podaj nowe hasło:");
            String newPassword = scanner.nextLine();

            // Zaktualizuj dane użytkownika w mapie
            users.put(currentUsername, new User(currentUsername, newPassword, currentStatus));
            System.out.println("Hasło zostało zmienione.");
        } else {
            System.out.println("Nieprawidłowy wybór.");
        }
    }
}