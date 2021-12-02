package solid.liskovsubstitution.after;

import java.math.BigDecimal;

public interface WithdrawableAccount extends Account {

    void withdraw(BigDecimal amount);

}
