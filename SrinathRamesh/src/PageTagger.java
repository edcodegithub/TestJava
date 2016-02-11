import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.apache.commons.lang3.StringEscapeUtils;
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
		MaxentTagger tagger = new MaxentTagger("Taggers/english-left3words-distsim.tagger");		 
		StringBuilder cc=new StringBuilder();
		// Cleaning the string by removing more than one white space
		s=s.replaceAll("\\s+", " ").trim();
		/**
		 * Factored parsing of sentences up to 200 words requires around 3GB of memory.
		 * If string input length is more than 200, we break it into substring where
		 * we can find the last word within 200 character limit. Then I apply tagString() method.
		 * After performed I append the String Builder.
		 *    I am doing it to avoid memory leak.
		 *    
		 *    Reference: "To be able to handle longer sentences, you need more (to parse sentences 
		 *    up to 100 words, you need 400 MB). For running the Factored Parser, 600 MB is needed 
		 *    for dealing with sentences up to 40 words. Factored parsing of sentences up to "200" 
		 *    words requires around 3GB of memory."
		 *    Website:
		 *    http://nlp.stanford.edu/nlp/javadoc/javanlp/edu/stanford/nlp/parser/lexparser/package-summary.html
		 *    http://nlp.stanford.edu/software/parser-faq.shtml
		 *    
		 */
		if(s.length()<=200){
			String sample = s;//"This is a sample text";
			String tagged = tagger.tagString(sample);
			System.out.println("tag text method ended");
			return tagged;
			
		}else{			
			
			int fixed=200;
			int firstIndex=0;
			int lastIndex=0;
			while((firstIndex<s.length())){
				lastIndex=s.lastIndexOf(" ", firstIndex+fixed-1);
				if((lastIndex>s.length())){
					break;
				}
				if(lastIndex==-1){
					lastIndex=firstIndex+fixed;
				}
				if(lastIndex<firstIndex){
					break;
				}
				String tagged = tagger.tagString(s.substring(firstIndex, lastIndex))+" ";
				cc.append(tagged);
				firstIndex=lastIndex+1;
								
			}
			return cc.toString();
		}		
	}
	/**
	 * 
	 * @param URL Link
	 * @return String
	 * @throws IOException
	 * 
	 * Explanation: I also had a memory leak while reading. I was using the
	 * scanner class to read each line. But the scanner class has a limit of 2048
	 * bytes to read from a single line.
	 * I initially used jsoup with this method Link.toExternalForm()).get().text();
	 * but this method failed for case-3( large data set). I was unable to take all the number.
	 * So I make the below correction. Also in buffered reader,default size is 2048 bytes, after
	 * that, We need to mention the specific size which we are not aware. 
	 * 
	 */
	public static String getText(URL Link) throws IOException {
		
		 URLConnection uc = Link.openConnection();
		 InputStream input = uc.getInputStream();		 	 
		 StringBuilder st = new StringBuilder();
		 byte[] b = new byte[2048]; // the max limit.
		 int read;	// total bytes read
		 /**
		  * public int read(byte[] b,int off,int len)
		  * returns the total number of bytes read into the buffer, or -1 
		  * if there is no more data because the end of the stream has been reached.
		  */
		 while ((read = input.read(b, 0, 2048)) != -1) {
			 st.append(new String(b, 0, read));		      
		    }		 	
		    input.close();
		    // Removing the head lines and script lines completely.
		    String ans=st.toString().replaceAll("(?is)<head.*?/head>"," ");
		    ans=ans.replaceAll("(?is)<script.*?/script>", " ");
		    ans=StringEscapeUtils.unescapeHtml4(ans); // to html elements such as &nbsp, &amp, etc
		    return ans.replaceAll("\\<.*?>"," ");	// remving other remaining tags if any.	    
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		System.out.println("Please enter the currect url");
		Scanner sc=new Scanner(System.in);
		String ip=sc.nextLine();
		URL url=new URL(ip); //http://gumgum-public.s3.amazonaws.com/numbers.html
		String st=getText(url);		
		String str=tagText(st);		
		PrintWriter out = new PrintWriter(new FileWriter("Output.txt"));
		out.println(str);
		out.close();		
		
	}
}
