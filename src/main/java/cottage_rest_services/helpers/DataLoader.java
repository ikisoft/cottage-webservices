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
                    "Kuopio",
                    random.nextInt(50) + 10,
                    random.nextInt(5) + 1,
                    random.nextInt(3) + 2,
                    random.nextInt(1000) + 50,
                    "Tässä on kuvaus",
                    "" + random.nextInt(15));
            LoadCottages(
                    "Testikatu " + i,
                    "Joensuu",
                    random.nextInt(50) + 10,
                    random.nextInt(5) + 1,
                    random.nextInt(3) + 2,
                    random.nextInt(1000) + 50,
                    "Tässä on kuvaus",
                    "" + random.nextInt(15));
        }

        loadUsers(
                "max.ikaheimo@gmail.com",
                "Ikis",
                "Max",
                "max.ikaheimo@gmail.com",
                "123123",
                "admin",
                 new String[] {"ROLE_USER", "ROLE_ADMIN"},
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
                              String city,
                              int size,
                              int rooms,
                              int beds,
                              double price,
                              String description,
                              String imgurl){

        cottage = new Cottage();
        cottage.setAddress(address);
        cottage.setCity(city);
        cottage.setSize(size);
        cottage.setRooms(rooms);
        cottage.setBeds(beds);
        cottage.setPrice(price);
        cottage.setDescription(description);
        cottage.setImgurl(imgurl);

        cottageRepository.save(cottage);

    }

    private void loadUsers(String username,
                           String lastname,
                           String firstname,
                           String email,
                           String phonenumber,
                           String password,
                           String[] roles, boolean landlord){

        user = new User();

        user.setDateCreated(new Date());
        user.setUsername(username);
        user.setLastname(lastname);
        user.setFirstname(firstname);
        user.setEmail(email);
        user.setPhonenumber(phonenumber);
        user.setPassword(password);
        user.setRoles(roles);
        user.setLandlord(landlord);

        userRepository.save(user);
    }
}
