/**
 * 
 */
package movieTicketBooking.vo;

import lombok.Data;

/**
 * @author Shalini
 *
 */
@Data
public class UserVo {
	private long userId;
	private String userName;
	private String password;
	private int mobileNo;
	private String email;
	private String sex;

}
