package com.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "admin_system")
public class Challanfield {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "place")
    private String place;

    @Column(name = "license_number")
    private Integer license_number;

    @Column(name = "vehicle_number")
    private String vehicle_number;

    @Column(name = "vehicle_type")
    private String vehicle_type;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "challan_type")
    private String challan_type;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getLicense_number() {
        return license_number;
    }

    public void setLicense_number(Integer license_number) {
        this.license_number = license_number;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getChallan_type() {
        return challan_type;
    }

    public void setChallan_type(String challan_type) {
        this.challan_type = challan_type;
    }
}
