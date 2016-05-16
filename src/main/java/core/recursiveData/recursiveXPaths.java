package core.recursiveData;

public class recursiveXPaths {
    //<editor-fold desc="GLASS">
    public final static String glass = "//*[contains(@class,'AFModalGlassPane')]";
    //</editor-fold>
    //<editor-fold desc="LOV XPATHS">
    public static final String[] lov_b_search = {"lov_b_search", "//*[contains(@id, '_afrLovInternalQueryId::search')]"};
    public static final String lov_i_genericinput = "//*[contains(@id, '_afrLovInternalQueryId:value00::content')]";
    public static final String[] lov_e_result = {"lov_e_result", "//*[contains(@id, '_afrLovInternalTableId::db')]/table/tbody/tr[1]/td[1]"};
    public static final String[] lov_e_altresult = {"lov_e_altresult", "//*[contains(@id, '_afrLovInternalTableId::db')]/table/tbody/tr[2]/td[1]"};
    public static final String[] lov_e_altresult2 = {"lov_e_altresult", "//*[contains(@id, '_afrLovInternalTableId::db')]/table/tbody/tr[3]/td[1]"};
    public static final String[] lov_b_ok = {"lov_b_ok", "//*[contains(@id, 'lovDialogId::ok')]"};
    //</editor-fold>
    //<editor-fold desc="DELETE XPATHS">
    public static final String delete_b_yes = "//*[contains(@id, 'dConfirmDelete::yes')]";
    public static final String audit_b_ok = "//*[contains(@id, 'd22::ok')]";
    //</editor-fold>
    //<editor-fold desc="LOG IN XPATHS">
    public static final String userinput = "//*[@id='username']";
    public static final String passinput = "//*[@id='password']";
    public static final String logout = "//*[@id='pt1:cblog1']";
    public static final String loginbutton = "//*[@id='inputs']/div/input";
    //</editor-fold>
    //<editor-fold desc="COMPONENT SEARCH">
    public static final String searchicon = "//*[contains(@id, 'pt1:searchminimenu::icon')]";
    public static final String componentinput = "//*[contains(@id, 'j_id__ctru158::content')]";
    public static final String searchcomponent = "//*[contains(@id, 'pt_i2::icon')]";
    public static final String result = "//*[contains(@id, 'pt_i3:0:cl3')]";
    //</editor-fold>
    //<editor-fold desc="JIRA">
    public static final String[] jirauserinput = {"username", "//*[contains(@id, 'login-form-username')]"};
    public static final String[] jirapassimput = {"password", "//*[contains(@id, 'login-form-password')]"};
    public static final String[] jiraloginbutton = {"login", "//*[contains(@id, 'login-form-submit')]"};
    public static final String[] jiralogoutbutton = {"userLogOut", "//*[contains(@id, 'header-details-user-fullname')]"};
    //</editor-fold>
}