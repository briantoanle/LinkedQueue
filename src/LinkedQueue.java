/**
 * LinkedQueue represents a linked implementation of a queue.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 08/12/08
 */

public class LinkedQueue<T> implements QueueADT<T>
{
	private int count;
	private LinearNode<T> front, rear;

	/**
	 * Creates an empty queue.
	 */
	public LinkedQueue() {
		count = 0;
		front = rear = null;
	}

	/**
	 * Adds the specified element to the rear of this queue.
	 *
	 * @param element  the element to be added to the rear of this queue
	 */
	public void enqueue (T element) {
		System.out.println("trying to enqueue " + element + " rear value is " + rear);
		 LinearNode<T> newLinNode = new LinearNode<>(element);
		 if(rear==null) {
			 front = rear = newLinNode;
			 count++;
			 return;
		 }
		 rear.setNext(newLinNode);
		 rear = newLinNode;
		 count++;
		 //System.out.println("printing rear " + rear.getElement());
	}

	/**
	 * Removes the element at the front of this queue and returns a
	 * reference to it. Throws an EmptyCollectionException if the
	 * queue is empty.
	 *
	 * @return                           the element at the front of this queue
	 * @throws EmptyCollectionException  if an empty collection exception occurs
	 */
	public T dequeue() throws EmptyCollectionException {
		if(front == null)
			return null;
		LinearNode<T> newLinNode = new LinearNode<>(front.getElement());
		front = front.getNext();
		count--;
		if(front ==null)
			rear = null;
		return newLinNode.getElement();
	}

	/**
	 * Returns a reference to the element at the front of this queue.
	 * The element is not removed from the queue.  Throws an
	 * EmptyCollectionException if the queue is empty.
	 *
	 * @return                            a reference to the first element in
	 *                                    this queue
	 * @throws //EmptyCollectionsException  if an empty collection exception occurs
	 */
	public T first() throws EmptyCollectionException {
		return front.getElement();
	}

	/**
	 * Returns true if this queue is empty and false otherwise.
	 *
	 * @return  true if this queue is empty and false if otherwise
	 */
	public boolean isEmpty() {
		if(count >0)
			return false;
		return true;
	}

	/**
	 * Returns the number of elements currently in this queue.
	 *
	 * @return  the integer representation of the size of this queue
	 */
	public int size() {
		return count;
	}
	//private LinearNode<T> next;
	//private T element;
	public LinearNode<T> getNext()
	{
		//return next;
		return null;
	}
	public String toString(){
		String str = "";
		//str += this.element + "->";
		LinearNode temp = front;
		while (temp != null){
			str += temp.getElement() + " -> ";
			temp = temp.getNext();
		}
		//str += "\n";
		return str;
	}
	public static void main(String[] args){

		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
/*		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		System.out.println(queue.toString());
		System.out.println(queue.size());
		System.out.println(queue.isEmpty() + " check empty");
		System.out.println("testing first() " + queue.first());

		System.out.println("dequeue return: " + queue.dequeue());
		System.out.println("dequeue return: " + queue.dequeue());
		System.out.println("dequeue return: " + queue.dequeue());
		System.out.println("testing dequeue " + queue);
		System.out.println("Queue size now = " + queue.size());

		queue.enqueue(10);
		queue.enqueue(20);

		System.out.println("where is my queue ? " + queue);

		System.out.println("value in rear is: " + queue.rear.getElement());
*/


		// Write a method called : orderInsert(int value)
		// make sure the new value will be inserted into your LinkedQueue in order
		// for example:
		// start with an empty LinkedQueue:
		// orderInsert(10) - your queue: 10
		// orderInsert(5)  - your queue: 5 -> 10
		// orderInsert(20) - your queue: 5 -> 10 -> 20
		// orderInsert(15) = your queue: 5 -> 10 -> 15 -> 20
		// orderInsert(25) - your queue: 5 -> 10 -> 15 -> 20 -> 25

		queue.orderInsert(10);
		System.out.println(queue);
		queue.orderInsert(5);
		System.out.println(queue);
		queue.orderInsert(20);
		queue.orderInsert(30);
		queue.orderInsert(15);
		queue.orderInsert(30);
		//queue.orderInsert();
//		System.out.println("size? " + queue.size());
//		queue.orderInsert(8);
		//queue.orderInsert(3);
		System.out.println(queue);
		//System.out.println(queue);
		System.out.println("size? " + queue.size());
	}

