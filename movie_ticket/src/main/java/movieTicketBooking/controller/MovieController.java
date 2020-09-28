package movieTicketBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import movieTicketBooking.RestClientApi;
import movieTicketBooking.model.request.MovieRequestModel;
import movieTicketBooking.model.response.MovieRequestResponse;
import movieTicketBooking.service.MovieService;
import movieTicketBooking.vo.MovieVo;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private  RestClientApi restClientApi;
	
	@PostMapping(value = "/addMovies")
	public List<MovieRequestResponse> addMovies(@RequestBody List<MovieRequestModel> movieDetails) {
		MovieRequestResponse response = new MovieRequestResponse();
		List<MovieRequestResponse> responseList = new ArrayList<>();
		List<MovieVo> movieVoList = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		for(MovieRequestModel movieDetail : movieDetails) {
			MovieVo movieVo = modelMapper.map(movieDetail, MovieVo.class);
			movieVoList.add(movieVo);
			 movieVoList = movieService.addMovies(movieVoList);
		}
		for(MovieVo movieVo : movieVoList) {
			 response = modelMapper.map(movieVo, MovieRequestResponse.class);
			responseList.add(response);
		}
		 
		return responseList;
		
	}
	
	@GetMapping(value = "/getAllMovies")
	public List<MovieRequestResponse> getAllMovies() {
		List<MovieRequestResponse> responseList = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		  List<MovieVo> movieVoList = movieService.getAllMovies();
		  for(MovieVo movieVo : movieVoList) {
			  MovieRequestResponse response = modelMapper.map(movieVo, MovieRequestResponse.class); 
			  responseList.add(response);
		  }
		 
		return responseList;
		
	}
	
	@GetMapping(value = "/search/{movieName}")
	public MovieRequestResponse findByMovieName(@PathVariable String movieName) {
		ModelMapper modelMapper = new ModelMapper();
		  MovieVo movieVo = movieService.findByMovieName(movieName);
		  return modelMapper.map(movieVo, MovieRequestResponse.class);
		 
		
	}
	
}
