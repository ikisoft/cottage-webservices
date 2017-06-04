package cottage_rest_services.landlord;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by maxikahe on 27.5.2017.
 */

@Entity
@Table
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private Date dateCreated;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private String password;


    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;

    }
}
