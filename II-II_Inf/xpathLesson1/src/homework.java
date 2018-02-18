import org.htmlcleaner.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class homework {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the link");
        String link = sc.nextLine();

        System.out.println("Enter xPath");
        String xpath = sc.nextLine();

        if (link == null) {
            throw new NullPointerException("Enter the link");
        }

        if (xpath == null) {
            throw new NullPointerException("Enter xpath");
        }

//        Pattern p = Pattern.compile("^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$");
//        Matcher m;
//        m=p.matcher(link);
//        if (m.matches() != true) {
//            throw new IllegalArgumentException("Enter correct link");
//        }

        if (!xpath.startsWith("/")) {
            throw new IllegalArgumentException("Enter correct xpath");
        }


        URL myUrl = new URL(link);


        HtmlCleaner htmlCleaner = new HtmlCleaner();
        CleanerProperties properties = htmlCleaner.getProperties();
        properties.setOmitComments(true);       // rm html comments
        TagNode tagNode = htmlCleaner.clean(myUrl);
        new PrettyXmlSerializer(properties).writeToFile(tagNode, "parsing.xml", "utf-8");

        File file = new File("parsing.xml");


        FileInputStream fileInputStream = new FileInputStream(file);
        XPath xPath = XPathFactory.newInstance().newXPath();
        DocumentBuilder documentBuilder;
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream);


        XPathExpression xPathExpression = xPath.compile(xpath);
        NodeList result = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < result.getLength(); i++) {
            System.out.println(result.item(i).getNodeValue());

        }
    }
}

