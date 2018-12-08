import java.io.*;
import java.util.*;

public class PartTwo {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("src/input"));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		
		int sum = 0;
		int index = 0;
		boolean found = false;
		
		while (in.hasNext())
			list.add(in.nextInt());
		
		while (!found) {
			if (index == list.size())
				index = 0;
			if (!set.contains(sum)) {
				set.add(sum);
				sum += list.get(index);
				index++;
			}
			else 
				found = true;
						
		}

		System.out.println(sum);
		
		in.close();
		
	}
		
}
