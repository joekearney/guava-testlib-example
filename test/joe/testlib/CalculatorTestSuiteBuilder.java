package joe.testlib;

import java.util.List;

import joe.testlib.testers.AddTester;
import joe.testlib.testers.MultiplyTester;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.testing.AbstractTester;
import com.google.common.collect.testing.FeatureSpecificTestSuiteBuilder;

public class CalculatorTestSuiteBuilder extends FeatureSpecificTestSuiteBuilder<CalculatorTestSuiteBuilder, CalculatorTestSubjectGenerator> {
	@SuppressWarnings("rawtypes")
	@Override protected List<Class<? extends AbstractTester>> getTesters() {
		return ImmutableList.of(AddTester.class, MultiplyTester.class);
	}
	public static CalculatorTestSuiteBuilder using(CalculatorTestSubjectGenerator generator) {
		return new CalculatorTestSuiteBuilder().usingGenerator(generator).named(generator.getName());
	}
}
