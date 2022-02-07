package com.prahlad.study.splitwise.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {
    private String name;
    private String hashedPassword;
    private String phoneNumber;
}
