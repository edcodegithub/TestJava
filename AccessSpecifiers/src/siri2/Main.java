package siri2;
import siri1.SrideviClass;
public class Main  {
public static void main(String[] args){
	RamClass s= new RamClass();	
	s.abc();// to access the print method of Sri Class
	s.print21(); // printing Ram method as long as it is public/protected
	
	
	/**
	 * 
	 */
	SrideviClass er= new SrideviClass();
	er.print21(); //print21 is accessed because it can be found in exisiting package
	er.print12(); // as print12 is public it can be accessed
}
}
