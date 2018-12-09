import java.io.*;
import java.util.*;

public class PartTwo {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("src/input"));

		ArrayList<String> list = new ArrayList<String>();
		int difference = 0;
		String answer = "";

		while (in.hasNext()) 
			list.add(in.next());		

		for (String s : list) {
			for (String t : list) {
				difference = 0;
				for (int i = 0; i < t.length(); i++)
					if (s.charAt(i) != t.charAt(i))
						difference++;
				if (difference == 1) {
					for (int i = 0; i < t.length(); i++) 
						if (s.charAt(i) == t.charAt(i))
							answer += s.charAt(i);
				}
			}

		}
		System.out.println(answer);

		in.close();
	}

}
