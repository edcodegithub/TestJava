package siri2;
import siri1.SriClass;
public class RamClass extends SriClass  {
	//RamClass s1= new RamClass(); //I get java.lang.StackOverflowError
	/**
	 * protected method's of a class of other packages can only be accessed
	 *  in a subclass not anywhere
	 */
	void abc(){
		// I wrote here to solve the error
		RamClass s1= new RamClass();
		//s1.print1(); //Default class can't be accessed even under a sub-class
        s1.print();
	}
    protected void print21(){
	   System.out.println("It is only Sriram");
   }
    
}
