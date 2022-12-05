package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Zwrot;

import java.util.List;

public class KomendaListaZwrot implements Komenda {
    private DataAccessObject<Zwrot> dataAccessObject;

    public KomendaListaZwrot() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista zwrot";
    }

    @Override
    public void obsluga() {
        List<Zwrot> zwroty = dataAccessObject.findAll(Zwrot.class);
        zwroty.forEach(System.out::println);
    }
}
