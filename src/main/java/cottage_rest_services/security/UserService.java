package cottage_rest_services.security;

import cottage_rest_services.landlord.Landlord;

/**
 * Created by Max on 6.6.2017.
 */
public interface UserService {

    public Landlord findUserByEmail(String email);
    public void saveUser(Landlord landlord);
}
