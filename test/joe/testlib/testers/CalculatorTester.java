package joe.testlib.testers;

import static joe.testlib.Calculator.toBigDecimal;

import java.math.BigDecimal;

import joe.testlib.CalculatorTestSubjectGenerator;

import com.google.common.collect.testing.AbstractTester;

public class CalculatorTester extends AbstractTester<CalculatorTestSubjectGenerator> {
	protected static void assertEqualsExact(Number actual, long expected) {
		assertEqualsExact(toBigDecimal(actual), new BigDecimal(expected));
	}
	protected static void assertEqualsExact(Number actual, double expected) {
		assertEqualsExact(toBigDecimal(actual), new BigDecimal(expected));
	}
	protected static void assertEqualsExact(BigDecimal actual, BigDecimal expected) {
		assertTrue("Expected [" + expected + "] but got [" + actual + "]",
				actual.compareTo(expected) == 0);
	}

	protected Number add(Number a, Number b) {
		return getSubjectGenerator().createTestSubject().add(a, b);
	}
	protected Number multiply(Number a, Number b) {
		return getSubjectGenerator().createTestSubject().multiply(a, b);
	}
}