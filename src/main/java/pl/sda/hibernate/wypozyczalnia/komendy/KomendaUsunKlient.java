package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Klient;

public class KomendaUsunKlient implements Komenda {
    private DataAccessObject<Klient> dataAccessObject;

    public KomendaUsunKlient() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun klient";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego klienta:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Klient.class, id)) {
            System.out.println("Usunieto klienta!");
        } else {
            System.err.println("Nie udalo sie usunac klienta!");
        }
    }
}
