package controller;

import dao.EmployeeDao;
import model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.MyUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by Dinesh on 7/19/2015.
 */
@Controller(value = "/employee")
public class EmployeeController {

    private Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @RequestMapping(value = "/employees/{id}", produces = "application/json")
    @ResponseBody
    public Employee get(@PathVariable Integer id) {
        LOGGER.info("Received the request");
        Employee employee = null;
        try {
             employee = employeeDao.findOne(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        LOGGER.info("returning the employee:" + employee);
        return employee;
    }

    @RequestMapping(value = "/employees_Name/{name}", produces = "application/json")
    @ResponseBody
    public Employee get( @PathVariable String name) {
        LOGGER.info("Received the request");
        Employee employee = null;
        try {
            employee = employeeDao.findByName(name);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        LOGGER.info("returning the employee:" + employee);
        return employee;
    }

    @RequestMapping(value = "/employees", produces = "application/json")
    @ResponseBody
    public List<Employee> get() {
        LOGGER.info("Received the request");
        List<Employee> employees = MyUtils.makeList(employeeDao.findAll());
        LOGGER.info("returning the employees:" + employees.size());
        return employees;
    }

}
