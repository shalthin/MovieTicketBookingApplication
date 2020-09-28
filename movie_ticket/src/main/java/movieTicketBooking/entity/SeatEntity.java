package movieTicketBooking.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "SEAT")
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seatId;
    private char rowId;
    private int rowNumber;
    private long screenId;

}
