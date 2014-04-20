package joe.testlib;

import static joe.testlib.CalculatorFeature.*;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TestsForCalculators {
	public static Test suite() {
		TestSuite suite = new TestSuite("Calculators");

		suite.addTest(CalculatorTestSuiteBuilder.using(new CalculatorTestSubjectGenerator() {
				@Override public Calculator createTestSubject() {
					return new BigDecimalCalculator();
				}})
			.withFeatures(GENERAL_PURPOSE)
			.createTestSuite());
		suite.addTest(CalculatorTestSuiteBuilder.using(new CalculatorTestSubjectGenerator() {
				@Override public Calculator createTestSubject() {
					return new IntegerCalculator();
				}})
			.withFeatures(INTEGER_PARAMETERS, ANY_SIGN, ANY_OPERATION)
			.createTestSuite());
		suite.addTest(CalculatorTestSuiteBuilder.using(new CalculatorTestSubjectGenerator() {
				@Override public Calculator createTestSubject() {
					return new PositiveIntegerAddingCalculator();
				}})
			.withFeatures(INTEGER_PARAMETERS, POSITIVE_NUMBERS, ADDITION)
			.createTestSuite());
//		suite.addTest(CalculatorTestSuiteBuilder.using(new CalculatorTestSubjectGenerator() {
//				@Override public Calculator createTestSubject() {
//					return new LyingCalculator();
//				}})
//			.withFeatures(CalculatorFeature.GENERAL_PURPOSE)
//			.createTestSuite());
		
		return suite;
	}
}
