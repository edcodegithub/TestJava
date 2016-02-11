import java.io.*;
import java.util.*;

public class  FileTest {

public static void main(String args[]) {        
	 try {
	        File input = new File("C:/Users/srinath/Desktop/input.txt");
	        File output = new File("C:/Users/srinath/Desktop/output.txt");
	       // System.out.println("hello");
	        Scanner sc = new Scanner(input);
	        //PrintWriter printer = new PrintWriter(output);
	        FileWriter ff=new FileWriter(output,true); // for appending the output file
	        BufferedWriter buffer=new BufferedWriter(ff);
	        PrintWriter printer = new PrintWriter(buffer);
	        
	        
	        // Read and write operation
	        String line;
	        String[] strs;  
	        while(sc.hasNextLine()) {
	            String s = sc.nextLine();
	            line=s;
	            //printer.println();
	            //printer.write(s);	
	            //printer.println();
	            strs = line.trim().split("\\s+");
	            for(int i=0;i<strs.length;i++){
	            	System.out.println(strs[i]);
	            	printer.write(strs[i]);
	            	printer.print("\t");
	            }
	            printer.println();
	           	            
	        }
	        printer.flush();
	        printer.close();
	        ff.close();
	        sc.close();
	        
	        
	    }
	    catch(FileNotFoundException e) {
	        System.err.println("File not found. Please scan in new file.");
	    } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
}
}
