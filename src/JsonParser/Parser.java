package JsonParser;

/*
 * Start 	-> { Element }
 * 			-> { }	
 * 
 * Element 	-> " AlphaNum " : Value
 * 			-> " AlphaNum " : Value , Element
 * 
 * Array 	-> Value
 * 			-> Value (, Value)*
 * 			-> e
 * 
 * Value 	-> " AlphaNum "
 * 			-> { Element }
 * 			-> [ Array ]
 * 			-> Constant 
 * 
 *
 * AlphaNum -> <String>
 * 
 * Constant	-> true / false / null / <Number>	
 * 
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

	   public static void main(String args[])throws IOException 
	   {
		      FileReader fr = new FileReader("src/SampleFiles/Test.json"); 
		      int read_val;
		      char c;
		      /*String st = "ab   c";
		      for(int i = 0; i<st.length();i++)
		      {
			      if(!Character.isWhitespace(st.charAt(i)))
			       System.out.println(st.charAt(i));
		      }*/
		      ArrayList<Character> jsonString = new ArrayList<>();
		      
		      while((read_val=fr.read())!=-1)   // reads the content to the array
		      {
		    	  c = (char)read_val;
			      if(!Character.isWhitespace(c))
			      {
			    	  jsonString.add(c);
		    	  }
		      }
		      fr.close();
		       System.out.println(jsonString); 
		      try
		      {
			      Start s = new Start();
		    	  int index = s.matchStart(jsonString,0);
		    	  if(index!=jsonString.size()) 
		    		  throw new ParserException("File contains extra values");
				  System.out.print("Valid Json :)"); 
				  
		      }
		      catch(ParserException pe) {
		    	  System.out.println("Json Invalid");
		      }
		      catch(IndexOutOfBoundsException iobe) 
		      {
		    	  System.out.println("Json Invalid");
		      }
		         
	}
	
}
