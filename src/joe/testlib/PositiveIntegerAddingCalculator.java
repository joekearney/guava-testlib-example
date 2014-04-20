package joe.testlib;

/**
 * Calculator that only understands positive integers. All other parameter types are not supported.
 * 
 * @author Joe Kearney
 */
public final class PositiveIntegerAddingCalculator implements Calculator {
	@Override
	public Integer add(Number a, Number b) {
		return checkSupported(a) + checkSupported(b);
	}

	private static int checkSupported(Number val) {
		if (!(val instanceof Integer && val.intValue() >= 0)) {
			throw new IllegalArgumentException("This calculator only supports integer arguments, but found [" + val + "] of type " + val.getClass());
		}
		return val.intValue();
	}
}
