package database.reservation.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor
public class Reservation {
    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private Long projectionId;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private Long userId;

    @NotNull
    @ElementCollection
    @Column(unique = true)
    private List<Long> seatNumbers;

    @NotNull
    @PositiveOrZero
    private Long price;
}
