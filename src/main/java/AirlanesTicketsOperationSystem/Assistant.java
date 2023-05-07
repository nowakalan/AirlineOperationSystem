

 package AirlanesTicketsOperationSystem;

import java.util.ArrayList;

    public class Assistant {

        public class Lotnisko {

            private ArrayList<Pasazer> pasazerowie;
            private ArrayList<Bilet> bilety;

            public Lotnisko() {
                pasazerowie = new ArrayList<>();
                bilety = new ArrayList<>();
            }

            public void dodajPasazera(Pasazer pasazer) {
                pasazerowie.add(pasazer);
            }

            public void usunPasazera(Pasazer pasazer) {
                pasazerowie.remove(pasazer);
            }

            public void sprzedajBilet(Bilet bilet) {
                bilety.add(bilet);
            }

            public void anulujBilet(Bilet bilet) {
                bilety.remove(bilet);
            }

            public void wyswietlDostepneLoty() {
                System.out.println("Dostępne loty:");
                // kod do wyświetlenia dostępnych lotów
            }

            public void wyswietlBilety() {
                System.out.println("Bilety w sprzedaży:");
                for (Bilet bilet : bilety) {
                    System.out.println(bilet);
                }
            }

            public void obslugaPasazerow() {
                System.out.println("Obsługa pasażerów:");
                for (Pasazer pasazer : pasazerowie) {
                    System.out.println(pasazer);
                }
            }

            public void main(String[] args) {
                Lotnisko lotnisko = new Lotnisko();
                Pasazer pasazer1 = new Pasazer("Jan", "Kowalski", "jkowalski@example.com");
                Pasazer pasazer2 = new Pasazer("Anna", "Nowak", "anowak@example.com");
                Bilet bilet1 = new Bilet("Warszawa", "Kraków", "2022-01-01", 120.50);
                Bilet bilet2 = new Bilet("Warszawa", "Londyn", "2022-02-14", 450.75);

                lotnisko.dodajPasazera(pasazer1);
                lotnisko.dodajPasazera(pasazer2);
                lotnisko.sprzedajBilet(bilet1);
                lotnisko.sprzedajBilet(bilet2);

                lotnisko.wyswietlDostepneLoty();
                lotnisko.wyswietlBilety();
                lotnisko.obslugaPasazerow();

                System.out.println("Dziękujemy za skorzystanie z naszych usług.");
            }
        }
    }
