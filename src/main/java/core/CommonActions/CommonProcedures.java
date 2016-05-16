package core.CommonActions;

import core.ConnectionDDBB.ConnectionMSSQL;
import core.ConnectionDDBB.DDBBInteractions;
import core.ErrorManager.ErrorManager;
import core.TestDriver.TestDriver;
import core.recursiveData.recursiveXPaths;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by otorandell on 11/02/2016.
 */
public class CommonProcedures {

    /**
     * This method is used to log into Atlas2.0, it uses the parameters the current driver has assigned.
     * @param driver this class manages all the information referent to the current test.
     */
    public static boolean atlasLogIn(TestDriver driver) {
        if (driver.getCurrentwork().equals("REGRESSION")) {
            if(!Functions.insertInput(driver, new String[]{"User Input", recursiveXPaths.userinput}, "username", driver.getUserdetails().getUsername(), " on login screen")){return false;}
            if(!Functions.insertInput(driver, new String[]{"Password Input", recursiveXPaths.passinput}, "password", driver.getUserdetails().getPassword(), " on login screen")){return false;}
            if(!Functions.checkClick(driver, new String[]{"Login Button", recursiveXPaths.loginbutton}, new String[]{"Logout Button", recursiveXPaths.logout}, " on login screen")){return false;}
            WebDriverWait wdw = new WebDriverWait(driver.getDriver(), 40, 500);
            wdw.until(ExpectedConditions.elementToBeClickable(By.xpath(recursiveXPaths.logout)));
            if (driver.getDriver().findElements(By.xpath("//*[@id='cblopg1']")).size() > 0) {
                String ecode = "--ERROR: Log In: User " + driver.getUserdetails().getUsername() + " has not company and office associated.";
                ErrorManager.process(driver, ecode);
                return false;

            }
        } else if (driver.getCurrentwork().equals("JIRA")) {
            if(!Functions.insertInput(driver, recursiveXPaths.jirauserinput, "username", driver.getUserdetails().getUsername(), " on JIRA login screen")){return false;}
            if(!Functions.insertInput(driver,recursiveXPaths.jirapassimput, "password", driver.getUserdetails().getPassword(), " on JIRA login screen")){return false;}
            if(!Functions.checkClick(driver, recursiveXPaths.jiraloginbutton, recursiveXPaths.jiralogoutbutton, " on JIRA login screen")){return false;}
            WebDriverWait wdw = new WebDriverWait(driver.getDriver(), 40, 500);
            wdw.until(ExpectedConditions.elementToBeClickable(By.xpath(recursiveXPaths.jiralogoutbutton[1])));
            }
        return true;
        }

    /**
     * This method search and click the target component screen to be tested
     * @param driver this class manages all the information referent to the current test.
     */
    public static boolean goToScreen(TestDriver driver) {
        try {
            if(!Functions.checkClick(driver, new String[]{"Search icon", recursiveXPaths.searchicon}, new String[]{"Component input", recursiveXPaths.componentinput}, 180, 500, " on main ATLAS page")){return false;}
            if(!Functions.insertInput(driver, new String[]{"Component", recursiveXPaths.componentinput}, "Component", driver.getTestdetails().getTestname(), " on main ATLAS page")){return false;}
            if(!Functions.checkClick(driver, new String[]{"Search component icon", recursiveXPaths.searchcomponent}, new String[]{"Component result", recursiveXPaths.result}, 180, 500, " on main ATLAS page")){return false;}
            if(!Functions.checkClickByAbsence(driver, new String[]{"Component result", recursiveXPaths.result}, new String[]{"Component result", recursiveXPaths.result}, 360, 500, " on main ATLAS page")){return false;}
        } catch (Exception e) {
            String ecode = "--ERROR: goToScreen(): Unable to enter the selected screen, maybe the server is running too slow..";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        return true;
    }

    /**
     * This method logs out of Atlas2.0 and checks that it's done correcly, otherwise will notify it.
     * @param driver this class manages all the information referent to the current test.
     */
    public static void atlaslogOut(TestDriver driver) {
        if (driver.getDriver().findElements(By.xpath(recursiveXPaths.logout)).size() > 0 && !driver.isLogouterror()) {
            driver.setLogouterror(true); //This flag prevents from looping here forever in case of logout error
            Functions.simpleClick(driver, new String[]{"Logout Button", recursiveXPaths.logout}, " on main ATLAS page.");
            checkAlert(driver);
        }
        else {
            driver.getReport().addContent("--WARNING-- Logout Button was not found, it's possible that it was never reached, check the screenshot", "p", "class='warning'");
            Functions.screenshot(driver);
        }
        //Checking logout worked as intended
        if (driver.getDriver().findElements(By.xpath(recursiveXPaths.userinput)).size() > 0) {
            driver.getReport().addContent("Logout Correct.", "p", "class='succes'");
            if (driver.getUserdetails().isDDBBCredentials()) {
                updateDDBBPriority(-1, driver);
            }

        } else {
            driver.getReport().addContent("Logout Failed, user priority was not updated", "p", "class='error'");
            Functions.screenshot(driver);
        }
        driver.setTestend();
    }

    /**
     * This method searches for a possible alert popup and closes it.
     * @param driver this class manages all the information referent to the current test.
     */
    private static void checkAlert(TestDriver driver) {
        try {
            Thread.sleep(3000);
            Alert alert = driver.getDriver().switchTo().alert();
            //EXIST ALERT??
            if (alert.getText() != null) ;
            {
                driver.getReport().addContent("BROWSER ALERT FOUND: " + alert.getText() + " --ALERT is being accepted.", "p", "warning");
                alert.accept();
                driver.getDriver().switchTo().defaultContent();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method updates the priority field of the current user for the test.
     * @param increment integer value that will increment the priority field in the selected row
     * @param driver this class manages all the information referent to the current test.
     */
    public static void updateDDBBPriority(int increment, TestDriver driver) {
        ConnectionMSSQL connection = new ConnectionMSSQL();
        connection.dbConnect("jdbc:jtds:sqlserver://VS-GORGBLAU;databaseName=Testing;", "betatester", "betatester");
        DDBBInteractions.updateTable(connection, driver.getUserdetails().getUsername(), increment);
        connection.closeConnection();
    }
    /* IN PROCESS
    public static boolean atlaslogOut(TestDriver driver) {
        if(!Functions.simpleClick(driver, new String[]{"Logout Button", recursiveXPaths.logout}, " on main ATLAS page.")){//forceLogout}
        checkAlert(driver);
    }
        if (driver.getDriver().findElements(By.xpath(recursiveXPaths.userinput)).size() > 0) {
            driver.getReport().addContent("Logout Correct.", "p", "class='succes'");
            if (driver.getUserdetails().isDDBBCredentials()) {
                updateDDBBPriority(-1, driver);
            }

        } else {
            driver.getReport().addContent("Logout Failed, user priority was not updated", "p", "class='error'");
            Functions.screenshot(driver);
        }*/
}

