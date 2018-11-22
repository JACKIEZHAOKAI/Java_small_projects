package Interface;
import Flight.*;

public class APIImplementation implements API {

		private FlightOpts FlighgtOption;
		
		public APIImplementation(){
			FlighgtOption=new FlightOpts();
		}
		
		public void AddPassenger(String name) 
		{
			try{
				FlighgtOption.Adding(name);
			}
			catch(FlightException outOfBound){
				System.out.printf("This is my custom exception:%s",outOfBound.getMessage());
			}
		}
		
		public void Removing(String name){
			FlighgtOption.Removing(name);
		}
		
		public void quit(){
			FlighgtOption.Quit();
		}
}
