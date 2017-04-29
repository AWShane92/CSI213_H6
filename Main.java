package H6;

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[]args){
	
		System.out.println("Starting program...");
		
	//Import file using scanner object. 
		String filename = "/Users/akeemshane/Documents/Documents - Akeem’s MacBook Pro/Eclipse/CSI213/src/H6/Histogram.txt";
		File inFile = new File(filename);
		BinaryTree bst = new BinaryTree();
	
	try{
			Scanner wfh = new Scanner(inFile);
			while(wfh.hasNext())
			{
				String s = wfh.next();
				bst.insert(new Node(s));		
			}
			
			wfh.close();
		}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	
	System.out.println("Finished loading words...");
	bst.printTree();
	System.out.println(" ");

	if(bst.search("that") == null){
		System.out.println("Node not found");	
		}
	else{
		System.out.println("Node found");
		}
	System.out.println(" ");
	System.out.println("DELETING MY FIRST WORD!!!!!! ");
	bst.deleteLeaf("wholly");
	bst.printTree();
	System.out.println(" ");
	System.out.println("DELETING MY SECOND WORD!!!!!! ");
	bst.remove("while");
	bst.printTree();
	}
}
