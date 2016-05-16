package core.HTMLReport;

/**
 * Created by otorandell on 08/02/2016.
 */
public abstract class HTMLFactory {

    protected  String taggedLine(String content, String tagkind, String attr){
       String result;
        result = "<"+tagkind+" "+attr+">"+content+"</"+tagkind+" "+attr+">";
        return result;
    }

    protected  String makeHead(String title, String style, String charset){
        String result=
        "<!doctype html>" +
                "<html>" +
                "<head>" +
                "<meta charset='"+charset+"'>" +
                taggedLine(title, "title","" )+
                taggedLine(style,"style","type='text/css'")+
                "</head>";
        return result;
    }

    protected  String addImg(String src, String attr){
     String result = "<img src ='"+src+"' alt='"+attr+"'>";
        return result;
    }
}
