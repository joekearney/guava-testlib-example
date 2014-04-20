Guava Testlib was written to test collections implementations exhaustively. It's general enough to allow tests to be written for any interface and have them run against many different implementations. It generates the cross product (filtered according to features) of tests and implementations and puts them in a nice hierarchy that looks great in Eclipse.

Tests can be annotated with `Feature`s that correspond to differences in implementations of the interface specification &ndash; the same set of tests can be used to test mutable and immutable collections, for example, and the framework will decide which tests to add to which suite.

This project shows a simple and contrived example of how to set up these tests. We have a `Calculator` interface and various implementations that support some of the operations for some of the parameters.

***

# What are the components?

* `FeatureSpecificTestSuiteBuilder` &ndash; this creates the test suite. Extend this, pass it a subject generator and call `createTestSuite`. This is where the set of tester classes is declared.
* `TestSubjectGenerator` &ndaash; this is just a supplier of your implementation.
* `AbstractTester` &ndash; extend this to provide actual tests. Test methods should be JUnit 3 style tests, not using `@Test` annotations. This class provides access to the subject generator. You might also want an abstract subclass fro m which your test cases extend if you want to give default assertion methods, for example.

# Let's get started

We'll work through commits to this repository.

Tag [`01-basic-code`](https://github.com/joekearney/guava-testlib-example/tree/01-basic-code) provides first basic implementations of our `Calculator` API. Tag [`02-basic-testlib`](https://github.com/joekearney/guava-testlib-example/tree/02-basic-testlib) adds the basics of the test framework. In particular:

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
