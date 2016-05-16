package screen;


import core.TestDriver.TestDriver;

import java.util.Map;

/**
 * Created by otorandell on 12/01/2016.
 */
public interface AT2Test {

    /**
     * This method is common in all test and it's which makes the test sart and run all the specific oprations.
     * @param driver    Object that manages and runs all the test.
     */
    boolean start(TestDriver driver);
    Map<String, String> getData();
}
