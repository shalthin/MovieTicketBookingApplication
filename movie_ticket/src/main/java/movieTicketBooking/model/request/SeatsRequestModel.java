package movieTicketBooking.model.request;

import lombok.Data;

@Data
public class SeatsRequestModel {
	private long seatId;
    private char rowId;
    private int rowNumber;
    private long screenId;

}
