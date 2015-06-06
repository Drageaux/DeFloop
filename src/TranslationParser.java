import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 
 */

/**
 * @author David Thong Nguyen (thn1069)
 *
 */
public class TranslationParser {
	
	/**
	 * Translate the word passed in and return a String definition
	 * 
	 * @param 		word (String) - word to be translated
	 * @return 		String definition
	 */
	public String translate(String word){
		String result = "";
		System.out.println("...translating \"" + word + "\"...");
		
		// get definition text from online dictionary
		Document doc = null;
		try {
			doc = Jsoup.connect(""
					+ "http://dictionary.reference.com/browse/" + word).get();
			Element definition = doc.select("div.def-content").first();
			String strDef = definition.text();
			
			// minor string formatting
			result = strDef.substring(0, strDef.length()-1);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		return result; 
	}
	
	
	public int loop(int count, String word, String definition) {
		int result = count;
		
		String[] splitDef; 
		splitDef = definition.split(" ");
		
		// start looping
	    String destinationWord = "";
	    while (!destinationWord.equals(word)) {
	    	
	    	for (int i = 0; i < splitDef.length; i++) {
	    		splitDef[i] = splitDef[i].replaceAll("[^\\w]", "");
	    		
	    		destinationWord = splitDef[i];
	    		if (destinationWord.equals(word)) {
	    			break;
	    		}
	    		
	    		String lowerDef = this.translate(splitDef[i]);
	    		result += this.loop(result, word, lowerDef);
		    }
		}
		
		result += 1;
		return result;
	}
}
