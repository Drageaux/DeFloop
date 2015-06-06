import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * jsoup Guide:
 * 		http://jsoup.org/cookbook/extracting-data/selector-syntax
 * Referenced Dictionary:
 * 		http://dictionary.reference.com/
 * 		http://dictionary.reference.com/browse/ 
 */

/**
 * @author David Thong Nguyen (thn1069)
 *
 */
public class Start {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TranslationParser parser = new TranslationParser();
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.print("Enter word: ");
			
			if (input.hasNext()) {
				String word = input.next();
				String definition = parser.translate(word);
				
				System.out.println("--> " + definition);

				// splitting and defining each word
				int count = 0;
				
				System.out.println("Depth level to find repeated word: "
						+ count);
			}
				
			
			input.nextLine();
			
		}
	}
}

