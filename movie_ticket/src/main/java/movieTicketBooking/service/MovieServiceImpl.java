package movieTicketBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import movieTicketBooking.entity.MovieEntity;
import movieTicketBooking.entity.MovieStatus;
import movieTicketBooking.repository.MovieRepository;
import movieTicketBooking.vo.MovieVo;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<MovieVo> addMovies(List<MovieVo> movieVoList) {
		ModelMapper mapper = new ModelMapper();
		List<MovieEntity> movieEntityList = new ArrayList<>();
		List<MovieVo> movieList = new ArrayList<>();
		if(!CollectionUtils.isEmpty(movieVoList)) {
			for(MovieVo movieVo : movieVoList) {
				MovieEntity movieEntity = mapper.map(movieVo, MovieEntity.class);
				if(movieEntity.getMovieName().equals("Bigil")) {
					movieEntity.setMovieStatus(MovieStatus.AVAILABLE);
					movieEntityList.add(movieEntity);
				} else if(movieEntity.getMovieName().equals("Ayan")) {
					movieEntity.setMovieStatus(MovieStatus.NOT_AVAILABLE);
					movieEntityList.add(movieEntity);
				}
			}
		}
		
		
		
		movieRepository.saveAll(movieEntityList);
		for(MovieEntity movieEntity : movieEntityList) {
			MovieVo movieVo = mapper.map(movieEntity,  MovieVo.class);
			movieList.add(movieVo);
		}
		return movieList;
	}

	@Override
	public MovieVo findByMovieName(String movieName) {
		ModelMapper mapper = new ModelMapper();
		MovieEntity movieEntity = movieRepository.findByMovieName(movieName);
		return mapper.map(movieEntity, MovieVo.class);
	}

	@Override
	public List<MovieVo> getAllMovies() {
		List<MovieVo> movieList = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		Iterable<MovieEntity> itrMovieEntity = movieRepository.findAll();
		for(MovieEntity movieEntity : itrMovieEntity) {
		MovieVo movieVo = mapper.map(movieEntity, MovieVo.class);
			movieList.add(movieVo);
		}
		return movieList;
	}


}
