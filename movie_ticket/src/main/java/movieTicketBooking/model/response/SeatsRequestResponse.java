/**
 * 
 */
package movieTicketBooking.model.response;

import lombok.Data;

/**
 * @author Shalini
 *
 */
@Data
public class SeatsRequestResponse {
	private long seatId;
    private char rowId;
    private int rowNumber;
    private long screenId;
}
