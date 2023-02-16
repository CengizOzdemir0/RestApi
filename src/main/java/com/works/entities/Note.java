package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Note extends Base{
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
