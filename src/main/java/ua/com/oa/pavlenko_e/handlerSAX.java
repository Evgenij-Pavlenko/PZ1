package ua.com.oa.pavlenko_e;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class handlerSAX extends DefaultHandler {

	public Shop shop;
	public Good good;
	public List<Good> goodslist = new ArrayList<>();
	public String newElement;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parse XML...");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// System.out.print("START :");

		if (qName.equalsIgnoreCase("shop")) {
			// System.out.print("Root element... " + qName);
			shop = new Shop();
			shop.setShopName(attributes.getValue("shopName")); // Название
																// магазина с
																// атрибута
																// подтягивает
			// System.out.println(attributes.getValue("shopName"));
		} else if (qName.equalsIgnoreCase("shopName")) {
			shop.setShopName(attributes.getType("shopName"));
			System.out.println(attributes.getIndex(qName));
		} else if (qName.equalsIgnoreCase("good")) {
			good = new Good();
			good.setId(Integer.parseInt(attributes.getValue("id")));

		}
		newElement = qName;

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		if (newElement.equalsIgnoreCase("name")) {
			good.setName(new String(ch, start, length));
			// System.out.println();

		} else if (newElement.equalsIgnoreCase("price")) {
			String price = new String(ch, start, length);
			// System.out.println(price);
			good.setPrice(Float.parseFloat(price.trim()));
		} else if (newElement.equalsIgnoreCase("category")) {
			good.setCategory(new String(ch, start, length));
		} else if (newElement.equalsIgnoreCase("description")) {
			good.setDescription(new String(ch, start, length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		newElement = "";
		// System.out.println("STOP: ");
		if (qName.equalsIgnoreCase("good")) {
			goodslist.add(good);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Stop parse XML...");
		System.out.println("Результат: ");
		shop.setGoodslist(goodslist);
		System.out.println(shop);
	}

}
