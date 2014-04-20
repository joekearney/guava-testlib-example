package joe.testlib;

public interface Calculator {
	default Number add(Number a, Number b) {
		throw new UnsupportedOperationException();
	}
	default Number multiply(Number a, Number b) {
		throw new UnsupportedOperationException();
	}
}
