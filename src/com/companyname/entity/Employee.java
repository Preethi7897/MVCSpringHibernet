package com.companyname.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee implements Serializable{

 private static final long serialVersionUID = -723583058586873479L;
 
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name = "empid")
 private Integer empId;
 
 @Column(name="empname")
 private String empName;

 @Column(name="salary")
 private double salary;
 
 public Integer getEmpId() {
  return empId;
 }

 public void setEmpId(Integer empId) {
  this.empId = empId;
 }

 public String getEmpName() {
  return empName;
 }

 public void setEmpName(String empName) {
  this.empName = empName;
 }

 public double getSalary() {
  return salary;
 }

 public void setSalary(double salary) {
  this.salary = salary;
 }

}
