package com.technicalkeeda.view;
 
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.technicalkeeda.bean.Employee;
 
public class ExcelView extends AbstractXlsView {
	
@Override
protected void buildExcelDocument(Map<String, Object> model, 
		Workbook workbook, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	  List<Employee> employees = (List) model.get("employees");
	  HSSFSheet sheet = (HSSFSheet) workbook.createSheet("Employee Report");
	  HSSFRow header = sheet.createRow(0);
	  header.createCell(0).setCellValue("Employee Id");
	  header.createCell(1).setCellValue("First Name");
	  header.createCell(2).setCellValue("Last Name");
	  header.createCell(3).setCellValue("Salary");
	  int counter = 1;
	  for (Employee e : employees) {
	   HSSFRow row = sheet.createRow(counter++);
	   row.createCell(0).setCellValue(e.getEmployeeId());
	   row.createCell(1).setCellValue(e.getFirstName());
	   row.createCell(2).setCellValue(e.getLastName());
	   row.createCell(3).setCellValue(e.getSalary());
	  }
	 }
	
}
