package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Klient;
import pl.sda.hibernate.wypozyczalnia.model.Samochod;
import pl.sda.hibernate.wypozyczalnia.model.Wypozyczenie;
import pl.sda.hibernate.wypozyczalnia.model.Zwrot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class KomendaZakonczWypozyczenie implements Komenda {

    private DataAccessObject<Wypozyczenie> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "zakoncz wypozyczenie";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id wypozyczenia, ktore chcesz zakonczyc");
        String idWypozyczenia = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idWypozyczenia);
        Optional<Wypozyczenie> optionalWypozyczenie = dao.find(Wypozyczenie.class, id);
        if (optionalWypozyczenie.isEmpty()) {
            System.err.println("Wypozyczenie o takim id nie istnieje");
            return;
        }
        Wypozyczenie wypozyczenieOrginal = optionalWypozyczenie.get();


        System.out.println("Podaj cene najmu");
        String cenaString = Komenda.scanner.nextLine();
        Double cena = Double.parseDouble(cenaString);

        System.out.println("Podaj date koncowa wypozyczenia (dd/MM/yyyy)");
        String dataString = Komenda.scanner.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime data = LocalDateTime.parse(dataString, dateTimeFormatter);

        Wypozyczenie wypozyczenie = Wypozyczenie.builder()
                .dataWypozyczenia(wypozyczenieOrginal.getDataWypozyczenia())
                .numerUmowy(wypozyczenieOrginal.getNumerUmowy())
                .cenaNajmu(cena)
                .dataKoncowaWypozyczenia(data)
                .build();

        dao.update(Wypozyczenie.class, id, wypozyczenie);


    }
}
