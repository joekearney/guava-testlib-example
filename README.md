Guava Testlib was written to test collections implementations exhaustively. It's general enough to allow tests to be written for any interface and have them run against many different implementations. It generates the cross product (filtered according to features) of tests and implementations and puts them in a nice hierarchy that looks great in Eclipse.

Tests can be annotated with `Feature`s that correspond to differences in implementations of the interface specification &ndash; the same set of tests can be used to test mutable and immutable collections, for example, and the framework will decide which tests to add to which suite.

This project shows a simple and contrived example of how to set up these tests. We have a `Calculator` interface and various implementations that support some of the operations for some of the parameters.

***

# What are the components?

* `FeatureSpecificTestSuiteBuilder` &ndash; this creates the test suite. Extend this, pass it a subject generator and call `createTestSuite`. This is where the set of tester classes is declared.
* `TestSubjectGenerator` &ndaash; this is just a supplier of your implementation.
* `AbstractTester` &ndash; extend this to provide actual tests. Test methods should be JUnit 3 style tests, not using `@Test` annotations. This class provides access to the subject generator. You might also want an abstract subclass fro m which your test cases extend if you want to give default assertion methods, for example.

# Let's get started

We'll start with a really simple calculator interface. We can consider an implementation that uses `BigDecimal` to make accurate calculations, and a strict integer calculator that doesn't know about decimals and throws if passed anything other than an `Integer`.

```java
public interface Calculator {
	default Number add(Number a, Number b) { throw new UnsupportedOperationException(); }
	default Number multiply(Number a, Number b) { throw new UnsupportedOperationException(); }
}
```

Tag [`01-basic-code`](https://github.com/joekearney/guava-testlib-example/tree/01-basic-code) provides first basic implementations of our `Calculator` API. Tag [`02-basic-testlib`](https://github.com/joekearney/guava-testlib-example/tree/02-basic-testlib) adds the basics of the test framework. In particular, the test suite builder:

```java
public class CalculatorTestSuiteBuilder extends
      FeatureSpecificTestSuiteBuilder<CalculatorTestSuiteBuilder, CalculatorTestSubjectGenerator> {
	@Override
	protected List<Class<? extends AbstractTester>> getTesters() {
		return ImmutableList.<Class<? extends AbstractTester>>of();
	}
	public static CalculatorTestSuiteBuilder using(CalculatorTestSubjectGenerator generator) {
		return new CalculatorTestSuiteBuilder().usingGenerator(generator);
	}
}
```

As soon as we write any test classes we'll add those classes to the list returned from `getTesters`.

# Writing a first test

To start with, let's write a superclass for our test cases, which can contain the common assertions and functions that we'll want to use.

```java
public class CalculatorTester extends AbstractTester<CalculatorTestSubjectGenerator> {
	protected static void assertEqualsExact(Number actual, long expected) {
		assertTrue("Expected [" + expected + "] but got [" + actual + "]",
			toBigDecimal(actual).compareTo(new BigDecimal(expected)) == 0);
	}
	/** Converts some useful classes of {@link Number} to {@link BigDecimal}. */
	private static BigDecimal toBigDecimal(Number actual) { ... }
}
```

We'll divide the test cases by the separate features of the Calculator that we're testing.

```java
public class AddTester extends CalculatorTester {
	public void testAddZero() throws Exception {
		Number result = getSubjectGenerator().createTestSubject().add(0, 0);
		assertEqualsExact(result, 0);
	}
}
```
