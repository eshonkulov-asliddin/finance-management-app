package com.asldev.financemanagementapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "expenses")
@Data
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_name")
    private String expenseName;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    // setters and getters
}
