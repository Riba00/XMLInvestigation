

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import com.saxonica.xqj.SaxonXQDataSource;

public class xQueryExample {


    public static void main(String[] args) {
        try {
            execute();
        } catch (FileNotFoundException | XQException e) {
            e.printStackTrace();
        }
    }


    private static void execute() throws FileNotFoundException, XQException {
        //LOAD XQUERY FROM THE DOCUMENT
        InputStream inputStream = new FileInputStream(new File("cds.xqy"));

        //SEARCH IN THE XML DOCUMENT AND GET THE RESULT
        XQDataSource ds = new SaxonXQDataSource();
        XQConnection conn = ds.getConnection();
        XQPreparedExpression exp = conn.prepareExpression(inputStream);
        XQResultSequence result = exp.executeQuery();

        //PRINT RESULT
        while (result.next()) {
            System.out.println(result.getItemAsString(null));
        }
    }
}
