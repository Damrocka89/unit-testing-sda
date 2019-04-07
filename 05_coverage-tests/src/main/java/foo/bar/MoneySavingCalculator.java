package foo.bar;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Period;

public class MoneySavingCalculator {

    public BigDecimal calculateSavings(
            SavingFrequency frequency,
            BigDecimal singleAmmount,
            Period duration
    ) {

        return singleAmmount.multiply(calculateDuration(duration)).divide(frequency.getValue(),8,BigDecimal.ROUND_HALF_UP).setScale(1, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateDuration(Period duration){
        int years=duration.getYears();
        int month=duration.getMonths();
        int days=duration.getDays();
        return BigDecimal.valueOf(days+month*30.42+years*365);
    }
}
