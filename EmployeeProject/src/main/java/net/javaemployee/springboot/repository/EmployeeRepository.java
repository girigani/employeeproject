package net.javaemployee.springboot.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.javaemployee.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("SELECT e FROM Employee e WHERE e.name LIKE %?1%" + "OR e.email LIKE %?1%" + "OR e.id LIKE %?1%" + "OR e.age LIKE %?1%" + "OR e.sal LIKE %?1%" )
	public List<Employee> findBykeyword(String keyword);
}