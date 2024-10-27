package spring.projects.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.projects.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
