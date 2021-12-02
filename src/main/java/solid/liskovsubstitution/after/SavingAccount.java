package solid.liskovsubstitution.after;

import solid.liskovsubstitution.before.Account;

import java.math.BigDecimal;

public class SavingAccount implements WithdrawableAccount {

    @Override
    public void deposit(BigDecimal amount) {
        // implementation
    }

    @Override
    public void withdraw(BigDecimal amount) {
        // implementation
    }
}