	public void orderInsert(int nextInsert){
		System.out.println("_____ START METHOD orderInsert " + nextInsert + " into Queue: " + this);
		//front rear
		//value
		//
		LinearNode newLinNode = new LinearNode(nextInsert);

		if(isEmpty()==true) {
			front = rear = newLinNode;
			count++;
			return;
		}
		//rear > value
		//10
		//add 5
		//rear = 10
		//


		// orderInsert(10) - your queue: 10
		// orderInsert(5)  - your queue: 5 -> 10
		// orderInsert(20) - your queue: 5 -> 10 -> 20
		// orderInsert(15) = your queue: 5 -> 10 -> 15 -> 20
		// orderInsert(25) - your queue: 5 -> 10 -> 15 -> 20 -> 25

		//1. nextInsert < front
		// in this case, the new Node (nextInsert) will be the new front and it will point to old front


		//2.
		// this case front < nextInsert < rear the new Node will be insert in the middle somewhere


		//3. last case: rear < nextInsert
		// this case, rear will point to new node and the new node will be the new rear after





		if(nextInsert < (int)front.getElement()){
			System.out.println("front greater than element");
			System.out.println("line 201 printing front "+ front.getElement());
			System.out.println("line 202 printing rear " +rear.getElement());
			System.out.println("Queue: " + this);
			newLinNode.setNext(front);
			front = newLinNode;
			System.out.println("line 206 printing front "+ front.getElement() + " what is next after front " + front.getNext().getElement().toString());
			System.out.println("line 207 printing rear " +rear.getElement());
			System.out.println("Queue: " + this);

		}


		//  5 -> 7 -> 8 -> 10
		//2.
		// this case front < nextInsert < rear the new Node will be inserted in the middle somewhere
		else if((int)front.getElement() < nextInsert && nextInsert < (int)rear.getElement()){
			LinearNode curNode = new LinearNode();
			LinearNode tempNode = new LinearNode();
			tempNode = front;

			System.out.println("front lower than element, rear greater than element");
			while((int)tempNode.getElement() < nextInsert && tempNode != null){
				System.out.println("value of tempNode " + front.getElement().toString() + " value of nextInsert " + nextInsert);
				curNode = tempNode;
				System.out.println("value of curNode is: " + curNode.getElement());
				tempNode = tempNode.getNext();
				System.out.println("value of tempNode is: " + tempNode.getElement());
			}
			curNode.setNext(newLinNode);
			newLinNode.setNext(tempNode);


		}
		else if((int)rear.getElement() < nextInsert){
			System.out.println("rear lower than element");
			rear.setNext(newLinNode);
			rear = newLinNode;
		}
		System.out.println("printing front "+ front.getElement());
		System.out.println("printing rear " +rear.getElement());
		System.out.println("--------------------");
		count++;

	}
	public void orderInsert2(int nextInsert){
		System.out.println("________ START METHOD orderInsert ____________");
		//front rear
		//value
		//
		LinearNode newLinNode = new LinearNode(nextInsert);

		if(isEmpty()==true) {
			front = rear = newLinNode;
			count++;
			return;
		}
		//rear > value
		//10
		//add 5
		//rear = 10
		//


		// orderInsert(10) - your queue: 10
		// orderInsert(5)  - your queue: 5 -> 10
		// orderInsert(20) - your queue: 5 -> 10 -> 20
		// orderInsert(15) = your queue: 5 -> 10 -> 15 -> 20
		// orderInsert(25) - your queue: 5 -> 10 -> 15 -> 20 -> 25

		if((int)rear.getElement() > nextInsert){
			System.out.println("rear greater than nextInsert");

			//rear = newLinNode;


			System.out.println("line 179 printing front "+ front.getElement());
			System.out.println("line 180 printing rear " +rear.getElement());
			if((int)front.getElement() > nextInsert) {
				System.out.println("front greater than nextInsert");
				front = newLinNode;
				front.setNext(rear);
			}

			if((int)front.getElement() < nextInsert){
				System.out.println("nextInsert greater than front");
				front = newLinNode;
				front.setNext(newLinNode);

				System.out.println("line 187 printing front "+ front.getElement());
				System.out.println("line 188 printing rear " +rear.getElement());
			}

		}
		System.out.println("printing front "+ front.getElement());
		System.out.println("printing rear " +rear.getElement());
		System.out.println("--------------------");
		count++;
	}

	//   5                   20
	// FRONT x   x   x   x  REAR
	//if the new number is smaller than FRONT, --> this new number is the new FRONT

	// if the new number is bigger than REAR, ---> this new number is the new REAR

	// otherwise, the node is somewhere in between!+ printing rear
}
