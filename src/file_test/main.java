package file_test;
public class main {
	public static void main(String[] args) throws Exception
	{
		read_file rf = new read_file();
		write_file wf = new write_file();
		StringBuffer sb = rf.readfile("input.txt");
		rf.readOneAdDealWithOneAd(sb);
		
		System.out.println("result set is: ");
		for(Ad a : processData.resultSet)
		{
			System.out.println(a);
		}
		System.out.println("abandon set is: ");
		for(Ad a : processData.abandonSet)
		{
			System.out.println(a);
		}
		
		//gd.arrange_ad_notimeissue(gd.process_data(sb));
		
		//wf.write_file(gd.arrange_ad_notimeissue(gd.process_data(sb)));
	}
}
