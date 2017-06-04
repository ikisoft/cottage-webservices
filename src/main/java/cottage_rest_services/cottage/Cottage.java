package cottage_rest_services.cottage;

import sun.plugin.dom.core.CoreConstants;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Max on 26.5.2017.
 */

@Entity
@Table
public class Cottage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private Date dateCreated;

    @Column
    private long ownerId;

    @Column
    private String address;

    @Column
    private double size;

    @Column
    private int rooms;

    @Column
    private int beds;

    @Column
    private String description;

    public long getId(){
        return id;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getAddress() {
        return address;
    }

    public double getSize() {
        return size;
    }

    public int getRooms() {
        return rooms;
    }

    public int getBeds() {
        return beds;
    }

    public String getDescription() {
        return description;
    }

    public void setDateCreated(Date dateCreated){

        this.dateCreated = dateCreated;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
