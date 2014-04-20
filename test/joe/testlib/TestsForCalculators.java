package joe.testlib;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestsForCalculators {
	public static Test suite() {
		TestSuite suite = new TestSuite("Calculators");
		
		suite.addTest(CalculatorTestSuiteBuilder.using(new CalculatorTestSubjectGenerator() {
				@Override
				public Calculator createTestSubject() {
					return new BigDecimalCalculator();
				}
			})
			.named("BigDecimalCalculator")
			.createTestSuite());
		
		return suite;
	}
}
