import java.io.*;
import java.util.*;

public class PartOne {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("src/input"));

		Record[] records = new Record[1017];
		int[][] guards = new int[10000][60];
		int index = 0;
		
		for (int i = 0; i < guards.length; i++)
			for (int j = 0; j < 60; j++)
				guards[i][j] = 0;

		while (in.hasNext()) {
			String line = in.nextLine();
			String[] split = line.split("[\\[\\-\\s:\\]]");

			int year = Integer.parseInt(split[1]);
			int month = Integer.parseInt(split[2]);
			int day = Integer.parseInt(split[3]);
			int hour = Integer.parseInt(split[4]);
			int minute = Integer.parseInt(split[5]);
			String message = "";

			for (int i = 6; i < split.length; i++)
				message += split[i] + " ";

			records[index] = new Record(year, month, day, hour, minute, message);
			index++;
		}

		Arrays.sort(records);
		
		int ID = 0;
		int asleepMin = 0;
		int wakeMin = 0;

		for (Record r : records) {
			if (r.getMessage().contains("Guard")) {
				String[] split = r.getMessage().split("[#\\s]");
				for (int i = 0; i < split.length; i++) 
					split[i] = split[i].replaceAll("\\s+","");
				ID = Integer.parseInt(split[3]);
			}
			else if (r.getMessage().contains("falls asleep")) {
				asleepMin = r.getMinute();
			}
			else if (r.getMessage().contains("wakes up")){
				wakeMin = r.getMinute();
				for (int i = asleepMin; i <= wakeMin; i++)
					guards[ID][i]++;
			}

		}
		
		int max = 0;
		int sum = 0;
		int guardID = 0;
		for (int i = 0; i < guards.length; i++) {
			sum = 0;
			for (int j = 0; j < 60; j++)
				sum += guards[i][j];
			if (sum > max) {
				max = sum;
				guardID = i;
			}
		}
		
		int maxMin = 0;
		int maxIn = 0;
		for (int i = 0; i < 60; i++) 
			if (guards[guardID][i] > maxMin) {
				maxMin = guards[guardID][i];
				maxIn = i;
			}
		
		System.out.println(guardID * maxIn);	

	}

}
