package movieTicketBooking.model.request;


import lombok.Data;

@Data
public class TheaterRequestModel {
	private String name;
	private MovieRequestModel movieRequestModel;

}
