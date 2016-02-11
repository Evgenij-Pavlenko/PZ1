package ua.com.oa.pavlenko_e;

import java.io.File;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
//import ua.com.oa.pavlenko_e.Shop;
//import ua.com.oa.pavlenko_e.Good;


public abstract class ParserJAXB {
	
	public static void marshaller (){
		Shop myShop = new Shop("ABC"); //Создаем магазин
		Good good1 = new Good(1, "lenovo-tab", 1000, "tab", "tab-pc");
		Good good2 = new Good(2, "Samsung-tab", 1500, "tab", "tab-pc");
		Good good3 = new Good(3, "Dell", 11000, "notebook", "notebook-pc");
		
		ArrayList<Good> goods = new ArrayList<>();
		goods.add(good1);
		goods.add(good2);
		goods.add(good3);
		
		myShop.setGoodslist(goods);//добавили список товаро в магазин
		
		
		try {
			//Создаем JAXB  контекст и инициализируем  marshaller
			JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			//Добавим свойство, которое выведет читабельный формат в результате
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			File XMLFile = new File("fileForParser.xml");
			
			//Пишем в XML файл
			jaxbMarshaller.marshal(myShop, XMLFile);
			
			//Пишем в консоль
			jaxbMarshaller.marshal(myShop, System.out);
			
		} catch (JAXBException e) {
			System.out.println("Парсер из объектов в XML некорректно работал");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public static void unmarshaller () {
			
		//Создаем JAXB контекст, инициализируем анмаршаллинг
		try {
			//Создаем JAXB контекст, инициализируем анмаршаллинг
			JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
			Unmarshaller jaxbUnmarshaller  = jaxbContext.createUnmarshaller();
			
			File XMLFile = new File ("fileForParser.xml");
			//Эта строка создает объекты из XML-файла
			Shop myShop = (Shop) jaxbUnmarshaller.unmarshal(XMLFile);
			
			System.out.println("Название магазина: " + myShop.getShopName());
			System.out.println("");
			
			List<Good> goodslist = myShop.getGoodslist();
			
//			System.out.println(goodslist); //Печать Листа товаров
			
			// Выводим на печать каждый товар
			for (Good good : goodslist) {
							
				System.out.println("goods ID: "+ good.getId());
				System.out.println("goods Name: "+ good.getName());
				System.out.println("goods Price: "+ good.getPrice());
				System.out.println("goodsc Category: "+ good.getCategory());
				System.out.println("goods Description: "+ good.getDescription());
				System.out.println("-------------------------------");
				
			}
			
		} catch (JAXBException e) {
			System.out.println("Парсер из XML в объекты некорректно работал");
			e.printStackTrace();
		}
		
		
	}
}
