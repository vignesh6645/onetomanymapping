package com.example.onetomanymapping.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class WorkerDTO {

    private  Integer id;

    private String name;

    private Integer age;

    private List<DepartmentDTO> departmentDTO;


}
