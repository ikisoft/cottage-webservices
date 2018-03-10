package cottage_rest_services.security;

import cottage_rest_services.user.User;
import cottage_rest_services.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Max on 8.6.2017.
 */

@Service
public class DetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        //User user = userRepository.findByEmail(email);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    AuthorityUtils.createAuthorityList("USER"));
        } else {
            throw new UsernameNotFoundException("User: '"
                    + username + "' not found.");
        }
    }
}

