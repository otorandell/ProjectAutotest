package core.CommonActions;

import core.ErrorManager.ErrorManager;
import core.FileGestor.ReportFile;
import core.TestDriver.TestDriver;
import core.recursiveData.recursiveXPaths;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by otorandell on 08/02/2016.
 */
public class Functions {

    /**
     * This the basic main operation, just does a click on the desired element, whitouth waitong for any response from driver.
     *
     * @param driver this object gathers all the info refferent to the current test
     */
    public static boolean simpleClick(TestDriver driver, String path[], String where) {
//HOW TO CALL THIS METHOD
        /* SwissKnife.simpleClick(driver,
                new String[]{"x", elements.get("x")}, //element to click
                " on where");*/
        try {
            driver.getDriver().findElement(By.xpath(path[1])).click();
            driver.getReport().addContent(path[0] + " clicked " + where);

        } catch (Exception e) {
            String ecode = "--ERROR: simpleClick(): Unable to click the element " + path[0] + " with xpath: " + path[1] + where + ".";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        return true;
    }

    /**
     * This method clicks an element expecting another element to be visible, otherwise throws an exception.
     *
     * @param driver this object gathers all the info refferent to the current test
     * @param path1  info reffered to the path of the element to be clicked [0] reffers to path name and [1] to the value
     * @param path2  info reffered to the path of the expected element [0] reffers to path name and [1] to the value
     * @param where  String printed on the report to define the general location of the current operation
     */
    public static boolean checkClick(TestDriver driver, String path1[], String path2[], String where) {
//HOW TO CALL THIS METHOD
        /* if(!Functions.checkClick(driver,
                new String[]{"x", getElements("x")}, //element to click
                new String[]{"y", getElements("x")}, //element expected to appear
                " on WHERE")){return false;}*/
        WebDriverWait wdw = new WebDriverWait(driver.getDriver(), 60, 500);
        WebDriverWait breathetime = new WebDriverWait(driver.getDriver(), 30, 500);
        try {

            breathetime.until(ExpectedConditions.elementToBeClickable(By.xpath(path1[1])));
            driver.getDriver().findElement(By.xpath(path1[1])).click();
        } catch (Exception e) {
            String ecode = "--ERROR: checkClick(): Unable to click the element " + path1[0] + " with xpath: " + path1[1] + where + ".";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        try{
            //catch
            wdw.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path2[1])));
            driver.getReport().addContent(path1[0] + " clicked " + where);

        } catch (Exception e) {
            String ecode = "--ERROR: checkClick(): Unable to check that the element " + path2[0] + " with xpath: " + path2[1] + where + "is visible after clicking "+ path1[0] +"("+path1[1]+")";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        return true;
    }

