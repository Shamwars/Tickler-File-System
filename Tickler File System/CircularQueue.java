/**
 * CircularQueue<T> class contains methods specific for the queue
 * @author Yassin Ting
 * @student ID 2014359
 * @version 1.0
 *
*/

public class CircularQueue<T>{
	int front;
	int tail;
	T[] arrayQueue;
	int maxCapacity;
    int size;

	public CircularQueue(int maxCapacity) {
		front = 0;
		tail = 0;
        size = 0;
        
		arrayQueue = (T[]) new Object[maxCapacity];
		this.maxCapacity = maxCapacity;
	}

	public boolean isEmpty() {
		return(size == 0);
	}

	public boolean isFull() {
        return (size == maxCapacity);
	}

	public int size() {
   		return size;
	}

	public void enqueue(T element) {
        if(!isFull()) {
            arrayQueue[tail%maxCapacity] =  element;
            tail = (tail+1)%maxCapacity;
            size++;
        } else {
            System.out.println("Totally full");
        }
    }

	public T dequeue() {
        if(!isEmpty()) {
            size--;
            T value = arrayQueue[front];
            front = (front+1)%maxCapacity;
            return value;
        }
        return null;
	}

	public T tail() {
		if(isEmpty()) 
			return null;
		return (T) arrayQueue[tail-1];
	}

	public T front() {
		if(isEmpty()) return null;
		return arrayQueue[front];
	}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        if(isEmpty()) {
            for(T l : arrayQueue) {
                sb.append('-');
                sb.append('|');
            }
        } else {
            if(front < tail) {
                for(int i = 0; i < front; i++) {
                    sb.append('-');
                    sb.append('|');
                }
                for(int i = front; i < tail; i++) {
                    sb.append(arrayQueue[i]);
                    sb.append('|');
                }
                for(int i = tail; i < arrayQueue.length; i++) {
                    sb.append('-');
                    sb.append('|');
                }
            } else {
                for(int i = 0; i < tail; i++) {
                    sb.append(arrayQueue[i]);
                    sb.append('|');
                }
                for(int i = tail; i < front; i++) {
                    sb.append('-');
                    sb.append('|');
                }
                for(int i = front; i < arrayQueue.length; i++) {
                    sb.append(arrayQueue[i]);
                    sb.append('|');
                }
            }
        }

        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }
}

