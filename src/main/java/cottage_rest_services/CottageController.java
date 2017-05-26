package cottage_rest_services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public void cottage(@RequestParam(value = "ownerId") Long ownerId,
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
    public void cottage(){


    }


}

