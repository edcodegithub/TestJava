import java.util.Arrays;
import java.util.HashMap;


public class Solution {
   
	
	    public static long factorial(long number) {
	      if (number <= 1)
	         return 1;
	         long temp=1;
	      while(number>1){
	          temp=(temp*number)%1000003;
	          number=number-1;
	      } 
	      
	      
	      return temp;
	   }
	    public static long   inverseNumber(int deno) {
            
            long ans = 1, base = ( long) deno%1000003;
            long mod= 1000003;
            int power = (int) (mod - 2);
            while (power > 0) {
                if (power == 1) {
                    return (ans * base) % mod;
                }
                if (power % 2 == 0) {
                    base = (base * base) % mod;
                    power /= 2;
                } else {
                    ans = (ans * base) % mod;
                    power--;
                }
            }
            return ans;
        }
	   public static int findIndex(StringBuilder a, char b){ 
		   int state=-1;
	       for(int i=0;i< a.length();i++){
	           if(a.charAt(i)==b){
	              return i;
	           }
	       }
	       return state;
	   }
		public int findRank(String a) {
		    char[] bSort=new char[a.length()];
		    HashMap<String,Integer> hh=new HashMap<>();
		    for(int i=0;i<a.length();i++){
		        bSort[i]=a.charAt(i);
		        if(hh.containsKey(a.charAt(i)+"")){
		        	Integer cc=hh.get(a.charAt(i)+"");
		        	hh.put(a.charAt(i)+"", cc+1);
		        }else{
		        	hh.put(a.charAt(i)+"", new Integer(1));
		        }
		        
		    }
		    Arrays.sort(bSort);
		    
		    StringBuilder sb=new StringBuilder();
		    for(char c:bSort){
		    	sb.append(c);
		    }
		    long ans=1;
		    int count=0;	    
		    for(int i=0;i<a.length();i++){
		        ++count;
		    	int rank=findIndex(sb,a.charAt(i));			     
			   //System.out.println(deno);			 
			   long ret=factorial(a.length()-count);
			   ret=ret%1000003;
			   int deno=1;
			   for (String key : hh.keySet()) {	        	
				      deno=(int) ((deno*(factorial(hh.get(key))))%1000003);		            
				}
			    
			   ans=  (ans+(rank*ret*inverseNumber((deno))))%1000003;
		    	sb.deleteCharAt(rank);
		    	Integer cd=hh.get(a.charAt(i)+"");
		    	cd--;
		    	if(cd==0){
		    		hh.remove(a.charAt(i)+"");
		    	}else{
		    		hh.put(a.charAt(i)+"", cd);
		    	}
		        
		       
		    }
		  
		    return (int)ans;
		}
	
	public static void main(String[] args){
		Solution ss=new Solution();
		System.out.println(ss.findRank("asasdsdsadasdadsadasdsa"));//asasdsdsadasdadsadasdsa
		
		
		
		}
	}
