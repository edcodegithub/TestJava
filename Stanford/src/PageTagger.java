import java.io.IOException;
import java.net.URL;
import org.jsoup.Jsoup;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;




public class PageTagger {
	/**
	 * Takes a String as input and returns the tagged text, another String, as output. 
	 * Internally the method should use thetagString method of MaxentTagger to tag the String.
	 * @param s
	 * @return tagged String
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static String tagText (String s) throws ClassNotFoundException, IOException{	
		System.out.println("tag text method started");
		MaxentTagger tagger = new MaxentTagger("Taggers/left3words-wsj-0-18.tagger");
		String sample = s;//"This is a sample text";
		String tagged = tagger.tagString(sample);
		System.out.println("tag text method ended");
		return tagged;
	}
	public static String getText(URL Link) throws IOException {
		System.out.println("get text method started");
		return Jsoup.connect(Link.toExternalForm()).get().text();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		//String ss="A passenger plane has crashed shortly after take-off from Kyrgyzstan's capital, Bishkek, killing a large number of those on board. The head of Kyrgyzstan's civil aviation authority said that out of about 90 passengers and crew, only about 20 people have survived. The Itek Air Boeing 737 took off bound for Mashhad, in north-eastern Iran, but turned round some 10 minutes later.";
		URL url=new URL("http://www.windingroad.com/articles/reviews/quick-drive-2012-bmw-z4-sdrive28i/");
		String st=getText(url);
		System.out.println("get text method ended");
		String str=tagText(st);
		System.out.println("tag text method ended");
		System.out.println(str);
	}
}
