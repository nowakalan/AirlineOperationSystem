package AirlanesTicketsOperationSystem;

import java.util.Scanner;

public class Client {

    public void clientMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("1. Wyswietl liste lotow");
        System.out.println("2. Kup bilet");
        System.out.println("3. Eksportuj bilet do pliku");
        System.out.println("4. Dodaj srodki do swojego portfela");
        System.out.println("5. Zwroc bilet");
        System.out.println("6. Skontaktuj sie z asystentem");
        System.out.println("7. Zmien swoje dane logowania");
        System.out.println("8. Wyjdź z programu");

        int choose = input.nextInt();
        input.nextLine();

        switch (choose) {
            case 1:
                //flight.displayFlightDetails();
                break;
            case 2:
                //TODO
                break;
            case 3:
                //TODO
                break;
            case 4:
                //TODO
                break;
            case 5:
                //TODO
                break;
            case 6:
                //TODO
                break;
            case 7:
                //TODO
                break;
            case 8:
                System.out.println("Do widzenia!");
                System.exit(0);
                break;
            default:
                System.out.println("Nieprawidłowy wybór!");
                break;
        }
    }
}