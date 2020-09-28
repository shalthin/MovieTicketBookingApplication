
package movieTicketBooking.service;

import java.util.List;

import movieTicketBooking.vo.SeatVo;

/**
 * @author Shalini
 *
 */
public interface SeatService {
	
	public List<SeatVo> select (List<SeatVo> seatVo);

}
