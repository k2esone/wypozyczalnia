package pl.sda.hibernate.wypozyczalnia.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Zwrot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime dataICzasZwrotu;

    private String notatkaUsterki;

    @OneToOne(mappedBy = "zwrot")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Wypozyczenie wypozyczenie;
}
