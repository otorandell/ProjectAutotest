package core.FileGestor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by otorandell on 09/02/2016.
 */
public class DataHarvester {
    String filepath;
    File file;
    FileReader filereader;
    BufferedReader bufferedreader;
    boolean open = false;
    public DataHarvester(String filepath) {
        this.filepath = filepath;
    }

    public void openFile(){
        try{
        this.file= new File(filepath);
            if(this.file.exists()){
        this.filereader = new FileReader(file);
        this.bufferedreader = new BufferedReader(filereader);
            open=true;
            }
            else{
                System.out.println(filepath+" was not found, please check.");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public void closeFile(){
        if(open){
        try{

    this.filereader.close();}
        catch (Exception e){
            e.printStackTrace();
        }}
    }
    public String harvest(String dataname){
        openFile();
        String line;
        String data="";
        if(open){
    try{
        while (((line = this.bufferedreader.readLine()) != null)) {
            String[] row = line.split("-");
            if (row[0].contains(dataname)) {
                data = row[1];
                closeFile();
                return data;
                }
            }
        }
    catch (Exception e){
            closeFile();
            e.printStackTrace();
        }
        closeFile();}
        return data;
    }
    public Map<String, String> harvestAll() {
        openFile();
        String line;
        Map<String, String> data = new HashMap<>();
        if (open) {
            try {
                while (((line = this.bufferedreader.readLine()) != (null))) {
                    String[] row = line.split("-");
                    data.put(row[0], row[1]);
                }
            } catch (Exception e) {
                closeFile();
                e.printStackTrace();
            }
            data.put("empty", "false");
            closeFile();
        }
        else{
            data.put("empty", "true");
        }

        return data;
    }
}
