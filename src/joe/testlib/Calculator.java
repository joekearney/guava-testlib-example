package joe.testlib;

import java.math.BigDecimal;

public interface Calculator {
	default Number add(Number a, Number b) { throw new UnsupportedOperationException(); }
	default Number multiply(Number a, Number b) { throw new UnsupportedOperationException(); }
	
	/** Converts some useful classes of {@link Number} to {@link BigDecimal}. */
	public static BigDecimal toBigDecimal(Number num) {
		if (num instanceof BigDecimal) {
			return (BigDecimal) num;
		} else if (num instanceof Long || num instanceof Integer) {
			return new BigDecimal(num.longValue());
		} else if (num instanceof Double || num instanceof Float) {
			return new BigDecimal(num.doubleValue());
		} else {
			return new BigDecimal(num.toString());
		}
	}
}
