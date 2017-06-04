package cottage_rest_services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by maxikahe on 27.5.2017.
 */

@RestController
@RequestMapping("/api/cutomer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer add(@RequestBody Customer customer) {
        Customer model = new Customer();
        model.setDateCreated(new Date());
        model.setLastName(customer.getFirstName());
        model.setFirstName(customer.getLastName());
        model.setEmail(customer.getEmail());
        model.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.saveAndFlush(model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer findOne(@PathVariable long id) {
        return customerRepository.findOne(id);
    }
}
