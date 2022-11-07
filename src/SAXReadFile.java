import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SAXReadFile {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

//     FORMA 1 NO VA
//        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
//        SAXParser saxParser = saxParserFactory.newSAXParser();
//        File file = new File("cd_catalog.xml");
//        CdsHandler handler = new CdsHandler();
//
//
//
//        ArrayList<CD> cds = handler.getCds();
//
//        System.out.println("aaaaaaa");
//        saxParser.parse(file,handler);
//        for (CD cd : cds){
//            System.out.println(cd);


        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            CdsHandler handler = new CdsHandler();

            saxParser.parse(new File("cd_catalog.xml"),handler);

            List<CD> cdList = handler.getCdList();
            for (CD cd : cdList){
                System.out.println(cd);
            }


        }catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
    }
}
