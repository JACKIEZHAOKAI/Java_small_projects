/*
 *  CIS 35A 6:00-9:50 p.m
 *  lab 5
 *  Due: 26th of July
 *  Date submitted: 28th of July
 *  ZHAOKAI XU
 */

import java.util.Scanner;
import Interface.APIImplementation;

public class Driver {

	  public static void main(String[] args)

	{
		APIImplementation a1=new APIImplementation();
		
		int option=0;
		
		Scanner input=new Scanner(System.in);
		
			//print the options 
			System.out.printf("\n1.Add passenger\n2.Remove passengers\n3.Quit\n\n");
			
			//options 
			while(option!=3)
			{
				System.out.printf("\nWhat is your choice?");
				option=input.nextInt();
				
				if(option==1)
					{	//request for name 
						System.out.printf("\nWho do you want to add?\n");
						String name=input.next();
						a1.AddPassenger(name);
					}
				else if(option==2)
					{	//request for name 
						System.out.printf("\nWho do you want to remove?\n");
						String name=input.next();
						a1.Removing(name);
					}
				else if(option==3)
					{
						a1.quit();
					}
				else
					{
						System.out.printf("this is not vaid option!\n");
					}
			}
	}

}
