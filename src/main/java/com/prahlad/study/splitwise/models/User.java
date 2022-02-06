package com.prahlad.study.splitwise.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name= "users")
public class User extends BaseModel {
    String name;
    String hashedPassword;
    String phoneNumber;
}
