package H6;

public class BinaryTree {
	
	private Node root;
	private int edges;
	
	public void add(Node newLeaf){
		
		if(root == null){		
			root = newLeaf;
		}	
		else{
			
			Node temp = root;
			
			while(this.inTree(newLeaf)==false){
				
				if((temp.compareTo(newLeaf) > 0)&&(temp.getLeft() == null)){		
					temp.setLeft(newLeaf);
				}
				if((temp.compareTo(newLeaf) < 0)&&(temp.getRight() == null)){
					temp.setRight(newLeaf);
				}
				
				temp = nextLeaf(temp,newLeaf);
			}
			
		}
		
	}
	public void delete(Node deleteLeaf){
		
	}
	public boolean inTree(Node leaf){
		
		boolean member = false;
		Node temp = root;
		
		while(temp != null){
			
			if(temp == leaf){
				member = true;
				return member;
			}
			
		temp =	nextLeaf(temp,leaf);
					
		}
		return member;
	}
	public Node nextLeaf(Node temp, Node leaf){
		
		if(temp.compareTo(leaf) > 0){
			temp = temp.getLeft();		
		}
		if(temp.compareTo(leaf)< 0){		
			temp = temp.getRight();
		}
		return temp;
	}
	
	public void printTree(){
		
	}
	

}
