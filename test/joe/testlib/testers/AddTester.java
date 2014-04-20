package joe.testlib.testers;

public class AddTester extends CalculatorTester {
	public void testAddZero() throws Exception {
		Number result = getSubjectGenerator().createTestSubject().add(0, 0);
		assertEqualsExact(result, 0);
	}
}
