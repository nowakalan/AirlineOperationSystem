package AirlanesTicketsOperationSystem;


public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        UserLoginSystem loginSystem = new UserLoginSystem();

        loginSystem.loadUsersFromFile();
        menu.mainMenu();
    }
}
