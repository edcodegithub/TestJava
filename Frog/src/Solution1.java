// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution1 {
    public int solution1(int[] A, int X, int D) {
    	
    	int x=-1; // coordinate
        int z=-1; //time vaiable
        
        if(x+D>=X-1){
        	z=0;
        	return z;
        } 
        
        // Memmory variable. Initialize visted=false
        Boolean[] mem=new Boolean[X];
        for(int i=0;i<X;i++){
        	mem[i]=false;
        }
        // traversing with time in Array A
        for(int j=0;j<A.length;j++){
        	//updating mem and x
        	if(mem[A[j]-1]==false){
        		mem[A[j]-1]=true;
        		if(x+D>=A[j]-1 && x<A[j]-1){
        			x=A[j]-1;
        		}
        	}
        	//cheaking jump
        	int y;
        	if(x+D<=X-1){
        	 y=x+D;
        	}else{
        		y=X-1;
        	}
        	int k=y;
        	while(k>x){
        		if(mem[k]==true){
        			x=k;
        			if(x+D>=X-1 ){ //&& mem[X-1]==true
                		z=j;
                		return z;
                	} else{
                		k=x+D;
                	}       			
        		}else{
        			if(x+D>=X-1 ){//&& mem[X-1]==true
                		z=j;
                		return z;
                	}
            		k--;
            	}
        	}
        	
        }
            
        
        
        
		return z;            
        }
        
    
    
    public static void main(String[] args){
    	Solution1 sol1=new Solution1();
    	int X=7;//20;//7;//14;
    	int[] A={2,3,4,5,6,1};//{2,4,6,15,17,3,1,9,10,8,7,5,4,3,14,12,20,19,18};////{2,12,10,8,6,4};
    	//{4,1,3,2,1,5};
    	//{9,7,6,4,2,8,2,9};
    	int D=2;//2;//3;
    	System.out.println(sol1.solution1(A, X,D));
    }
}
