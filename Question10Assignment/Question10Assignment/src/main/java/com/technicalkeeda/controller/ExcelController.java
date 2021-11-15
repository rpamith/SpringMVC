package com.technicalkeeda.controller;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import com.technicalkeeda.bean.Employee;
 
@Controller
public class ExcelController {
 
 @RequestMapping(value = "/generate/excel.htm", method = RequestMethod.GET)
 ModelAndView generateExcel(HttpServletRequest request,
   HttpServletResponse response) throws Exception {
  System.out.println("Calling generateExcel()...");
  
  Employee yashwant = new Employee();
  yashwant.setEmployeeId(1);
  yashwant.setFirstName("Amith");
  yashwant.setLastName("Kumar");
  yashwant.setSalary(30000);
  
  Employee mahesh = new Employee();
  mahesh.setEmployeeId(2);
  mahesh.setFirstName("Ajith");
  mahesh.setLastName("Kumar");
  mahesh.setSalary(10000);
  
  List employees = new ArrayList();
  employees.add(amith);
  employees.add(ajith);
  
  ModelAndView modelAndView = new ModelAndView("excelView", "employees",employees);
  
  return modelAndView;
 }
}