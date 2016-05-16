package core.TestDriver;

/**
 * Created by otorandell on 09/02/2016.
 */
public class TestDetails {
    String environment ="";
    String testname ="";
    String mainmenu;
    String submenu;
    String screen;
    String issue;
    String csedprocedure;

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public TestDetails() {
    }

    public String getCsedProcedure() {
        return csedprocedure;
    }

    public void setCsedProcedure(String csedprocedure) {
        this.csedprocedure = csedprocedure;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environement) {
        this.environment = environement;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String getMainmenu() {
        return mainmenu;
    }

    public void setMainmenu(String mainmenu) {
        this.mainmenu = mainmenu;
    }

    public String getSubmenu() {
        return submenu;
    }

    public void setSubmenu(String submenu) {
        this.submenu = submenu;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }
    public String getMenu(){
        String[] splitted = getTestname().split("AT2");
        String menu = splitted[1].substring(0,2);
        return menu;
    }
}
