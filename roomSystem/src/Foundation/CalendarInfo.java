package Foundation;
import java.io.Serializable;
import java.util.Calendar;


public class CalendarInfo implements Serializable{
		
		private int year;
		private int month;
		private int daynum;
		private boolean[] checkbook; 
		Calendar cal= Calendar.getInstance();
	    
		
		public CalendarInfo()
		{
			this.year = cal.get(Calendar.YEAR);
			this.month = cal.get(Calendar.MONTH)+1;
			cal.set(Calendar.YEAR,year);
			cal.set(Calendar.MONTH,month-1);
			daynum = cal.getActualMaximum(Calendar.DATE);
			checkbook = new boolean[daynum];
			for(int i = 0; i<daynum;i++)
				checkbook[i] = false;
		}
		public CalendarInfo(int year, int month)
		{
			this.year = year;
			this.month = month;
			cal.set(Calendar.YEAR,year);
			cal.set(Calendar.MONTH,month-1);
			daynum = cal.getActualMaximum(Calendar.DATE);
			checkbook = new boolean[daynum];
			for(int i = 0; i<daynum;i++)
				checkbook[i] = false;
		}
		
		public int getYear()
		{
			return year;
		}
		public void setYear(int year)
		{
			this.year = year;
		}
		
		public int getmonth()
		{
			return month;
		}
		public void setmonth(int month)
		{
			this.month = month;
		}
		
		public boolean getbook(int day)
		{
			return checkbook[day];
		}
		public void setbook(int day, boolean temp)
		{
			checkbook[day] = temp;
		}
		public int getDayNum()
		{
			return daynum;
		}
}
