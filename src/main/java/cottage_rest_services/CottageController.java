package cottage_rest_services;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Max on 26.5.2017.
 */

@RestController
@RequestMapping("/cottage")
public class CottageController {

    private ArrayList<Cottage> testList = new ArrayList<>();
    private final AtomicLong id = new AtomicLong();
    Cottage cottage;

    @RequestMapping(method = RequestMethod.POST)
    public void cottage(@RequestParam(value = "ownerId") long ownerId,
                        @RequestParam(value = "address") String address,
                        @RequestParam(value = "size") double size,
                        @RequestParam(value = "rooms") int rooms,
                        @RequestParam(value = "beds") int beds,
                        @RequestParam(value = "description") String description) {

        cottage = new Cottage(id.incrementAndGet(), ownerId, address, size, rooms, beds, description);

        testList.add(cottage);

        for (int i = 1; i < testList.size(); i++) {
            System.out.println(testList.get(i).getId());

        }

        /*System.out.println("id = " + id);
        System.out.println("ownerId = " + ownerId);
        System.out.println("address = " + address);
        System.out.println("size = " + size);
        System.out.println("rooms = " + rooms);
        System.out.println("beds = " + beds);
        System.out.println("description = " + description);*/
    }

    @RequestMapping(method = RequestMethod.GET)
    public void getAllCottages() {
        System.out.println("get all cottages");
        //return all

    }

    @RequestMapping(value = "/{cottageId}", method = RequestMethod.GET)
    public void getCottage(@PathVariable long cottageId) {
        System.out.println("get cottage " + cottageId);
    }

    @RequestMapping(value = "/{cottageId}", method = RequestMethod.PUT)
    public void putCottage(@PathVariable long cottageId) {
        System.out.println("put cottage " + cottageId);
    }

    @RequestMapping(value = "/{cottageId}", method = RequestMethod.DELETE)
    public void deleteCottage(@PathVariable long cottageId) {
        System.out.println("delete cottage " + cottageId);
    }


}

