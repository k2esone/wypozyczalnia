package pl.sda.hibernate.wypozyczalnia.komendy;

import pl.sda.hibernate.wypozyczalnia.database.DataAccessObject;
import pl.sda.hibernate.wypozyczalnia.model.Klient;
import pl.sda.hibernate.wypozyczalnia.model.Samochod;

public class KomendaDodajSamochod implements Komenda {

    private DataAccessObject<Samochod> dao = new DataAccessObject<Samochod>();

    @Override
    public String getKomenda() {
        return "dodaj samochod";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj numer rejestracyjny");
        String nrRej = Komenda.scanner.nextLine();

        System.out.println("Podaj marka");
        String marka = Komenda.scanner.nextLine();

        System.out.println("Podaj model");
        String model = Komenda.scanner.nextLine();

        System.out.println("Podaj ilosc miejsc");
        String iloscString = Komenda.scanner.nextLine();
        Double ilosc = Double.parseDouble(iloscString);

        Samochod samochod = Samochod.builder()
                .nrRej(nrRej)
                .marka(marka)
                .model(model)
                .iloscMiejsc(ilosc)
                .build();

        dao.insert(samochod);


    }
}
