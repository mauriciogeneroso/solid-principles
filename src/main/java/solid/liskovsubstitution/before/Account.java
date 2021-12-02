package solid.liskovsubstitution.before;

import java.math.BigDecimal;

public interface Account {

    void deposit(BigDecimal amount);

    void withdraw(BigDecimal amount);
}
