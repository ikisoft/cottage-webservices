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
    private Date datecreated;

    @Column
    private String lastname;

    @Column
    private String firstname;

    @Column
    private String email;

    @Column
    private int phonenumber;

    public long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setDateCreated(Date datecreated) {

        this.datecreated = datecreated;

    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
