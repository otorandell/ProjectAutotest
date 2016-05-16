package screen.AT2MDMCL0030;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by otorandell on 16/02/2016.
 */
public class AT2MDMCL0030Locators {
    Map<String, String> elements = new HashMap<>();

    public AT2MDMCL0030Locators() {
        setElements();
    }

    public Map<String, String> getElements() {
        return elements;
    }

    public void setElements() {


         /* SEARCH */
        elements.put("search_b_search", "//*[contains(@id, 'qryId1::search')]");
        elements.put("search_b_reset", "//*[contains(@id, 'qryId1::reset')]");
        elements.put("search_e_result", "//*[contains(@id, 'pc1:resId1::db')]/table/tbody/tr[1]/td[1]");
        elements.put("search_n_records", "//*[contains(@id, 'pc1:ot35')]");

        elements.put("search_i_param_name", "//*[contains(@id, 'value00::content')]");
        elements.put("search_i_param_value", "//*[contains(@id, 'value10::content')]");
        elements.put("search_i_age_ext_code", "//*[contains(@id, 'value20::content')]");

        /* RECORD INTERACTION */
        elements.put("record_interaction_b_add", "//*[contains(@id, 'pc1:pcgt1:boton_add')]");
        elements.put("record_interaction_b_add2", "//*[contains(@id, 'pc1:pcgtss1:boton_add')]");
        elements.put("record_interaction_b_edit", "//*[contains(@id, 'pc1:pcgt1:boton_edit')]");
        elements.put("record_interaction_b_detach_close", "//*[contains(@id, '_afrDetachDialogId::close')]");
        elements.put("record_interaction_b_save", "//*[contains(@id, 'pc1:pcgt1:btn_commitExit')]");
        elements.put("record_interaction_b_cancel", "//*[contains(@id, 'pc1:pcgt1:boton_rollbackp')]");
        elements.put("record_interaction_b_cancel_b_ok", "//*[contains(@id, 'pc1:pcgt1:ctbt1')]");


        elements.put("record_interaction_i_param_name", "//*[contains(@id, 'pcgt1:it3::content')]");
        elements.put("record_interaction_i_param_value", "//*[contains(@id, 'pcgt1:it1::content')]");
        elements.put("record_interaction_i_age_ext_code", "//*[contains(@id, 'pcgt1:it2::content')]");

        /* DELETE */
        elements.put("delete_b_delete", "//*[contains(@id, 'pc1:pcgt1:boton_remove')]");

        /*DIALOG CANCEL*/
        elements.put("alert_b_ok", "//*[contains(@id, 'msgDlg::cancel')]");


    }
}
