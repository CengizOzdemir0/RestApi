package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nid;

    @NotNull
    @NotEmpty
    @Column(length = 100)
    @Length(min = 3, max = 100)
    private String title;
    @NotNull
    @NotEmpty
    @Column(length = 200)
    @Length(min = 2, max = 200)
    private String detail;


}
