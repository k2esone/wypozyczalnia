package pl.sda.hibernate.wypozyczalnia.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wypozyczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime dataWypozyczenia;

    private LocalDateTime dataKoncowaWypozyczenia;
    private String numerUmowy;
    private Double cenaNajmu;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Samochod samochod;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Klient klient;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Zwrot zwrot;
}
