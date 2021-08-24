package com.example.onetomanymapping.controller;

import com.example.onetomanymapping.DTO.WorkerDTO;
import com.example.onetomanymapping.baseresponse.BaseResponse;
import com.example.onetomanymapping.model.Department;
import com.example.onetomanymapping.serviece.WorkerServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/worker")
@RestController
public class WorkerController {

    @Autowired
    private WorkerServiece workerServiece;

    @PostMapping("/add")
    public BaseResponse add(@RequestBody WorkerDTO workerDTO) {
        return workerServiece.add(workerDTO);
    }

    @GetMapping("/getAll")
    public List<Department> list(){
        return workerServiece.listAll();
    }

    @DeleteMapping("/deletall")
    public BaseResponse deleted( ){
        return workerServiece.deleted();
    }

    @PutMapping("/Update")
    public BaseResponse updatedetail(@RequestBody WorkerDTO workerDTO) {
        return workerServiece.updatedetail(workerDTO);
    }
   @GetMapping("/workerbyid/{id}")
    public Department findWorkerById(@PathVariable int id){
        return workerServiece.getWorkerById(id);
   }

}
