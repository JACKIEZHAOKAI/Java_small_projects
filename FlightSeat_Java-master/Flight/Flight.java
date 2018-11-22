package Flight;
import java.util.Scanner;

public class Flight {
	
	//10 rows and 4 columns of the seats 
	private passenger[][] array;
	//max 10 people in the waiting list 
	private waitinglist theWaitingList;
	
	Scanner input=new Scanner(System.in);
	
//constructor
public Flight(){
	array=new passenger[3][2];
	theWaitingList=new waitinglist();
	
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<2;j++)
		{
			array[i][j]=null;
			
		}
	}

}
	
//*****************print the chart **************	
public void printChart(){

	System.out.printf("\nThe seat chart:\n");
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<2;j++)
		{
			if(array[i][j]!=null)
				System.out.printf("(%d,%d)%-12s ",i,j,array[i][j].getName());
			else
				System.out.printf("(%d,%d)%-12s",i,j,"Avaliable");
		}
		System.out.printf("\n");
	}
	
	//print waiting list
	theWaitingList.printWaitingListArray();
}

//*****************Add passenger function**************
public void Add(String name) throws FlightException
{	
	int col,row;
	//temporary storage
	passenger person=new passenger(name);
	
	//check the available seats
	Boolean test=false;
	
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<2;j++)
		{
			if(array[i][j]==null)
				test=true;
		}
	}
	
	// if the all seats are not available 
	if(!test)
	{	
		//test if the waiting list is full
		if(theWaitingList.getSize()<3)
		{
			//add to waiting list
			System.out.printf("Sorry! The seats are full. You will be added to waitinglist!\n ");
			theWaitingList.setWaitingList(person);
		}
		else 
		{
			throw new FlightException("Sorry! You will not be added, the waitinglist is full!");
		}
	}
	else
	//if there is empty seat
	{
		//choose a seat 
		System.out.printf("Where do your want to take a seat?\n");
		System.out.printf("the column:");
		col=input.nextInt();
		System.out.printf("the row:");
		row=input.nextInt();
		
		//test the input column and row is correct 
		if(row>3||row<0||col>2||col<0)
		{
			throw new FlightException("the col or the row is out of bound");
		}
			
		//test if this seat is empty 
		if(array[col][row]==null)
		{	
			//construct a new passenger 
			array[col][row]=new passenger(name);	
			System.out.printf("You have been successfully added.\n");
		}
		else	
		//this seat is not empty
		{
			System.out.printf("Sorry! The seat is not available!\nPlease choose other seat.\n");
		}
	}
	
}
	
//*****************Remove passenger function**************
	public void Remove(String name) throws FlightException
	{		
		//Search the seating chart for the passenger's name and delete it
		Boolean PassangerFound=false;
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				//find the correct passenger		
				if(array[i][j]!=null&&array[i][j].getName().equalsIgnoreCase(name))
				{	
					PassangerFound=true;
					
                    //delete the passenger
					array[i][j]=null;
					System.out.printf("the passenger %s has been successfully removed!\n",name);
					System.out.printf("Now seat (%d,%d) is available.\n",i,j);
									
				}	
			}
		}
		
		//test the person exist 
		if(PassangerFound==false)
		{
			throw new FlightException("the passenger does not exist!");
		}
	}
	
//*****************updating function**************
	public void updating()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				//if the waiting list is not empty, move the 1st passenger on the wl
                //into the chart
				if(theWaitingList!=null && array[i][j]==null)
				{	array[i][j]=theWaitingList.getWaitingList();	}	
			}
		}
	}

}
