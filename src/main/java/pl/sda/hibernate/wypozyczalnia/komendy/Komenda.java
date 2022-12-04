package pl.sda.hibernate.wypozyczalnia.komendy;

import java.util.Scanner;

public interface Komenda {
    Scanner scanner = new Scanner(System.in);
    String getKomenda();
    void obsluga();
}
