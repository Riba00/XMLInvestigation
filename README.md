# investigacioXML
<p align ="center">
  <img src="https://user-images.githubusercontent.com/91245889/200307389-ca0a263f-0785-4115-b7fa-d9a1303f0ce6.png">
</p>


## Content Table
- [DOM](#dom)
- [SAX](#sax)
- [xPath](#xpath)
- [xQuery](#xquery)

### DOM




DOM is, regardless of the language, a model used for handling files. A tree of objects called **nodes** is generated and represent each tag in the XML document. These nodes can be of different types (documents, elements, attributes...) and are related to each other through a parent-child relationship.

<p align="center">
 <img src="https://user-images.githubusercontent.com/91245889/197552609-3b5f1be9-f1c7-4011-a12d-6ce4a8988a11.png">
</p>

DOM reads an entire document. It is useful when reading small to medium size XML files. It is a tree-based parser and a little slow when compared to SAX and occupies more space when loaded into memory. We can insert and delete nodes using the DOM API.
It is important to put all the code inside a try and catch it with a catch to prevent possible errors that could happen.

Thanks to some classes we can interact with the file:

* DocumentBuilderFactory
* DocumentBuilder
* Document
* NodeList

<ins>**EXAMPLE READING FILE**</ins>

You can see a reading file example in this project on class **src/DOMReadFile.java**

Output:
<p>
  <img src="https://user-images.githubusercontent.com/91245889/197555697-5e5b4d6b-4ca9-4797-9c73-40a4617277f1.png">
</p>

<ins>**EXAMPLE WRITING FILE**</ins>

In DOMWriteFile.java yo can see how to generate XML document.

Result:
<p>
  <img src="https://user-images.githubusercontent.com/91245889/200117849-3c78691a-3d4d-4b66-9a91-286556432a67.png">
</p>

### SAX

  SAX is also a parser for XML documents but it does not create a parse tree. Items are processed in the same order as they appear in the document. The main difference between DOM and SAX is that while the former has access to the entire document, that is, all elements and attributes are available at once, in SAX only the current element is available.
  
  SAX is responsible for traversing the structure of the document showing events that correspond to the elements that are is finding
  
  We need some classes to read a file using SAX:
  * SAX ParserFactory
  * SAX Parser
  * Handler
  
  And also, we need to catch the exceptions: ParserConfigurationException, SAXException and IOException.

- <ins>**EXAMPLE READING FILE**</ins>

You can see an example on **src/SAXReadFile.java**

Result:
<p>
  <img src="https://user-images.githubusercontent.com/91245889/200331608-d87c70f0-fb4d-468a-a093-4aed70367cd5.png">
</p>

### XPath

  The XPath language is the system used to browse and query the elements and attributes contained in the structure of an XML document.

  XPath is used by programmers to define advanced search criteria and specific calculations. It contains a library of 100 standard functions, which allow you to perform operations for handling strings, numerical operations, date comparisons.

  In this project you have an example how to do an xPath expression in Java. Check **src/xPathExample.java**

Result:

<p>
  <img src="https://user-images.githubusercontent.com/91245889/200308028-0958077f-cf86-4724-bf63-e697f6d4145a.png">
</p>

### XQuery

- [ ] Que es
- [ ] Que puc fer amb XQuery
- [ ] Exemple de com consultar els Cds més barats de 10$
