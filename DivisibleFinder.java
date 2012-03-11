
public class DivisibleFinder {
	
	private class List{
		
		private class Node{
			
			private int data;
			private Node next;
			
			private Node(int i){
				data = i;
				next = null;
			}
			
			private Node(int i, Node n){
				data = i;
				next = n;
			}
			
		}
		
		private Node head;
		
		private List(){
			head = null;
		}
		
		private List(int i){
			head = new Node(i);
		}
		
		private void insert(int i){
			if(head == null){
				head = new Node(i);
				return;
			}
			if(i < head.data){
				head = new Node(i, head);
				return;
			}
			Node n = head;
			while(n.next != null){
				if(i < n.next.data){
					n.next = new Node(i, n.next);
					return;
				}
			}
			n.next = new Node(i);
		}
		
	}

}
