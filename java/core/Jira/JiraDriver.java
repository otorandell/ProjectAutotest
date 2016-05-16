package core.Jira;

import core.TestDriver.TestDriver;

/**
 * Created by otorandell on 12/02/2016.
 */
public class JiraDriver {
    TestDriver driver;

    public TestDriver getDriver() {
        return driver;
    }

    public void setDriver(TestDriver driver) {
        this.driver = driver;
    }

    public JiraDriver(TestDriver driver) {
    this.driver = driver;
    }

    public void driverSetUp(JiraDetails jiradetails) {
        driver.setCurrentwork("JIRA");
        setJiraURL(jiradetails.getUrl());
    }

    private void setJiraURL(String url) {
        driver.getDriverdetails().setUrl(url);
    }
}
