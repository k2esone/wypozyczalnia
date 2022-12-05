package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Samochod;

import java.util.List;

public class KomendaListaSamochod implements Komenda {
    private DataAccessObject<Samochod> dataAccessObject;

    public KomendaListaSamochod() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista samochod";
    }

    @Override
    public void obsluga() {
        List<Samochod> samochody = dataAccessObject.findAll(Samochod.class);
        samochody.forEach(System.out::println);
    }
}
