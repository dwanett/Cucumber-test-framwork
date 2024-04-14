package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.assertj.core.api.SoftAssertions;
import steps.ExampleSteps;

public class Hooks {

	public static SoftAssertions softAssertions;

	@Before
    public static void setUp() {
		softAssertions = new SoftAssertions();
		System.out.println("Сработал Before");
    }

	@After
	public static void tearDown(Scenario scenario) {
		System.out.println("Сработал After");
		softAssertions.assertAll();
	}
}