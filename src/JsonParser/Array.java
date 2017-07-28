package JsonParser;

/* 
 * Array 	-> Value (, Value)*
 * 			-> e
 * 
 */

import java.util.ArrayList;

class Array 
{

	int matchArray(ArrayList<Character> jsonString, int index) throws ParserException
	{
		if(jsonString.get(index) != ']') 
		{
			{
				Value v = new Value();
				index = v.matchValue(jsonString, index);
			}
			while(jsonString.get(index) != ']')
			{
				if(jsonString.get(index) != ',') 
					throw new ParserException("Missing closing ] or , for some array ");
				index++;
				if(index>=jsonString.size())
					throw new ParserException("Missing closing ] for some array ");
				{
					Value v = new Value();
					index = v.matchValue(jsonString, index);
				}
				
			}
		}
		if(jsonString.get(index) != ']')
			throw new ParserException("Json array should end with ]");
		
		index ++;
		return index;
	}
	
}
