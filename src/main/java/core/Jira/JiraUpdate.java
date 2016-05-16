package core.Jira;

import core.CommonActions.CommonProcedures;
import core.CommonActions.Functions;
import core.TestDriver.TestDriver;
import core.recursiveData.recursiveXPaths;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by otorandell on 12/02/2016.
 */
public class JiraUpdate {
    JiraDetails jiradetails;
    JiraDriver jiradriver;
    boolean jiraloop = false;


    public JiraDetails getJiradetails() {
        return jiradetails;
    }

    public JiraDriver getJiradriver() {
        return jiradriver;
    }

    public JiraUpdate(TestDriver driver) {
        this.jiradriver = new JiraDriver(driver);
        this.jiradetails = new JiraDetails(driver);
        this.jiradriver.driverSetUp(this.jiradetails);
    }

    public TestDriver getDriver() {
        return this.jiradriver.getDriver();
    }

    private String getElements(String key) {
        return getJiradetails().getElements().get(key);
    }

    public boolean start() {
        if(!openDriver()){return false;}
        if(!setJiraURL(getJiradetails().getUrl())){return false;}
        if(!jiraLogIn()){return false;}
        if(!manageCycle()){return false;}
        if(!executeTest()){return false;}
        if(!updateStatus()){return false;}
        if(!jiraAttach()){return false;}
        if(!jiraLogOut()){return false;}
        return true;
    }

    private boolean jiraAttach() {
        System.out.println("Attach Hudson Workspace URL");
        String jsinput = "document.getElementById(\"editable-comment-div\").style.display='block';";
        JavascriptExecutor javascriptexecutor = (JavascriptExecutor) getDriver().getDriver();
        javascriptexecutor.executeScript(jsinput);
        if(!Functions.simpleClick(getDriver(),
                new String[]{"comment", getElements("comment")}, //element to click
                " Jira Attach")){return false;}
        String content = hudsonEnvironment();
        if(!Functions.insertInput(getDriver(), new String[]{"comment",getElements("comment")},
                "comment", content," Jira Attach")){return false;}
        if(!Functions.simpleClick(getDriver(),
                new String[]{"commentUpdate", getElements("commentUpdate")}, //element to click
                " Jira Attach")){return false;}
        return true;
    }

    public boolean jiraLogOut() {
        System.out.println("Jira log out");
        if(!Functions.zoomOut(getDriver())){return false;}
        if(!jiraloop){
            jiraloop=true;
            try{
                Thread.sleep(2000);
            } catch(Exception e) {
                e.printStackTrace();
            }
            if(!Functions.checkClick(getDriver(),
                   recursiveXPaths.jiralogoutbutton, //element to click
                    new String[]{"logout", getElements("logout")}, //element expected to appear
                    " on Jira LogOut")){return false;}
            try{
                Thread.sleep(2000);
            } catch(Exception e) {
                e.printStackTrace();
            }
            if(!Functions.checkClick(getDriver(),
                    new String[]{"logout", getElements("logout")}, //element to click
                    new String[]{"logInAgain", getElements("logInAgain")}, //element expected to appear
                    " on Jira LogOut")){return false;}}

       getJiradriver().getDriver().closeDriver();
        return true;
    }

    private String hudsonEnvironment() {
        if (getDriver().getTestdetails().getEnvironment().equals("test")) {
            return "http://192.168.22.143:8080/view/" + getDriver().getTestdetails().getMenu() + "/job/Test" + getDriver().getTestdetails().getTestname() + "/ws/" +getDriver().getReport().getFile().getFinalpath();
        } else {
            return "http://192.168.22.143:8092/view/" + getDriver().getTestdetails().getMenu() + "/job/Sis" + getDriver().getTestdetails().getTestname() + "/ws/" +getDriver().getReport().getFile().getFinalpath();
        }
    }

    private boolean updateStatus() {
        System.out.println("Update Status");
        if(!Functions.checkClick(getDriver(),
                new String[]{"currentStatus", getElements("currentStatus")}, //element to click
                new String[]{"updateStatus", getElements("updateStatus")}, //element expected to appear
                " Jira update Status")){return false;}//
        try{Thread.sleep(2000);}
        catch (Exception e){}
        if(!Functions.selectText(getDriver(),
                new String[]{"listStatus",getElements("listStatus")},
                getJiradetails().getTeststatus(), "Status", " Jira update Status")){return false;}
        if(!Functions.checkClickByAbsence(getDriver(),
                new String[]{"updateStatus", getElements("updateStatus")},
                new String[]{"updateStatus", getElements("updateStatus")},
                " Jira update Status")){return false;}
        return true;
    }

