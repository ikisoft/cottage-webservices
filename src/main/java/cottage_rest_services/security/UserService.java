package cottage_rest_services.security;

import cottage_rest_services.user.User;

/**
 * Created by Max on 6.6.2017.
 */
public interface UserService {

    public User findUserByEmail(String email);
    public void saveUser(User user);
}
