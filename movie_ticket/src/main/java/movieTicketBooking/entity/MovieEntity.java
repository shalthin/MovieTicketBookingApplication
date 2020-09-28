package movieTicketBooking.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Shalini
 *
 */

@Data
@Entity
@Table(name = "MOVIE")
public class MovieEntity {
	@Id
	@GeneratedValue
	private long movieId;
	private String movieName;
	private MovieType movieType;
	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> cast;
	private MovieStatus movieStatus;
}
