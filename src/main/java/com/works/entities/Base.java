package com.works.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

// bu ben bir entity miras gidecek demektir.
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class Base {
    // inserti kim yaptı kaydı tutulur.
    @CreatedBy
    private String createBy;

    @LastModifiedBy
    private String lastModifiedBy;

    @CreatedDate
    private Long createDate;

    @LastModifiedDate
    private Long lastModifiedData;
}
