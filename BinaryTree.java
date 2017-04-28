package H6;

import Lab10.BSTNode;

public class BinaryTree {
	
	private Node root;
	private int edges;
	
	public Node getRoot(){
		return this.root;
	}

	//Methods used to Insert using recursion
	public void insert(Node leaf){
		if(this.isEmpty()){
			root = leaf;
			root.setCounter();
		}else{	
		insert(root,leaf);
		}
	}
	public void insert(Node tree, Node leaf){

    	if(tree.compareTo(leaf) > 0){
    		if(tree.getLeft() == null){
    			tree.setLeft(leaf);
    		}
    		insert(tree.getLeft(),leaf);
    	}
    	 if(tree.compareTo(leaf) < 0){
    		 if(tree.getRight() == null){
    			 tree.setRight(leaf);
    		 }
    		insert(tree.getRight(),leaf);
    	}
    	 if(tree.compareTo(leaf)==0){
    		 tree.setCounter();
    	 }
	}
	public Node search(String data){
			
		if(this.isEmpty()){ 
			return null;
		}
		else{
			Node temp = root;
			while(temp != null){
			
				if(temp.getData().compareToIgnoreCase(data) == 0){
					return temp;
				}
				else if(temp.getData().compareToIgnoreCase(data) > 0){
					temp = temp.getLeft();
				}
				else{
					temp = temp.getRight();
				}
			}
			return temp;
		}
	}
	public void deleteLeaf(Node deleteLeaf){
		
	}
	public void deleteTree(){
		root = null;
	}

	public void printTree(){
		
		if(this.isEmpty()){
			System.out.println("This tree is empty");
		}
		else{
			printTree(root);
		}
	}
	
	public void printTree(Node tree){
		
		if(tree != null){
			printTree(tree.getLeft());
			tree.print();
			printTree(tree.getRight());
		}	
	}
	
	public boolean isEmpty(){
		
		return root == null;
	}
}
