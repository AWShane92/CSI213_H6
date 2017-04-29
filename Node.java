package H6;

public class Node {
	
	//Properties
		private String data;
		private int counter;
		private Node left;
		private Node right;
		private Node parent;
		
		//Constructors
		public Node(String data){
			
			this.data = data;
			this.left = null;
			this.right = null;
			this.parent = null;
			
		}	
		
		public Node(String data, Node parent)
		{
			this.data = data;
			this.left = null;
			this.right = null;
			this.parent = parent;
		}
		//Methods
		public String getData(){
			return this.data;
		}
		public void setData(String data){
			this.data = data;
		}
		public int getCounter(){	
			return this.counter;
		}
		public void count(){
			this.counter++;
		}
		public Node getRight(){
			return this.right;
		}
		public void setRight(Node right){
			this.right = right;
		}
		public Node getLeft(){
			return this.left;
		}
		public void setLeft(Node left){
			this.left = left;
		}
		
		public Node getParent(){
			return this.parent;
		}
		
		public void setParent(Node parent){
			this.parent = parent;
		}
		//Prints node's ID and data. 
		public void print(){
			
			System.out.println(this.data +" "+this.counter);
		}
		//Compares the data of one node to another node. 
		public int compareTo(Node node){
			if(node == null){
				return 0 ;
			}else{
				return this.data.compareToIgnoreCase(node.getData());	
			}
			
			
		}
		
}
