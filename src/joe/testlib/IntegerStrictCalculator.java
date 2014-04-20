package joe.testlib;

/**
 * Calculator that only understands integers. All other parameter types are not supported
 * 
 * @author Joe Kearney
 */
public final class IntegerStrictCalculator implements Calculator {
	@Override
	public Integer add(Number a, Number b) {
		checkSupported(a);
		checkSupported(b);
		return a.intValue() + b.intValue();
	}

	private static void checkSupported(Number a) {
		if (!(a instanceof Integer)) {
			throw new UnsupportedOperationException("This calculator only supports integer arguments, but found [" + a + "] of type " + a.getClass());
		}
	}

}
