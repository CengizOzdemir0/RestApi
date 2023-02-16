package com.works.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iid;

    private String url;
    private String roles;
    private String username;
    private String detail;
    private String agent;
    private Long date;


}
