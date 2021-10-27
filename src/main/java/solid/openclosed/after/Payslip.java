package solid.openclosed.after;

import java.math.BigDecimal;

public class Payslip {

    private BigDecimal balance;

    public void calculate(Employee employee) {
        this.balance = employee.getSalary();
    }
}
