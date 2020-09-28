/**
 * 
 */
package movieTicketBooking.repository;

import org.springframework.data.repository.CrudRepository;

import movieTicketBooking.entity.SeatEntity;

/**
 * @author Shalini
 *
 */
public interface SeatRespository extends CrudRepository<SeatEntity, Long> {

}
