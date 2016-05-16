package screen.AT2MDMOR0028;

import core.CommonActions.CommonProcedures;
import core.CommonActions.DataGenerator;
import core.CommonActions.Functions;
import core.ErrorManager.ErrorManager;
import core.TestDriver.TestDriver;
import core.recursiveData.recursiveXPaths;
import org.openqa.selenium.By;

/**
 * Created by otorandell on 08/04/2016.
 */
public class AT2MDMOR0028Test {

    protected AT2MDMOR0028Locators locators;
    protected AT2MDMOR0028Data data;

    public AT2MDMOR0028Test() {
    }

    public AT2MDMOR0028Locators getLocators() {
        return locators;
    }

    public void setLocators(AT2MDMOR0028Locators locators) {
        this.locators = locators;
    }

    public AT2MDMOR0028Data getData() {
        return data;
    }

    public void setData(AT2MDMOR0028Data data) {
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

        if (languageTestCSED(driver)){
            return true;
        }
        if(webLabelTestCSED(driver)){
            return true;
        }
        return false;
    }

    private boolean webLabelTestCSED(TestDriver driver) {
        driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES\" TABLE TEST", 2, true);

        if(!Functions.checkClick(driver,
                new String[]{"web_label_languages_tab",
                        getElements("web_label_languages_tab")}, //element to click
                new String[]{"web_label_languages_tab_web_label_languages_table_search_i_language_code",
                        getElements("web_label_languages_tab_web_label_languages_table_search_i_language_code")}, //element to click
                " to GO TO \"WEB LABEL LANGUAGES\" TAB")){return false;}

