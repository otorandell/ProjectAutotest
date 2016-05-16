package screen.AT2ACCDI0003;

import core.CommonActions.CommonProcedures;
import core.CommonActions.Functions;
import core.TestDriver.TestDriver;
import core.recursiveData.recursiveXPaths;
import org.openqa.selenium.By;

/**
 * Created by otorandell on 29/12/2015.
 */
public class AT2ACCDI0003Test {

    protected AT2ACCDI0003Locators locators;
    protected AT2ACCDI0003Data data;

    public AT2ACCDI0003Test() {

    }

    public AT2ACCDI0003Locators getLocators() {
        return locators;
    }

    public void setLocators(AT2ACCDI0003Locators locators) {
        this.locators = locators;
    }

    public AT2ACCDI0003Data getData() {
        return data;
    }

    public void setData(AT2ACCDI0003Data data) {
        this.data = data;
    }

    public void start(TestDriver driver) {
        setScreenInfo(driver);
        driver.getTestdetails().setScreen("AT2BOOSA1002");
        CommonProcedures.goToScreen(driver);
        driver.getTestdetails().setScreen("AT2ACCDI0003");

    }
    protected void setScreenInfo(TestDriver driver) {
        driver.getTestdetails().setMainmenu("Accomodation");
        driver.getTestdetails().setSubmenu("Distribution");
        driver.getTestdetails().setScreen("Availability General");
    }
    protected String getElements(String key){
        String value = this.locators.getElements().get(key);
        return value;
    }
    protected String getData(String key){
        String value = this.data.getData().get(key);
        return value;
    }
    protected boolean testCSED(TestDriver driver) {
//3091401
           if(!getBookingProcedure(driver)){return false;}
        //   if(!webLabelLanguagesTabWebLabelLanguagesTableSearch(driver)){return false;}
        //   if(!webLabelLanguagesTabWebLabelLanguagesTableRecordInteraction(driver, false)){return false;}
        //   if(!webLabelLanguagesTabWebLabelLanguagesTableSearch(driver)){return false;} // COMMENTED FOR SOME REASON
        //   if(!webLabelLanguagesTabWebLabelLanguagesTableExtraActions(driver)){return false;} // COMMENTED FOR SOME REASON
        //   if(!webLabelLanguagesTabwebLabelLanguagesDescriptionTableTestCSED(driver)){return false;}
        //   if(!webLabelLanguagesTabWebLabelLanguagesTableSearch(driver)){return false;}
        //   if(!webLabelLanguagesTabWebLabelLanguagesTableDelete(driver)){return false;}
        return true;

    }

    private boolean getBookingProcedure(TestDriver driver) {
        if (!Functions.checkClick(driver,
                new String[]{"boosa1002_b_searchbook", getElements("boosa1002_b_searchbook")}, //element to click
                new String[]{"y", getElements("x")}, //element expected to appear
                " on AT2BOOSA1002")) {
            return false;
        }
        return true;
    }
}
