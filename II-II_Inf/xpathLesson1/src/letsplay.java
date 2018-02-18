import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class letsplay {
    public static void main(String[] args) throws IOException {

        URL myUrl = new URL("https://github.com/");
        URLConnection urlConnection = myUrl.openConnection();

        int n = urlConnection.getContentLength();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        int c;
        StringBuilder str = new StringBuilder();
        while ((c = bufferedReader.read()) != -1) {
            str.append((char) c);
            System.out.println(c);
        }

        HtmlCleaner htmlCleaner = new HtmlCleaner();
        CleanerProperties properties = htmlCleaner.getProperties();
        properties.setOmitComments(true);       // rm html comments
        TagNode tagNode = htmlCleaner.clean(str.toString());

        PrettyXmlSerializer xmlSerializer = new PrettyXmlSerializer(properties);
        String htmlout = null;
        htmlout = xmlSerializer.getAsString(tagNode);
//        System.out.println(htmlout);

//        new PrettyXmlSerializer(properties).writeToFile(
//                tagNode, "temp.html", "utf-8"
//        );

    }
}