    private boolean executeTest() {
        System.out.println("Test execution");
        setJiraURL(getJiradetails().getUrlbrowse() + getDriver().getTestdetails().getIssue());
        if(!Functions.checkClick(getDriver(),
                new String[]{"execute_button", getElements("execute_button")},
                new String[]{"add_test_cycle_radio", getElements("add_test_cycle_radio")},
                " Jira execute Test")){return false;}
        if(!Functions.simpleClick(getDriver(),
                new String[]{"add_test_cycle_radio", getElements("add_test_cycle_radio")},
                " Jira execute Test")){return false;}
        if(!Functions.selectText(getDriver(),
                new String[]{"add_version_select", getElements("add_version_select")},
                getJiradetails().getJiraVersion(), "jiraVersion", " Jira TestCycle")){return false;}
        if(!Functions.selectText(getDriver(),
                new String[]{"add_test_cycle_select", getElements("add_test_cycle_select")},
                getJiradetails().getJiraCycle() + getJiradetails().getJiraCycleDate(), "jiraVersion", " Jira TestCycle")){return false;}
        if(!Functions.checkClickByAbsence(getDriver(),
                new String[]{"execute_button_popup_button", getElements("execute_button_popup_button")},
                new String[]{"execute_button_popup_button", getElements("execute_button_popup_button")},
                " Jira execute Test")){return false;}
        return true;
    }

    private boolean jiraLogIn() {
        System.out.println("Jira Log In");
        if(!CommonProcedures.atlasLogIn(getDriver())){return false;}
        return true;
    }

    private boolean manageCycle() {
        if(!setTestCycle()){return false;}
        if (!cycleExist()) {
            if(!createCycle()){return false;}
        } else {
            System.out.println("The cycle already exists");
        }
        return true;
    }

    private boolean createCycle() {
        if(!Functions.checkClick(getDriver(),
                new String[]{"firstCycle", getElements("firstCycle")}, //element to click
                new String[]{"cycleName", getElements("cycleName")}, //element expected to appear
                " Jira TestCycle")){return false;}
        if(!Functions.selectText(getDriver(),
                new String[]{"cycleVersionDropDown", getElements("cycleVersionDropDown")},
                 getJiradetails().getJiraVersion(),"jiraVersion", " Jira TestCycle")){return false;}
        if(!Functions.insertInput(getDriver(), new String[]{"cycleName", getElements("cycleName")},
                "cycle", getJiradetails().getJiraCycle() + getJiradetails().getJiraCycleDate(), " Jira TestCycle")){return false;}
        if(!Functions.insertInput(getDriver(), new String[]{"buildNumber", getElements("buildNumber")},
                "build", getJiradetails().getJiraBuildNumber(), " Jira TestCycle")){return false;}
        if(!Functions.insertInput(getDriver(), new String[]{"dateFrom", getElements("dateFrom")},
                "from", getJiradetails().getJiraCycleFrom(), " Jira TestCycle")){return false;}
        if(!Functions.insertInput(getDriver(), new String[]{"dateTo", getElements("dateTo")},
                "to", getJiradetails().getJiraCycleTo(), " Jira TestCycle")){return false;}
        if(!Functions.simpleClick(getDriver(),
                new String[]{"saveButtonCreateCycle", getElements("saveButtonCreateCycle")}, //element to click
                " Jira TestCycle")){return false;}
        return true;
    }

    private boolean cycleExist() {
        List<WebElement> list = getDriver().getDriver().findElements(By.className(getElements("existingCycles")));

        try {
            for (WebElement we : list) {
                Thread.sleep(500);
                if (we.getText().contains(getJiradetails().getJiraCycle() + getJiradetails().getJiraCycleDate()))
                    return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    private boolean setTestCycle() {
        if(!Functions.checkClick(getDriver(),
                new String[]{"test_e_dropdown", getElements("test_e_dropdown")}, //element to click
                new String[]{"test_e_dropdown_e_plantestcycle", getElements("test_e_dropdown_e_plantestcycle")}, //element to click
                " on Jira TopBar Nav")){return false;}
        if(!Functions.checkClick(getDriver(),
                new String[]{"test_e_dropdown_e_plantestcycle", getElements("test_e_dropdown_e_plantestcycle")}, //element to click
                new String[]{"plantestycle_select_version", getElements("plantestycle_select_version")}, //element to click
                " on Jira TopBar Nav")){return false;}
        if(!Functions.insertInput(getDriver(),
                new String[]{"plantestycle_select_version", getElements("plantestycle_select_version")},
                "jiravesion",
                getJiradetails().getJiraVersion(),
                " on Jira Test Cycles Screen")){return false;}
return true;
    }

    private boolean setJiraURL(String url) {
        getDriver().getDriver().get(url);
        return true;
    }

    private boolean openDriver() {
        getDriver().setDriver(new FirefoxDriver());// turns the old driver's driver into a new driver so we can drive better in our driver world
        getDriver().getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        getDriver().getDriver().manage().window().maximize();
        return true;
    }

}
