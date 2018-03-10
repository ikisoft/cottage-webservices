package cottage_rest_services.reservation;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Max on 4.6.2017.
 */

@Entity
@Table
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private Date datecreated;

    @Column
    private Date dateexpires;

    @Column
    private long landlordId;

    @Column
    private long cottageId;

    @Column
    private long customerId;


    public Date getDateCreated() {
        return datecreated;
    }

    public void setDateCreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getDateExpires() {
        return dateexpires;
    }

    public void setDateExpires(Date dateexpires) {
        this.dateexpires = dateexpires;
    }

    public long getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(long landlordId) {
        this.landlordId = landlordId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCottageId() {
        return cottageId;
    }

    public void setCottageId(long cottageId) { this.cottageId = cottageId; }
}
