package joe.testlib;

import java.math.BigDecimal;

/**
 * Calculator that translates all parameters to {@link BigDecimal} to do arithmetic.
 * 
 * @author Joe Kearney
 */
public final class BigDecimalCalculator implements Calculator {
	@Override
	public Number add(Number a, Number b) {
		return new BigDecimal(a.toString()).add(new BigDecimal(b.toString()));
	}
}
