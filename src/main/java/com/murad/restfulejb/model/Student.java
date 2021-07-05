package com.murad.restfulejb.model;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "City", nullable = false)
    private String city;
    @Column(name = "Region", nullable = false)
    private String region;
    @Column(name = "Zip", nullable = false)
    private String zip;
    @Column(name = "Country", nullable = false)
    private String country;
    
    public Student() {
    }
    
    public Student(final String name, final String email, final String city, final String region, final String zip, final String country) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.region = region;
        this.zip = zip;
        this.country = country;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public void setCity(final String city) {
        this.city = city;
    }
    
    public String getRegion() {
        return this.region;
    }
    
    public void setRegion(final String region) {
        this.region = region;
    }
    
    public String getZip() {
        return this.zip;
    }
    
    public void setZip(final String zip) {
        this.zip = zip;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(final String country) {
        this.country = country;
    }
}


