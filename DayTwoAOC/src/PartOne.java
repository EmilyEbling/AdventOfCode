import java.util.*;
import java.io.*;

public class PartOne {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("src/input"));
		
		int[] array;
		
		int two = 0;
		int three = 0;
		
		boolean hasTwo = false;
		boolean hasThree = false;
		
		while (in.hasNext()) {
			String line = in.nextLine();
			array = new int[26];
			
			for (int i = 0; i < line.length(); i++) 
				array[line.charAt(i) - 'a']++;
			
			for (int i = 0; i < array.length; i++) {
				if (array[i] == 2)
					hasTwo = true;
				if (array[i] == 3)
					hasThree = true;
			}	
			if (hasTwo)
				two++;
			if (hasThree)
				three++;
			
			hasTwo = hasThree = false;
			
		}
		
		System.out.println(two * three);

		in.close();
		
	}

}
