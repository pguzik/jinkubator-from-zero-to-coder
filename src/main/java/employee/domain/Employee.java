package employee.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Piotrek
 */
@Entity
@Table(name = "DOMAIN_EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    @NotBlank
    private final String firstName;

    @Column(name = "last_name")
    @NotBlank
    private final String lastName;

    @Column(name = "salary")
    @NotNull
    private final BigDecimal salary;

    public Employee(String firstName, String lastName, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    Employee raiseSalary(BigDecimal raise) {
        BigDecimal salaryBeforeRaise = this.salary;
        BigDecimal salaryAfterRaise = salaryBeforeRaise.add(raise);
        return new Employee(this.firstName, this.lastName, salaryAfterRaise);
    }
}
