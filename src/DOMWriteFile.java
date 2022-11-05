import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMWriteFile {
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            //ROOT ELEMENT
            Element rootElement = doc.createElement("catalog");
            doc.appendChild(rootElement);

            //CD ELEMENT
            Element cdElement = doc.createElement("cd");
            rootElement.appendChild(cdElement);

            //CD ELEMENT ATTRIBUTE
            Attr cdIdAttr = doc.createAttribute("id");
            cdIdAttr.setValue("1");
            cdElement.setAttributeNode(cdIdAttr);

            //CD CHILD ELEMENTS
            Element titleElement = doc.createElement("title");
            titleElement.appendChild(doc.createTextNode("CD1"));
            cdElement.appendChild(titleElement);

            Element artistElement = doc.createElement("artist");
            artistElement.appendChild(doc.createTextNode("ARTIST 1"));
            cdElement.appendChild(artistElement);

            Element countryElement = doc.createElement("country");
            countryElement.appendChild(doc.createTextNode("COUNTRY 1"));
            cdElement.appendChild(countryElement);

            Element companyElement = doc.createElement("company");
            companyElement.appendChild(doc.createTextNode("COMPANY 1"));
            cdElement.appendChild(companyElement);

            Element priceElement = doc.createElement("price");
            priceElement.appendChild(doc.createTextNode("PRICE 1"));
            cdElement.appendChild(priceElement);

            Element yearElement = doc.createElement("year");
            yearElement.appendChild(doc.createTextNode("YEAR 1"));
            cdElement.appendChild(yearElement);

            //XML DOCUMENT CREATION
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("catalog_replication.xml"));

            transformer.transform(source,result);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
