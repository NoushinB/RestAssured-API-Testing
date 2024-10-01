package hooks;

import core.library.Constants;
import core.library.PropertyLoader;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {

    @BeforeAll
    public static void setup() {
        PropertyLoader.getInstance().setBaseUrl(Constants.Urls.BASE_URL);
    }

    @Before
    public static void beforeTest() {

    }

    @After
    public static void afterTest() {

    }

    @AfterAll
    public static void teardown() {

    }
}