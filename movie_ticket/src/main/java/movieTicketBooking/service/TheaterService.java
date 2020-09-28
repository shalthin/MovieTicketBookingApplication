
package movieTicketBooking.service;

import java.util.List;

import movieTicketBooking.vo.MovieVo;
import movieTicketBooking.vo.TheaterVo;

/**
 * @author Shalini
 *
 */
public interface TheaterService {
	public List<TheaterVo> addTheater(List<TheaterVo> theaterVoList);
	public TheaterVo findByName(String name);
	public List<TheaterVo> getAllTheater();

}