    /**
     * This method clicks an element expecting another element to be visible, otherwise throws an exception.
     * @param driver this class manages all the information referent to the current test.
     * @param path1  info reffered to the path of the element to be clicked [0] reffers to path name and [1] to the value
     * @param path2  info reffered to the path of the expected element [0] reffers to path name and [1] to the value
     * @param seconds seconds the WebDriverWait element will wait before an exception is thrown
     * @param miliseconds time in miliseconds between condition checking
     * @param where  String printed on the report to define the general location of the current operation
     */
    public static boolean checkClick(TestDriver driver, String path1[], String path2[],int seconds, long miliseconds, String where) {
//HOW TO CALL THIS METHOD
        /* SwissKnife.checkClick(driver,
                new String[]{"x", elements.get("x")}, //element to click
                new String[]{"y", elements.get("x")}, //element expected to appear
                30, 500, //seconds/miliseconds (driver wait)
                " on where");*/
        WebDriverWait wdw = new WebDriverWait(driver.getDriver(), seconds, miliseconds);
        WebDriverWait breathetime = new WebDriverWait(driver.getDriver(), 30, 500);
        try {

            breathetime.until(ExpectedConditions.elementToBeClickable(By.xpath(path1[1])));
            driver.getDriver().findElement(By.xpath(path1[1])).click();
        } catch (Exception e) {
            String ecode = "--ERROR: checkClick(): Unable to click the element " + path1[0] + " with xpath: " + path1[1] + where + ".";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        try{
            //catch
            wdw.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path2[1])));
            driver.getReport().addContent(path1[0] + " clicked " + where);

        } catch (Exception e) {
            String ecode = "--ERROR: checkClick(): Unable to check that the element " + path2[0] + " with xpath: " + path2[1] + where + "is visible after clicking "+ path1[0] +"("+path1[1]+")";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        return true;
    }

    /**
     * This method clicks an element expecting another element to disappear, otherwise throws an exception.
     * @param driver this object gathers all the info refferent to the current test
     * @param path1  info reffered to the path of the element to be clicked [0] reffers to path name and [1] to the value
     * @param path2  info reffered to the path of the expected element [0] reffers to path name and [1] to the value
     * @param where  String printed on the report to define the general location of the current operation
     */
    public static boolean checkClickByAbsence(TestDriver driver, String path1[], String path2[], String where) {
        //HOW TO CALL THIS METHOD
        /* SwissKnife.checkClickByAbsence(driver,
                new String[]{"x", elements.get("x")}, //element to click
                new String[]{"y", elements.get("x")}, //element expected to disappear
                " on where");*/

        WebDriverWait wdw = new WebDriverWait(driver.getDriver(), 30, 1000);
        WebDriverWait breathetime = new WebDriverWait(driver.getDriver(), 30, 500);

        try {

            breathetime.until(ExpectedConditions.elementToBeClickable(By.xpath(path1[1])));
            driver.getDriver().findElement(By.xpath(path1[1])).click();
        } catch (Exception e) {
            String ecode = "--ERROR: checkClickByAbscence(): Unable to click the element " + path1[0] + " with xpath: " + path1[1] + where + ".";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        try{
            wdw.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path2[1])));
            driver.getReport().addContent(path1[0] + " clicked " + where);

        }catch (Exception e) {
            String ecode = "--ERROR: checkClickByAbscence(): Unable to check that the element " + path2[0] + " with xpath: " + path2[1] + where + "has disappeared after clicking "+ path1[0] +"("+path1[1]+")";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        return true;
    }

    /**
     * This method clicks an element expecting another element to disappear, otherwise throws an exception.
     * @param driver this class manages all the information referent to the current test.
     * @param path1  info reffered to the path of the element to be clicked [0] reffers to path name and [1] to the value
     * @param path2  info reffered to the path of the expected element [0] reffers to path name and [1] to the value
     * @param seconds seconds the WebDriverWait element will wait before an exception is thrown
     * @param miliseconds time in miliseconds between condition checking
     * @param where  String printed on the report to define the general location of the current operation
     */
    public static boolean checkClickByAbsence(TestDriver driver, String path1[], String path2[], int seconds, int miliseconds, String where) {
        //HOW TO CALL THIS METHOD
        /* SwissKnife.checkClickByAbsence(driver,
                new String[]{"x", elements.get("x")}, //element to click
                new String[]{"y", elements.get("x")}, //element expected to disappear
                90, 500,
                " on where");*/

        WebDriverWait wdw = new WebDriverWait(driver.getDriver(), seconds, miliseconds);
        WebDriverWait breathetime = new WebDriverWait(driver.getDriver(), 30, 500);

        try {

            breathetime.until(ExpectedConditions.elementToBeClickable(By.xpath(path1[1])));
            driver.getDriver().findElement(By.xpath(path1[1])).click();
        } catch (Exception e) {
            String ecode = "--ERROR: checkClickByAbscence(): Unable to click the element " + path1[0] + " with xpath: " + path1[1] + where + ".";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        try{
            wdw.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path2[1])));
            driver.getReport().addContent(path1[0] + " clicked " + where);

        }catch (Exception e) {
            String ecode = "--ERROR: checkClickByAbscence(): Unable to check that the element " + path2[0] + " with xpath: " + path2[1] + where + "has disappeared after clicking "+ path1[0] +"("+path1[1]+")";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        return true;
    }

    /**
     * This method clicks (or not) QbE button if its not deployed yet, otherwise just checkis if its deployed
     * @param driver this object gathers all the info refferent to the current test
     * @param b_qbe xpath referent to the qbe button, [0] is the data name, [1] is the value
     * @param qbe_input xpath referent to the qbe input, [0] is the data name, [1] is the value
     * @param where  String printed on the report to define the general location of the current operation
     */
    public static boolean clickQbE (TestDriver driver, String[] b_qbe, String[] qbe_input, String where){
        //HOW TO CALL THIS METHOD
        /*SwissKnife.clickQbE(driver,
                new String[]{"x", elements.get("x")},// query button
                new String[]{"y", elements.get("y")},//any query input
                "where"); // where the operation occurs
                */
        driver.getReport().addContent("QbE Deployment: ", "h5", "");
        if(driver.getDriver().findElements(By.xpath(qbe_input[1])).size()>0){
            driver.getReport().addContent("QbE is already deployed");
        }
        else{
            driver.getReport().addContent("QbE is not deployed ("+qbe_input[0]+" is not visible), proceeding to click it.");
            if(!checkClick(driver, b_qbe, qbe_input, where)){return false;}
        }
        driver.getReport().addContent("","br","");
    return true;
    }

    /**
     * This method is a succesion of a check click and a simple click, intended to do click and search actions which are very common
     * @param driver this object gathers all the info refferent to the current test
     * @param b_search
     * @param e_result
     * @param where
     */
    public static boolean clickSearchAndResult(TestDriver driver, String[] b_search, String[] e_result, String where){
        //HOW TO CALL THIS METHOD
        /*SwissKnife.clickSearchAndResult(driver,
                new String[]{"x", elements.get("x")}, //search button
                new String[]{"y", elements.get("y")}, //result element
                " on SEARCH");*/ // where
        if(!checkClick(driver,b_search, e_result, where)){return false;}
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            return false;
        }
        if(!simpleClick(driver, e_result, where)){return false;}
