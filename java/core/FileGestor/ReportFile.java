package core.FileGestor;


import core.TestDriver.TestDriver;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by otorandell on 08/02/2016.
 */
public class ReportFile {

    private String filename;
    private String filepath;
    private String finalpath;

    public ReportFile(TestDriver driver) {
        setFilename(driver);
        setFilepath(driver);
    }

    public String getFinalpath() {
        return finalpath;
    }

    public void setFinalpath(String finalpath) {
        this.finalpath = finalpath;
    }

    public void setFilename(TestDriver driver) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
        String date = df.format(driver.getTestdate());
        this.filename = driver.getTestdetails().getTestname()+date+".html";
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(TestDriver driver){
        String provisionalpath="";
        String name = driver.getTestdetails().getTestname();
        if(driver.getTestdetails().getEnvironment().equals("sis")){
            provisionalpath = "C:/HudsonSis/jobs/Sis" + name + "/workspace/";
        }
        else{
            provisionalpath = "C:/Hudson/jobs/Test" + name + "/workspace/";
        }
        File folder = new File(provisionalpath);
        if(!folder.exists()){
            provisionalpath = "C:/mavenlog/";
        }
        if (!folder.exists()) { //The workspace is not present -> put results in log folde
            folder = new File(provisionalpath);
            folder.mkdir();
        }
        this.filepath = provisionalpath;
    }

    public void saveReport(String content){
        FileWriter out;
        setFinalpath(this.filepath+this.filename);
        try{
            out = new FileWriter(getFinalpath());
            out.write(content);
            out.close();
            System.out.println("--Report saved on "+getFinalpath()+"--");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
