/**
 * 
 */
package movieTicketBooking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import movieTicketBooking.entity.MovieEntity;
import movieTicketBooking.entity.SeatEntity;
import movieTicketBooking.repository.SeatRespository;
import movieTicketBooking.vo.MovieVo;
import movieTicketBooking.vo.SeatVo;

/**
 * @author Shalini
 *
 */
@Service
public class SeatServiceImpl implements SeatService {
	
	private static final int SEAT_LIMIT = 6;
	
	@Autowired
	private SeatRespository seatRespository;

	@Override
	public List<SeatVo> select(List<SeatVo> seatVoList) {
		ModelMapper mapper = new ModelMapper();
		List<SeatEntity> seatEntityList = new ArrayList<>();
		List<SeatVo> seatList = new ArrayList<>();
		if(!CollectionUtils.isEmpty(seatVoList)) {
			for(SeatVo seat : seatVoList) {
				SeatEntity seatEntity = mapper.map(seat, SeatEntity.class);
				seatEntityList.add(seatEntity);
			}
			if(seatEntityList.size() <= SEAT_LIMIT) {
				seatRespository.saveAll(seatEntityList);	
			} else {
				throw new RuntimeException("Seat limit should not be exceed 6");
			}
			
			for(SeatEntity seatEntity : seatEntityList) {
				SeatVo seatVo = mapper.map(seatEntity,  SeatVo.class);
				seatList.add(seatVo);
			}
		}
		
		return seatList;
	}

}
