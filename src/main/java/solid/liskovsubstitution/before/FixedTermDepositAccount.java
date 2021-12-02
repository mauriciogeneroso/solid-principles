package solid.liskovsubstitution.before;

import java.math.BigDecimal;

public class FixedTermDepositAccount implements Account {

    @Override
    public void deposit(BigDecimal amount) {
        // implementation
    }

    @Override
    public void withdraw(BigDecimal amount) {
        throw new UnsupportedOperationException("Withdrawals are not supported by FixedTermDepositAccount!!");
    }
}
