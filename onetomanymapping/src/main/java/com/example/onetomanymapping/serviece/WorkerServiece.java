package com.example.onetomanymapping.serviece;


import com.example.onetomanymapping.DTO.WorkerDTO;
import com.example.onetomanymapping.baseresponse.BaseResponse;
import com.example.onetomanymapping.model.Department;
import com.example.onetomanymapping.model.Worker;
import com.example.onetomanymapping.repository.DepartmentRepository;
import com.example.onetomanymapping.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class WorkerServiece {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    public BaseResponse add(WorkerDTO workerDTO) {

        Worker worker = new Worker();
        BaseResponse baseResponse = new BaseResponse();
        worker.setName(workerDTO.getName());
        worker.setAge(workerDTO.getAge());
        workerRepository.save(worker);

        workerDTO.getDepartmentDTO().stream().forEachOrdered(departmentDTO -> {

            Department department = new Department();
            department.setDept_name(departmentDTO.getDept_name());
            department.setDept_members(departmentDTO.getDept_members());
            department.setWorker(worker);
            departmentRepository.save(department);
        });

        baseResponse.setData(workerDTO);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");

        return baseResponse;
    }

    public List<Department> listAll() {

        return departmentRepository.findAll();
    }

    public Department getWorkerById(Integer id){
        return departmentRepository.findById(id).orElse(null);
    }

    public BaseResponse deleted() {
        BaseResponse baseResponse = new BaseResponse();
        workerRepository.deleteAll();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("employee info deleted successfully..");
        return baseResponse;
    }
    public BaseResponse updatedetail(WorkerDTO workerDTO) {

        Worker existworker = workerRepository.findById(workerDTO.getId()).orElse(null);
        BaseResponse baseResponse=new BaseResponse();
        existworker.setName(workerDTO.getName());
        existworker.setAge(workerDTO.getAge());
        workerRepository.save(existworker);

        workerDTO.getDepartmentDTO().stream().forEachOrdered(departmentDTO -> {

            Department existdepartment = departmentRepository.findById(departmentDTO.getDept_Id()).orElse(null);
            existdepartment.setDept_name(departmentDTO.getDept_name());
            existdepartment.setDept_members(departmentDTO.getDept_members());
            existdepartment.setWorker(existworker);
            departmentRepository.save(existdepartment);
        });
        baseResponse.setData(workerDTO);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        return baseResponse;
    }
    /*public BaseResponse getworkerbyId(int id){
        return workerRepository.findById(id).orElse(null);
    }*/
}


/*public BaseResponse det(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BaseResponse baseResponse = new BaseResponse();
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmpAge(employeeDTO.getEmpAge());
        employeeRepository.save(employee);
        employeeDTO.getAddressDTO().stream().forEachOrdered(addressDTO -> {
            Address address = new Address();
            address.setCity(addressDTO.getCity());
            address.setPincode(addressDTO.getPincode());
            address.setEmployee(employee);
            addressRepository.save(address);
        });
        baseResponse.setData(employeeDTO);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("sucess");
        return baseResponse;
    }*/
