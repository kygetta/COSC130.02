
//Creator: Kylie Hall
		//Date: 11/8
		
		/*
		
		MY TREE IS BELOW
		
				1
			  /    \
			 2	    7
			/ \    / \
		   3   4  8   9
		  / \        /  \
		 5   6      10  11
		
		output: 5 3 6 2 4 1 8 7 10 9 11
		*/
public class Post {
	public static <T> void InOrderTree(Node<T> node) {
		if(node == null) {//base case
			return;
		}
	
		
		
		//commands below will sort through the tree traversal.
		//1. Call left subtree
		//2. Visit root
		//3. Visit right subtree
		InOrderTree(node.left);
		InOrderTree(node.right);
		System.out.println(node.data + " ");//calls for root node
		
		
	}
	
		public static void main(String[] args) {
		
		//Below each node is created
		Node<Integer> a = new Node<Integer>(1);
		Node<Integer> b = new Node<Integer>(2);
		Node<Integer> c = new Node<Integer>(3);
		Node<Integer> d = new Node<Integer>(5);
		Node<Integer> e = new Node<Integer>(6);
		Node<Integer> f = new Node<Integer>(4);
		Node<Integer> g = new Node<Integer>(7);
		Node<Integer> h = new Node<Integer>(8);
		Node<Integer> i = new Node<Integer>(9);
		Node<Integer> j = new Node<Integer>(10);
		Node<Integer> k = new Node<Integer>(11);
		
		//This will create or build the tree of nodes.
		Node<Integer> build = a; 
		a = a;
		a.left = b; a.left.left = c; a.left.left.left = d; a.left.left.right = e;
		a.left.right = f; a.right = g;
		a.right.right = i; a.right.right.right = k;
		a.right.left = h;
		a.right.right.left = j;
		
	InOrderTree(build);//calls for method that will sort through the tree.
	}

	
		

}