package sunset.com.projeto.apisunset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sunset.com.projeto.apisunset.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}