package joe.testlib;

public class LyingCalculator implements Calculator {
	@Override
	public Number add(Number a, Number b) {
		return a.doubleValue() + b.doubleValue() + 3.0;
	}
}
