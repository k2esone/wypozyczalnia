package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Klient;
import pl.sda.hibernate.wypozyczalnia.model.Samochod;
import pl.sda.hibernate.wypozyczalnia.model.Wypozyczenie;

import java.util.Optional;
import java.util.Scanner;

public class KomendaDodajWypozyczenie implements Komenda {

    private DataAccessObject<Wypozyczenie> dao = new DataAccessObject<Wypozyczenie>();
    private DataAccessObject<Samochod> daoSamochod = new DataAccessObject<Samochod>();
    private DataAccessObject<Klient> daoKlient = new DataAccessObject<Klient>();

    @Override
    public String getKomenda() {
        return "dodaj wypozyczenie";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id samochodu, ktory chcesz wypozyczyc");
        String idString = Komenda.scanner.nextLine();
        Long idSamochod = Long.parseLong(idString);
        Optional<Samochod> samochodOptional = daoSamochod.find(Samochod.class, idSamochod);
        if (samochodOptional.isEmpty()) {
            System.err.println("Podany samochod nie istnieje");
            return;
        }

        System.out.println("Podaj id klienta, ktoremu chcesz wypozyczyc samochod");
        String idString2 = Komenda.scanner.toString();
        Long idKlienta = Long.parseLong(idString2);
        Optional<Klient> klientOptional = daoKlient.find(Klient.class, idKlienta);
        if (klientOptional.isEmpty()) {
            System.err.println("Podany klient nie istnieje");
            return;
        }

        System.out.println("Podaj numer umowy");
        String nrUmowy = Komenda.scanner.nextLine();


        Wypozyczenie wypozyczenie = Wypozyczenie.builder()
                .samochod(samochodOptional.get())
                .klient(klientOptional.get())
                .numerUmowy(nrUmowy)
                .build();

        dao.insert(wypozyczenie);


    }
}
