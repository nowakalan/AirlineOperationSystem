package AirlanesTicketsOperationSystem;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu menu = new Menu();
        UserLoginSystem loginSystem = new UserLoginSystem();

        loginSystem.loadUsersFromFile();
        menu.mainMenu();


    }
}
