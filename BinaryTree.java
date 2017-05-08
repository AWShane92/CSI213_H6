package H6;

import java.util.ArrayList;

import Lab10.BSTNode;

public class BinaryTree {
	
	private Node root;
	
	private int size;
	
	public Node getRoot(){
		return this.root;
	}

	//Methods used to Insert using recursion
	public void insert(Node leaf){
		
		if(this.isEmpty()){
			root = leaf;
			root.count();
			size++;
			}else{	
			Node insert = root;
			
			while(insert != null)
			{
				//Increase counter if node is data is already in tree
				if(insert.getData().equals(leaf.getData()))
				{
					insert.count();
					break;
				}
				/*Compares data in tree to new data, if new data is 
				 * lexicographically larger than current data and
				 * and if there is no new data there insert new node
				 * with that data to the right of the current data.
				 */
				else if(insert.getData().compareToIgnoreCase(leaf.getData()) <0)
				{
					if(insert.getRight() == null)
					{
						Node newNode = new Node(leaf.getData(), insert);
						insert.setRight(newNode);
						size++;
					}
					else
					{
						insert = insert.getRight();
					}
				}
				/*Compares data in tree to new data, if new data is 
				 * lexicographically larger than current data and
				 * and if there is no new data there insert new node
				 * with that data to left of the current data.
				 */
				else if(insert.getData().compareToIgnoreCase(leaf.getData()) > 0)
				{
					if(insert.getLeft() == null)
					{
						Node newNode = new Node(leaf.getData(), insert);
						insert.setLeft(newNode);
						size++;
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
		//If the tree is empty or if the data is empty then return null	
		if(this.isEmpty() || data == null){ 
			return null;
		}
		else{
			Node temp = root;
			while(temp != null){
				//Returns temp if data is found
				if(temp.getData().compareToIgnoreCase(data) == 0){
					return temp;
				}
				//Compares temp to data to determine which direction  to traverse
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
	//***This delete method uses findMinimum***
	public void deleteLeaf(String data){
		
		Node delete = this.search(data);
		
		if(delete == null){
			System.out.println("This node is not in the tree");
			return;
		}
		else
		{
			//If delete has no children then delete the node
			if(delete.getLeft() == null && delete.getRight() == null)
			{
				if(delete.getParent().getLeft() == delete)
				{
					delete.getParent().setLeft(null);
					size--;
				}
				else
				{
					delete.getParent().setRight(null);
					size--;
				}
			}
			//If delete has has a left child, delete's parent's left is now that child
			else if(delete.getLeft() != null && delete.getRight() == null)
			{
				if(delete.getParent().getLeft() == delete)
				{
					delete.getParent().setLeft(delete.getLeft());
					size--;
				}
				else
				{
					delete.getParent().setRight(delete.getLeft());
					size--;
				}
			}
			//if delete has a right child, delete's parent's left is now that child
			else if(delete.getLeft() == null && delete.getRight() != null)
			{
				if(delete.getParent().getLeft() == delete)
				{
					delete.getParent().setLeft(delete.getRight());
					size--;
				}
				else
				{
					delete.getParent().setRight(delete.getRight());
					size--;
				}
			}
			/*If delete has two children uses findMinimum to search for the 
			 * smallest data of the left sub tree of the 
			 * node that is intended to be deleted, sends the data of 
			 * the node to that minimum node and then deletes that 
			 * minimum node. 
			 */
			else
			{
				Node minimum = findMinimum(delete);
				String s = minimum.getData();
				minimum.setData(delete.getData());
				delete.setData(s);
				
				if(minimum.getParent().getLeft() == minimum)
				{
					minimum.getParent().setLeft(null);
					size--;
				}
				else
				{
					minimum.getParent().setRight(null);
					size--;
				}
			}
		}
			
	}
	//***This delete method uses find Maximum***
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
					size--;
				}
				else
				{
					delete.getParent().setRight(null);
					size--;
				}
			}
			else if(delete.getLeft() != null && delete.getRight() == null)
			{
				if(delete.getParent().getLeft() == delete)
				{
					delete.getParent().setLeft(delete.getLeft());
					size--;
				}
				else
				{
					delete.getParent().setRight(delete.getLeft());
					size--;
				}
			}
			else if(delete.getLeft() == null && delete.getRight() != null)
			{
				if(delete.getParent().getLeft() == delete)
				{
					delete.getParent().setLeft(delete.getRight());
					size--;
				}
				else
				{
					delete.getParent().setRight(delete.getRight());
					size--;
				}
			}
			else
			{
				//If delete is the root node
				if(delete==root){
					
					Node max = findMaximum(delete.getLeft());
					
						max.setRight(delete.getRight());
						root = delete.getLeft();	
						size--;
				}
				else{
				/*If delete has two children uses findMaximum to find the maximum
				 * value of delete's left sub tree, then sets delete's right subtree
				 * to the right of the max value of the left subtree, then sets
				 * deletes parents to deletes left
				 */
				Node max = findMaximum(delete.getLeft());
				
				if(delete.getParent().getLeft() == delete){
					
					max.setRight(delete.getRight());
					delete.getParent().setLeft(delete.getLeft());
					size--;
				}
				else{
					max.setRight(delete.getRight());
					delete.getParent().setRight(delete.getLeft());
					size--;
					}	
				}
			}	
		}			
	}
	public void deleteTree(){
		root = null;
	}
	//Initial method use to printTree
	public void printTree(){
		
		if(this.isEmpty()){
			System.out.println("This tree is empty");
			return;
		}
		else{
			printTree(root);
		}
	}
	//Uses recursion to print each node in the tree
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
	public int getSize(){
		return this.size;
	}
	//Uses recursion to find the minimum value of a subtree
	public Node findMinimum(Node node){
		if(node.getLeft() == null){
			return node;
		}
		else{
			return findMinimum(node.getLeft());
		}
	}
	//Uses recursion to find the maximum value of a subtree
	public Node findMaximum(Node node)	{
		if(node.getRight() == null){
			return node;
		}else{
			return findMaximum(node.getRight());
		}
	}
}
