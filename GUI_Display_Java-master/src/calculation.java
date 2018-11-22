package project6;

public class calculation
{
	public int getWeek(int firstMonth, int firstDay, int lastMonth, int lastDay)
	{
		int days,weeks;
		days=30*(lastMonth-firstMonth)+(lastDay-firstDay);
		if(days%7==0)
		{
			weeks=days/7;
		}
		else 
		{
			weeks=days/7+1;
		}
		return weeks;
	}
	
	public double calculateTotal(int cottagePrice, int boatPrice, int weeks)
	{
		double total;
		total = (cottagePrice + boatPrice) * weeks;
		return total;
	}
	
}
