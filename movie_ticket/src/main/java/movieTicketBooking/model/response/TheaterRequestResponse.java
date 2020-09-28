package movieTicketBooking.model.response;

import javax.persistence.Column;

import lombok.Data;
import movieTicketBooking.entity.MovieEntity;

@Data
public class TheaterRequestResponse {
	private int id;
	private String name;
	private MovieRequestResponse movieRequestResponse;

}
