package cottage_rest_services.reservation;

import cottage_rest_services.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Max on 4.6.2017.
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    //TODO change this!!
    Customer findByEmail(String email);

}