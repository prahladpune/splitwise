package com.prahlad.study.splitwise.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Map;

@Setter
@Getter
@Entity
public class Expense extends BaseModel {

    @ElementCollection
    Map<User, Long> owedBy;
    @ElementCollection
    Map<User, Long> paidBy;
    private long amount;
    private Currency currency;
    private String description;
    @ManyToOne
    private User createdBy;

}
