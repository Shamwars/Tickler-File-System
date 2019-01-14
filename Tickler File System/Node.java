/**
 * Node class
 * @author Yassin Ting
 * @student ID 2014359
 * @version 1.0
 *
*/

public class Node<T>{
	T data; 
	Node<T> next;
	
	Node (T d){
		data = d;
		next = null;
	}
	T getData(){
		return data;
	}
}