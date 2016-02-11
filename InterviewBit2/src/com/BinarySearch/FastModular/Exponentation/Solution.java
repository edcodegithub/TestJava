package com.BinarySearch.FastModular.Exponentation;

import java.math.BigInteger;
/**
 *  Fast Modular exponentation algorithm: a^b%m
 *  Note: Reaminder must be positive
 *  Edge Case: base=71045970,expo=41535484,divisor=64735492
 * @author srinath
 *
 */
public class Solution {
	static int mod(BigInteger igInteger, int m) {
	    return igInteger.mod(BigInteger.valueOf(m)).add(BigInteger.valueOf(m)).mod(BigInteger.valueOf(m)).intValue();
	}
	public static Integer pow(int x, int n, int d) {
	    if(x==0 && n==0 && d==1){
	        return 0;
	    }
	    BigInteger result = new BigInteger("1");
    while (n > 0)
    {
        if (n % 2 == 1)        	
            result =  BigInteger.valueOf(mod(  result.multiply(BigInteger.valueOf(x)),d));        
        n = n >> 1;		
        x = mod((BigInteger.valueOf(x).multiply(BigInteger.valueOf(x)) ),d);
    }
  
    return result.intValue();
	}
	public static void main(String[] args){
		System.out.println(pow(71045970,41535484,64735492));
	}

}
