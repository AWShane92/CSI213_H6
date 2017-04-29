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
			root.count();
			}else{	
			Node insert = root;
			
			while(insert != null)
			{
				if(insert.getData().equals(leaf.getData()))
				{
					insert.count();
					break;
				}
				
				else if(insert.getData().compareToIgnoreCase(leaf.getData()) <0)
				{
					if(insert.getRight() == null)
					{
						Node newNode = new Node(leaf.getData(), insert);
						insert.setRight(newNode);
					}
					else
					{
						insert = insert.getRight();
					}
				}
				
				else if(insert.getData().compareToIgnoreCase(leaf.getData()) > 0)
				{
					if(insert.getLeft() == null)
					{
						Node newNode = new Node(leaf.getData(), insert);
						insert.setLeft(newNode);
					}
					else
					{
						insert = insert.getLeft();
					}
				}
			}
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
	public void deleteLeaf(String data){
		
		Node delete = this.search(data);
		
		if(delete == null){
			System.out.println("This node is not in the tree");
			return;
		}
		else
		{
			if(delete.getLeft() == null && delete.getRight() == null)
			{
				if(delete.getParent().getLeft() == delete)
				{
					delete.getParent().setLeft(null);
				}
				else
				{
					delete.getParent().setRight(null);
				}
			}
			else if(delete.getLeft() != null && delete.getRight() == null)
			{
				if(delete.getParent().getLeft() == delete)
				{
					delete.getParent().setLeft(delete.getLeft());
				}
				else
				{
					delete.getParent().setRight(delete.getLeft());
				}
			}
			else if(delete.getLeft() == null && delete.getRight() != null)
			{
				if(delete.getParent().getLeft() == delete)
				{
					delete.getParent().setLeft(delete.getRight());
				}
				else
				{
					delete.getParent().setRight(delete.getRight());
				}
			}
			else
			{
				Node minimum = findMinimum(delete);
				String s = minimum.getData();
				minimum.setData(delete.getData());
				delete.setData(s);
				
				if(minimum.getParent().getLeft() == minimum)
				{
					minimum.getParent().setLeft(null);
				}
				else
				{
					minimum.getParent().setRight(null);
				}
			}
		}
			
	}
	public void remove(String data){
		
		Node delete = this.search(data);
		
		if(delete == null){
			System.out.println("This node is not in the tree");
			return;
		}
		else
		{
			if(delete.getLeft() == null && delete.getRight() == null)
			{
				if(delete.getParent().getLeft() == delete)
				{
					delete.getParent().setLeft(null);
				}
				else
				{
					delete.getParent().setRight(null);
				}
			}
			else if(delete.getLeft() != null && delete.getRight() == null)
			{
				if(delete.getParent().getLeft() == delete)
				{
					delete.getParent().setLeft(delete.getLeft());
				}
				else
				{
					delete.getParent().setRight(delete.getLeft());
				}
			}
			else if(delete.getLeft() == null && delete.getRight() != null)
			{
				if(delete.getParent().getLeft() == delete)
				{
					delete.getParent().setLeft(delete.getRight());
				}
				else
				{
					delete.getParent().setRight(delete.getRight());
				}
			}
			else
			{
				Node max = findMaximum(delete.getLeft());
				
				if(delete.getParent().getLeft() == delete){
					
					max.setRight(delete.getRight());
					delete.getParent().setLeft(delete.getLeft());	
				}
				else{
					max.setRight(delete.getRight());
					delete.getParent().setRight(delete.getLeft());
				}	
			}
		}			
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
	
	public Node findMinimum(Node node){
		if(node.getLeft() == null){
			return node;
		}
		else{
			return findMinimum(node.getLeft());
		}
	}
	public Node findMaximum(Node node)	{
		if(node.getRight() == null){
			return node;
		}else{
			return findMaximum(node.getRight());
		}
	}
	public Node findParent(Node temp)
	{
		Node parent = null;
		Node search = root;
		
		if(temp == root)
		{
			System.out.println("I'm trying to find the root. NO.");
		}
		while(search != null)
		{
			if(temp.getData().compareToIgnoreCase(search.getData()) < 0)
			{
				if(search.getLeft().getData().equals(temp.getData()))
				{
					parent = search;
				}
				else
				{
					search = search.getLeft();
				}
			}
			else if(temp.getData().compareToIgnoreCase(search.getData()) > 0)
			{
				if(search.getRight().getData().equals(temp.getData()))
				{
					parent = search;
				}
				else
				{
					search = search.getRight();
				}
			}
		}
		
		return parent;
	}
}
