package screen.AT2MDMOR0028;

import core.TestDriver.TestDriver;
import screen.AT2MDMCL0030.AT2MDMCL0030Data;
import screen.AT2MDMCL0030.AT2MDMCL0030Locators;
import screen.AT2MDMCL0030.AT2MDMCL0030Test;
import screen.AT2Test;

import java.util.Map;

/**
 * Created by otorandell on 08/04/2016.
 */
public class AT2MDMOR0028Manager implements AT2Test {
    AT2MDMOR0028Test test;
    String[] procedure;

    public AT2MDMOR0028Manager() {
        setTest(new AT2MDMOR0028Test());
        this.test.setData(new AT2MDMOR0028Data());
        this.test.setLocators(new AT2MDMOR0028Locators());
    }

    public String[] getProcedure() {
        return procedure;
    }

    public AT2MDMOR0028Test getTest() {
        return test;
    }

    public Map<String, String> getData() {
        return this.test.getData().getData();}

    public void setTest(AT2MDMOR0028Test test) {
        this.test = test;
    }

    public void setProcedure(String[] procedure) {
        this.procedure = procedure;
    }

    public boolean start(TestDriver driver) {
        setProcedure(driver.getTestdetails().getCsedProcedure().split(""));
        getTest().start(driver);
        if (!csedIteration(driver)) {
            return false;
        }
        return true;
    }

    private boolean csedIteration(TestDriver driver) {
                if (!getTest().testCSED(driver)) {
                    return false;
                }
        return true;

    }
}
