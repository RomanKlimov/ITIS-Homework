import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.namespace.QName;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class main {
    public static void main(String[] args) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        DocumentBuilder documentBuilder;
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("/home/roman/IdeaProjects/xpathLesson1/src/books.xml"));


        XPathExpression xPathExpression = xPath.compile("//book/title/text()");
        NodeList result = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < result.getLength(); i++) {
            System.out.println(result.item(i).getNodeValue());
        }

    }
}
