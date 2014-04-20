package joe.testlib;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestsForCalculators {
	public static Test suite() {
		TestSuite suite = new TestSuite("Calculators");

		suite.addTest(CalculatorTestSuiteBuilder.using(new CalculatorTestSubjectGenerator() {
				@Override public Calculator createTestSubject() {
					return new BigDecimalCalculator();
				}})
			.named("BigDecimalCalculator")
			.createTestSuite());
		suite.addTest(CalculatorTestSuiteBuilder.using(new CalculatorTestSubjectGenerator() {
			@Override public Calculator createTestSubject() {
				return new IntegerStrictCalculator();
			}})
		.named("IntegerStrictCalculator")
		.createTestSuite());
		suite.addTest(CalculatorTestSuiteBuilder.using(new CalculatorTestSubjectGenerator() {
				@Override public Calculator createTestSubject() {
					return new LyingCalculator();
				}})
			.named("LyingCalculator")
			.createTestSuite());
		
		return suite;
	}
}
