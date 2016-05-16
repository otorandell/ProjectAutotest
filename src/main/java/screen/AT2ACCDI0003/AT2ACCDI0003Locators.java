package screen.AT2ACCDI0003;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by otorandell on 16/02/2016.
 */
public class AT2ACCDI0003Locators {
    Map<String, String> elements = new HashMap<>();

    public AT2ACCDI0003Locators() {
        setElements();
    }

    public Map<String, String> getElements() {
        return elements;
    }

    public void setElements() {


         /* BOOSA1002 */
        elements.put("boosa1002_b_searchbook", "//*[contains(@id, '0:i10::icon')]");
        elements.put("boosa1002_b_bookingsearch", "//*[contains(@id, '0:cb2::icon')]");
        elements.put("boosa1002_b_bookingsearch_i_booking", "//*[contains(@id, '0:it55::content')]");
        elements.put("boosa1002_b_bookingsearch_b_search", "//*[contains(@id, '0:cb1header')]");
        elements.put("boosa1002_purchasehotels_e_result_b_c", "//*[contains(@id, 'pc1:tPurch:1:cb9')]");

         /* BOOSA0001 */
        elements.put("boosa0001_i_creationdate", "//*[contains(@id, 'id4::content')]");
        elements.put("boosa0001_b_search", "//*[contains(@id, 'pt1:dyntdc:r2:1:cb3')]");
        elements.put("boosa0001_e_result", "//*[contains(@id, 'pc1:t1::db')]/table/tbody/tr[1]/td[1]");
        elements.put("boosa0001_e_result_e_bookreference", "//*[contains(@id, '1:pc1:t1:0:cl1')]");
        elements.put("boosa0001_b_closetab", "//*[contains(@id, 'dynTabsPane:2:tabIndex::rmAbv')]");

        /* ACCDI0003 */

        elements.put("accdi0003_lov_destination", "//*[contains(@id, 'r1:0:destinationId::lovIconId')]");
        elements.put("accdi0003_i_destination", "//*[contains(@id, 'r1:0:destinationId::content')]");
        elements.put("accdi0003_lov_area", "//*[contains(@id, 'r1:0:areaId::lovIconId')]");
        elements.put("accdi0003_i_area", "//*[contains(@id, 'r1:0:areaId::content')]");
        elements.put("accdi0003_lov_area", "//*[contains(@id, 'r1:0:areaId::lovIconId')]");
        elements.put("accdi0003_i_area", "//*[contains(@id, 'r1:0:areaId::content')]");
        elements.put("accdi0003_lov_rate", "//*[contains(@id, 'r1:0:rateId::lovIconId')]");
        elements.put("accdi0003_i_rate", "//*[contains(@id, 'r1:0:rateId::content')]");
        elements.put("accdi0003_lov_transfer", "//*[contains(@id, 'r1:0:transferId::lovIconId')]");
        elements.put("accdi0003_i_transfer", "//*[contains(@id, 'r1:0:transferId::content')]");
        elements.put("accdi0003_lov_room", "//*[contains(@id, 'r1:0:roomId::lovIconId')]");
        elements.put("accdi0003_i_room", "//*[contains(@id, 'r1:0:roomId::content')]");
        elements.put("accdi0003_lov_characteristics", "//*[contains(@id, 'r1:0:characteristicsId::lovIconId')]");
        elements.put("accdi0003_i_characteristics", "//*[contains(@id, 'r1:0:characteristicsId::content')]");
        elements.put("accdi0003_lov_board", "//*[contains(@id, 'r1:0:boardId::lovIconId')]");
        elements.put("accdi0003_i_board", "//*[contains(@id, 'r1:0:boardId::content')]");
        elements.put("accdi0003_cb_agr", "//*[contains(@id, 'r1:0:sbc1::content')]");
        elements.put("accdi0003_cb_payment", "//*[contains(@id, 'r1:0:sbc2::content')]");
        elements.put("accdi0003_b_search", "//*[contains(@id, 'r1:0:r1:0:ctb1')]");
        elements.put("accdi0003_b_detach", "//*[contains(@id, 'r1:0:pc1:_dchTbr')]");

    }
}
