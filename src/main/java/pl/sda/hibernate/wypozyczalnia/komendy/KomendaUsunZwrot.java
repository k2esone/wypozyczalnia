package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Zwrot;

public class KomendaUsunZwrot implements Komenda {
    private DataAccessObject<Zwrot> dataAccessObject;

    public KomendaUsunZwrot() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun zwrot";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego zwrotu:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Zwrot.class, id)) {
            System.out.println("Usunieto zwrot!");
        } else {
            System.err.println("Nie udalo sie usunac zwrotu!");
        }
    }
}
