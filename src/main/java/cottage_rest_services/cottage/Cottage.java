package cottage_rest_services.cottage;


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
    private Date datecreated;

    @Column
    private long ownerid;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private double size;

    @Column
    private int rooms;

    @Column
    private int beds;

    @Column
    private double price;

    @Column
    private String description;

    @Column
    private String imgurl;

    public long getId(){
        return id;
    }

    public long getOwnerId() {
        return ownerid;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
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

    public double getPrice() { return price; }

    public String getDescription() {
        return description;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setDateCreated(Date dateCreated){

        this.datecreated = dateCreated;
    }

    public void setOwnerId(long ownerId) {
        this.ownerid = ownerId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
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

    public void setPrice(double price) { this.price = price; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

}
