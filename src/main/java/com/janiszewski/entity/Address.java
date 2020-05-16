package com.janiszewski.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name="ADDRESS_STREET")
    private String addressStreet;

    @Column(name="ADDRESS_CITY")
    private String addressCity;

    @Column(name="ADDRESS_COUNTRY")
    private String addressCountry;

    /*
    public Address() { super(); }
    public Address(String addressStreet, String addressCity, String addressCountry) {
        super();
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressCountry = addressCountry;
    }*/
}
