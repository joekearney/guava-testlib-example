package joe.testlib;

import com.google.common.collect.testing.TestSubjectGenerator;

public abstract class CalculatorTestSubjectGenerator implements TestSubjectGenerator<Calculator> {
	String getName() {
		return createTestSubject().getClass().getSimpleName();
	}
}
