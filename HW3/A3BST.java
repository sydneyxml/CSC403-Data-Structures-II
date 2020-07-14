package assignment3;
import algs4.*;

/*
 * <Ximan Liu>
 * <A3BST>
 */

/*
 * This is a simplified version of the BST class
 * from the algs4 package.  
 * 
 */

public class A3BST<K extends Comparable<? super K>, V> {
	private Node<K,V> root;             // root of BST

	private static class Node<K extends Comparable<? super K>,V> {
		public K key;       			// sorted by key
		public V val;             		// associated data
		public Node<K,V> left, right;  	// left and right subtrees

		public Node(K key, V val) {
			this.key = key;
			this.val = val;
		}
	}
	
	public A3BST() {}
	
	// countTwins
	public int countTwins() {
		
		if(root == null) return 0;
		
		A3BST<K, V> leftSubTree = new A3BST<>();
        A3BST<K, V> rightSubTree = new A3BST<>();
        
        leftSubTree.root = root.left;
        rightSubTree.root = root.right;
  
	    if(root.left != null && root.right != null)
	        return 1 + leftSubTree.countTwins() + rightSubTree.countTwins();
	    else
	    	return leftSubTree.countTwins() + rightSubTree.countTwins();
	}
	
	// lessThanValueCount
	 public int lessThanValueCount(V val) {
		 
		 if (root == null) return 0;
		 
		 A3BST<K, V> leftSubTree = new A3BST<>();
	     A3BST<K, V> rightSubTree = new A3BST<>();
	     
	     leftSubTree.root = root.left;
	     rightSubTree.root = root.right;
	     
	     int count = leftSubTree.lessThanValueCount(val) + rightSubTree.lessThanValueCount(val);
	     
	     if ((int)(root.val) < (int)(val)) {
	    	 count++;
	     }
	     return count;
	 }
	

	/* *********************************************************************
	 *  Search BST for given key, and return associated value if found,
	 *  return null if not found
	 ***********************************************************************/
	// does there exist a key-value pair with given key?
	public boolean contains(K key) {
		return get(key) != null;
	}

	// return value associated with the given key, or null if no such key exists
	public V get(K key) { return get(root, key); }
	private V get(Node<K,V> x, K key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return x.val;
	}

	/* *********************************************************************
	 *  Insert key-value pair into BST
	 *  If key already exists, update with new value
	 ***********************************************************************/
	public void put(K key, V val) {
		if (val == null) { delete(key); return; }
		root = put(root, key, val);
	}

	private Node<K,V> put(Node<K,V> x, K key, V val) {
		if (x == null) return new Node<>(key, val);
		int cmp = key.compareTo(x.key);
		if      (cmp < 0)
			x.left  = put(x.left,  key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val   = val;
		return x;
	}

	/* *********************************************************************
	 *  Delete
	 ***********************************************************************/

	public void delete(K key) {
		root = delete(root, key);
	}
	
	private Node<K,V> delete(Node<K,V> x, K key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = delete(x.left,  key);
		else if (cmp > 0) x.right = delete(x.right, key);
		else {
			// x is the node to be deleted.  
			// The value returned in each of these cases below
			// becomes the value of the child reference from
			// the parent of x.  Returning a null makes that
			// reference a null and so cuts x off, causing its
			// automatic deletion.
			
			// Determine how many children x has.
			if (x.right == null && x.left == null){
				// This is a leaf node.
				return null;
			} else if (x.right == null) {
				// One child, to the left.
				return x.left;
			} else if (x.left == null) {
				// One child, to the right.
				return x.right;
			} else {
				// Node x has two children.
				// Find the node in x's right subtree with
				// the minimum key.
				Node<K,V> rightTreeMinNode = findMin(x.right);
				x.key = rightTreeMinNode.key;
				x.val = rightTreeMinNode.val;
				x.right = delete(x.right, rightTreeMinNode.key);
			}
		}
		return x;
	}
	
	private Node<K,V> findMin(Node<K,V> x) {
		if (x.left == null) return x;
		else return findMin(x.left);
	}

	public void printKeys() {
		printKeys(root);
	}
	
	private void printKeys(Node<K,V> x) {
		if (x == null) return;
		printKeys(x.left);
		StdOut.println(x.key);
		printKeys(x.right);
	}
	
	public Iterable<K> keys() {
		Queue<K> q = new Queue<>();
		inOrder(root, q);
		return q;
	}

	private void inOrder(Node<K,V> x, Queue<K> q) {
		if (x == null) return;
		inOrder(x.left, q);
		q.enqueue(x.key);
		inOrder(x.right, q);
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node<K,V> x) {
		if (x == null) return -1;
		return 1+Math.max(height(x.left), height(x.right));
	}

	/* ***************************************************************************
	 *  Visualization
	 *****************************************************************************/

	public void drawTree() {
		if (root != null) {
			StdDraw.setPenColor (StdDraw.BLACK);
			StdDraw.setCanvasSize(1200,700);
			drawTree(root, .5, 1, .25, 0);
		}
	}
	private void drawTree (Node<K,V> n, double x, double y, double range, int depth) {
		int CUTOFF = 10;
		StdDraw.text (x, y, n.key.toString ());
		StdDraw.setPenRadius (.007);
		if (n.left != null && depth != CUTOFF) {
			StdDraw.line (x-range, y-.08, x-.01, y-.01);
			drawTree (n.left, x-range, y-.1, range*.5, depth+1);
		}
		if (n.right != null && depth != CUTOFF) {
			StdDraw.line (x+range, y-.08, x+.01, y-.01);
			drawTree (n.right, x+range, y-.1, range*.5, depth+1);
		}
	}
}