        if(!webLabelLanguagesTabWebLabelLanguagesTableRecordInteraction(driver, true)){return false;}
        if(!webLabelLanguagesTabWebLabelLanguagesTableSearch(driver)){return false;}
        if(!webLabelLanguagesTabWebLabelLanguagesTableRecordInteraction(driver, false)){return false;}
        if(!webLabelLanguagesTabWebLabelLanguagesTableSearch(driver)){return false;} // COMMENTED FOR SOME REASON
        if(!webLabelLanguagesTabWebLabelLanguagesTableExtraActions(driver)){return false;} // COMMENTED FOR SOME REASON
        if(!webLabelLanguagesTabwebLabelLanguagesDescriptionTableTestCSED(driver)){return false;}
        if(!webLabelLanguagesTabWebLabelLanguagesTableSearch(driver)){return false;}
        if(!webLabelLanguagesTabWebLabelLanguagesTableDelete(driver)){return false;}
        return true;
    }

    private boolean webLabelLanguagesTabWebLabelLanguagesTableDelete(TestDriver driver) {
        driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES\" TABLE DELETE:", 3, false);

        if(!Functions.doDelete(driver,
                new String[]{"web_label_languages_tab_web_label_languages_table_delete_b_delete",
                        getElements("web_label_languages_tab_web_label_languages_table_delete_b_delete")},//delete button
                " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE DELETE")){return false;}
        return true;
    }

    private boolean webLabelLanguagesTabwebLabelLanguagesDescriptionTableTestCSED(TestDriver driver) {
        driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES\" TABLE TEST", 2, true);

        if(!webLabelLanguagesTabWebLabelLanguagesDescriptionTableRecordInteraction(driver, true)){return false;}
        if(!webLabelLanguagesTabWebLabelLanguagesDescriptionTableQuery(driver)){return false;}
        if(!webLabelLanguagesTabWebLabelLanguagesDescriptionTableRecordInteraction(driver, false)){return false;}
        if(!webLabelLanguagesTabWebLabelLanguagesDescriptionTableQuery(driver)){return false;}
        if(!webLabelLanguagesTabWebLabelLanguagesDescriptionTableExtraActions(driver)){return false;}
        if(!webLabelLanguagesTabWebLabelLanguagesDescriptionTableQuery(driver)){return false;}
        if(!webLabelLanguagesTabWebLabelLanguagesDescriptionTableDelete(driver)){return false;}
        
        return true;
    }

    private boolean webLabelLanguagesTabWebLabelLanguagesDescriptionTableDelete(TestDriver driver) { driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE DELETE:", 3, false);

        if(!Functions.doDelete(driver,
                new String[]{"web_label_languages_tab_web_label_languages_description_table_delete_b_delete",
                        getElements("web_label_languages_tab_web_label_languages_description_table_delete_b_delete")},//delete button
                " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE DELETE")){return false;}
return true;
    }

    private boolean webLabelLanguagesTabWebLabelLanguagesDescriptionTableExtraActions(TestDriver driver) {
        driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE EXTRA ACTIONS:", 3, false);
        if(!Functions.auditData(driver,
                new String[]{"web_label_languages_tab_web_label_languages_description_table_audit_b_actions",
                        getElements("web_label_languages_tab_web_label_languages_description_table_audit_b_actions")}, //actions button
                new String[]{"web_label_languages_tab_web_label_languages_description_table_audit_b_audit",
                        getElements("web_label_languages_tab_web_label_languages_description_table_audit_b_audit")}, //audit button
                new String[]{"web_label_languages_tab_web_label_languages_description_table_audit_b_ok",
                        recursiveXPaths.audit_b_ok}, //audit_b_ok
                " to AUDIT \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE DATA")){return false;}
        if(!Functions.detachTable(driver,
                new String[]{"web_label_languages_tab_web_label_languages_description_table_detach_b_detach",
                        getElements("web_label_languages_tab_web_label_languages_description_table_detach_b_detach")}, //detach button
                true,
                " to DETACH \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE")){return false;}
    return true;
    }

    private boolean webLabelLanguagesTabWebLabelLanguagesDescriptionTableQuery(TestDriver driver) {
        driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE SEARCH:", 3, false);

         if(!Functions.clickQbE(driver,
                new String[]{"web_label_languages_tab_web_label_languages_description_table_query_b_qbe",
                        getElements("web_label_languages_tab_web_label_languages_description_table_query_b_qbe")},//any query input
                new String[]{"web_label_languages_tab_web_label_languages_description_table_query_i_code",
                        getElements("web_label_languages_tab_web_label_languages_description_table_query_i_code")},// query button
                " ")){return false;}
         if(!Functions.insertInput(driver,
                new String[]{"web_label_languages_tab_web_label_languages_description_table_query_i_code",
                        getElements("web_label_languages_tab_web_label_languages_description_table_query_i_code")},
                "web_label_languages_tab_web_label_languages_description_table_code",
               getData("web_label_languages_tab_web_label_languages_description_table_code"),
                " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE SEARCH ")){return false;}
         if(!Functions.insertInput(driver,
                new String[]{"web_label_languages_tab_web_label_languages_description_table_query_i_description",
                        getElements("web_label_languages_tab_web_label_languages_description_table_query_i_description")},
                "web_label_languages_tab_web_label_languages_description_table_description",
               getData("web_label_languages_tab_web_label_languages_description_table_description"),
                " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE SEARCH ")){return false;}
         if(!Functions.enterQueryAndClickResult(driver,
                new String[]{"web_label_languages_tab_web_label_languages_description_table_query_i_code",
                        getElements("web_label_languages_tab_web_label_languages_description_table_query_i_code")}, //any query input
                new String[]{"web_label_languages_tab_web_label_languages_description_table_query_e_result",
                        getElements("web_label_languages_tab_web_label_languages_description_table_query_e_result")}, //table result
                " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE SEARCH ")){return false;}
    return true;
    }

    private boolean webLabelLanguagesTabWebLabelLanguagesDescriptionTableRecordInteraction(TestDriver driver, boolean add) {

        if (add) {
            driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE ADD:", 3, false);

            if(!Functions.checkClick(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_b_add",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_b_add")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    "")){return false;}
            if(!Functions.createLovByValue(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_code_b_lov",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_code_b_lov")}, //LoV button
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_i_code",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_i_code")}, //external LoV input
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_code_lov_i_code",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_code_lov_i_code")}, //internal LoV input
                    getData("web_label_languages_tab_web_label_languages_table_language_code"),
                    "web_label_languages_tab_web_label_languages_description_table_code", //name of the data
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE ADD")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_i_description",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_i_description")},
                    "web_label_languages_tab_web_label_languages_description_table_description",
                    getData("web_label_languages_tab_web_label_languages_description_table_code") + " ADD",
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE ADD")){return false;}
            if(!Functions.checkClickByAbsence(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_b_save",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_b_save")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE ADD")){return false;}
        } else {
            driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE EDIT:", 3, false);
            if(!Functions.checkClick(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_b_edit",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_b_edit")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    "")){return false;}
            if(!Functions.createLov(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_code_b_lov",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_code_b_lov")},
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_i_code",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_i_code")},
                    recursiveXPaths.lov_b_search,
                    recursiveXPaths.lov_e_result,
                    recursiveXPaths.lov_b_ok,
                    "web_label_languages_tab_web_label_languages_description_table_code",
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE EDIT")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_i_description",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_i_description")},
                    "web_label_languages_tab_web_label_languages_description_table_description",
                    getData("web_label_languages_tab_web_label_languages_description_table_code") + " EDIT",
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE EDIT")){return false;}
            if(!Functions.checkClickByAbsence(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_b_save",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_b_save")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE EDIT")){return false;}
        }
        
    return true;
    }

    private boolean webLabelLanguagesTabWebLabelLanguagesTableExtraActions(TestDriver driver) {
        driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE EXTRA ACTIONS:", 3, false);
        if(!Functions.auditData(driver,
                new String[]{"web_label_languages_tab_web_label_languages_description_table_audit_b_actions",
                        getElements("web_label_languages_tab_web_label_languages_description_table_audit_b_actions")}, //actions button
                new String[]{"web_label_languages_tab_web_label_languages_description_table_audit_b_audit",
                        getElements("web_label_languages_tab_web_label_languages_description_table_audit_b_audit")}, //audit button
                new String[]{"web_label_languages_tab_web_label_languages_description_table_audit_b_ok",
                        recursiveXPaths.audit_b_ok}, //audit_b_ok
                " to AUDIT \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE DATA")){return false;}
        if(!Functions.detachTable(driver,
                new String[]{"web_label_languages_tab_web_label_languages_description_table_detach_b_detach",
                        getElements("web_label_languages_tab_web_label_languages_description_table_detach_b_detach")}, //detach button
                true,
                " to DETACH \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE")){return false;}
        return true;
    }

    private boolean webLabelLanguagesTabWebLabelLanguagesTableSearch(TestDriver driver) {
        driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES\" TABLE SEARCH:", 3, false);

        if(!Functions.insertInput(driver,
                new String[]{"web_label_languages_tab_web_label_languages_table_search_i_language_code",
                        getElements("web_label_languages_tab_web_label_languages_table_search_i_language_code")},
                "web_label_languages_tab_web_label_languages_table_language_code",
               getData("web_label_languages_tab_web_label_languages_table_language_code"),
                " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES\" TABLE SEARCH ")){return false;}

        if(!Functions.insertInput(driver,
                new String[]{"web_label_languages_tab_web_label_languages_table_search_i_language_description",
                        getElements("web_label_languages_tab_web_label_languages_table_search_i_language_description")},
                "web_label_languages_tab_web_label_languages_table_language_description",
               getData("web_label_languages_tab_web_label_languages_table_language_description"),
                " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES\" TABLE SEARCH ")){return false;}

        if(!Functions.clickSearchAndResult(driver,
                new String[]{"web_label_languages_tab_web_label_languages_table_search_b_search",
                        getElements("web_label_languages_tab_web_label_languages_table_search_b_search")}, //element to click
                new String[]{"web_label_languages_tab_web_label_languages_table_search_e_result",
                        getElements("web_label_languages_tab_web_label_languages_table_search_e_result")},
                " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES\" TABLE SEARCH ")){return false;}
        return true;
    }

    private boolean webLabelLanguagesTabWebLabelLanguagesTableRecordInteraction(TestDriver driver, boolean add) {

        if (add) {
            driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE ADD:", 3, false);

             if(!Functions.checkClick(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_b_add",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_b_add")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    "")){return false;}
             if(!Functions.createLovByValue(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_code_b_lov",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_code_b_lov")}, //LoV button
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_i_code",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_i_code")}, //external LoV input
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_code_lov_i_code",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_code_lov_i_code")}, //internal LoV input
                   getData("web_label_languages_tab_web_label_languages_table_language_code"),
                    "web_label_languages_tab_web_label_languages_description_table_code", //name of the data
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE ADD")){return false;}
             if(!Functions.insertInput(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_i_description",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_i_description")},
                    "web_label_languages_tab_web_label_languages_description_table_description",
                   getData("web_label_languages_tab_web_label_languages_description_table_code") + " ADD",
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE ADD")){return false;}
             if(!Functions.checkClickByAbsence(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_b_save",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_b_save")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE ADD")){return false;}
        } else {
            driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE EDIT:", 3, false);


            if(!Functions.simpleClick(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_query_e_result",
                            getElements("web_label_languages_tab_web_label_languages_description_table_query_e_result")}, //element to click
                    "")){return false;}
            if(!Functions.checkClick(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_b_edit",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_b_edit")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    "")){return false;}
             if(!Functions.createLov(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_code_b_lov",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_code_b_lov")},
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_i_code",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_i_code")},
                    recursiveXPaths.lov_b_search,
                    recursiveXPaths.lov_e_result,
                    recursiveXPaths.lov_b_ok,
                    "web_label_languages_tab_web_label_languages_description_table_code",
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE EDIT")){return false;}
             if(!Functions.insertInput(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_i_description",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_i_description")},
                    "web_label_languages_tab_web_label_languages_description_table_description",
                   getData("web_label_languages_tab_web_label_languages_description_table_code") + " EDIT",
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE EDIT")){return false;}
             if(!Functions.checkClickByAbsence(driver,
                    new String[]{"web_label_languages_tab_web_label_languages_description_table_record_interaction_b_save",
                            getElements("web_label_languages_tab_web_label_languages_description_table_record_interaction_b_save")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    " on \"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES DESCRIPTION\" TABLE EDIT")){return false;}
        }
        return true;
    }

    private boolean languageTestCSED(TestDriver driver) {
        driver.getReport().addHeader("\"WEB LABEL LANGUAGES\" TAB, \"WEB LABEL LANGUAGES\" TABLE TEST", 2, true);

        if(!Functions.checkClick(driver,
                new String[]{"Language Tab", getElements("Language Tab")}, //element to click
                new String[]{"language_tab_language_code_table_search_i_language_code",
                        getElements("language_tab_language_code_table_search_i_language_code")}, //element expected to appear
                " to GO TO \"LANGUAGE\" TAB")){return false;}

        if(!languageTabLanguageCodeTableRecordInteraction(driver, true)){return false;}
        if(!languageTabLanguageCodeTableSearch(driver)){return false;}
        if(!languageTabLanguageCodeTableRecordInteraction(driver, false)){return false;}
        if(!languageTabLanguageCodeTableSearch(driver)){return false;}
        if(!languageTabLanguageCodeTableExtraActions(driver)){return false;}
        if(!languageTabLanguageDescriptionTestCSED(driver)){return false;}
        if(!languageTabLanguageCodeTableSearch(driver)){return false;}
        if(!languageTabLanguageCodeTableDelete(driver)){return false;}
        return true;
        
    }

    private boolean languageTabLanguageCodeTableDelete(TestDriver driver) {
        driver.getReport().addHeader("\"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE DELETE:", 3, false);

        if(!Functions.doDelete(driver,
                new String[]{"language_tab_language_code_table_delete_b_delete",
                        getElements("language_tab_language_code_table_delete_b_delete")},//delete button
                " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE DELETE")){return false;}

        return false;
    }

    private boolean languageTabLanguageDescriptionTestCSED(TestDriver driver) {
        driver.getReport().addHeader("\"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE TEST", 2, true);
        if(!languageTabLanguageDescriptionTableRecordInteraction(driver, true)){return false;}
        if(!languageTabLanguageDescriptionTableQuery(driver)){return false;}
        if(!languageTabLanguageDescriptionTableRecordInteraction(driver, false)){return false;}
        if(!languageTabLanguageDescriptionTableQuery(driver)){return false;}
        if(!languageTabLanguageDescriptionTableExtraActions(driver)){return false;}
        if(!languageTabLanguageDescriptionTableDelete(driver)){return false;}
       return true;
    }

    private boolean languageTabLanguageDescriptionTableDelete(TestDriver driver) {
        driver.getReport().addHeader("\"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE DELETE:", 3, false);
        boolean recordsToDelete = true;
         if(!Functions.simpleClick(driver,
                new String[]{"language_tab_language_description_table_query_clear_inputs",
                        getElements("language_tab_language_description_table_query_clear_inputs")}, //element to click
                " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE QUERY ")){return false;}
         if(!Functions.enterQueryAndClickResult(driver,
                new String[]{"language_tab_language_description_table_query_i_code",
                        getElements("language_tab_language_description_table_query_i_code")},
                new String[]{"language_tab_language_description_table_query_e_result",
                        getElements("language_tab_language_description_table_query_e_result")},
                " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE QUERY ")){return false;}
        while (recordsToDelete) {
             if(!Functions.simpleClick(driver,
                    new String[]{"language_tab_language_description_table_query_e_result",
                            getElements("language_tab_language_description_table_query_e_result")},
                    " ")){return false;}
             if(!Functions.doDelete(driver,
                    new String[]{"language_tab_language_description_table_delete_b_delete",
                            getElements("language_tab_language_description_table_delete_b_delete")},
                    " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE DELETE ")){return false;}
            try {
                if (driver.getDriver().findElements(By.xpath(getElements("language_tab_language_description_table_query_e_result"))).size() > 0) {
                    recordsToDelete = true;
                } else {
                    recordsToDelete = false;
                }
            } catch (Exception e) {
                String ecode = "--ERROR: cannot check language_tab_language_description_table_query_e_result is visible or not)";
                e.printStackTrace();
                ErrorManager.process(driver, ecode);
                return  false;
            }
        }

        return true;
    }


    private boolean languageTabLanguageDescriptionTableExtraActions(TestDriver driver) {

        driver.getReport().addHeader("\"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE EXTRA ACTIONS:", 2, false);

        if(!Functions.auditData(driver,
                new String[]{"language_tab_language_description_table_audit_b_actions",
                        getElements("language_tab_language_description_table_audit_b_actions")}, //actions button
                new String[]{"language_tab_language_description_table_audit_b_audit",
                        getElements("language_tab_language_description_table_audit_b_audit")}, //audit button
                new String[]{"language_tab_language_description_table_audit_b_ok",
                        recursiveXPaths.audit_b_ok}, //audit_b_ok
                " to AUDIT \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE DATA ")){return false;}
        if(!Functions.detachTable(driver,
                new String[]{"language_tab_language_description_table_detach_b_detach",
                        getElements("language_tab_language_description_table_detach_b_detach")}, //detach button
                true,
                " to DETACH \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE ")){return false;}
        return true;
    }

    private boolean languageTabLanguageDescriptionTableQuery(TestDriver driver) {
        driver.getReport().addHeader("\"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE QUERY:", 2, false);

         if(!Functions.clickQbE(driver,

                new String[]{"language_tab_language_description_table_query_b_qbe",
                        getElements("language_tab_language_description_table_query_b_qbe")},
                new String[]{"language_tab_language_description_table_query_i_code",
                        getElements("language_tab_language_description_table_query_i_code")},
                " ")){return false;}
         if(!Functions.insertInput(driver,
                new String[]{"language_tab_language_description_table_query_i_code",
                        getElements("language_tab_language_description_table_query_i_code")},
                "language_tab_language_description_table_code",
               getData("language_tab_language_description_table_code"),
                " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE QUERY ")){return false;}
         if(!Functions.insertInput(driver,
                new String[]{"language_tab_language_description_table_query_i_description",
                        getElements("language_tab_language_description_table_query_i_description")},
                "language_tab_language_description_table_description",
               getData("language_tab_language_description_table_description"),
                " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE QUERY ")){return false;}
         if(!Functions.enterQueryAndClickResult(driver,
                new String[]{"language_tab_language_description_table_query_i_code",
                        getElements("language_tab_language_description_table_query_i_code")},
                new String[]{"language_tab_language_description_table_query_e_result",
                        getElements("language_tab_language_description_table_query_e_result")},
                " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE QUERY ")){return false;}

        return true;
    }

    private boolean languageTabLanguageDescriptionTableRecordInteraction(TestDriver driver, boolean add) {
        if (add) {
            driver.getReport().addHeader("\"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE ADD:", 3, false);

            if(!Functions.checkClick(driver,
                    new String[]{"language_tab_language_description_table_record_interaction_b_add",
                            getElements("language_tab_language_description_table_record_interaction_b_add")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    "")){return false;}
            if(!Functions.createLovByValue(driver,
                    new String[]{"language_tab_language_description_table_record_interaction_code_b_lov",
                            getElements("language_tab_language_description_table_record_interaction_code_b_lov")}, //LoV button
                    new String[]{"language_tab_language_description_table_record_interaction_i_code",
                            getElements("language_tab_language_description_table_record_interaction_i_code")}, //external LoV input
                    new String[]{"language_tab_language_description_table_record_interaction_code_lov_i_code",
                            getElements("language_tab_language_description_table_record_interaction_code_lov_i_code")}, //internal LoV input
                    "NOR", // value to search
                    "language_tab_language_description_table_code", //name of the data
                    " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE ADD")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"language_tab_language_description_table_record_interaction_i_description",
                            getElements("language_tab_language_description_table_record_interaction_i_description")},
                    "language_tab_language_description_table_description",
                   getData("language_tab_language_code_table_language_code") + " ÅDD",
                    " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE ADD")){return false;}
            if(!Functions.checkClickByAbsence(driver,
                    new String[]{"language_tab_language_description_table_record_interaction_b_save",
                            getElements("language_tab_language_description_table_record_interaction_b_save")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE ADD")){return false;}
        } else {
            driver.getReport().addHeader("\"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE EDIT:", 3, false);

            if(!Functions.checkClick(driver,
                    new String[]{"language_tab_language_description_table_record_interaction_b_edit",
                            getElements("language_tab_language_description_table_record_interaction_b_edit")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE EDIT")){return false;}
            if(!Functions.createLovByValue(driver,
                    new String[]{"language_tab_language_description_table_record_interaction_code_b_lov",
                            getElements("language_tab_language_description_table_record_interaction_code_b_lov")}, //LoV button
                    new String[]{"language_tab_language_description_table_record_interaction_i_code",
                            getElements("language_tab_language_description_table_record_interaction_i_code")}, //external LoV input
                    new String[]{"language_tab_language_description_table_record_interaction_code_lov_i_code",
                            getElements("language_tab_language_description_table_record_interaction_code_lov_i_code")}, //internal LoV input
                    "FIN", // value to search
                    "language_tab_language_description_table_code", //name of the data
                    " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE EDIT")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"language_tab_language_description_table_record_interaction_i_description",
                            getElements("language_tab_language_description_table_record_interaction_i_description")},
                    "language_tab_language_description_table_description",
                   getData("language_tab_language_code_table_language_code") + " ÄDD",
                    " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE EDIT")){return false;}
            if(!Functions.checkClickByAbsence(driver,
                    new String[]{"language_tab_language_description_table_record_interaction_b_save",
                            getElements("language_tab_language_description_table_record_interaction_b_save")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    " on \"LANGUAGE\" TAB, \"LANGUAGE DESCRIPTION\" TABLE EDIT")){return false;}

        }
        
        return true;  
    }

    private boolean languageTabLanguageCodeTableExtraActions(TestDriver driver) {
        driver.getReport().addHeader("\"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE EXTRA ACTIONS:", 3, false);

         if(!Functions.auditData(driver,
                new String[]{"language_tab_language_code_table_audit_b_actions",
                        getElements("language_tab_language_code_table_audit_b_actions")},
                new String[]{"language_tab_language_code_table_audit_b_audit",
                        getElements("language_tab_language_code_table_audit_b_audit")},
                new String[]{"audit_b_ok", recursiveXPaths.audit_b_ok},
                " to AUDIT \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE DATA")){return false;}
         if(!Functions.detachTable(driver,
                new String[]{"language_tab_language_code_table_detach_b_detach",
                        getElements("language_tab_language_code_table_detach_b_detach")},
                true,     //screenshot??
                " to DETACH \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE")){return false;}

        return true;
    }

    private boolean languageTabLanguageCodeTableSearch(TestDriver driver) {

        driver.getReport().addHeader("\"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE SEARCH:", 3, false);

        if(!Functions.insertInput(driver,
                new String[]{"language_tab_language_code_table_search_i_language_code",
                        getElements("language_tab_language_code_table_search_i_language_code")},
                "language_tab_language_code_table_language_code",
                getData("language_tab_language_code_table_language_code"),
                " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE SEARCH ")){return false;}
        if(!Functions.insertInput(driver,
                new String[]{"language_tab_language_code_table_search_i_language_description",
                        getElements("language_tab_language_code_table_search_i_language_description")},
                "language_tab_language_code_table_language_description",
                getData("language_tab_language_code_table_language_description"),
                " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE SEARCH ")){return false;}
        if(!Functions.insertInput(driver,
                new String[]{"language_tab_language_code_table_search_i_sap_language_code",
                        getElements("language_tab_language_code_table_search_i_sap_language_code")},
                "language_tab_language_code_table_sap_language_code",
                getData("language_tab_language_code_table_sap_language_code"),
                " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE SEARCH ")){return false;}
        if(!Functions.clickSearchAndResult(driver,
                new String[]{"\"Language\" Tab, \"Language Code\" table, Search button",
                        getElements("\"Language\" Tab, \"Language Code\" table: Search button")},
                new String[]{"language_tab_language_code_table_search_e_result",
                        getElements("language_tab_language_code_table_search_e_result")},
                " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE SEARCH ")){return false;}

        return true;
    }

    private boolean languageTabLanguageCodeTableRecordInteraction(TestDriver driver, boolean add) {

        if (add) {
            driver.getReport().addHeader("\"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE ADD:", 3, false);

            if(!Functions.checkExistence(driver, "", "language_tab_language_code_table_language_code",
                    new String[]{"language_tab_language_code_table_search_i_language_code",
                            getElements("language_tab_language_code_table_search_i_language_code")},
                    new String[]{"\"Language\" Tab, \"Language Code\" table, Search button",
                            getElements("\"Language\" Tab, \"Language Code\" table: Search button")},

                    new String[]{"language_tab_language_code_table_search_e_result",
                            getElements("language_tab_language_code_table_search_e_result")},
                    "both",
                    "")){return false;}
            if(!Functions.checkClick(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_b_add",
                            getElements("language_tab_language_code_table_record_interaction_b_add")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    "")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_i_language_code",
                            getElements("language_tab_language_code_table_record_interaction_i_language_code")},
                    "language_tab_language_code_table_language_code",
                    getData("language_tab_language_code_table_language_code"),
                    " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE ADD")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_i_language_description",
                            getElements("language_tab_language_code_table_record_interaction_i_language_description")},
                    "language_tab_language_code_table_language_description",
                    getData("language_tab_language_code_table_language_code") + " ADD",
                    " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE ADD")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_i_sap_language_code",
                            getElements("language_tab_language_code_table_record_interaction_i_sap_language_code")},
                    "language_tab_language_code_table_sap_language_code",
                    getData("language_tab_language_code_table_language_code").substring(0, 1),
                    " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE ADD")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_i_language_description_spanish",
                            getElements("language_tab_language_code_table_record_interaction_i_language_description_spanish")},
                    "language_tab_language_code_table_language_description_spanish",
                    getData("language_tab_language_code_table_language_description") + " (ES)",
                    " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE ADD")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_i_language_description_english",
                            getElements("language_tab_language_code_table_record_interaction_i_language_description_english")},
                    "language_tab_language_code_table_language_description_english",
                    getData("language_tab_language_code_table_language_description") + " (EN)",
                    " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE ADD")){return false;}
            if(!Functions.checkClickByAbsence(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_b_save",
                            getElements("language_tab_language_code_table_record_interaction_b_save")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE ADD")){return false;}

        } else {
            driver.getReport().addHeader("\"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE EDIT:", 3, false);

            if(!Functions.checkClick(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_b_edit",
                            getElements("language_tab_language_code_table_record_interaction_b_edit")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    "")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_i_language_code",
                            getElements("language_tab_language_code_table_record_interaction_i_language_code")},
                    "language_tab_language_code_table_language_code",
                    DataGenerator.getRandomAlphanumericSequence(3, false),
                    " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE EDIT")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_i_language_description",
                            getElements("language_tab_language_code_table_record_interaction_i_language_description")},
                    "language_tab_language_code_table_language_description",
                    getData("language_tab_language_code_table_language_code") + " EDIT",
                    " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE EDIT")){return false;}
            if(!Functions.insertInput(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_i_sap_language_code",
                            getElements("language_tab_language_code_table_record_interaction_i_sap_language_code")},
                    "language_tab_language_code_table_sap_language_code",
                    getData("language_tab_language_code_table_language_code").substring(0, 1),
                    " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE EDIT")){return false;}
            if(!Functions.checkClickByAbsence(driver,
                    new String[]{"language_tab_language_code_table_record_interaction_b_save",
                            getElements("language_tab_language_code_table_record_interaction_b_save")}, //element to click
                    new String[]{"glass", recursiveXPaths.glass},
                    " on \"LANGUAGE\" TAB, \"LANGUAGE CODE\" TABLE EDIT")){return false;}


        }
        return true;
    }

}
