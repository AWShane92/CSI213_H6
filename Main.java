package H6;

import java.util.*;
import java.io.*;

public class Main {

	private static int wordCount;
	private static Node [] leaves = new Node[15];
	
	public static void main(String[]args){
	
	//Import file using scanner object. 
	Scanner wordFrequencyHistogram = null;
	int i = 0;
	
	try{
		wordFrequencyHistogram = new Scanner(new File("/Users/akeemshane/Documents/Documents - Akeem’s MacBook Pro/Eclipse/CSI213/src/H6/Histogram.txt"));
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	while(wordFrequencyHistogram.hasNextLine()){
		Scanner wfh = new Scanner(wordFrequencyHistogram.nextLine());
		while(wfh.hasNext()){
			String s = wfh.next();	
			Node leaf = new Node(s);
			leaves[i] = leaf;
			i++;
			
		}
	}
	System.out.println(wordCount);
	System.out.println(" ");
	
	for(i = 0; i < leaves.length; i++){
		System.out.println(leaves[i].getData());
		
	}
	
	
	
	
	
	}
}
