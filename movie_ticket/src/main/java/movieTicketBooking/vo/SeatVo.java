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
public class SeatVo {
	private long seatId;
    private char rowId;
    private int rowNumber;
    private long screenId;

}
