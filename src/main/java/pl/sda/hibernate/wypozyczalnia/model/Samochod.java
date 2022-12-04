package pl.sda.hibernate.wypozyczalnia.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Samochod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nrRej;
    private String marka;
    private String model;
    private Double iloscMiejsc;

    @OneToMany(mappedBy = "samochod")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Wypozyczenie> wypozyczenia;

}
