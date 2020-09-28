package movieTicketBooking.vo;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import movieTicketBooking.entity.MovieStatus;
import movieTicketBooking.entity.MovieType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieVo {
	private int movieId;
	private String movieName;
    private MovieType movieType;
    private List<String> cast;
    MovieStatus movieStatus;

}
