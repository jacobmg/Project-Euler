
public class DivisibleFinder {
	
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
	
	private class List{
		
		private Node head;
		
		private List(){
			head = null;
		}
		
		private List(int i){
			head = new Node(i);
		}
		
		private List(Node n){
			head = n;
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
				n = n.next;
			}
			n.next = new Node(i);
		}
		
		private List next(){
			return new List(head.next);
		}
		
	}
	
	public int findMinDivisible(int maxDivisor){
		List divisors = new List();
		for(int i = 1; i <= maxDivisor; i++){
			Node n = divisors.head;
			int remainder = i;
			while(n != null){
				if(remainder % n.data == 0){
					remainder = remainder / n.data;
				}
				n = n.next;
			}
			divisors.insert(remainder);
		}
		
		Node n = divisors.head;
		int product = 1;
		while(n != null){
			product *= n.data;
			n = n.next;
		}
		return product;
	}
	
	public static void main(String[] args){
		DivisibleFinder df = new DivisibleFinder();
		System.out.println(df.findMinDivisible(20));
	}

}
