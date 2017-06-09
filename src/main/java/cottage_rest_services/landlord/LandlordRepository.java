package cottage_rest_services.landlord;

import cottage_rest_services.landlord.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

/**
 * Created by maxikahe on 27.5.2017.
 */

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Long> {

    Landlord findByUsername(String username);

}