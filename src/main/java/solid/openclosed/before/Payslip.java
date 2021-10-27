package solid.openclosed.before;

import java.math.BigDecimal;

public class Payslip {

    private BigDecimal balance;

    private void calculate(Object employee) {
        if (employee instanceof FullTimeContract) {
            balance = ((FullTimeContract) employee).salary();
        } else if (employee instanceof PartTimeContract) {
            balance = ((PartTimeContract) employee).salary();
        } else if (employee instanceof Contractor) {
            balance = ((Contractor) employee).payment();
        } else {
            throw new IllegalArgumentException("Invalid employee type: "
                    + employee.getClass().getName());
        }
    }
}
