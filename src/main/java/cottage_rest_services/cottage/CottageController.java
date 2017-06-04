package cottage_rest_services.cottage;

import cottage_rest_services.cottage.Cottage;
import cottage_rest_services.customer.Customer;
import cottage_rest_services.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Max on 26.5.2017.
 */

@RestController
@RequestMapping("api/cottage")
public class CottageController {

    @Autowired
    private CottageRepository cottageRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cottage> findAll() {
        return cottageRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Cottage add(@RequestBody Cottage cottage) {
        Cottage model = new Cottage();
        model.setDateCreated(new Date());
        model.setOwnerId(cottage.getOwnerId());
        model.setAddress(cottage.getAddress());
        model.setSize(cottage.getSize());
        model.setRooms(cottage.getRooms());
        model.setBeds(cottage.getBeds());
        model.setDescription(cottage.getDescription());
        return cottageRepository.saveAndFlush(model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cottage findOne(@PathVariable long id) {
        return cottageRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Cottage update(@PathVariable long id, @RequestBody Cottage cottage) {
        Cottage model = cottageRepository.findOne(id);

        if (model != null) {
            model.setAddress(cottage.getAddress());
            model.setSize(cottage.getSize());
            model.setRooms(cottage.getRooms());
            model.setBeds(cottage.getBeds());
            model.setDescription(cottage.getDescription());
            return cottageRepository.saveAndFlush(model);
        }

        return null;
    }

    //TODO Delete not working ???
/*    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        cottageRepository.delete(id);
    }*/


}

