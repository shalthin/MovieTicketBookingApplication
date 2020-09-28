package movieTicketBooking.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import movieTicketBooking.vo.MovieVo;

/**
 * @author Shalini
 *
 */

@Data
@Entity
@Table(name = "THEATER")
public class TheaterEntity {
	@Id
	@GeneratedValue
	private long id;
	private String name;

}
