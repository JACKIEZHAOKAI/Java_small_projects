package Flight;

public class FlightOpts {
	private Flight flight;
	
	//constructor 
	public FlightOpts()
	{
		flight=new Flight();
	}
	
	//Adding  
	public void Adding(String name) // throws FlightException
	{	
		//Display a chart of the seats in the airplane in a tabular form 
		flight.printChart();
    
		//add the passenger
		try {
			flight.Add(name);		
		}
		catch(FlightException outBound)
		{	
			throw outBound;
		}
	}
	
	//Removing 
	public void Removing(String name )
	{
		//searching and removing the passenger
		try{
			flight.Remove(name);
		}
		catch(FlightException NoName)
		{
			System.out.printf("This is my custom exception:%s",NoName.getMessage());
		}
		
		//updating the array 
		flight.updating();
	}
	
	//Quit 
	public void Quit()
	{
		System.exit(0);
	}

	
}
