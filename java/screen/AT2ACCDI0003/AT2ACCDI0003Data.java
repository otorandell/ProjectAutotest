package screen.AT2ACCDI0003;

import core.CommonActions.DataGenerator;
import core.FileGestor.DataHarvester;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by otorandell on 16/02/2016.
 */
public class AT2ACCDI0003Data {
    Map<String, String> data = new HashMap<>();
    DataHarvester harvester;

    public AT2ACCDI0003Data() {
        this.harvester = new DataHarvester("C:/ProjectAutotest/src/main/resources/AT2ACCDI0003Values.txt");
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
        //TODO FILL WITH DATA
    }
}
