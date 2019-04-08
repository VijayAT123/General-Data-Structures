
public class BSTreeLL<T extends Comparable<T>>{
	private class Node{
		private T data;
		private Node link;
		private Node leftChild;
		private Node rightChild;
		
		public Node(T aData) {
			data = aData;
			leftChild = rightChild = null;
		}
	}
	
	private Node root;
	public BSTreeLL() {
		root = null;
	}
	
	public void insert(T aData) {
		if(root == null)//empty tree
			root = new Node(aData);
		else 
			insert(root, aData);
		
	}
	
	private Node insert(Node aNode, T aData) {
		if(aNode == null)//found a leaf
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data)<0)//go left
			aNode.leftChild = insert(aNode.leftChild, aData);
		else
			aNode.rightChild = insert(aNode.rightChild, aData);
		return aNode;
	}
	
	public void delete(T aData) {
		root = delete(root, aData);
		
	}
	
	private Node delete(Node aNode, T aData) {
		if(aNode == null) //find value
			return null;
		if(aData.compareTo(aNode.data)<0)//go left
			aNode.leftChild = delete(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data)>0)//go right
			aNode.rightChild = delete(aNode.rightChild, aData);
		else{ //found value	
			if(aNode.rightChild == null) //either only left or no children
				return aNode.leftChild;
			if(aNode.leftChild == null) //only right child
				return aNode.rightChild;
			Node temp = findMinimumInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = delete(aNode.rightChild, temp.data);
		}
		return aNode;	
	}
	
	private Node findMinimumInTree(Node aNode) {
		if(aNode == null)
			return null;
		if(aNode.leftChild == null)
			return aNode;
		else
			return findMinimumInTree(aNode.leftChild);
	}
	
	public void printInOrder() {
		printInOrder(root);
	}
	
	private void printInOrder(Node aNode) {
		if(aNode == null)
			return;
		printInOrder(aNode.leftChild);
		System.out.println(aNode.data);
		printInOrder(aNode.rightChild);
		
	}
}