import java.util.*;

class BST 
{
	Node root=null;

	//Structure of node.
	class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data=data;
			left=null;
			right=null;
		}
	}

	/*
	Initial Struture of BST
				50
			   /  \
			  25   60
		     /    /  \
		    20   55  70
		    	/  \
		       52  57
	*/

	BST(){
		add(50);
		add(25);
		add(20);
		add(60);
		add(55);
		add(57);
		add(52);
		add(70);
	}

	//Add element in root.
	public void add(int data){
		Node newNode=new Node(data);
		if(root==null){
			root=newNode;
		}
		else{
			Node curr=root,pre=root;
			while(curr!=null){
				pre=curr;
				if(curr.data==data){
					System.out.println(data+" is already exist.");
					return;
				}
				else if(curr.data>data){
					curr=curr.left;
				}
				else{
					curr=curr.right;
				}
			}
			if(pre.data>data)
				pre.left=newNode;
			else
				pre.right=newNode;
		}
		System.out.println(data+" added successfully.");
	}

	//Inorder logic
	public void inorder(Node root){
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}

	//Preorder logic
	public void preorder(Node root){
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}

	//Postorder logic
	public void postorder(Node root){
		if(root==null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}

	// Delete Node from BST
	public String delete(int data){
		if(root==null){
			return "BST is empty.";
		}else{
			Node curr=root,pre=root;
			boolean f=false;
			while(curr!=null){
				if(curr.data==data){
					f=true;
					break;
				}else if(curr.data>data){
					pre=curr;
					curr=curr.left;
				}else{
					pre=curr;
					curr=curr.right;
				}
			}

			if(!f){ // data is not find.
				return data+" is not available.";
			}
			else if(f && curr.left==null || curr.right==null){ // data has 0 or 1 child
				
				if(curr!=root){
					Node address = curr.left!=null?curr.left:curr.right;	
					if(curr.data>pre.data){
						pre.right=address;
					}else{
						pre.left=address;
					}
				}else{
					if(curr.left!=null){
						root=curr.left;
					}else{
						root=curr.right;
					}
				}
				
				return data+" deleted successfully.";

			}else{	// data has 2 child.

				Node nextRoot=null,preRoot=curr;
				nextRoot=curr.left;
				while(nextRoot.right!=null){
					preRoot=nextRoot;
					nextRoot=nextRoot.right;
				}
					
				if(preRoot!=curr){
					preRoot.right=nextRoot.left;
				}else{
					preRoot.left=nextRoot.left;
				}
				curr.data=nextRoot.data;

				return data+" deleted successfully.";
			}
		}
	}

	// Calculate Height of BST using recursive method.
	int calculateHeight(BST.Node root){
		if(root==null){
			return 0;
		}

		return 1 + Math.max(calculateHeight(root.left), calculateHeight(root.right));
	}

	public static void main(String arg[])
	{
		BST bst=new BST();
		Scanner sc=new Scanner(System.in);

		while(true){
			System.out.println("1. Enter node");
			System.out.println("2. Delete the node");
			System.out.println("3. Inorder traversal");
			System.out.println("4. Preorder traversal");
			System.out.println("5. Postorder traversal");
			System.out.println("6. Height of BST");
			System.out.println("7. Exit");
			System.out.print("\nEnter your choice : ");
			int choice = sc.nextInt();

			switch(choice){
				case 1: 
					System.out.print("\nData : ");
					bst.add(sc.nextInt());
					break;
				case 2:
					System.out.print("\nData : ");
					System.out.println(bst.delete(sc.nextInt()));
					break;
				case 3: 
					if(bst.root==null)
						System.out.print("\nBST is empty.");
					else{
						System.out.println("\nInorder :");
						bst.inorder(bst.root);
					}
					break;
				case 4:
					if(bst.root==null)
						System.out.print("\nBST is empty.");
					else{
						System.out.println("\nPreorder :");
						bst.preorder(bst.root);
					}
					break;
				case 5: 
					if(bst.root==null)
						System.out.print("\nBST is empty.");
					else{
						System.out.println("\nPostorder :");
						bst.postorder(bst.root);
					}
					break;
				case 6:
					System.out.print("\nHeight of BST : "+bst.calculateHeight(bst.root));
					break;
				case 7:
					System.exit(0);
				default : 
					System.out.println("\nYou enter wrong choice.");
			}
			System.out.println("\n");
		}
	}
}