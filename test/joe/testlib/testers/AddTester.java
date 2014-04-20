package joe.testlib.testers;

import joe.testlib.CalculatorFeature;
import joe.testlib.CalculatorFeature.Require;

@Require(CalculatorFeature.ADDITION)
public class AddTester extends CalculatorTester {
	public void testAddZero() {
		assertEqualsExact(add(0, 0), 0);
	}
	@Require(CalculatorFeature.POSITIVE_NUMBERS)
	public void testPositiveAddZero() {
		assertEqualsExact(add(1, 0), 1);
		assertEqualsExact(add(0, 1), 1);
	}
	@Require(CalculatorFeature.NEGATIVE_NUMBERS)
	public void testNegativeAddZero() {
		assertEqualsExact(add(-1, 0), -1);
		assertEqualsExact(add(0, -1), -1);
	}
	@Require({CalculatorFeature.POSITIVE_NUMBERS, CalculatorFeature.FLOATING_POINT_PARAMETERS})
	public void testPositiveFracAddZero() {
		assertEqualsExact(add(1.5, 0), 1.5);
		assertEqualsExact(add(0, 1.5), 1.5);
	}
	@Require({CalculatorFeature.NEGATIVE_NUMBERS, CalculatorFeature.FLOATING_POINT_PARAMETERS})
	public void testNegativeFracddZero() {
		assertEqualsExact(add(-1.5, 0), -1.5);
		assertEqualsExact(add(0, -1.5), -1.5);
	}

	@Require({CalculatorFeature.POSITIVE_NUMBERS, CalculatorFeature.INTEGER_PARAMETERS})
	public void testOnePlusOne() {
		Number result = add(1, 1);
		assertEqualsExact(result, 2);
	}
	@Require({CalculatorFeature.NEGATIVE_NUMBERS, CalculatorFeature.INTEGER_PARAMETERS})
	public void testMinusOnePlusMinusOne() {
		Number result = add(-1, -1);
		assertEqualsExact(result, -2);
	}
	@Require({CalculatorFeature.GENERAL_PURPOSE})
	public void testMinusOnePlusHalf() {
		Number result = add(-1, 0.5);
		assertEqualsExact(result, -0.5);
	}
	
	@Require(absent={CalculatorFeature.FLOATING_POINT_PARAMETERS})
	public void testFloatUnsupported_addFloat() {
		try {
			add(1, 0.5);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
		try {
			add(0.5, 0.5);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
		try {
			add(0.5, 1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
		try {
			add(0.6, 0.6);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
	}
	@Require(absent={CalculatorFeature.NEGATIVE_NUMBERS})
	public void testNegativeUnsupported_addNegative() {
		try {
			add(-1, 1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
		try {
			add(1, -1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
		try {
			add(-1, -1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {}
	}
}
