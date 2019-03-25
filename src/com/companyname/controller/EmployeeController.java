package com.companyname.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.entity.Employee;
import com.companyname.model.EmployeeBean;
import com.companyname.service.EmployeeService;
@Controller
public class EmployeeController {
 
 @Autowired
 private EmployeeService employeeService;
 
 @RequestMapping(value = "/add", method = RequestMethod.GET)
 public ModelAndView addEmployee(@ModelAttribute("command")EmployeeBean employeeBean,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
  return new ModelAndView("addEmployee", model);
 }
 
@RequestMapping(value = "/save", method = RequestMethod.POST)
public ModelAndView saveEmployee(@ModelAttribute("command")EmployeeBean employeeBean, 
   BindingResult result) {
  Employee employee = prepareModel(employeeBean);
  employeeService.addEmployee(employee);
  return new ModelAndView("redirect:/add");
 }


 @RequestMapping(value="/employees", method = RequestMethod.GET)
 public ModelAndView listEmployees() {
	 Map<String, Object> model = new HashMap<String, Object>();
  model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
  return new ModelAndView("employeesList", model);
 }

private EmployeeBean prepareEmployeeBean(Employee employee){
	  EmployeeBean bean = new EmployeeBean();	
	  bean.setId(employee.getEmpId());
	  bean.setName(employee.getEmpName());
	  bean.setSalary(employee.getSalary());
	  
	  return bean;
	 }

 private Employee prepareModel(EmployeeBean employeeBean){
  Employee employee = new Employee();
  employee.setEmpId(employeeBean.getId());
  employee.setEmpName(employeeBean.getName());
  employee.setSalary(employeeBean.getSalary());
  return employee;
 }
 
 private List<EmployeeBean> prepareListofBean(List<Employee> employees){
  List<EmployeeBean> beans = null;
  if(employees != null && !employees.isEmpty()){
   beans = new ArrayList<EmployeeBean>();
   EmployeeBean bean = null;
   for(Employee employee : employees){
    bean = new EmployeeBean();
    bean.setId(employee.getEmpId());
    bean.setName(employee.getEmpName());
    bean.setSalary(employee.getSalary());
    beans.add(bean);
   }
  }
  return beans;
 }
 
 
}
