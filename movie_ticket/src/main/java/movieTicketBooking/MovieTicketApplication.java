package movieTicketBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class MovieTicketApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MovieTicketApplication.class, args);
		RestClientApi api = context.getBean(RestClientApi.class);
//		api.doPost();
		
	}

}
