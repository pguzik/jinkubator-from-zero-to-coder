package employee.anemic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Piotrek
 */
@Repository
public interface AnemicEmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> getEmployeeById(Long id);
}
