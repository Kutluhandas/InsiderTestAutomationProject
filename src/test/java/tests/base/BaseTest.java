package tests.base;

import driver.DriverManager;
import org.junit.jupiter.api.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    /*
       We can use following variable if we would like to run manually.
    */
    //static String browser = "chrome";
    static String browser = System.getProperty("browser");

    @BeforeAll
    public static void setUp(){
        DriverManager.initialize(browser);
    }

    @AfterAll
    void tearDown() {
        DriverManager.tearDown();
        }
    }



