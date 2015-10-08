package employee.anemic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Piotrek
 */
@Service
public class AnemicEmployeeService {
    public static final BigDecimal RAISE = new BigDecimal(100.0);

    private AnemicEmployeeRepository anemicEmployeeRepository;

    @Autowired
    public AnemicEmployeeService(AnemicEmployeeRepository anemicEmployeeRepository) {
        this.anemicEmployeeRepository = anemicEmployeeRepository;
    }

    public Employee getEmployeeById(Long employeeId) {
        return anemicEmployeeRepository.getEmployeeById(employeeId).orElseThrow(
                IllegalArgumentException::new);
    }

    public Employee raiseSalary(Employee employee) {
        BigDecimal salaryBeforeRaise = employee.getSalary();
        BigDecimal salaryAfterRaise = salaryBeforeRaise.add(RAISE);
        employee.setSalary(salaryAfterRaise);
        return employee;
    }
}
