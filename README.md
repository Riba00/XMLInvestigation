# investigacioXML

# Investigació XML

## Taula continguts

### DOM

- [x] Que es
- [x] Com funciona
- [x] Classes necessaries
- [x] Excepcions
- [x] Codi exemple lectura fitxer
- [x] Codi exemple escriure fitxer
<p align="center">
 <img src="https://user-images.githubusercontent.com/91245889/197552609-3b5f1be9-f1c7-4011-a12d-6ce4a8988a11.png">
</p>


DOM is, regardless of the language, a model used for handling files. A tree of objects called **nodes** is generated and represent each tag in the XML document. These nodes can be of different types (documents, elements, attributes...) and are related to each other through a parent-child relationship.

DOM reads an entire document. It is useful when reading small to medium size XML files. It is a tree-based parser and a little slow when compared to SAX and occupies more space when loaded into memory. We can insert and delete nodes using the DOM API. 
It is important to put all the code inside a try and catch it with a catch to prevent possible errors that could happen.

Once the file is loaded, thanks to some classes we can interact with the file:
* DocumentBuilderFactory
* DocumentBuilder
* Document
* NodeList

<ins>**EXAMPLE READING FILE**</ins>

~~~
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

~~~
Output:
<p>
  <img src="https://user-images.githubusercontent.com/91245889/197555697-5e5b4d6b-4ca9-4797-9c73-40a4617277f1.png">
</p>

<ins>**EXAMPLE WRITING FILE**</ins>

~~~
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
~~~
Result:
<p>
  <img src="https://user-images.githubusercontent.com/91245889/200117849-3c78691a-3d4d-4b66-9a91-286556432a67.png">
</p>
 
### SAX
- [ ] Que es
- [ ] Com funciona
- [ ] Classes necessaries
- [ ] Excepcions
- [ ] Codi exemple lectura fitxer
- [ ] Codi exemple escriure fitxer





### XPath

- [ ] Que es
- [ ] Que puc fer amb XPath
- [ ] Exemple de com consultar els Cds anteriors a 1990


### XQuery

- [ ] Que es
- [ ] Que puc fer amb XPath
- [ ] Exemple de com consultar els Cds més barats de 10$


### Recursos

http://jmoral.es/blog/xml-dom
