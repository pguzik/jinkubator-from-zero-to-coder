package employee.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Piotrek
 */
@Repository
public interface DomainEmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> getEmployeeById(Long id);
}
