package AirlanesTicketsOperationSystem;

import java.util.Scanner;


public class Administrator {

    private UserLoginSystem loginSystem;

    UserLoginSystem userLoginSystem = new UserLoginSystem();
    Flight flight = new Flight();






        public void administratorMenu() {
            Scanner input = new Scanner(System.in);


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
                    //flight.addFlightToDatabase(flightDatabase);
                    break;
                case 2:
                    //flight.removeFlightFromDatabase(flightsDatabase);
                    break;
                case 3:
                    //flight.editFlightInDatabase(flightDatabase);
                    break;
                case 4:
                    //flight.displayFlightDetails();
                    break;
                case 5:
                    userLoginSystem.registerUser();
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
}