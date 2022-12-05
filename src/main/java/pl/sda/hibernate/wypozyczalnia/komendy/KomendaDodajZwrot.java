package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Wypozyczenie;
import pl.sda.hibernate.wypozyczalnia.model.Zwrot;

import java.util.Optional;

public class KomendaDodajZwrot implements Komenda {

    private DataAccessObject<Zwrot> dao = new DataAccessObject<>();
    private DataAccessObject<Wypozyczenie> daoWypozyczenie = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj zwrot";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id wypozyczenia, dla ktorego chcesz zrobic zwrot");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);
        Optional<Wypozyczenie> wypozyczenieOptional = daoWypozyczenie.find(Wypozyczenie.class, id);
        if (wypozyczenieOptional.isEmpty()) {
            System.err.println("Wypozyczenie o podanym id nie istnieje");
            return;
        }

        System.out.println("Podaj notatke(usterki) / brak");
        String notatka = Komenda.scanner.nextLine();


        Zwrot zwrot = Zwrot.builder()
                .wypozyczenie(wypozyczenieOptional.get())
                .notatkaUsterki(notatka)
                .build();

        dao.insert(zwrot);


    }
}
