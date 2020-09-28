package movieTicketBooking.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import movieTicketBooking.model.request.MovieRequestModel;
import movieTicketBooking.model.request.SeatsRequestModel;
import movieTicketBooking.model.response.MovieRequestResponse;
import movieTicketBooking.model.response.SeatsRequestResponse;
import movieTicketBooking.service.SeatService;
import movieTicketBooking.vo.MovieVo;
import movieTicketBooking.vo.SeatVo;

@RestController
public class SeatsController {
	
	@Autowired
	private SeatService seatService;
	
	@PostMapping(value = "/select")
	 public List<SeatsRequestResponse> selectSeats(List<SeatsRequestModel> seatRequest) {
		SeatsRequestResponse response = new SeatsRequestResponse();
		List<SeatsRequestResponse> responseList = new ArrayList<>();
		List<SeatVo> seatVoList = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		for(SeatsRequestModel seatDetail : seatRequest) {
			SeatVo seatVo = mapper.map(seatDetail, SeatVo.class);
			seatVoList.add(seatVo);
			seatVoList = seatService.select(seatVoList);
		}
		for(SeatVo seatVo : seatVoList) {
			 response = mapper.map(seatVo, SeatsRequestResponse.class);
			responseList.add(response);
		}
		
		
		return responseList;
		 
	 }

}
