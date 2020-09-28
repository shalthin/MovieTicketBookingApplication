package movieTicketBooking.model.response;

import lombok.Data;

@Data
public class UserDetailsRequestResponse {
	private long userId;
	private String userName;
	private String password;
	private int mobileNo;
	private String email;
	private String sex;

}
