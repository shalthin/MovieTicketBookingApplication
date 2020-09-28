package movieTicketBooking.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Shalini
 *
 */
@Data
@Entity
@Table(name = "BOOKING")
public class BookingEntity {
	@Id
	@GeneratedValue
	private int bookingId; 
    private int userId; 
    private int movieId; 
    private SeatStatus seatStatus; 
    private int numberOfSeats;
    private int amount; 
    private PaymentStatus status_of_payment; 
    private Date booked_date; 
    private LocalDateTime movie_timing; 


}
