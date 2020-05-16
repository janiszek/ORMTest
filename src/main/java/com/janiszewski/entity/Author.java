package com.janiszewski.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name="BIRTH_DATE")
    private Date birthDate;

    @Embedded
    private Address address;

    /*
    public Author() { super(); }

    public Author(String firstName, String lastName, Date birthDate) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    */
}
