package file_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class read_file {
	
	public StringBuffer readfile(String filename)
	{
		FileReader fr = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		String line;
		try{
			fr = new FileReader("C:\\Users\\yu wang\\Desktop\\"+filename);//C:\Users\yu wang\Desktop
		}catch(Exception e)
		{
			System.out.println("open file error");
		}
		try {
			br = new BufferedReader(fr);
			line = br.readLine();
			while(line!=null)
			{
				//System.out.println(line);
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return sb;
	}
	public void readOneAdDealWithOneAd(StringBuffer sb)
	{	
		String[] each_ad = sb.toString().split("\\n");//split input file stringbuffer by return
		//Ad[] ads = new Ad[each_ad.length];  //create a Ad array to store ad objects
		for(int i = 0; i<each_ad.length;i++)
		{
			String[] each_column = each_ad[i].split(" ");//split each line by space
			
			String name = each_column[0];//we got ad name
			String startTime = each_column[1];//ad time
			String endTime = each_column[2];
			String place = each_column[3];//ad location
		
			// create a Ad object
			Ad ad = new Ad();
			ad.setName(name);
			ad.setStartTime(Integer.parseInt(startTime));
			ad.setEndTime(Integer.parseInt(endTime));
			ad.setPlace(place);
			processData.dealWithAd(ad);
		}
		//test if our process data function works
//		System.out.println("Test input data.");
//		for(int j = 0;j<ads.length;j++)
//		{
//			System.out.println(ads[j].getName());
//		}

	}
}
