import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMReadFile {
    public static void main(String[] args) {

        File file = new File("cd_catalog.xml");

        // LECTURA DE FITXER
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            // NORMALIZE XML DOCUMENT
            doc.getDocumentElement().normalize();

            // SAVE THE NODES AND SHOW CD's COUNT
            NodeList nList = doc.getElementsByTagName("CD");
            System.out.println("Número de CD: " + nList.getLength());

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("TITLE: "
                            + eElement.getElementsByTagName("TITLE").item(0).getTextContent());
                    System.out.println("ARTIST: "
                            + eElement.getElementsByTagName("ARTIST").item(0).getTextContent());
                    System.out.println("COUNTRY: "
                            + eElement.getElementsByTagName("COUNTRY").item(0).getTextContent());
                    System.out.println("COMPANY: " + eElement.getElementsByTagName("COMPANY").item(0).getTextContent());
                    System.out.println("PRICE: "+eElement.getElementsByTagName("PRICE").item(0).getTextContent());
                    System.out.println("YEAR: "+eElement.getElementsByTagName("YEAR").item(0).getTextContent());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}