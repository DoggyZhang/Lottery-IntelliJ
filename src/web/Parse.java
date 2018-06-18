package web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class Parse {

    // http://kaijiang.500.com/shtml/dlt/18069.shtml
    public static void main(String[] args) {
        try {
            InputStreamReader in = new InputStreamReader(new FileInputStream("D:\\WorkSpace\\IDEA\\Lottery\\res\\web.txt"));

            BufferedReader reader = new BufferedReader(in);

            String html = null;
            StringBuilder builder = new StringBuilder();

            while ((html = reader.readLine()) != null) {
                builder.append(html);
                builder.append("\n");
            }

            html = builder.toString();
            // System.out.println(builder.toString());

            Document doc = Jsoup.parse(html);
            Elements kj_tablelist02 = doc.getElementsByClass("kj_tablelist02");

            Element info = kj_tablelist02.first();

            Elements ball_box01 = info.getElementsByClass("ball_box01");
            System.out.println(" ball_box01.size()");
            System.out.println(ball_box01.size());
            System.out.println("ball_box01.html() ");
            System.out.println(ball_box01.html());

            System.out.println("---------------------------------------------------------------------------------------");
            Elements lis = ball_box01.first().getElementsByTag("li");

            for( Element e :  lis){
                System.out.println("-----------------");
                System.out.println(e.html());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
