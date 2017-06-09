package cottage_rest_services.landlord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by maxikahe on 27.5.2017.
 */

@RestController
@RequestMapping("/api/landlord")
public class LandlordController {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private LandlordRepository landlordRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Landlord> findAll() {
        return landlordRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Landlord add(Landlord landlord) {
        Landlord model = new Landlord();
        //model.setDateCreated(new Date());
        model.setUsername(landlord.getUsername());
        model.setLastName(landlord.getFirstName());
        model.setFirstName(landlord.getLastName());
        model.setEmail(landlord.getEmail());
        model.setPhoneNumber(landlord.getPhoneNumber());
        model.setPassword(landlord.getPassword());
        return landlordRepository.saveAndFlush(model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Landlord findOne(@PathVariable long id) {
        return landlordRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Landlord update(@PathVariable long id, @RequestBody Landlord landlord) {
        Landlord model = landlordRepository.findOne(id);

        if (model != null) {
            model.setLastName(landlord.getFirstName());
            model.setFirstName(landlord.getLastName());
            model.setEmail(landlord.getEmail());
            model.setPhoneNumber(landlord.getPhoneNumber());
            return landlordRepository.saveAndFlush(model);
        }
        return null;
    }

    //TODO Delete not working ???
/*    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        landlordRepository.delete(id);
    }*/
}

