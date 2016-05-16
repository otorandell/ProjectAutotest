package core.HTMLReport;


import core.FileGestor.ReportFile;
import core.TestDriver.TestDriver;

/**
 * Created by otorandell on 08/02/2016.
 */
public class AutoReport extends HTMLFactory {
    String style = "body{color:#13335a;font-family:calibri,sans-serif;background:rgb(230,230,230);}" +
            " .container{border:1px solid black;padding:10px;width:90%;margin:5%;background:white;}" +
            " a{color : inherit;}" +
            " .error{color:red;font-weight:bold;}" +
            " .warning{color:orange;font-weight:bold;}" +
            " .hidden{visibility: hidden;}" +
            " .success{color:#0484a8;font-weight:bold;}" +
            " .header{color:#13335a;font-size:20px;font-weight:bold;display:block;}" +
            " .title{color:#13335a;font-size:40px;font-weight:bold;margin-bottom:-2%;margin-top:2%;margin-left:5%;}" +
            " img{width:200px;}" +
            ".container img:hover{width:1200px}";
    String meta = "";
    String content = "";
    String header = "";
    String footer = "";
    String body = "";
    String fullhtml = "";
    ReportFile file;

    public ReportFile getFile() {
        return file;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AutoReport() {}

    public void setMeta(TestDriver driver) {
        this.meta = makeHead(driver.getTestdetails().getTestname(), this.style, "UTF-8");
    }

    public void setHeader(TestDriver driver) {
        String status = "";
        String link = driver.getTestdetails().getTestname() + " " + driver.getTestdetails().getScreen();
        if (driver.getTeststatus() != 0) {
            status = "<div class='error'><a href='#" + link + "'>ERROR: " + link + " </a></div>";
        } else {
            status = "<div class='success'><a href='#" + link + "'>SUCCESS: " + link + " </a></div>";
        }
        String title = "<span class='header'>" +
                "<a name='" + link + "'/>" +
                " Component: " + driver.getTestdetails().getTestname() +
                " </span>" +
                " <span class='header'>" +
                " Screen: " + driver.getTestdetails().getScreen() +
                " </span>" +
                " <span class='header'>" +
                " Web Browser: firefox 23.0.1" + //ADJUST HERE
                " </span>" +
                " <span class='header'>" +
                " Environment: " + driver.getTestdetails().getEnvironment() +
                " </span>" +
                "<hr>";
        String header = addImg("file://C:/atlas20logo.png", "style='margin-left: 5%;'") +
                taggedLine(driver.getTestdetails().getTestname(), "p", "class='title'") +
                taggedLine(status, "div", "class='container'") +
                "<div class='container'>" +
                title;
        this.header = header;

    }

    public void setBody(TestDriver driver) {
        setHeader(driver);
        setFooter(driver);
        setMeta(driver);
        String pre = this.header + this.content + this.footer + "</div>";
        String body = taggedLine(pre, "body", "");
        this.body = body;

    }

    public void setFooter(TestDriver driver) {
        String semifooter = "";
        if (driver.getTeststatus() != 0) {
            semifooter = "<p class ='error'>Test " + driver.getTestdetails().getTestname() + " completed unsuccesfully, check the scrennshot and the error line for more info.</p><hr>";
        } else {
            semifooter = "<p class ='success'>Test " + driver.getTestdetails().getTestname() + " completed succesfully.</p><hr>";
        }
        String info = "<span class='header'>" +
                " Test Realized on " + driver.getTestdate() +
                " </span>" +
                " <span class='header'>" +
                " Total time: " + (driver.getTestend() - driver.getTeststart()) / 1000 + " seconds" +
                " </span>" +
                "<a href='#title'>Go to page top</a>" +
                "<hr>";
        this.footer = semifooter + info;
    }

    public void addContent(String line, String htmltag, String attr) {
        String newline = taggedLine(line, htmltag, attr);
        this.content = this.content + newline;
        System.out.println(newline);
    }

    public void addContent(String line) {
        String newline = taggedLine(line, "p", "");
        this.content = this.content + newline;
        System.out.println(newline);

    }

    public void closeBlock() {
        this.content = this.content + "</div><div class ='container'>";
    }

    public void saveReport(TestDriver driver) {
        mergeHTML(driver);
        file = new ReportFile(driver);
        file.saveReport(this.fullhtml);
    }

    public void mergeHTML(TestDriver driver) {
        setBody(driver);
        this.fullhtml = this.meta + this.body;
    }

    public void addImage(String src, String attr) {
        String newline = addImg(src, attr);
        this.content = this.content + newline;

    }

    public void addRawText(String raw) {
        this.content = this.content + raw;
    }

    public void addHeader(String line, int type, boolean center) {
        String style = "";
        if (center) {
            style = " style=\"text-align: center;\"";
        }
        String newline = "<h" + type + style + ">" + line + "</h" + type + ">";
        System.out.println(newline);
        this.content = this.content + newline;

    }
}