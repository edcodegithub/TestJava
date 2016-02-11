import java.io.*;
import java.util.*;

public  class Solution {
    public static int isPalindrome(String p){
        int i=0;
        int j=p.length()-1;
        while(i<=j){
            if(p.charAt(i)!=p.charAt(j)){
                if((p.charAt(i+1)==p.charAt(j))&&(p.charAt(i+2)==p.charAt(j-1))){
                    return i;
                }else if((p.charAt(i)==p.charAt(j-1))&&(p.charAt(i+1)==p.charAt(j-2))){
                    return j;
                }else{
                    return i;
                }
            }
            i++;
            j--;
        }
        return -1;
        
    }

    public static  void main(String[] args) {
    	
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        sc.nextLine();
        for(int b=0;b<a;b++){
            String st=sc.nextLine();
            System.out.println(Solution.isPalindrome(st));
        }
    }
}