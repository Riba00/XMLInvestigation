import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SAXReadFile {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        try {
            //DECLARE SAX PARSER
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            //HANDLER TO IDENTIFY THE ELEMENTS
            CdsHandler handler = new CdsHandler();

            //LOAD THE FILE
            saxParser.parse(new File("cd_catalog.xml"),handler);

            //PRINT CDS
            List<CD> cdList = handler.getCdList();
            for (CD cd : cdList){
                System.out.println(cd);
            }


        }catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
    }
}
