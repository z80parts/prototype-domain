package jp.prototype.domain.model;

import java.time.LocalDate;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import lombok.Data;

@Data
//@Entity
//@Table(name = "employee")
public class Employee {

//  @Id
  private String empId;

  private String empName;

  private String jobCd;

  private String deptId;

  private LocalDate hireDate;

  private LocalDate retireDate;

}
