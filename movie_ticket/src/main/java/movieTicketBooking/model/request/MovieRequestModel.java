package movieTicketBooking.model.request;

import java.util.List;

import lombok.Data;
import movieTicketBooking.entity.MovieType;

@Data
public class MovieRequestModel {
	private String MovieName;
	private MovieType movieType;
	private List<String> cast;

}
