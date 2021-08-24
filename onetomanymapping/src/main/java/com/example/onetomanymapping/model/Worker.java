package com.example.onetomanymapping.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "Worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

   /* @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_dept_id",referencedColumnName = "id")
    private List<Department> departmentId;
    */
   /* @OneToMany(cascade =CascadeType.ALL )
    @JoinColumn(name = "fk_dept_id")
    private List<Department> department;
    */
}
