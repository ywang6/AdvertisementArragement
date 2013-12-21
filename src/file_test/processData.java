package file_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 * arrangeAd() is the main function in the class, deal with all the ads to make sure which ads put into 
 * the resultSet and abandonSet.
 * dealwithAad() is to deal with ads in different places, if it is fit, put into the fittable, otherwise,
 * put into abandonSet.
 * fitThisTable() is to judge if the time span of the ads can fit the current timetable.
 * putIntoThisTable() is to judge if the table is fit, put into the table.
 * @author yu wang
 *  
 */
public class processData {
	public static HashMap<Integer, ArrayList<Ad>> leftTable = new HashMap<Integer, ArrayList<Ad>>(); 
	//hashmap put left place ads with key is time spot, value is arraylist of ads. 
	public static HashMap<Integer, ArrayList<Ad>> midTable = new HashMap<Integer, ArrayList<Ad>>();
	//hashmap put mid place ads with key is time spot, value is arraylist of ads.
	public static HashMap<Integer, ArrayList<Ad>> rightTable = new HashMap<Integer, ArrayList<Ad>>();
	//hashmap put right place ads with key is time spot, value is  arraylist of ads.
	public static HashSet<Ad> resultSet = new HashSet<Ad>();//put valid result into resultSet
	public static HashSet<Ad> abandonSet = new HashSet<Ad>();//put valid result into abandonSet
	
	/*
	 * dealWithAd() is to judge if the ads in this place fit the current table, if it fits,put into
	 * the timetable and resultset, if not, put into abandonset.
	 */
	public static void dealWithAd(Ad ad)
	{
		if(ad.getPlace().equals("left"))
		{
			if(fitThisTable(leftTable, ad))
			{
				putIntoThisTable(leftTable, ad);
				putIntoResultSet(ad);
				write_file.writeFile(ad);
			}
			else
			{
				putIntoAbandonSet(ad);
			}
		}
		else if(ad.getPlace().equals("mid"))
		{
			if(fitThisTable(midTable, ad))
			{
				putIntoThisTable(midTable, ad);
				putIntoResultSet(ad);
				write_file.writeFile(ad);
			}
			else
			{
				putIntoAbandonSet(ad);
			}
		}
		else
		{
			if(fitThisTable(rightTable, ad))
			{
				putIntoThisTable(rightTable, ad);
				putIntoResultSet(ad);
				write_file.writeFile(ad);
			}
			else
			{
				putIntoAbandonSet(ad);
			}
		}
	}
	/*
	 * fitThisTable() is to judge if the ad fit the timetable, if the size of the arraylist in the 
	 * current time is greater than 3, not fit. Same ad name in the same time same place, not fit.
	 */
	public static boolean fitThisTable(HashMap<Integer, ArrayList<Ad>> timeTable, Ad ad)
	{
		int startTime = ad.getStartTime();
		int endTime = ad.getEndTime();
		int i = 0;
		for(i = startTime; i<=endTime; i++)
		{
			if(!timeTable.containsKey(i)) continue; // no such time, move on
			else if(timeTable.get(i).size()>=3) return false;// number of ads more than 3, not fit
			else								
			{
				for(Ad a : timeTable.get(i))
				{
					if(a.getName().equals(ad.getName()))// Same ad name, same time, same place, not fit
					return false;
				}
			// other case, go on.
			}
		}
		return true; 					// if move to the last, fit.
	}
	//if fit, put this ad into current timeTable. I put this ad based on its time point.
	//Say, if you have ad1 start from 2 to 4. I will put 2->ad1,3->ad1,4->ad1 into this table.
	public static void putIntoThisTable(HashMap<Integer, ArrayList<Ad>> timeTable, Ad ad)
	{
		int startTime = ad.getStartTime();
		int endTime = ad.getEndTime();
		for(int i = startTime; i<=endTime; i++)
		{
			if(!timeTable.containsKey(i)) 
			{
				ArrayList<Ad> adList = new ArrayList<Ad>();
				adList.add(ad);
				timeTable.put(i, adList);
			}
			else
			{
				timeTable.get(i).add(ad);
			}
		}
	}
	// save the fit ad into result set.
	public static void putIntoResultSet(Ad ad)
	{
		resultSet.add(ad);
	}
	// save the unfit ad into abandon set.
	public static void putIntoAbandonSet(Ad ad)
	{
		abandonSet.add(ad);
	}
}
					