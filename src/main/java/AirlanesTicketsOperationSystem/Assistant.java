package AirlanesTicketsOperationSystem;

import java.util.Scanner;

 public class Assistant {



         UserLoginSystem userLoginSystem = new UserLoginSystem();
         Flight flight = new Flight();



     public void assistantMenu() {
             Scanner input = new Scanner(System.in);

             System.out.println("1. Wyswietl liste lotow");
             System.out.println("2. Edytuj lot");
             System.out.println("3. Odwolaj lot");
             System.out.println("4. Ustaw info o opoznieniu");
             System.out.println("5. Zmien swoje dane logowania");
             System.out.println("6. Wyjdź z programu");

             int choose = input.nextInt();
             input.nextLine();

             switch (choose) {
                 case 1:
                     //flight.displayFlightDetails();
                     break;
                 case 2:
                     //flight.editFlightInDatabase(flightDatabase);
                     break;
                 case 3:
                     //flight.removeFlightFromDatabase();
                     break;
                 case 4:
                     //flight.setDelayed();
                     break;
                 case 5:
                     userLoginSystem.updateUser();
                     assistantMenu();
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