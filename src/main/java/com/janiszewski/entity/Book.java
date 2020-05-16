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
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="TITLE",
            nullable = false,
            insertable = true,
            updatable = true)
    private String title;

    @Column(name="ISBN")
    private String isbn;

    @Temporal(TemporalType.DATE)
    @Column(name="ISSUE_DATE")
    private Date issueDate;

    /*
    public Book() { super(); }

    public Book(String title, String isbn, Date issueDate) {
        super();
        this.title = title;
        this.isbn = isbn;
        this.issueDate = issueDate;
    }
     */
}
