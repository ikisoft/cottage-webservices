package cottage_rest_services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by maxikahe on 27.5.2017.
 */

@RestController
@RequestMapping("/api/cutomer")
public class CustomerController {

    private final AtomicLong id = new AtomicLong();
    private Customer customer;

    @RequestMapping(method = RequestMethod.POST)
    public void cottage(@RequestParam(value = "lastName") String lastName,
                        @RequestParam(value = "firstName") String firstName,
                        @RequestParam(value = "email") String email,
                        @RequestParam(value = "phoneNumber") int phoneNumber) {

        customer = new Customer(id.incrementAndGet(), lastName, firstName, email, phoneNumber);

        System.out.println("New customer created");

    }


}
