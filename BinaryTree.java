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
			boolean isLeaf = false;
			
			while(temp != null){
				
				
			
				if((temp.compareTo(newLeaf) > 0)&&(temp.getLeft() == null)){		
					temp.setLeft(newLeaf);
					isLeaf = true;
				}
				else if((temp.compareTo(newLeaf) < 0)&&(temp.getRight() == null)){
					temp.setRight(newLeaf);
					isLeaf = true;
				}
				else {
					temp.setCounter(temp.getCounter() + 1);
					isLeaf = true;
				}
				
				temp = nextLeaf(temp,newLeaf);
			}
			
		}	
			
	}
	public Node nextLeaf(Node temp, Node leaf){
		
		if(temp == null){
			return temp;
		}	
		else if(temp.compareTo(leaf) < 0){
			temp = temp.getLeft();		
		}
		else if(temp.compareTo(leaf) > 0){		
			temp = temp.getRight();
		}
		return temp;
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
	
	public void printTree(){
		
	}
	

}
