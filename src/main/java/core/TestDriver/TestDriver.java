package core.TestDriver;

import core.CommonActions.CommonProcedures;
import core.ErrorManager.ErrorManager;
import core.HTMLReport.AutoReport;
import core.Jira.JiraUpdate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import screen.AT2Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by otorandell on 10/02/2016.
 */
public class TestDriver {

    //<editor-fold desc="ATTRIBUTES">
    DriverDetails driverdetails;
    Class<?> clazz;
    AT2Test test;
    TestDetails testdetails;
    UserDetails userdetails;
    DateFormat testdateformat;
    Date testdate;
    AutoReport report;
    WebDriver driver;
    long teststart;
    long testend;
    int teststatus = 0;
    boolean logouterror = false;
    String currentwork;
    boolean jirastatus = true;
    //</editor-fold>

    //<editor-fold desc="GETTERES & SETTERS">


    public AT2Test getTest() {
        return test;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public String getCurrentwork() {
        return currentwork;
    }

    public void setCurrentwork(String currentwork) {
        this.currentwork = currentwork;
    }

    public DriverDetails getDriverdetails() {
        return driverdetails;
    }

    public int getTeststatus() {
        return teststatus;
    }

    public TestDetails getTestdetails() {
        return testdetails;
    }

    public UserDetails getUserdetails() {
        return userdetails;
    }

    public AutoReport getReport() {
        return report;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setTeststatus(int teststatus) {
        this.teststatus = teststatus;
    }

    public boolean isLogouterror() {
        return logouterror;
    }

    public void setLogouterror(boolean logouterror) {
        this.logouterror = logouterror;
    }

    public void setTestdateformat(String testdateformat) {
        DateFormat dateformant = new SimpleDateFormat(testdateformat);
        this.testdateformat = dateformant;
    }

    public long getTeststart() {
        return teststart;
    }

    public long getTestend() {
        return testend;
    }

    public void setTestend() {
        this.testend = System.currentTimeMillis();
    }

    public Date getTestdate() {
        return testdate;
    }

    public void setTestdate() {
        Date testdate = new Date();
        this.testdate = testdate;
    }
    //</editor-fold>

    //<editor-fold desc="CONSTRUCTOR">
    public TestDriver(String[] args) {
        driverdetails = new DriverDetails();
        testdetails = new TestDetails();
        userdetails = new UserDetails();
        setTestdateformat("yyyy/MM/dd HH:mm:ss");
        setTestdate();
        DetailsAdmin detailsadmin = new DetailsAdmin();
        detailsadmin.setAll(driverdetails, testdetails, userdetails, args);
        report = new AutoReport();

    }
    //</editor-fold>

    /**
     *
     */
    public void testStart() {
        System.out.println("Welcome to Autotest 2.0");
        if (checkExistence(this.getTestdetails().getTestname())) {
            openDriver();
            this.driver.get(this.driverdetails.getUrl());
            this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            setCurrentwork("REGRESSION");
            createTest();
            if(CommonProcedures.atlasLogIn(this)){
            test();
            }
            after();
        }
    }

    /**
     *
     */
    public void after() {
        JiraUpdate jira = null;
        if (getCurrentwork().equals("REGRESSION")) {
            CommonProcedures.atlaslogOut(this);
            if (jiraWorkflowStart() && jirastatus) {
                this.jirastatus = false;
                jira = new JiraUpdate(this);
                jira.start();
            }
        } else if (getCurrentwork().equals("JIRA")) {
            jira.jiraLogOut();
        } else if (getCurrentwork().equals("RESET")) {

        }
        getReport().saveReport(this);
        closeDriver();
        endTheRun();
}

    public void openDriver() {
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
    }

    public void createTest(){
        String testname = this.getTestdetails().getTestname();
        try {
            this.clazz = Class.forName("screen." + testname + "." + testname + "Manager");
            Constructor<?> ctor = this.clazz.getConstructor();
            this.test = (AT2Test) ctor.newInstance(new Object[]{});
        } catch (Exception e) {
            String message = "-- ERROR -- test(); Not able to find the class referent to the current test(" + testname + "), ir it has invalid structure, please check";
            e.printStackTrace();
            ErrorManager.process(this, message);
        }
    }
    public boolean test() {
        try {
            if(test.start(this)){return false;}
        } catch (Exception e) {
            String message = "-- ERROR -- test(); Not able to find the class referent to the current test, or it has invalid structure, please check";
            e.printStackTrace();
            ErrorManager.process(this, message);
            return false;
        }
        return true;
    }

    /**
     *
     * @param testname
     * @return
     */
    public boolean checkExistence(String testname) {
        boolean exist = true;
        try {
            this.clazz = Class.forName("screen." + testname + "." + testname + "Manager");
        } catch (Exception e) {
            exist = false;
            System.out.println("-- ERROR -- checkTestExistence(); Not able to find the class referent to the current test(" + testname + "), or it has invalid structure, please check");
        }
        return exist;
    }

    public void closeDriver() {
        this.driver.close();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public boolean jiraWorkflowStart() {

        String fileName = "c:/SisVersion.txt";
        File f = new File(fileName);

        if (!getTestdetails().getIssue().equals("") && f.exists()) {
            return true;
        } else {
            return false;
        }

    }

    public void endTheRun(){
        System.exit(teststatus);
    }

}