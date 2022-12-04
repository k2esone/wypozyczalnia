package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Klient;

import java.util.List;

public class KomendaListaKlient implements Komenda {
    private DataAccessObject<Klient> dataAccessObject;

    public KomendaListaKlient() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista klient";
    }

    @Override
    public void obsluga() {
        List<Klient> faktury = dataAccessObject.findAll(Klient.class);
        faktury.forEach(System.out::println);
    }
}
