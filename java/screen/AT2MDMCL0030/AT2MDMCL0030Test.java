package screen.AT2MDMCL0030;

import core.CommonActions.CommonProcedures;
import core.CommonActions.DataGenerator;
import core.CommonActions.Functions;
import core.TestDriver.TestDriver;
import core.recursiveData.recursiveXPaths;
import org.openqa.selenium.By;
import screen.AT2Test;

/**
 * Created by otorandell on 29/12/2015.
 */
public class AT2MDMCL0030Test{

    protected AT2MDMCL0030Locators locators;
    protected AT2MDMCL0030Data data;

    public AT2MDMCL0030Test() {

    }

    public AT2MDMCL0030Locators getLocators() {
        return locators;
    }

    public void setLocators(AT2MDMCL0030Locators locators) {
        this.locators = locators;
    }

    public AT2MDMCL0030Data getData() {
        return data;
    }

    public void setData(AT2MDMCL0030Data data) {
        this.data = data;
    }

    public void start(TestDriver driver) {
        setScreenInfo(driver);
        CommonProcedures.goToScreen(driver);
    }
    protected void setScreenInfo(TestDriver driver) {
        driver.getTestdetails().setMainmenu("Master Data");
        driver.getTestdetails().setSubmenu("Client");
        driver.getTestdetails().setScreen("Partner agency parameters 2.0");
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

        if (recordInteraction(driver, true)) {
        if (search(driver)) {
        if (recordInteraction(driver, false)) {
        if (search(driver)) {
        if (delete(driver)) {
            return true;}}}}}
        return false;
    }

    protected boolean recordInteraction(TestDriver driver, boolean add) {

            if (add) {

                if(!Functions.checkClick(driver,
                        new String[]{"record_interaction_b_add", getElements("record_interaction_b_add")},
                        new String[]{"glass", recursiveXPaths.glass},
                        "")){return false;}
                if(!Functions.insertInput(driver,
                        new String[]{"record_interaction_i_param_name", getElements("record_interaction_i_param_name")},
                        "param_name",
                        getData("param_name"),
                        " on ADD")){return false;}
                if(!Functions.insertInput(driver,
                        new String[]{"record_interaction_i_param_value", getElements("record_interaction_i_param_value")},
                        "param_value",
                        getData("param_value"),
                        " on ADD")){return false;}
                if(!Functions.insertInput(driver,
                        new String[]{"record_interaction_i_age_ext_code", getElements("record_interaction_i_age_ext_code")},
                        "age_ext_code",
                        getData("age_ext_code"),
                        " on ADD")){return false;}
                if(!Functions.checkClickByAbsence(driver,
                        new String[]{"record_interaction_b_save", getElements("record_interaction_b_save")},
                        new String[]{"glass", recursiveXPaths.glass},
                        " on ADD")){return false;}

            } else {

                if(!Functions.checkClick(driver,
                        new String[]{"record_interaction_b_edit", getElements("record_interaction_b_edit")},
                        new String[]{"glass", recursiveXPaths.glass},
                        "")){return false;}
                if(!Functions.insertInput(driver,
                        new String[]{"record_interaction_i_param_name", getElements("record_interaction_i_param_name")},
                        "param_name",
                        getData("update_"+"param_name"),
                        " on EDIT")){return false;}
                if(!Functions.insertInput(driver,
                        new String[]{"record_interaction_i_param_value", getElements("record_interaction_i_param_value")},
                        "param_value",
                        getData("update_"+"param_value"),
                        " on EDIT")){return false;}
                if(!Functions.insertInput(driver,
                        new String[]{"record_interaction_i_age_ext_code", getElements("record_interaction_i_age_ext_code")},
                        "age_ext_code",
                        getData("update_"+"age_ext_code"),
                        " on EDIT")){return false;}
                if(!Functions.checkClickByAbsence(driver,
                        new String[]{"record_interaction_b_save", getElements("record_interaction_b_save")},
                        new String[]{"glass", recursiveXPaths.glass},
                        " on EDIT")){return false;}

            }
        return true;
        }

    protected boolean search(TestDriver driver) {

        try {
            if(!Functions.insertInput(driver,
                    new String[]{"search_i_param_name", getElements("search_i_param_name")},
                    "param_name",
                    getData("param_name"),
                    " on SEARCH")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"search_i_param_value", getElements("search_i_param_value")},
                    "param_value",
                   getData("param_value"),
                    " on SEARCH")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"search_i_age_ext_code", getElements("search_i_age_ext_code")},
                    "age_ext_code",
                    getData("age_ext_code"),
                    " on SEARCH")){return false;}
            if(!Functions.simpleClick(driver,
                    new String[]{"search_b_search", getElements("search_b_search")},
                    " on SEARCH")){return false;}
            Thread.sleep(3000);
            if(!Functions.simpleClick(driver,
                    new String[]{"search_e_result", getElements("search_e_result")},
                    " on SEARCH")){return false;}
        } catch (Exception search) {

            search.printStackTrace();
        }
        return true;
    }
    protected boolean delete(TestDriver driver) {

        try {
            if(!Functions.simpleClick(driver,
                    new String[]{"search_e_result", getElements("search_e_result")},
                    " on SEARCH")){return false;}
            if(!Functions.simpleClick(driver,
                    new String[]{"delete_b_delete", getElements("delete_b_delete")},
                    " on SEARCH")){return false;}
            Thread.sleep(3000);
            if(!Functions.simpleClick(driver,
                    new String[]{"delete_b_yes", recursiveXPaths.delete_b_yes},
                    " on SEARCH")){return false;}
        } catch (Exception delete) {
            delete.printStackTrace();
        }
        return true;
}
    protected boolean reset(TestDriver driver){
        if(driver.getDriver().findElements(By.xpath(recursiveXPaths.glass)).size()>0){
            if(driver.getDriver().findElements(By.xpath(getElements("alert_b_ok"))).size()>0){
                if(!Functions.simpleClick(driver,
                        new String[]{"alert_b_ok", getElements("alert_b_ok")},
                        " on SEARCH")){return false;}
            }
            if(driver.getDriver().findElements(By.xpath(getElements("record_interaction_b_cancel"))).size()>0){
                if(!Functions.simpleClick(driver,
                        new String[]{"record_interaction_b_cancel", getElements("record_interaction_b_cancel")},
                        " on SEARCH")){return false;}
                if(!Functions.simpleClick(driver,
                        new String[]{"record_interaction_b_cancel_b_ok", getElements("record_interaction_b_cancel_b_ok")},
                        " on SEARCH")){return false;}
            }
        }
        if(driver.getDriver().findElements(By.xpath(getElements("alert_b_ok"))).size()>0){

        }
    return true;
    }
    protected boolean enabler(TestDriver driver){
        if(!Functions.simpleClick(driver,
                new String[]{"search_b_reset", getElements("search_b_reset")},
                " on SEARCH")){return false;}
        if(!Functions.simpleClick(driver,
                new String[]{"search_b_search", getElements("search_b_search")},
                " on SEARCH")){return false;}
        return true;
    }
    }
