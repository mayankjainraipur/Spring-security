package com.login.security.controller;


import com.login.security.model.Employee;
import com.login.security.model.Storage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @RequestMapping(value="/add",method=RequestMethod.POST, consumes = {"application/JSON"})
    public String addEmployee(@RequestBody Employee emp)
    {
        Storage str = new Storage();
        boolean res = str.addEmployee(emp);
        if(res)
            return "Success";
        else
            return "Failed";
    }

    @RequestMapping(value="/get/emp/{id}",method=RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id")int id)
    {
        Storage str = new Storage();
        Employee emp = str.getEmployee(id);
        System.out.println(emp);
        return emp;
    }

    @RequestMapping(value="/getAll",method=RequestMethod.GET)
    public List<Employee> getAll()
    {
        Storage str = new Storage();
        return str.listAll();
    }

    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public String delete(@PathVariable("id")int id)
    {
        Storage str = new Storage();
        boolean res = str.deleteEmployee(id);
        if(res)
            return "Success";
        else
            return "false";
    }

}
