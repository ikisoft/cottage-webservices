package cottage_rest_services.security;

import cottage_rest_services.landlord.Landlord;
import cottage_rest_services.landlord.LandlordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Max on 8.6.2017.
 */

@Service
public class LandlordUserDetailsService implements UserDetailsService {

    @Autowired
    private LandlordRepository landlordRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Landlord landlord = landlordRepository.findByUsername(username);
        if (landlord != null) {
            return new User(landlord.getUsername(), landlord.getPassword(),
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

