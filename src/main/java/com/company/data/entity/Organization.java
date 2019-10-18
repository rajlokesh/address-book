package com.company.data.entity;

import javax.persistence.*;

@Entity
@Table(name="ORGANIZATION")
public class Organization {
    @Id
    @Column(name="ORGANIZATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="PHONE")
    private String phone;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
