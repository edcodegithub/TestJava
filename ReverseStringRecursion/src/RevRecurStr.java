import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class RevRecurStr {
	
	public static String reverse(String str){
		if(str==null||str.length()==1){
			return str;
		}
		return reverse(str.substring(1)+str.charAt(0));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		InputStreamReader input=new InputStreamReader(System.in);
		 StringBuilder st = new StringBuilder();
		 char[] b = new char[2048]; // the max limit.
		 int read;
		 while( ((read = input.read(b, 0, 2048)) != -1)&&read!='\n') {
			 st.append(new String(b, 0, read));		      
		    }		 	
		    input.close();
		    System.out.println(st.toString());

	}

}
