package com;

import java.util.Random;

public class Start {
	public static void main(String[] args) {
        Random r=new Random();
    	r.setSeed(System.nanoTime());
    	String s="00110101101110100110001100111000011101100001100101110100101001101010101010100010101010101";
    	int j;
    	
    	int count0=0;
    	int count1=0;
    	
        for(int i=0;i<100;i++) {
            j=r.nextInt(2);
        	
        	System.out.print(j);
        	
        	if(j==0) count0++;
        	else count1++;
        }
        
        System.out.println();
        System.out.println("==============");
        System.out.println("0's:"+count0+", 1's:"+count1);
        System.out.println("==============");
        System.out.println(s);
	}
}
