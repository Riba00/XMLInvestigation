# Investigació XML

## Taula continguts

### DOM

- [x] Que es
- [x] Com funciona
- [x] Classes necessaries
- [x] Excepcions
- [x] Codi exemple lectura fitxer
- [ ] Codi exemple escriure fitxer
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



 

### SAX
- [x] Que es
- [x] Com funciona
- [x] Classes necessaries
- [x] Excepcions
- [x] Codi exemple lectura fitxer
- [ ] Codi exemple escriure fitxer





### XPath

- [x] Que es
- [x] Que puc fer amb XPath
- [x] Cl
- [x] Excepcions
- [x] Codi exemple lectura fitxer
- [ ] Codi exemple escriure fitxer


### XQuery



### Recursos

http://jmoral.es/blog/xml-dom

