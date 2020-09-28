package movieTicketBooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * @author Shalini
 *
 */
@Data
@Entity
@Table(name = "USER")
public class UserEntity {
	@Id
	@GeneratedValue
	private long userId;
	private String userName;
	private String password;
	private int mobileNo;
	private String email;
	private String sex;
	

}
