package AirlanesTicketsOperationSystem;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLoginSystem {
    private static Map<String, String> users = new HashMap<>();
    Menu menu = new Menu();

    public void loadUsersFromFile() {


        try {
            File file = new File("/Users/alannowak/Desktop/JAVA/System-obslugi-biletow-lotniczych/src/main/java/AirlanesTicketsOperationSystem/users.txt");
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
        for (String key : users.keySet()) {
            System.out.println(key + " = " + users.get(key) + "\n");
        }
    }


    public void registerUser() {

        Scanner scanner = new Scanner(System.in);

                System.out.println("Rejestracja użytkownika");
                System.out.print("Podaj login: ");
                String username = scanner.nextLine();

                System.out.print("Podaj hasło: ");
                String password = scanner.nextLine();

                if (username.isEmpty() || password.isEmpty()) {
                    System.out.println("Nazwa użytkownika i hasło nie mogą być puste");
                    //throw new IllegalArgumentException("Nazwa użytkownika i hasło nie mogą być puste");
                }

                else if (users.containsKey(username)) {
                    System.out.println("Użytkownik o podanej nazwie już istnieje.");
                    //throw new IllegalArgumentException("Użytkownik o podanej nazwie już istnieje.");
                } else {
                    users.put(username, password);
                    System.out.println("Zarejestrowano użytkownika.");
                    System.out.println();
                    saveUsersToFile(); // Zapisz użytkowników do pliku po rejestracji
                }
            menu.mainMenu();
        }


        private void saveUsersToFile () {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/alannowak/Desktop/JAVA/System-obslugi-biletow-lotniczych/src/main/java/AirlanesTicketsOperationSystem/users.txt", false))) {
                for (Map.Entry<String, String> entry : users.entrySet()) {
                    String username = entry.getKey();
                    String password = entry.getValue();

                    writer.write(username + "," + password); // Format: login,hasło
                    writer.newLine();
                }
                    writer.close();
                System.out.println("Dane użytkowników zostały zapisane do pliku.");
            } catch (IOException e) {
                System.out.println("Wystąpił błąd podczas zapisywania danych użytkowników do pliku.");
            }
        }

        public void loginUser () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Logowanie użytkownika");
            System.out.print("Podaj login: ");
            String username = scanner.nextLine();

            System.out.print("Podaj hasło: ");
            String password = scanner.nextLine();

            // Logika logowania użytkownika
            // ... TODO

            System.out.println("Zalogowano użytkownika.");
            System.out.println();
        }
    }