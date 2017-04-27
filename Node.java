package H6;

public class Node {
	
	//Properties
		private String data;
		private int counter;
		private Node left;
		private Node right;
		
		//Constructors
		public Node(String data){
			
			this.data = data;
			this.left = null;
			this.right = null;
			this.counter = 1;
			
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
		public void setCounter(int counter){
			this.counter = counter;
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
		//Prints node's ID and data. 
		public void print(){
			
			System.out.println("This data is: "+ this.data);
		}
		//Compares the data of one node to another node. 
		public int compareTo(Node node){
			
			return this.data.compareTo(node.getData());
		}
		
		public boolean isLeaf(){
			
			return (this.right != null) || (this.left != null);
		}
		

}
