package com.example.onetomanymapping.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DepartmentDTO {

    private Integer dept_Id;


    private String dept_name;


    private Integer dept_members;
}
