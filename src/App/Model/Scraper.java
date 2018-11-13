package App.Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.regex.*;


public class Scraper {

    public void scrape() throws Exception{

        final Document document = Jsoup.connect("http://iyyf.org/wyyc2018-rules/freestyle-rules-2018/").get();

        for(Element line: document.select("div.post-entry p")){
            final String lineText = line.text();
            if(lineText.matches("[0-9].*")){
                System.out.println(lineText);
            }

        }
    }


}
