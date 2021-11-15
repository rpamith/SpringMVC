package com.technicalkeeda.bean;
 
public class Employee {
 
 private int employeeId;
 
 private String firstName;
 
 private String lastName;
 
 private int salary;
 
 public int getEmployeeId() {
  return employeeId;
 }
 
 public String getFirstName() {
  return firstName;
 }
 
 public String getLastName() {
  return lastName;
 }
 
 public int getSalary() {
  return salary;
 }
 
 public void setEmployeeId(int employeeId) {
  this.employeeId = employeeId;
 }
 
 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }
 
 public void setLastName(String lastName) {
  this.lastName = lastName;
 }
 
 public void setSalary(int salary) {
  this.salary = salary;
 }
 
}