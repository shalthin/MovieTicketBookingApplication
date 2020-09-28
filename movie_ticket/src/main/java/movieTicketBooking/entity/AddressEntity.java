package movieTicketBooking.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
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
@Entity(name = "ADDRESS")
public class AddressEntity {
	@Id
	@GeneratedValue
	private String streetNo; 
	private String city; 
	private String state; 
    private String pinCode; 
    private String landmark;

}
