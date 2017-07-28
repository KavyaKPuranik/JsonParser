package JsonParser;

/* 
 * Value 	-> " AlphaNum "
 * 			-> { Element }
 * 			-> [ Array ]
 * 			-> Constant
 * 
 */

import java.util.ArrayList;

class Value 
{

	int matchValue(ArrayList<Character> jsonString, int index) throws ParserException
	{
		switch(jsonString.get(index))
		{
			case '"' :  index++;
						{
							Terminal t = new Terminal();
							index = t.matchAlphaNum(jsonString, index);
						}
			break;
			
			case '{' :  
						Start s = new Start();
		    	  		index = s.matchStart(jsonString,index);
			break;
			
			case '[' :   index++;
						Array a = new Array();
	  					index = a.matchArray(jsonString,index);
	  		break;
			
			default :   {
							Terminal t = new Terminal();
							index = t.matchConstant(jsonString, index);
						}
			break;
		}
		
		
		return index;
	}
	
}
