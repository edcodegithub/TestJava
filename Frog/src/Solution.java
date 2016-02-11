// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // count==x for a path
        Boolean[] fall=new Boolean[X];
        for(int i=0; i<X; i++){
            fall[i]=false;    
        }
        int count=0;
        int ans=-1;
        //checking the path
        for(int j=0;j<A.length;j++){
            if(fall[A[j]-1]==false){
               fall[A[j]-1]=true;
               ++count;
               if(count==X){
                    ans=j;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
    	Solution sol=new Solution();
    	int X=5;
    	int[] A={1,3,1,4,2,3,5,4};
    	System.out.println(sol.solution(X, A));
    }
}