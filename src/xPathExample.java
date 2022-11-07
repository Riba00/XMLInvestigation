
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.sql.SQLOutput;

public class xPathExample {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse("cd_catalog.xml");

            XPath xp = XPathFactory.newInstance().newXPath();

            NodeList nl = (NodeList) xp.compile("//CD[YEAR<1990]").evaluate(d, XPathConstants.NODESET);

            System.out.print("CDs before 1990: "+nl.getLength());

            for (int i = 0; i < nl.getLength(); i++) {
                System.out.println(xp.compile(".").evaluate(nl.item(i)));
            }
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
            throw new RuntimeException(e);
        }

    }


}
