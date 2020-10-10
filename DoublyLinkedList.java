import java.util.*;

class DoublyLinkedList 
{
	Node head,tail;

	//DoublyLinkedList Structure
	class Node{
		int data;
		Node next,prev;
		Node(int data){
			this.data=data;
			next=null;
			prev=null;
		}
	}

	//Add data at first doubly linked list.
	public void addFirst(int data){
		Node newNode=new Node(data);
		if(head==null){
			head=newNode;
			tail=newNode;
		}
		else{
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
		}
		System.out.println(data+" is added at first successfully.");
	}

	//Add data at last doubly linked list.
	public void addLast(int data){
		Node newNode=new Node(data);
		if(tail==null){
			head=newNode;
			tail=newNode;
		}
		else{
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
		}
		System.out.println(data+" is added at last successfully.");
	}

	//Delete data from using index.
	public void delete(int index){
		if(head==null){
			System.out.println("Doubly Linked list is empty.");
		}
		else{
			Node q=head,pre=head;
			int i;
			for(i=0;q!=null&&i<index;i++){
				q=q.next;
			}
			if(q==null)
				System.out.println("Not available.");
			else{
				System.out.println(q.data+" deleted successfully.");
				if(q==head)
					head=head.next;
				if(q==tail)
					tail=tail.prev;
				if(q.next!=null)
					q.next.prev=q.prev;
				if(q.prev!=null)
					q.prev.next=q.next;
			}
		}
	}

	//Display From the First.
	public void displayFirst(){
		if(head==null){
			System.out.println("Doubly Linked list is empty.");
		}
		else{
			Node q=head;
			System.out.println("Doubly LinkedList from first : ");
			while(q!=null){
				System.out.print(q.data+" ");
				q=q.next;
			}
			System.out.println();
		}
	}

	//Display From the Last.
	public void displayLast(){
		if(tail==null){
			System.out.println("Doubly Linked list is empty.");
		}
		else{
			Node q=tail;
			System.out.println("Doubly LinkedList from last: ");
			while(q!=null){
				System.out.print(q.data+" ");
				q=q.prev;
			}
			System.out.println();
		}
	}

	//Reverse the DLL
	public void reverse(){
		if(head==null){
			System.out.println("Doubly Linked list is empty.");
		}
		else{
			Node curr=head,temp;
			while(curr!=null){
				temp=curr.next;
				curr.next=curr.prev;
				curr.prev=temp;
				curr=temp;
			}
			temp=head;
			head=tail;
			tail=temp;
			System.out.println("DLL is reversed.");
		}
	}

	public static void main(String arg[])
	{
		DoublyLinkedList dll=new DoublyLinkedList();
		Scanner sc=new Scanner(System.in);

		while(true){
			System.out.println("1. Add data at first");
			System.out.println("2. Add data at last");
			System.out.println("3. Delete from first");
			System.out.println("4. Reverse the DLL");
			System.out.println("5. Display LL from first");
			System.out.println("6. Display LL from last");
			System.out.println("7. Exit");
			System.out.print("\nEnter your choice : ");
			int choice=sc.nextInt();
			switch(choice){
				case 1: System.out.print("\nData : ");
						dll.addFirst(sc.nextInt());
						break;
				case 2: System.out.print("\nData : ");
						dll.addLast(sc.nextInt());
						break;
				case 3:	System.out.print("\nIndex : ");
						dll.delete(sc.nextInt());
						break;
				case 4: dll.reverse();
						break;
				case 5: dll.displayFirst();
						break;
				case 6: dll.displayLast();
						break;
				case 7: System.exit(0);
						break;
				default: System.out.println("You enter wrong choice.");
			}
			System.out.println();
		}
	}
}