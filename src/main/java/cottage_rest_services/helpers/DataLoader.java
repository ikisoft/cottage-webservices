package cottage_rest_services.helpers;

import cottage_rest_services.cottage.Cottage;
import cottage_rest_services.cottage.CottageRepository;
import cottage_rest_services.user.User;
import cottage_rest_services.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

/**
 * Created by maxikahe on 10.11.2017.
 */
@Component
public class DataLoader implements ApplicationRunner {

    private CottageRepository cottageRepository;
    private UserRepository userRepository;
    private Cottage cottage;
    private User user;
    private Random random;

    @Autowired
    public DataLoader(CottageRepository cottageRepository, UserRepository userRepository) {
        this.cottageRepository = cottageRepository;
        this.userRepository = userRepository;
    }

    /**
     * Runs on application start
     * @param args
     */
    public void run(ApplicationArguments args) {

        random = new Random();
        load();
    }

    /**
     * Loads all test data into the embedded database during application start
     */
    private void load(){

        //Load cottages
        for(int i = 0; i < 5; i++){
            LoadCottages(
                    "Testikatu " + i,
                    random.nextInt(50) + 10,
                    random.nextInt(5) + 1,
                    random.nextInt(3) + 2,
                    "Tässä on kuvaus");
        }

        loadUsers(
                "max.ikaheimo@gmail.com",
                "Ikis",
                "Max",
                "max.ikaheimo@gmail.com",
                "123123",
                "admin",
                true);
    }


    /**
     * Loads cottages to the embedded database during application startup
     * <p>
     * @param  address cottage address
     * @param  size cottage size in square meters
     * @param  rooms number of rooms in the cottage
     * @param  beds number of beds in the cottage
     * @param  description additional description for the cottage
     */
    private void LoadCottages(String address,
                              int size,
                              int rooms,
                              int beds,
                              String description){

        cottage = new Cottage();
        cottage.setAddress(address);
        cottage.setSize(size);
        cottage.setRooms(rooms);
        cottage.setBeds(beds);
        cottage.setDescription(description);

        cottageRepository.save(cottage);

    }

    private void loadUsers(String username,
                           String lastname,
                           String firstname,
                           String email,
                           String phonenumber,
                           String password,
                           boolean landlord){

        user = new User();

        user.setDateCreated(new Date());
        user.setUsername(username);
        user.setLastname(lastname);
        user.setFirstname(firstname);
        user.setEmail(email);
        user.setPhonenumber(phonenumber);
        user.setPassword(password);
        user.setLandlord(landlord);

        userRepository.save(user);
    }
}
