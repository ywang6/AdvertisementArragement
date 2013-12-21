package file_test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class write_file{
	public static void writeFile(Ad ad){
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter("C:\\Users\\yu wang\\Desktop\\output.txt", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bw = new BufferedWriter(fw);
		
			try {
				bw.append(ad.getName()+" "+ad.getStartTime()+" "+ad.getEndTime()+" "+ ad.getPlace());
				bw.newLine();
				bw.flush();
			}catch (IOException e) {
				e.printStackTrace();
			}
	}	
}
