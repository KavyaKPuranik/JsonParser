This is a JsonValidator, implemented using Java.

The JSON files need to follow specific grammar/syntax. 
The code does the validation of the same.

To start with the program, you need to place your JSON file under the folder src/SampleFiles with the name "Test.json".

Then open the package, src/JsonParser and compile all the class files together. 
Then run the run the Parser class.

Working of the program:

To parse the JSON, the Program uses the following grammar:
/*
 * Start 	-> { Element }
			-> { }	
 * Element 	-> " AlphaNum " : Value
 			-> " AlphaNum " : Value , Element
 * Array 	-> Value
 			-> Value (, Value)*
  			-> e
 * Value 	-> " AlphaNum "
 			-> { Element }
 			-> [ Array ]
 			-> Constant 
 * AlphaNum -> <String>
 * Constant	-> true / false / null / <Number>	
 */

The program starts with the Parser class. 

Description of each of the classes is as follows:
Parser:	main		 -> Reads JSON string from file and calls start method for validation.

ParserException:	 -> At any point of time in the program, if the JSON is invalid, a new object of this class is thrown along with an appropriate erroer message.

Start:	matchStart	 -> Returns index (int)
			 -> Accepts Parameters jsonString and index
			 -> Validates the start and calls appropriate methods.

Element:matchElement	 -> Returns index (int)
			 -> Accepts Parameters jsonString and index
			 -> Validates the element and calls appropriate methods.

Array:	matchArray	 -> Returns index (int)
			 -> Accepts Parameters jsonString and index
			 -> Validates the Array and calls appropriate methods.

Value:	matchValue	 -> Returns index (int)
			 -> Accepts Parameters jsonString and index
			 -> Validates the Value and calls appropriate methods.

Terminal:matchAlphaNum	 -> Returns index (int)
			 -> Accepts Parameters jsonString and index
			 -> Validates the both Terminal conditions that are key as well as value (any string) and calls appropriate methods.

Terminal:matchConstant	 -> Returns index (int)
			 -> Accepts Parameters jsonString and index
			 -> Validates the remaining terminals that are null,true,false and numbers and then calls appropriate methods.

