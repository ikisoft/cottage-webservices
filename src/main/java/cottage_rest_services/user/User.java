package cottage_rest_services.user;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by maxikahe on 27.5.2017.
 */

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private Date dateCreated;
    @Column
    private String username;
    @Column
    private String lastname;
    @Column
    private String firstname;
    @Column
    private String email;
    @Column
    private String phonenumber;
    @Column
    private String password;
    @Column
    private boolean landlord;

    public long getId() {
        return id;
    }

    public String getUsername(){
        return username;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLandlord() {
        return landlord;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public void setLandlord(boolean landlord) {
        this.landlord = landlord;
    }
}
