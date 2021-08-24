package com.example.onetomanymapping.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_Id")
    private Integer Id;

    @Column(name = "dept_name")
    private String dept_name;

    @Column(name = "dept_members")
    private Integer dept_members;


    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "worker_id")
    private Worker worker;
}
