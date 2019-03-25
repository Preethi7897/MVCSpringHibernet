package com.companyname.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyname.entity.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

 @Autowired
 private SessionFactory sessionFactory;
 
 public void addEmployee(Employee employee) {
   sessionFactory.getCurrentSession().saveOrUpdate(employee);
 }

 @SuppressWarnings("unchecked")
 public List<Employee> listEmployeess() {
  return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
 }

}
