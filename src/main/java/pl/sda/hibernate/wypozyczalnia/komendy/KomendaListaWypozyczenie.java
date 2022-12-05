package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Wypozyczenie;

import java.util.List;

public class KomendaListaWypozyczenie implements Komenda {
    private DataAccessObject<Wypozyczenie> dataAccessObject;

    public KomendaListaWypozyczenie() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista wypozyczenie";
    }

    @Override
    public void obsluga() {
        List<Wypozyczenie> wypozyczenia = dataAccessObject.findAll(Wypozyczenie.class);
        wypozyczenia.forEach(System.out::println);
    }
}
