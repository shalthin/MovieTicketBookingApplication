package movieTicketBooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import movieTicketBooking.entity.MovieEntity;
import movieTicketBooking.entity.MovieType;
import movieTicketBooking.model.request.MovieRequestModel;

@Service
public class RestClientApi {
	private static final String ADDMOVIES = ("http://localhost:8080/addMovies");
	
	 RestTemplate restTemplate = new RestTemplate();
	
	public void doPost() {
		MovieRequestModel movie = new MovieRequestModel();
		MovieRequestModel movieOne = new MovieRequestModel();
		List<MovieRequestModel> movieList = new ArrayList<>();
		movie.setMovieName("comali");
		movie.setMovieType(MovieType.TAMIL);
		movie.setCast(Arrays.asList("ravi","kajal"));
		movieList.add(movie);
		movieOne.setMovieName("bigil");
		movieOne.setMovieType(MovieType.TAMIL);
		movieOne.setCast(Arrays.asList("vijay","nayandhara"));
		movieList.add(movieOne);
		ResponseEntity<MovieEntity> result = restTemplate.postForEntity(ADDMOVIES, movieList, MovieEntity.class);
		 System.out.println(result);
	}

}
