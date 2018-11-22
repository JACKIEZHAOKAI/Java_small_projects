package Flight;
import java.util.*;

public class waitinglist {
	private Queue<passenger> queue;
	private int sizeOfQueue;
	
	//waiting list constructor 
	public waitinglist(){
		queue = new Queue<passenger>();
		sizeOfQueue=queue.size();
	}
	
	//setter
	public void setWaitingList(passenger person)	
	{	//add a passenger to the tail
		queue.add(person);
	}
		
	//getter
	public passenger getWaitingList()	
	{	//take the 1st passenger and move up the array 
		return queue.poll();
	}
	
	public void printWaitingListArray(){
		
		System.out.printf("\nThe waiting list:\n");
		for( passenger person:queue){
			System.out.printf("%20s\n",person.getName());
		}
	}
	
	public int getSize()
	{return sizeOfQueue;}
	
}
