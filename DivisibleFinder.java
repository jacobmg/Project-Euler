
/*
 * Goal: What is the smallest number that is evenly divisible by all of the numbers 1-20?
 * 
 * http://projecteuler.net/problem=5
 */

public class DivisibleFinder {
	
	//A simple implementation of a node to be used in a list of ints
	
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
	
	//A simple list performing only the tasks required by this problem
	
	private class List{
		
		private Node head;
		
		private List(){
			head = null;
		}
		
		private List(int i){
			head = new Node(i);
		}
		
		//Simply inserts at the front of the list as order is not important
		
		private void insert(int i){
			if(head == null){
				head = new Node(i);
			}
			else{
				head = new Node(i, head);
			}
		}
		
	}
	
	public int findMinDivisible(int maxDivisor){
		List divisors = new List(1);
		
		/*
		 * Each iteration of the for loop checks whether the number is divisible by a divisor i.
		 * It does this by attempting to divide by the prime factors required to maintain divisibility.
		 * After the divisor is divided by the prime factors which go evenly into it,
		 * if the remainder is not 1, it is added as another prime factor.
		 */
		
		for(int i = 1; i <= maxDivisor; i++){
			Node n = divisors.head;
			int remainder = i;
			while(n != null){
				if(remainder % n.data == 0){
					remainder = remainder / n.data;
				}
				n = n.next;
			}
			if(remainder != 1){
				divisors.insert(remainder);
			}
		}
		
		/*
		 * The resulting prime factors produced by the above loop are multiplied together
		 * to create a number divisible by all numbers 1 through maxDivisor.
		 */
		
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
