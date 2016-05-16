package screen.AT2MDMOR0028;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by otorandell on 08/04/2016.
 */
public class AT2MDMOR0028Locators {

    Map<String, String> elements = new HashMap<>();

    public AT2MDMOR0028Locators() {
        setElements();
    }
    public Map<String, String> getElements() {
        return elements;
    }

    private void setElements() {

        elements.put("Language Tab", "//*[contains(@id, 'sdi1::disAcr')]");

        /* LANGUAGE TAB, LANGUAGE CODE TABLE SEARCH */
        elements.put("\"Language\" Tab, \"Language Code\" table: Search button", "//*[contains(@id, 'qryId1::search')]");
        elements.put("language_tab_language_code_table_search_e_result", "//*[contains(@id, 'pc1:gntidio::db')]/table/tbody/tr[1]/td[1]");
        elements.put("language_tab_language_code_table_search_e_result_no_data", "//*[contains(@id, 'pc1:gntidio::db')]");
        elements.put("language_tab_language_code_table_search_n_records", "//*[contains(@id, 'pc1:ot2')]");

        elements.put("language_tab_language_code_table_search_i_language_code", "//*[contains(@id, 'value00::content')]");
        elements.put("language_tab_language_code_table_search_i_language_description", "//*[contains(@id, 'value10::content')]");
        elements.put("language_tab_language_code_table_search_cb_status", "//*[contains(@id, 'value20::content')]");
        elements.put("language_tab_language_code_table_search_i_sap_language_code", "//*[contains(@id, 'value30::content')]");

        /* LANGUAGE TAB, LANGUAGE CODE TABLE RECORD INTERACTION */
        elements.put("language_tab_language_code_table_record_interaction_b_add", "//*[contains(@id, 'pc1:pcgt1:boton_add')]");
        elements.put("language_tab_language_code_table_record_interaction_b_edit", "//*[contains(@id, 'pc1:pcgt1:boton_edit')]");
        elements.put("language_tab_language_code_table_record_interaction_b_save", "//*[contains(@id, 'pc1:pcgt1:btn_commitExit')]");

        elements.put("language_tab_language_code_table_record_interaction_i_language_code", "//*[contains(@id, 'it4::content')]");
        elements.put("language_tab_language_code_table_record_interaction_i_language_description", "//*[contains(@id, 'it6::content')]");
        elements.put("language_tab_language_code_table_record_interaction_cb_status", "//*[contains(@id, 'sbc2::content')]");
        elements.put("language_tab_language_code_table_record_interaction_i_sap_language_code", "//*[contains(@id, 'it5::content')]");
        elements.put("language_tab_language_code_table_record_interaction_i_language_description_spanish", "//*[contains(@id, 'it17::content')]");
        elements.put("language_tab_language_code_table_record_interaction_i_language_description_english", "//*[contains(@id, 'it18::content')]");

        /* LANGUAGE TAB, LANGUAGE CODE TABLE EXTRA ACTIONS */
        elements.put("language_tab_language_code_table_audit_b_actions", "//*[contains(@id, 'pc1:pcgm1:dc_m1')]");
        elements.put("language_tab_language_code_table_audit_b_audit", "//*[contains(@id, 'pc1:pcgm1:dc_cmi0')]/td[2]");
        elements.put("language_tab_language_code_table_audit_b_ok", "//*[contains(@id, 'pcgm1:d22::ok')]");

        elements.put("language_tab_language_code_table_detach_b_detach", "//*[contains(@id, 'pc1:_dchTbr')]");

         /* LANGUAGE TAB, LANGUAGE CODE TABLE DELETE */
        elements.put("language_tab_language_code_table_delete_b_delete", "//*[contains(@id, 'pc1:pcgt1:boton_remove')]");
        elements.put("language_tab_language_code_table_delete_b_yes", "//*[contains(@id, 'pcgt1:dConfirmDelete::yes')]");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /* LANGUAGE TAB, LANGUAGE DESCRIPTION TABLE QUERY */
        elements.put("language_tab_language_description_table_query_b_qbe", "//*[contains(@id, 'pc2:_qbeTbr')]");
        elements.put("language_tab_language_description_table_query_e_result", "//*[contains(@id, 'pc2:gntidi::db')]/table/tbody/tr[1]/td[1]");
        elements.put("language_tab_language_description_table_query_e_result_no_data", "//*[contains(@id, 'pc2:gntidi::db')]");
        elements.put("language_tab_language_description_table_query_clear_inputs", "//*[contains(@id, 'pc2:gntidi::ch::t')]/tbody/tr[2]/th/a");

        elements.put("language_tab_language_description_table_query_i_code", "//*[contains(@id, '_afr_gntidi_afr_c6::content')]");
        elements.put("language_tab_language_description_table_query_i_description", "//*[contains(@id, '_afr_gntidi_afr_c5::content')]");

        /* LANGUAGE TAB, LANGUAGE DESCRIPTION TABLE RECORD INTERACTION */
        elements.put("language_tab_language_description_table_record_interaction_b_add", "//*[contains(@id, 'pc2:pcgt2:boton_add')]");
        elements.put("language_tab_language_description_table_record_interaction_b_edit", "//*[contains(@id, 'pc2:pcgt2:boton_edit')]");
        elements.put("language_tab_language_description_table_record_interaction_b_save", "//*[contains(@id, 'pc2:pcgt2:btn_commitExit')]");

        elements.put("language_tab_language_description_table_record_interaction_i_code", "//*[contains(@id, 'codLangId::content')]");
        elements.put("language_tab_language_description_table_record_interaction_code_b_lov", "//*[contains(@id, 'codLangId::lovIconId')]");
        elements.put("language_tab_language_description_table_record_interaction_code_lov_i_code", "//*[contains(@id, '_afrLovInternalQueryId:value00::content')]");

        elements.put("language_tab_language_description_table_record_interaction_i_description", "//*[contains(@id, 'it9::content')]");

        /* LANGUAGE TAB, LANGUAGE DESCRIPTION TABLE EXTRA ACTIONS */
        elements.put("language_tab_language_description_table_audit_b_actions", "//*[contains(@id, 'pc2:pcgm2:dc_m1')]");
        elements.put("language_tab_language_description_table_audit_b_audit", "//*[contains(@id, 'pc2:pcgm2:dc_cmi0')]/td[2]");
        elements.put("language_tab_language_description_table_audit_b_ok", "//*[contains(@id, 'pc2:pcgm2:d22::ok')]");

        elements.put("language_tab_language_description_table_detach_b_detach", "//*[contains(@id, 'pc2:_dchTbr')]");

        /* LANGUAGE TAB, LANGUAGE DESCRIPTION TABLE DELETE */
        elements.put("language_tab_language_description_table_delete_b_delete", "//*[contains(@id, 'pc2:pcgt2:boton_remove')]");
        elements.put("language_tab_language_description_table_delete_b_yes", "//*[contains(@id, 'pcgt2:dConfirmDelete::yes')]");

        //</editor-fold>

        //<editor-fold desc="WEB LABEL LANGUAGES TAB XPATHS">

        elements.put("web_label_languages_tab", "//*[contains(@id, 'sd2::disAcr')]");

        /* WEB LABEL LANGUAGES TAB, WEB LABEL LANGUAGES TABLE SEARCH */
        elements.put("web_label_languages_tab_web_label_languages_table_search_b_search", "//*[contains(@id, 'qryId2::search')]");
        elements.put("web_label_languages_tab_web_label_languages_table_search_e_result", "//*[contains(@id, 'pc3:etiweb::db')]/table/tbody/tr[1]/td[1]");
        elements.put("web_label_languages_tab_web_label_languages_table_search_e_result_no_data", "//*[contains(@id, 'pc3:etiweb::db')]");
        elements.put("web_label_languages_tab_web_label_languages_table_search_n_records", "//*[contains(@id, 'pc3:ot6')]");

        elements.put("web_label_languages_tab_web_label_languages_table_search_i_language_code", "//*[contains(@id, 'value00::content')]");
        elements.put("web_label_languages_tab_web_label_languages_table_search_i_language_description", "//*[contains(@id, 'value10::content')]");
        elements.put("web_label_languages_tab_web_label_languages_table_search_cb_active", "//*[contains(@id, 'value20::content')]");

        /* WEB LABEL LANGUAGES TAB, WEB LABEL LANGUAGES TABLE RECORD INTERACTION */
        elements.put("web_label_languages_tab_web_label_languages_table_record_interaction_b_add", "//*[contains(@id, 'pc3:pcgt3:boton_add')]");
        elements.put("web_label_languages_tab_web_label_languages_table_record_interaction_b_edit", "//*[contains(@id, 'pc3:pcgt3:boton_edit')]");
        elements.put("web_label_languages_tab_web_label_languages_table_record_interaction_b_save", "//*[contains(@id, 'pc3:pcgt3:btn_commitExit')]");

        elements.put("web_label_languages_tab_web_label_languages_table_record_interaction_i_language_code", "//*[contains(@id, 'it12::content')]");
        elements.put("web_label_languages_tab_web_label_languages_table_record_interaction_i_language_description", "//*[contains(@id, 'it13::content')]");
        elements.put("web_label_languages_tab_web_label_languages_table_record_interaction_cb_active", "//*[contains(@id, 'sbc4::content')]");

        /* WEB LABEL LANGUAGES TAB, WEB LABEL LANGUAGES TABLE EXTRA ACTIONS */
        elements.put("web_label_languages_tab_web_label_languages_table_audit_b_actions", "//*[contains(@id, 'pc3:pcgm3:dc_m1')]");
        elements.put("web_label_languages_tab_web_label_languages_table_audit_b_audit", "//*[contains(@id, 'pc3:pcgm3:dc_cmi0')]/td[2]");
        elements.put("web_label_languages_tab_web_label_languages_table_audit_b_ok", "//*[contains(@id, 'pcgm3:d22::ok')]");

        elements.put("web_label_languages_tab_web_label_languages_table_detach_b_detach", "//*[contains(@id, 'pc3:_dchTbr')]");

        /* WEB LABEL LANGUAGES TAB, WEB LABEL LANGUAGES TABLE DELETE */
        elements.put("web_label_languages_tab_web_label_languages_table_delete_b_delete", "//*[contains(@id, 'pc3:pcgt3:boton_remove')]");
        elements.put("web_label_languages_tab_web_label_languages_table_delete_b_yes", "//*[contains(@id, 'pcgt3:dConfirmDelete::yes')]");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /* WEB LABEL LANGUAGES TAB, WEB LABEL LANGUAGES TABLE QUERY */
        elements.put("web_label_languages_tab_web_label_languages_description_table_query_b_qbe", "//*[contains(@id, 'pc4:_qbeTbr')]");
        elements.put("web_label_languages_tab_web_label_languages_description_table_query_e_result", "//*[contains(@id, 'pc4:etiweid::db')]/table/tbody/tr[1]/td[1]");
        elements.put("web_label_languages_tab_web_label_languages_description_table_query_e_result_no_data", "//*[contains(@id, 'pc4:etiweid::db')]");
        elements.put("web_label_languages_tab_web_label_languages_description_table_query_n_records", "//*[contains(@id, 'pc4:ot10')]");

        elements.put("web_label_languages_tab_web_label_languages_description_table_query_i_code", "//*[contains(@id, '_afr_etiweid_afr_c13::content')]");
        elements.put("web_label_languages_tab_web_label_languages_description_table_query_i_description", "//*[contains(@id, '_afr_etiweid_afr_c12::content')]");

        /* WEB LABEL LANGUAGES TAB, WEB LABEL LANGUAGES TABLE RECORD INTERACTION */
        elements.put("web_label_languages_tab_web_label_languages_description_table_record_interaction_b_add", "//*[contains(@id, 'pc4:pcgt4:boton_add')]");
        elements.put("web_label_languages_tab_web_label_languages_description_table_record_interaction_b_edit", "//*[contains(@id, 'pc4:pcgt4:boton_edit')]");
        elements.put("web_label_languages_tab_web_label_languages_description_table_record_interaction_b_save", "//*[contains(@id, 'pc4:pcgt4:btn_commitExit')]");

        elements.put("web_label_languages_tab_web_label_languages_description_table_record_interaction_i_code", "//*[contains(@id, 'codLang1Id::content')]");
        elements.put("web_label_languages_tab_web_label_languages_description_table_record_interaction_code_b_lov", "//*[contains(@id, 'codLang1Id::lovIconId')]");
        elements.put("web_label_languages_tab_web_label_languages_description_table_record_interaction_code_lov_i_code", "//*[contains(@id, '_afrLovInternalQueryId:value00::content')]");

        elements.put("web_label_languages_tab_web_label_languages_description_table_record_interaction_i_description", "//*[contains(@id, 'it16::content')]");

        /* WEB LABEL LANGUAGES TAB, WEB LABEL LANGUAGES TABLE RECORD INTERACTION */
        elements.put("web_label_languages_tab_web_label_languages_description_table_audit_b_actions", "//*[contains(@id, 'pc4:pcgm4:dc_m1')]");
        elements.put("web_label_languages_tab_web_label_languages_description_table_audit_b_audit", "//*[contains(@id, 'pc4:pcgm4:dc_cmi0')]/td[2]");
        elements.put("web_label_languages_tab_web_label_languages_description_table_audit_b_ok", "//*[contains(@id, 'pcgm4:d22::ok')]");

        elements.put("web_label_languages_tab_web_label_languages_description_table_detach_b_detach", "//*[contains(@id, 'pc4:_dchTbr')]");

        /* WEB LABEL LANGUAGES TAB, WEB LABEL LANGUAGES TABLE RECORD INTERACTION */
        elements.put("web_label_languages_tab_web_label_languages_description_table_delete_b_delete", "//*[contains(@id, 'pc4:pcgt4:boton_remove')]");
        elements.put("web_label_languages_tab_web_label_languages_description_table_delete_b_yes", "//*[contains(@id, 'pcgt4:dConfirmDelete::yes')]");

    }
}
