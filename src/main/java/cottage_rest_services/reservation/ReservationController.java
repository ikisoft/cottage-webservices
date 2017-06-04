package cottage_rest_services.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Max on 4.6.2017.
 */

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Reservation add(@RequestBody Reservation reservation){
        Reservation model = new Reservation();
        model.setDateCreated(reservation.getDateCreated());
        model.setDateExpires(reservation.getDateExpires());
        model.setLandlordId(reservation.getLandlordId());
        model.setCustomerId(reservation.getCustomerId());
        return reservationRepository.saveAndFlush(model);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Reservation update(@PathVariable long id, @RequestBody Reservation reservation){
        Reservation model = reservationRepository.findOne(id);

        if(model != null){
            model.setDateCreated(reservation.getDateCreated());
            model.setDateExpires(reservation.getDateExpires());
            model.setCustomerId(reservation.getCustomerId());
            return reservationRepository.saveAndFlush(model);
        }
        return null;
    }

    //TODO Delete not working ???
/*    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        cottageRepository.delete(id);
    }*/

}
