package camp.nextstep.edu.calculator;

import java.util.Objects;

public class CalculatorNumber {
    static final CalculatorNumber ZERO = new CalculatorNumber(0);

    private int value;

    public static CalculatorNumber of(final String number) {
        return new CalculatorNumber(number);
    }

    private CalculatorNumber(final int number) {
        this.value = number;
    }

    private CalculatorNumber(final String number) {
        try {
            this.value = Integer.parseInt(number);
            checkNegativeValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be numeric.", e);
        }
    }

    private void checkNegativeValue() {
        if (this.value < 0) {
            throw new IllegalArgumentException("Value must be greater than or equal to zero.");
        }
    }

    public CalculatorNumber add(final CalculatorNumber number) {
        return new CalculatorNumber(this.value + number.value);
    }

    public int toInt() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorNumber number = (CalculatorNumber) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
