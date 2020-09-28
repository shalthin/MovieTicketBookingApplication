package movieTicketBooking.model.response;

import java.util.List;

import lombok.Data;
import movieTicketBooking.entity.MovieStatus;
import movieTicketBooking.entity.MovieType;

@Data
public class MovieRequestResponse {
	private int movieId;
	private String movieName;
    private MovieType movieType;
    private List<String> cast;
    private MovieStatus movieStatus;

}
