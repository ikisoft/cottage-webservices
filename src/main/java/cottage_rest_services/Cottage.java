package cottage_rest_services;

import sun.plugin.dom.core.CoreConstants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Max on 26.5.2017.
 */


public class Cottage {

    private long id;
    private long ownerId;
    private String address;
    private double size;
    private int rooms;
    private int beds;
    private String description;

    public Cottage(long id, long ownerId, String address, double size, int rooms,
                   int beds, String description){

        this.id = id;
        this.ownerId = ownerId;
        this.address = address;
        this.size = size;
        this.rooms = rooms;
        this.beds = beds;
        this.description = description;

    }

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

    public void setId(long id) {
        this.id = id;
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
