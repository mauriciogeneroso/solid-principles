package solid.liskovsubstitution.after;

import java.math.BigDecimal;

public class CurrentAccount implements WithdrawableAccount {

    @Override
    public void deposit(BigDecimal amount) {
        // implementation
    }

    @Override
    public void withdraw(BigDecimal amount) {
        // implementation
    }
}
