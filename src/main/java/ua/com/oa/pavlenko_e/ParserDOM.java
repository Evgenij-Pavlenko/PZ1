package ua.com.oa.pavlenko_e;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ParserDOM {
	public static void makeParseDOM() {
		
	
	File xmlDomFile = new File("fileForParser.xml");
	//создаем фабрику строителей
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	 
	try {
		// создаем конкретного строителя документ
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		
		// строитель строит документ 
		Document doc = dBuilder.parse(xmlDomFile);
		
		doc.getDocumentElement().normalize();
		//Поучаем корневой элемент
	    System.out.println("Root element: " 
	       + doc.getDocumentElement().getNodeName());
	    System.out.println("Название магазина: "
	    		+ doc.getDocumentElement().getAttribute("shopName"));
	    NodeList nList = doc.getElementsByTagName("good");
	    NodeList nList2 = doc.getChildNodes();
	    
	    System.out.println("----------------------------");
	    
	    
	    for (int i = 0; i < nList.getLength(); i++) {
	    	Node node = nList.item(i);
	    	System.out.println("\nCurrent Element :" + node.getNodeName());
	    	if (node.getNodeType() == Node.ELEMENT_NODE) {
	    		Element el = (Element) node;
	    		System.out.println("goods ID: " + el.getAttribute("id"));
	    		System.out.println("goods Name: " + el.getElementsByTagName("name").item(0).getTextContent());
	    		System.out.println("goods Price: " + el.getElementsByTagName("price").item(0).getTextContent());
	    		System.out.println("goodsc Category: " + el.getElementsByTagName("category").item(0).getTextContent()); 
	    		System.out.println("goods Description: " + el.getElementsByTagName("description").item(0).getTextContent());
				
	    		
//	    		"goods ID: "+ good.getId());
//				System.out.println("goods Name: "+ good.getName());
//				System.out.println("goods Price: "+ good.getPrice());
//				System.out.println("goodsc Category: "+ good.getCategory());
//				System.out.println("goods Description:
			}
			
		}
	    System.out.println("\nВсего товаров: " + nList.getLength() + " шт");
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}
