package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;

/**
 * Created by Robert.Dumitrescu on 7/12/2017.
 */
public class Location {
    @Id(name = "location_id")
    private Long id;
    @Column(name = "location_streetAddress")
    private String streetAddress;
    @Column(name = "location_postalCode")
    private String postalCode;
    @Column(name = "location_city")
    private String city;
    @Column(name = "location_stateProvince")
    private String stateProvince;

    public long getId() {
        return id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
