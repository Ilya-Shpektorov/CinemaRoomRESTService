package cinema.Controllers;

import cinema.Models.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private Cinema cinema;

    @GetMapping("/seats")
    public String getSeats(){
        return cinema.getAvailableSeatsInfo();
    }

}
