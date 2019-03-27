package eb.inglabs.model;

import java.math.BigDecimal;

public class AmountWeekly {

    private BigDecimal amount;
    private int week;

    public AmountWeekly setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public AmountWeekly setWeek(int week) {
        this.week = week;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getWeek() {
        return week;
    }
}
