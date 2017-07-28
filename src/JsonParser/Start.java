package JsonParser;

/*
 *  Start 	-> { Element }
 * 			-> { }	
 */

import java.util.ArrayList;

class Start {

	int matchStart(ArrayList<Character> jsonString, int index) throws ParserException,IndexOutOfBoundsException
	{
		if(jsonString.get(index) != '{')
			throw new ParserException("Json should start with {");
		
		index++;
		
		if(jsonString.get(index) != '}')
		{
			Element e = new Element();
			index = e.matchElement(jsonString, index);
		}
			
		if(jsonString.get(index) != '}')
			throw new ParserException("Json is incomplete");

		index++;
		//System.out.println(index + " " + jsonString.get(index));
		return index;
	}
	
	
}
