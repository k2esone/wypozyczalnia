package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Klient;

import java.util.Optional;

public class KomendaZnajdzKlient implements Komenda {

    private DataAccessObject<Klient> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "znajdz klient";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id klienta, ktorego chcesz znalezc");
        Long id = Long.parseLong(Komenda.scanner.nextLine());

        Optional<Klient> klient = dao.find(Klient.class, id);
        klient.ifPresent(System.out::println);

    }
}
