Guava Testlib was written to test collections implementations exhaustively. It's general enough to allow tests to be written for any interface and have them run against many different implementations. It generates the cross product (filtered according to features) of tests and implementations and puts them in a nice hierarchy that looks great in Eclipse.

Tests can be annotated with `Feature`s that correspond to differences in implementations of the interface specification &ndash; the same set of tests can be used to test mutable and immutable collections, for example, and the framework will decide which tests to add to which suite.

This project shows a simple and contrived example of how to set up these tests. We have a `Calculator` interface and various implementations that support some of the operations for some of the parameters.
***
# What are the components?

* `FeatureSpecificTestSuiteBuilder` &ndash; this creates the test suite. Extend this, pass it a subject generator and call `createTestSuite`. This is where the set of tester classes is declared.
* `TestSubjectGenerator` &ndaash; this is just a supplier of your implementation.
* `AbstractTester` &ndash; extend this to provide actual tests. Test methods should be JUnit 3 style tests, not using `@Test` annotations. This class provides access to the subject generator. You might also want an abstract subclass fro m which your test cases extend if you want to give default assertion methods, for example.
