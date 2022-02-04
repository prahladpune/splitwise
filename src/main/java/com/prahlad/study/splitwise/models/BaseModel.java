package com.prahlad.study.splitwise.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Id
    private int id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate modifiedAt;

}
