package ua.com.oa.pavlenko_e;

public class Parser {

	public static void main(String[] args) {

		/**
		 * JAXB
		 */
		System.out.println("Парсинг при помощи JAXB: ");
		System.out.println("");
		System.out.println("Marshaller:\n");
		
		ParserJAXB.marshaller();
		System.out.println("\nUnMarshaller:\n");
		ParserJAXB.unmarshaller();
		System.out.println("*********************************");

		/**
		 * DOM
		 */
		System.out.println("Парсинг при помощи DOM: ");
		System.out.println("");
		ParserDOM.makeParseDOM();
		System.out.println("*********************************");
		
		/**
		 * SAX
		 */
		System.out.println("Парсинг при помощи SAX"
				+ ": ");
		System.out.println("");
		ParserSAX.parserSAX();
		System.out.println("*********************************");

	}

}
