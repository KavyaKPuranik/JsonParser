package JsonParser;

/* 
 * Element 	-> " AlphaNum " : Value
 * 			-> " AlphaNum " : Value , Element
 * 
 */

import java.util.ArrayList;

class Element 
{

	int matchElement(ArrayList<Character> jsonString, int index) throws ParserException,IndexOutOfBoundsException
	{
		if(jsonString.get(index) != '"')
			throw new ParserException("Json element key should start with \"");
		
		index++;
		{
			Terminal t = new Terminal();
			index = t.matchAlphaNum(jsonString, index);
		}
			
		if(jsonString.get(index) != ':')
			throw new ParserException("Missing ':' for some key:value Pair");

		index++;
		{
			Value v = new Value();
			index = v.matchValue(jsonString, index);
		}
		
		if(jsonString.get(index) == ',')
		{
			index++;
			index = matchElement(jsonString, index);
		}
		
		return index;
	}
	
}
