/**
 * LinkedList<T> class contains methods specific to the Node.
 * @author Yassin Ting
 * @student ID 2014359
 * @version 1.0
 *
*/

public class LinkedList<T>{
	Node<T> head;
	Node<T> tail;
	int size = 0;

	public void printList(){
		Node<T> n = head;
		while (n != null){
			System.out.println("Data : " + n.data);
			n = n.next;
		}
	}
	
	public void add(T data){
		Node<T> newNode = new Node<T>(data); 
		if(head == null){
			head = newNode;
			tail = newNode;
		}else{
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}
	
	public Node<T> getHead(){
		return head;
	}
	
	public T get(int index){
		if(index == 0){
			return head.data;
		}else if(index > 0 && index < size){
			Node<T> temp = head;
			int i= 0;
			while(i != index){
				temp = temp.next;
				i++;
			}
			return temp.data;
		}else{
			return null;
		}
	}
	
	public T removeTop(){
		if(size > 0){
			Node<T> temp = head;
			head = head.next;
			size--;
			return temp.getData();
		}else{
			return null;
		}
	}
	
	public T getTop(){
		if(size == 0){
			return null;
		}else{
			return head.getData();
		}
	}
	
	public void joinLists(Node<T> headOfOtherList, int sizeOfOtherList){
		this.size += sizeOfOtherList;
		this.tail.next = headOfOtherList;
	}
	
	public void insertAfter(Node<T> prev, T data){
		Node<T> newNode = new Node<T>(data);
		newNode.next = prev.next;
		prev.next = newNode;
		size++;
	}
	
	public void append(T data){
		Node<T> newNode = new Node<T>(data);
		if(head == null){
			head = newNode;
		}
		newNode.next = null;
		Node<T> last = head;
		while(last.next != null){
			last = last.next;
		}
		last.next = newNode;
		size++;
	}
	
	public void push(T data){
		Node<T> newNode = new Node<T>(data); 
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public void deleteNodeWithValue(T value) { //assuming this method will be called only if the node is present in the list
		if(size == 1){
			head = null;
		}
		Node prev = head;
		Node curr = head.next;
		while (curr != null){
			if(curr.data.equals(value)){
				prev.next = curr.next;
			}else {
				prev = prev.next;
				curr = curr.next; // no null pointer exception will be shown even if curr.next is null
			}
		}
	}
		
	public int getSize(){
		return size;
	}
}