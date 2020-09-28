package movieTicketBooking.model.request;

import lombok.Data;

@Data
public class UserDetailsRequestModel {

	private String userName;
	private String password;
	private int mobileNo;
	private String email;
	private String sex;

}
