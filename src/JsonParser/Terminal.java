package JsonParser;

/* 
 * AlphaNum 	-> <String>
 * Constant		-> true / false / null / <Number>	
 * 
 */

import java.util.ArrayList;

class Terminal {

	int matchAlphaNum(ArrayList<Character> jsonString, int index) throws ParserException
	{
		while(jsonString.get(index) != '"')
		{
			if(jsonString.get(index) == '\\') 
				index++;
			index++;
			if(index>=jsonString.size())
				throw new ParserException("Missing closing \" for some key or value ");
		}
		
		index++;
		
		return index;
	}

	int matchConstant(ArrayList<Character> jsonString, int index) throws ParserException
	{
		switch(jsonString.get(index))
		{
			case 't' :  if(jsonString.get(index+1)!='r' || 
					       jsonString.get(index+2)!='u' || 
					       jsonString.get(index+3)!='e' )
						throw new ParserException("Expecting 'STRING', 'NUMBER', 'null', 'true', 'false', '{', '[', got 'undefined'");
						index+=4;
			break;

			case 'f' :  if(jsonString.get(index+1)!='a' || 
					       jsonString.get(index+2)!='l' || 
					       jsonString.get(index+3)!='s' || 
					       jsonString.get(index+4)!='e' )
						throw new ParserException("Expecting 'STRING', 'NUMBER', 'null', 'true', 'false', '{', '[', got 'undefined'");
						index+=5;
			break;
			

			case 'n' :  if(jsonString.get(index+1)!='u' || 
					       jsonString.get(index+2)!='l' || 
					       jsonString.get(index+3)!='l' )
						throw new ParserException("Expecting 'STRING', 'NUMBER', 'null', 'true', 'false', '{', '[', got 'undefined'");
						index+=4;
			break;

			case '-':	index++;

			case '0': 	index++;
						if(Character.isDigit(jsonString.get(index)))
							throw new ParserException("Expecting 'STRING', 'NUMBER', 'null', 'true', 'false', '{', '[', got 'undefined'");
						if(jsonString.get(index)=='.')
						do
						{
							index++;
						}while(Character.isDigit(jsonString.get(index)));
						break;
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9': 	int count_dot=0;
						while(Character.isDigit(jsonString.get(index)) || (jsonString.get(index)=='.' && count_dot<1) )
						{
							if(jsonString.get(index)=='.')
								{
									count_dot++;
								}
							index++;
						}
			break;
			default : throw new ParserException("Expecting 'STRING', 'NUMBER', 'null', 'true', 'false', '{', '[', got 'undefined'");
			
		}
		
		
		return index;
	}
	
}