return true;
    }

    /**
     * This method is uset to insert strings into the desired input, also checks that is done correctly
     *
     * @param driver    this object gathers all the info refferent to the current test
     * @param path      path of the input to be filled
     * @param data_name key for the data to be stored
     * @param value     value for the data to be stored
     * @param where     Location of the operation
     */
    public static boolean insertInput(TestDriver driver, String path[], String data_name, String value, String where) {
        //HOW TO CALL THIS METHOD:
        /*
         SwissKnife.insertInput(driver, new String[]{"inputname",elements.get("inputvalue")},
          "dataname", datavalue," where");
        */
        driver.getReport().addContent("Insert Input:","h5","");
        WebDriverWait wdw = new WebDriverWait(driver.getDriver(), 30, 1000);
        try{
            wdw.until(ExpectedConditions.elementToBeClickable(By.xpath(path[1])));
            if(!simpleClick(driver, path, where)){return false;}
            driver.getDriver().findElement(By.xpath(path[1])).clear();
            driver.getDriver().findElement(By.xpath(path[1])).sendKeys(value);
            Thread.sleep(1000); //To avoid reset
            driver.getTest().getData().put(data_name, driver.getDriver().findElement(By.xpath(path[1])).getAttribute("value"));
            if (!driver.getTest().getData().get(data_name).equals("") && !driver.getTest().getData().get(data_name).equals(null)) {

                if (data_name.contains("password")) {
                    driver.getReport().addContent(data_name + " (******) inserted" + where + ".");
                } else {
                    driver.getReport().addContent(data_name + " (" + value + ") inserted" + where + ".");
                }
            }

        }
        catch(Exception e){
            String ecode = "--ERROR: insertInput(): Unable to insert "+data_name+" with value: \""+value+"\" into " + path[0] + " (xpath " + path[1] + ") on " + where + ".";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }

        driver.getReport().addContent("","br","");
        return true;
    }

    /**
     * Takes a screenshot of the web browser current content
     * @param driver this object gathers all the info refferent to the current test
     */
    public static boolean screenshot(TestDriver driver) {
        try {
            String name = driver.getTestdetails().getTestname();
            WebElement html = driver.getDriver().findElement(By.tagName("html"));
            if (driver.getDriverdetails().getBrowser().equals("ff")) {
                html.sendKeys(Keys.chord(Keys.CONTROL, "0"));
                try{
                    Thread.sleep(1000);}
                catch (Exception e){}
            } else { //CHROME AND IE HAVE ISSUES WITH ZOOM.
                driver.getReport().addContent("--WARNING: screenshot - Chrome and IE Web Drivers have issues with zooming. Method WILL NOT ZOOM!!<br>"
                        + "Keep in mind this might cause problems with screenshot area captured.", "p", "class='warning'");
            }
            Date mydate = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String date = dateFormat.format(mydate);
            File scrFile = ((TakesScreenshot) driver.getDriver()).getScreenshotAs(OutputType.FILE);
            name = name + "_picture_at_" + date + ".png";
            ReportFile reportfile = new ReportFile(driver);
            String path = reportfile.getFilepath();
            FileUtils.copyFile(scrFile, new File(path+name));
            driver.getReport().addImage(name,"");



        } catch (IOException e) {
            String message = "--ERROR: screenshot(): Unable to screnshot, probably driver doesent exist anymore or was never created";
            e.printStackTrace();
            ErrorManager.process(driver, message);
            return false;
        }
        return true;
    }

    /**
     * This method does the auditData process entirely, even clicks the actions button first.
     * @param driver this object gathers all the info refferent to the current test
     * @param b_actions xpath referent to the actions button, [0] is the data name, [1] is the value
     * @param b_audit xpath referent to the audit button, [0] is the data name, [1] is the value
     * @param b_ok xpath referent to the pop up ok button, [0] is the data name, [1] is the value
     * @param where  String printed on the report to define the general location of the current operation
     */
    public static boolean auditData(TestDriver driver, String[] b_actions, String[] b_audit, String[] b_ok, String where){
        //HOW TO CALL THIS METHOD
        /* SwissKnife.auditData(driver,
                new String[]{"x",elements.get("x")}, //actions button
                new String[]{"y",elements.get("y")}, //audit button
                new String[]{"audit_b_ok",recursiveXPaths.audit_b_ok}, //audit_b_ok
                "where");*/ //where this occurs
        driver.getReport().addContent("Audit Data:", "h5", "");
        String[] glass = {"glass", recursiveXPaths.glass};
        if(!checkClick(driver, b_actions, b_audit, where)){return false;}
        if(!checkClick(driver, b_audit, glass, where)){return false;}
        //screenshot(driver);
        if(!checkClickByAbsence(driver, b_ok, glass, where)){return false;}
        driver.getReport().addContent("","br","");
        return true;
    }

    /**
     * this method fills a LoV field by searching in the internal lov search for a value, and saves it into data for a further usage
     * @param driver this object gathers all the info refferent to the current test
     * @param b_lov xpath referent to the LoV button, [0] is the data name, [1] is the value
     * @param i_lov xpath referent to the LoV input, [0] is the data name, [1] is the value
     * @param b_search xpath referent to the LoV internal search button, [0] is the data name, [1] is the value
     * @param e_result xpath referent to the LoV internal result, [0] is the data name, [1] is the value
     * @param b_ok xpath referent to the LoV internal ok button, [0] is the data name, [1] is the value
     * @param data_name xpath referent to the actions button, [0] is the data name, [1] is the value
     * @param where tells where the operation is taking effect
     */
    public static boolean createLov (TestDriver driver, String[] b_lov, String[] i_lov, String[] b_search, String[] e_result, String[] b_ok, String data_name, String where){
        // HOW TO CALL THIS METHOD
        /*SwissKnife.createLov(driver,
                    new String[]{"x",elements.get("y")}, // b_lov
                    new String[]{"", elements.get("")}, // i_lov
                    recursiveXPaths.lov_b_search, // lov b search
                    recursiveXPaths.lov_e_result, // lov result
                    recursiveXPaths.lov_b_ok, //lov b ok
                    "", //Data name
                    "");*/ // where the operation occurs
        driver.getReport().addContent("LoV Creation: ", "h4", "");
        String attr ="";
        if(!simpleClick(driver, i_lov, where)){return false;}
        if(!checkClick(driver, b_lov, b_search, where)){return false;}
        if(!clickSearchAndResult(driver, b_search, e_result, where)){return false;}
        if(!checkClickByAbsence(driver, b_ok, recursiveXPaths.lov_e_result, where)){return false;}
        try{
            attr = driver.getDriver().findElement(By.xpath(i_lov[1])).getAttribute("value");
            if(!attr.equals("") && !attr.equals(null)){
                driver.getTest().getData().put(data_name, attr);
            }
            else{
                String ecode = "--ERROR: createLov - Unable to check that the correct value was inserted in " + i_lov[0] + " (xpath: " + i_lov[1] + ")" + where + ". Value is blank or null.";
                ErrorManager.process(driver, ecode);
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            String ecode = "--ERROR: createLov - Unable to get the selected " + i_lov[0] + " (xpath: " + i_lov[1] + ")" + where + ".";
            ErrorManager.process(driver, ecode);
            return false;
        }

        driver.getReport().addContent("","br","");
        return true;

    }

    /**
     * This method catches the value of the attribute "value" from a WebElement and puts it into the data map.
     * @param driver this object gathers all the info refferent to the current test
     * @param path xpath referent to the target WebElement, [0] is the data name, [1] is the value
     * @param data_name name of the data that is included in the data map
     * @param where tells where the operation is taking effect
     */
    public static boolean getValue(TestDriver driver, String[] path, String data_name, String where){
        //HOW TO CALL THIS METHOD
        /*SwissKnife.getValue(driver,new String[]{"x", elements.get("x")}, // element path
                "data_name", // key for data value (the name)
                " where");*/ // whoere this operation occurs
        WebElement element = findElement(driver, path, where);
        String attr="";
        try{
            attr = element.getAttribute("value");}
        catch (Exception e){
            String ecode = "--ERROR:getValue(): Unable to get the value of " + path[0] + " with xpath: " + path[1]+" " + where+".";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        driver.getTest().getData().put(data_name, attr);
        driver.getReport().addContent("HTML value ("+attr+") taken from "+path[0]+where);
        return true;

    }

    /**
     * This method catches the text value from a WebElement and puts it into the data map.
     * @param driver this object gathers all the info refferent to the current test
     * @param path xpath referent to the target WebElement, [0] is the data name, [1] is the value
     * @param data_name name of the data that is included in the data map
     * @param where tells where the operation is taking effect
     */
    public static boolean getText(TestDriver driver, String[] path, String data_name, String where){
        //HOW TO CALL THIS METHOD
        /*SwissKnife.getText(driver,new String[]{"x", elements.get("x")}, // element path
                data_name, // key for data value (the name)
                " where");*/ // where this operation occurs
        WebElement element = findElement(driver, path, where);
        String text="";
        try{
            text = element.getText();}
        catch (Exception e){
            String ecode = "--ERROR:getText(): Unable to get the value of " + path[0] + " with xpath: " + path[1]+" " + where+".";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        driver.getTest().getData().put(data_name, text);
        driver.getReport().addContent("Content ("+text+") taken from "+path[0]+where);
    return true;
    }

    /**
     * this method fills a LoV field by searching in the internal lov search for a specific value, and saves it into data for a further usage
     * @param driver this object gathers all the info refferent to the current test
     * @param b_lov xpath referent to the LoV button, [0] is the data name, [1] is the value
     * @param i_lov xpath referent to the LoV input, [0] is the data name, [1] is the value
     * @param i_inside_lov xpath referent to the internal LoV input, [0] is the data name, [1] is the value
     * @param value this is what will be searched into the lov
     * @param data_name name of the data that is included in the data map
     * @param where tells where the operation is taking effect
     */
    public static boolean createLovByValue (TestDriver driver, String[] b_lov, String[] i_lov, String[] i_inside_lov, String value, String data_name, String where){
        //HOW TO CALL THIS METHOD
        /* SwissKnife.createLovByValue(driver,
                new String[]{"x", elements.get("x")}, //LoV button
                new String[]{"y", elements.get("y")}, //external LoV input
                new String[]{"z", elements.get("z")}, //internal LoV input
                "value", // value to search
                "key", //name of the data
                " on where");*/ //where this operation occurs
        driver.getReport().addContent("LoV by value Creation: ", "h4", "");
        String attr ="";
        if(!simpleClick(driver, i_lov, where)){return false;}
        if(!checkClick(driver, b_lov, recursiveXPaths.lov_b_search, where)){return false;}
        if(!insertInput(driver,i_inside_lov,"ref"+data_name, value, where)){return false;}
        if(!clickSearchAndResult(driver, recursiveXPaths.lov_b_search, recursiveXPaths.lov_e_result, where)){return false;}
        if(!checkClickByAbsence(driver, recursiveXPaths.lov_b_ok, recursiveXPaths.lov_b_search, where)){return false;}
        try{
            attr = driver.getDriver().findElement(By.xpath(i_lov[1])).getAttribute("value");
            if(!attr.equals("") && !attr.equals(null)){
                driver.getTest().getData().put(data_name, attr);
            }
            else{
                String ecode = "--ERROR: createLov - Unable to check that the correct value was inserted in " + i_lov[0] + " (xpath: " + i_lov[1] + ")" + where + ". Value is blank or null.";
                ErrorManager.process(driver, ecode);
                return false;

            }
        }
        catch(Exception e){
            String ecode = "--ERROR: createLov - Unable to get the selected " + i_lov[0] + " (xpath: " + i_lov[1] + ")" + where + ".";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }

        driver.getReport().addContent("","br","");
            return true;
    }

    /**
     * this method presses the enter button to do a query search, and then tries to click a result
     * @param driver this object gathers all the info refferent to the current test
     * @param qbe_input xpath referent to the query input, [0] is the data name, [1] is the value
     * @param e_result xpath referent to the result, [0] is the data name, [1] is the value
     * @param where tells where the operation is taking effect
     */
    public static boolean enterQueryAndClickResult(TestDriver driver, String[] qbe_input, String[] e_result, String where){
        //HOW TO CALL THIS METHOD
        /*SwissKnife.enterQueryAndClickResult(driver,
            new String[]{"x", elements.get("x")}, //any query input
            new String[]{"y", elements.get("y")}, //table result
                "where"); // where this operation occurs
                */
        if(!simpleClick(driver, qbe_input, where)){return false;}
        try {
            driver.getDriver().findElement(By.xpath(qbe_input[1])).sendKeys(Keys.RETURN);
        }
        catch(Exception e){
            String ecode = "--ERROR: enterQueryAndClickResult - Unable to enter the data in the query.";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        if(!simpleClick(driver, e_result, where)){return false;}
        return true;
    }

    /**
     * This method chooses the wanted option form dropdown menus
     * @param driver this object gathers all the info refferent to the current test
     * @param pathselect xpath referent to the select WebElement, [0] is the data name, [1] is the value
     * @param content value of the element we are searching for
     * @param dataname name of the data that is included in the data map
     * @param where tells where the operation is taking effect
     */
    public static boolean selectText(TestDriver driver, String[] pathselect, String content, String dataname, String where){
        //HOW TO CALL THIS METHOD
        /*SwissKnife.selectText(driver,
                    new String[]{"x",elements.get("x")},
                    "content",
                    "dataname",
                    " where");*/
        boolean found = false;
        Select e_select;
        List<WebElement> options = null;
        try {
            e_select = new Select(driver.getDriver().findElement(By.xpath(pathselect[1])));
            options = e_select.getOptions();
        } catch (Exception f) {
            String ecode = "--ERROR: selectText(): Unable to find the element " + pathselect[0] + " with xpath: " + pathselect[1] + where + ".";
            f.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        try {
            for (WebElement option : options) {
                String optiontext = option.getText();
                if (optiontext.contains(content)) {
                    option.click();
                    Thread.sleep(2000);
                    driver.getReport().addContent("Option (" + content + ") selected on " + pathselect[0] + ".");
                    found = true;
                    driver.getTest().getData().put(dataname, content);
                    break;
                }
            }
            if(!found){
                String ecode = "--ERROR: selectText(): Unable to find the target option into " + pathselect[0] + " with xpath: " + pathselect[1] + where + ".";
                ErrorManager.process(driver, ecode);
                return false;
            }
        } catch (Exception e) {
            String ecode = "--ERROR: selectText(): Unable to find the target option into " + pathselect[0] + " with xpath: " + pathselect[1] + where + ".";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        return true;
    }

    /**
     * This method does the process of the detach table testing
     * @param driver this object gathers all the info refferent to the current test
     * @param path xpath referent to the detach button, [0] is the data name, [1] is the value
     * @param screenshot boolean value that indicates if the process has or not to do an screenshot
     * @param where tells where the operation is taking effect
     */
    public static boolean detachTable(TestDriver driver, String[] path, boolean screenshot, String where){
        //HOW TO CALL THIS METHOD
        /*SwissKnife.detachTable(driver,
                new String[]{"x",elements.get("x")}, //detach button
                true/false,     //screenshot??
                "where");*/     //where this occurs
        driver.getReport().addContent("Detach Table:", "h5", "");
        if(!simpleClick(driver, path, where)){return false;}
        //if(screenshot){screenshot(driver);}
        if(!simpleClick(driver, path, where)){return false;}
        driver.getReport().addContent("","br","");
return true;
    }

    /**
     * This method manages all the delete proces in Atlas 2.0
     * @param driver this object gathers all the info refferent to the current test
     * @param b_delete xpath referent to the delete button, [0] is the data name, [1] is the value
     * @param where tells where the operation is taking effect
     */
    public static boolean doDelete(TestDriver driver, String[] b_delete, String where){
        //HOW TO CALL THIS METHOD
        /*SwissKnife.doDelete(driver,
                new String[]{"b_delete", elements.get("b_delete")},//delete button
                " on DELETE");*/
        driver.getReport().addContent("Deleting Record:", "h5", "");
        if(!checkClick(driver, b_delete, new String[]{"glass",
                recursiveXPaths.glass}, where)){return false;}
        if(!checkClickByAbsence(driver, new String[]{"b_delete_yes",
                recursiveXPaths.delete_b_yes}, new String[]{"glass",
                recursiveXPaths.glass}, where)){return false;}
        driver.getReport().addContent("","br","");
return true;
    }

    /**
     * This method manages all the delete proces in Atlas 2.0 overrides with the b_delete_yes param
     * @param driver this object gathers all the info refferent to the current test
     * @param b_delete xpath referent to the delete button, [0] is the data name, [1] is the value
     * @param b_delete_yes xpath referent to the confirmation delete button, [0] is the data name, [1] is the value
     * @param where tells where the operation is taking effect
     */
    public static boolean doDelete(TestDriver driver, String[] b_delete,String[] b_delete_yes, String where){
        //HOW TO CALL THIS METHOD
        /*SwissKnife.doDelete(driver,
                new String[]{"b_delete", elements.get("b_delete")},//delete button
                new String[]{"b_delete_yes", elements.get("b_delete_yes")},//delete button
                " on DELETE");*/
        driver.getReport().addContent("Deleting Record:", "h5", "");
        if(!checkClick(driver, b_delete, new String[]{"glass",
                recursiveXPaths.glass}, where)){return false;}
        if(!checkClickByAbsence(driver,
                b_delete_yes,
                new String[]{"glass",
                        recursiveXPaths.glass}, where)){return false;}
        driver.getReport().addContent("","br","");
    return true;
    }

    /**
     * This method manages all the delete proces in Atlas 2.0, also checks the records to check if was successful
     * @param driver this object gathers all the info refferent to the current test
     * @param b_delete xpath referent to the delete button, [0] is the data name, [1] is the value
     * @param n_records xpath referent to the record balues, [0] is the data name, [1] is the value
     * @param where tells where the operation is taking effect
     */
    public static boolean doDeleteNCheck(TestDriver driver, String[] b_delete, String[] n_records, String where){
        /* Niggas on da hood call da method like this:

        SwissKnife.doDeleteNCheck(driver,
                new String[]{"b_delete",
                        elements.get("b_delete")},
                new String[]{"n_records",
                        elements.get("n_records")},
                " where");
         */

        driver.getReport().addContent("Deleting Record:", "h5", "");
        if(!zoomOut(driver)){return false;}
        int recordsbefore=0;
        int recordsafter=0;
        try{
            recordsbefore = Integer.parseInt(driver.getDriver().findElement(By.xpath(n_records[1])).getText());}
        catch(Exception e){
            String ecode = "--ERROR: doDeleteNCheck(): Unable to find "+n_records[0]+" or cast it to integer before delete was done.";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        if(!checkClick(driver, b_delete, new String[]{"glass",
                recursiveXPaths.glass}, where)){return false;}
        if(!checkClickByAbsence(driver, new String[]{"b_delete_yes",
                recursiveXPaths.delete_b_yes}, new String[]{"glass",
                recursiveXPaths.glass}, where)){return false;}
        try{
            recordsafter = Integer.parseInt(driver.getDriver().findElement(By.xpath(n_records[1])).getText());}
        catch(Exception f){
            String ecode = "--ERROR: doDeleteNCheck(): Unable to find "+n_records[0]+" or cast it to integer after delete was done.";
            f.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        if((recordsbefore-recordsafter)==1){
            driver.getReport().addContent("Delete successful, records changed from: "+recordsbefore+" to: "+recordsafter+".");
        }
        else if((recordsbefore-recordsafter)!=0){
            driver.getReport().addContent("Oops seems like mutiple operations occured during test, cannot confirm delete was or not successful, records from: "+recordsbefore+" to: "+recordsafter+".","p","class='warning'");
        }
        else if((recordsbefore-recordsafter)==0){
            String message ="Delete Unsuccessful, records didn't change (from: "+recordsbefore+" to: "+recordsafter+").";
            ErrorManager.process(driver,message);
            return false;
        }
        if(!zoomIn(driver)){return false;}
        driver.getReport().addContent("","br","");
        return true;
    }

    /**
     * Zooms out the WebDriver
     * @param driver this object gathers all the info refferent to the current test
     */
    public static boolean zoomOut(TestDriver driver){
        try{
            WebElement html = driver.getDriver().findElement(By.tagName("html"));
            html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
            html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
            html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
            html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
            driver.getReport().addContent("Screen zoomed out");}
        catch (Exception e){ // by the way, this error "should never" be shown, zoom cannot fail (unless something really weird happens)
            String ecode = "--ERROR:zoomOut(): Not possible to zoom out.";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        return true;
    }

    /**
     * Zooms in the WebDriver
     * @param driver
     */
    public static boolean zoomIn(TestDriver driver){
        try{
            WebElement html = driver.getDriver().findElement(By.tagName("html"));
            html.sendKeys(Keys.chord(Keys.CONTROL, Keys.NUMPAD0));

            driver.getReport().addContent("Screen zoomed in to default");}
        catch (Exception e){ // by the way, this error "should never" be shown, zoom cannot fail (unless something really weird happens)
            String ecode = "--ERROR:zoomIn(): Not possible to zoom in.";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
            return false;
        }
        return true;
    }

    /**
     *
     * @param driver this object gathers all the info refferent to the current test
     * @param value this is what will be searched into the lov
     * @param dataname name of the data that is included in the data map
     * @param input xpath referent to the input where the value has to be inserted, [0] is the data name, [1] is the value
     * @param button xpath referent to the button to be clicked, [0] is the data name, [1] is the value
     * @param result xpath referent to the expected/unexpected result, [0] is the data name, [1] is the value
     * @param randtype kind of the random value (integer, string or both)
     * @param where tells where the operation is taking effect
     */
    public static boolean checkExistence(TestDriver driver, String value, String dataname, String[] input, String button[], String result[], String randtype, String where){
        //HOW TO CALL THIS METHOD
        /*SwissKnife.checkExistence(driver, "","x",//data name (x)
                new String[]{"y", elements.get("y")},//input
                new String[]{"z", elements.get("z")},//search button
                new String[]{"w", elements.get("w")},//expected not found result
                "integer/string/both",//type of input
                "");//where
                */
        driver.getReport().addContent("Check Existence:", "h5", "");
        String myrand = "";
        String newvalue ="";
        String replacement ="";
        int i =0;
        driver.getReport().addRawText("<!--Start-->");
        do{
            if(randtype.toLowerCase().equals("integer")){
                myrand = Integer.toString(DataGenerator.random(1, 100));}
            if(randtype.toLowerCase().equals("string")){
                myrand = DataGenerator.getRandomAlphanumericSequence(5, false);}
            else{
                myrand = DataGenerator.getRandomAlphanumericSequence(5, true);
            }
            newvalue = value+myrand;
            if(!insertInput(driver, input, dataname, newvalue, where)){return false;}
            if(!simpleClick(driver, button, where)){return false;}
            i++;
        } while(driver.getDriver().findElements(By.xpath(result[1])).size()>0|| i>= 30);

        driver.getReport().addRawText("<!--End-->");
        int startIndex =  driver.getReport().getContent().indexOf("<!--Start-->",0);
        int endIndex = driver.getReport().getContent().indexOf("<!--End-->",9);
        String str = driver.getReport().getContent().substring(startIndex, endIndex);
        driver.getReport().getContent().replace(str,replacement);

        if(i>=30){
            String message ="--ERROR: checkExistence(): Unable to not overlap other records after "+i+" tries";
            ErrorManager.process(driver, message);
            return false;
        }
        else{
            driver.getTest().getData().put(dataname, newvalue);
            driver.getReport().addContent(newvalue+" choosen to fill "+dataname+"value.");

        }
        driver.getReport().addContent("", "br", "");
    return true;
    }

    /**
     *
     * @param driver this object gathers all the info refferent to the current test
     * @param path xpath referent to the input where the value has to be inserted, [0] is the data name, [1] is the value
     * @param where tells where the operation is taking effect
     * @return returns the found WebElement
     */
    public static WebElement findElement(TestDriver driver, String[] path, String where){
        WebElement element = null;
        try{
            element = driver.getDriver().findElement(By.xpath(path[1]));
        }
        catch(Exception e){
            String ecode = "--ERROR:findElement(): Unable to find the element " + path[0] + " with xpath: " + path[1]+" " + where+".";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
        }
        return element;
    }
}
