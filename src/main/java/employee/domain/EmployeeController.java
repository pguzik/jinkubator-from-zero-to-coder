package employee.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Piotrek
 */
@RestController
@RequestMapping(value = "/employee/{employeeId}")
public class EmployeeController {
    public static final BigDecimal RAISE = new BigDecimal(100.0);

    private DomainEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(DomainEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(value = "/raise", method = RequestMethod.PUT)
    public Employee giveRaise(@PathVariable("employeeId") Long employeeId) {
        final Employee employee = employeeRepository.getEmployeeById(employeeId).orElseThrow(
                IllegalArgumentException::new);
        return employee.raiseSalary(RAISE);
    }
}
