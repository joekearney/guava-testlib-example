guava-testlib-example
=====================

Guava Testlib was written to test collections implementations exhaustively. It's general enough to allow tests to be written for any interface and have them run against many different implementations.

Tests can be annotated with `Feature`s that correspond to differences in implementations of the interface specification &ndash; the same set of tests can be used to test mutable and immutable collections, for example, and the framework will decide which tests to add to which suite.
