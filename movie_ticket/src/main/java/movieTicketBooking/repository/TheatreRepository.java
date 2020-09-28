package movieTicketBooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import movieTicketBooking.entity.TheaterEntity;

@Repository
public interface TheatreRepository extends CrudRepository<TheaterEntity, Long> {
	TheaterEntity findByTheatreId(Long theatreId);
	TheaterEntity findByTheatreName(String theatreName);
}
