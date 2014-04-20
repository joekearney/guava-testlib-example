package joe.testlib;

/**
 * Calculator that only understands integers. All other parameter types are not supported
 * 
 * @author Joe Kearney
 */
public final class IntegerCalculator implements Calculator {
	@Override
	public Integer add(Number a, Number b) {
		return checkSupported(a) + checkSupported(b);
	}
	@Override
	public Integer multiply(Number a, Number b) {
		return checkSupported(a) * checkSupported(b);
	}

	private static int checkSupported(Number val) {
		if (!(val instanceof Integer)) {
			throw new IllegalArgumentException("This calculator only supports integer arguments, but found [" + val + "] of type " + val.getClass());
		}
		return val.intValue();
	}
}
