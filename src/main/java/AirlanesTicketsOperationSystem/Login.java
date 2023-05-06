package AirlanesTicketsOperationSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
    private Map<String, String> users; // Przechowuje pary login - hasło    public UserLoginSystem() {
    users = new HashMap<String, String>();
    public void registerUser(String username, String password) {
    users.put(username, password);
    System.out.println("Uzytkownik zarejestrowany.");
        private void saveUsersToFile() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))) {
                for (Map.Entry<String, String> entry : users.entrySet()) {
                    String username = entry.getKey();
                    String password = entry.getValue();                writer.write(username + "," + password); // Format: login,hasło
                    writer.newLine();
                }
                System.out.println("Dane użytkowników zostały zapisane do pliku.");
            } catch (IOException e) {
                System.out.println("Wystąpił błąd podczas zapisywania danych użytkowników do pliku.");
            }
        }

}    public void login(String username, String password) {
    if (users.containsKey(username)) {
        String storedPassword = users.get(username);
        if (password.equals(storedPassword)) {
            System.out.println("Zalogowano pomyślnie.");
            // Tutaj można wykonać odpowiednie akcje po zalogowaniu
        } else {
            System.out.println("Niepoprawne hasło.");
        }
    } else {
        System.out.println("Użytkownik o podanym loginie nie istnieje.");
    }
}    public static void main(String[] args) {
    UserLoginSystem loginSystem = new UserLoginSystem();
    loginSystem.registerUser("jan123", "haslo123");
            loginSystem.login("jan123", "haslo123"); // Poprawne logowanie
                    loginSystem.login("jan123", "niepoprawnehaslo"); // Niepoprawne hasło
    loginSystem.login("anna456", "haslo456"); // Użytkownik nie istnieje
}
}



