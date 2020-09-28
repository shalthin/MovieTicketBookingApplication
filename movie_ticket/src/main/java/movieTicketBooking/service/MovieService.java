package movieTicketBooking.service;

import java.util.List;

import movieTicketBooking.entity.MovieEntity;
import movieTicketBooking.vo.MovieVo;

public interface MovieService {
	
	public List<MovieVo> addMovies(List<MovieVo> movieVoList);
	public MovieVo findByMovieName(String movieName);
	public List<MovieVo> getAllMovies();
	
	

}
