package foo.bar;

import java.math.BigDecimal;

public enum SavingFrequency {
    EACH_DAY(BigDecimal.valueOf(1)),
    EACH_WEEK(BigDecimal.valueOf(7)),
    EACH_MONTH(BigDecimal.valueOf(30.42)),
    EACH_SECOND_DAY(BigDecimal.valueOf(2)),
    TWICE_A_WEEK(BigDecimal.valueOf(3.5)),
    ONCE_A_YEAR(BigDecimal.valueOf(365));

    private BigDecimal value;

    SavingFrequency(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;

    }
}
