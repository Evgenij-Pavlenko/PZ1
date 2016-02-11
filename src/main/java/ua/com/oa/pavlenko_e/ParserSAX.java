package ua.com.oa.pavlenko_e;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParserSAX {
	 
	 public static void parserSAX (){
	 File fileXML = new File("fileForParser.xml");
	 SAXParserFactory spFactory = SAXParserFactory.newInstance();
     try {
         SAXParser  sParser = spFactory.newSAXParser();
         handlerSAX handler   = new handlerSAX();
         sParser.parse(fileXML, handler);
       
     } catch (Throwable err) {
         err.printStackTrace ();
     }
     System.out.println();
}
}
