package cottage_rest_services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by maxikahe on 27.5.2017.
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User add(User user) {
        User model = new User();
        model.setDateCreated(new Date());
        model.setUsername(user.getUsername());
        model.setLastname(user.getFirstname());
        model.setFirstname(user.getLastname());
        model.setEmail(user.getEmail());
        model.setPhonenumber(user.getPhonenumber());
        model.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        model.setLandlord(user.isLandlord());
        return userRepository.saveAndFlush(model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findOne(@PathVariable long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable long id, @RequestBody User user) {
        User model = userRepository.findOne(id);

        if (model != null) {
            model.setLastname(user.getFirstname());
            model.setFirstname(user.getLastname());
            model.setEmail(user.getEmail());
            model.setPhonenumber(user.getPhonenumber());
            return userRepository.saveAndFlush(model);
        }
        return null;
    }

    //TODO Delete not working ???
/*    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        landlordRepository.delete(id);
    }*/
}

