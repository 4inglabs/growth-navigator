package eb.inglabs.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AmountDaily {

    private BigDecimal amount;
    private LocalDateTime dateTime;

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public AmountDaily setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public AmountDaily setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
