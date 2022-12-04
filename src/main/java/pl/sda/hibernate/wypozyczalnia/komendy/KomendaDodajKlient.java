package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Klient;

public class KomendaDodajKlient implements Komenda {

    private DataAccessObject<Klient> dao = new DataAccessObject<Klient>();

    @Override
    public String getKomenda() {
        return "dodaj klient";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj imie klienta");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj nazwisko");
        String nazwisko = Komenda.scanner.nextLine();

        System.out.println("Podaj nip");
        String nip = Komenda.scanner.nextLine();

        Klient klient = Klient.builder()
                .imie(imie)
                .nazwisko(nazwisko)
                .nip(nip)
                .build();

        dao.insert(klient);


    }
}
