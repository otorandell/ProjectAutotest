package screen.AT2MDMCL0030;

import core.CommonActions.DataGenerator;
import core.FileGestor.DataHarvester;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by otorandell on 16/02/2016.
 */
public class AT2MDMCL0030Data {
    Map<String, String> data = new HashMap<>();
    DataHarvester harvester;

    public AT2MDMCL0030Data() {
        this.harvester = new DataHarvester("C:/ProjectAutotest/src/main/resources/AT2MDMCL0030Values.txt");
        setData();
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData() {
        this.data = harvester.harvestAll();
        if(data.get("empty").equals("true")){
            setDefaultData();
        }
    }
    public void setDefaultData(){
        data.put("param_name",DataGenerator.getRandomAlphanumericSequence(5, true));
        data.put("update_param_name",DataGenerator.getRandomAlphanumericSequence(5, true));
        data.put("param_value",DataGenerator.getRandomAlphanumericSequence(5, true));
        data.put("update_param_value",DataGenerator.getRandomAlphanumericSequence(5, true));
        data.put("age_ext_code",Integer.toString(DataGenerator.random(1, 20)));
        data.put("update_age_ext_code",Integer.toString(DataGenerator.random(1, 20)));
    }
}
