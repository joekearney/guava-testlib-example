package joe.testlib.testers;

import joe.testlib.CalculatorFeature;
import joe.testlib.CalculatorFeature.Require;

@Require(CalculatorFeature.MULTIPLICATION)
public class MultiplyTester extends CalculatorTester {
	public void testMultiplyZero() {
		assertEqualsExact(multiply(0, 0), 0);
	}

	@Require({CalculatorFeature.POSITIVE_NUMBERS, CalculatorFeature.INTEGER_PARAMETERS})
	public void testOneTimesOne() {
		assertEqualsExact(multiply(1, 1), 1);
	}
	@Require({CalculatorFeature.NEGATIVE_NUMBERS, CalculatorFeature.INTEGER_PARAMETERS})
	public void testMinusOneTimesMinusOne() {
		assertEqualsExact(multiply(-1, -1), 1);
	}
	@Require({CalculatorFeature.GENERAL_PURPOSE})
	public void testMinusOneTimesHalf() {
		assertEqualsExact(multiply(-1, 0.5), -0.5);
	}
	
	@Require(absent={CalculatorFeature.FLOATING_POINT_PARAMETERS})
	public void testFloatUnsupported_multiplyFloat() {
		try {
			multiply(1, 0.5);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
		try {
			multiply(0.5, 0.5);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
		try {
			multiply(0.5, 1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
		try {
			multiply(0.6, 0.6);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
	}
	@Require(absent={CalculatorFeature.NEGATIVE_NUMBERS})
	public void testNegativeUnsupported_multiplyNegative() {
		try {
			multiply(-1, 1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
		try {
			multiply(1, -1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
		try {
			multiply(-1, -1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
	}
}
