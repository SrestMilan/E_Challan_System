package com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adminpanel")
public class Challanfield {
    // for ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID ")
    private long id;

//for full name
    @Column(name = "Name")
    private String Name;

    // for place
    @Column(name = "Place ")
    private String Place;

    // for License Number
    @Column(name = "License Number")
    private int  LicenseNumber;

    // for Vehicle Number
    @Column(name = " Vehicle Number")
    private String   VehicleNumber;

    // for Vehicle Type
    @Column(name = " Vehicle Type")
    private String   VehicleType;

    // for Created_By
    @Column(name = " Created_By")
    private String    Created_By;

    // for Rule Voilence
    @Column(name = " Rule Voilence")
    private String     RuleVoilence;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public int getLicenseNumber() {
        return LicenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        LicenseNumber = licenseNumber;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }

    public String getRuleVoilence() {
        return RuleVoilence;
    }

    public void setRuleVoilence(String ruleVoilence) {
        RuleVoilence = ruleVoilence;
    }
}
