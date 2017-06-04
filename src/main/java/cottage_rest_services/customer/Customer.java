package cottage_rest_services.customer;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by maxikahe on 27.5.2017.
 */

@Entity
@Table
public class Customer {
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
    private int phoneNumber;

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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setDateCreated(Date dateCreated){

        this.dateCreated = dateCreated;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
