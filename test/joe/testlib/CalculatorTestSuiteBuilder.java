package joe.testlib;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.testing.AbstractTester;
import com.google.common.collect.testing.FeatureSpecificTestSuiteBuilder;

public class CalculatorTestSuiteBuilder extends FeatureSpecificTestSuiteBuilder<CalculatorTestSuiteBuilder, CalculatorTestSubjectGenerator> {
	@SuppressWarnings("rawtypes")
	@Override
	protected List<Class<? extends AbstractTester>> getTesters() {
		return ImmutableList.<Class<? extends AbstractTester>>of();
	}

	public static CalculatorTestSuiteBuilder using(CalculatorTestSubjectGenerator generator) {
		CalculatorTestSuiteBuilder builder = new CalculatorTestSuiteBuilder();
		builder.usingGenerator(generator);
		return builder;
	}
}
