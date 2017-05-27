package cottage_rest_services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by maxikahe on 27.5.2017.
 */

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Long> {

}