import java.io.*;
import java.util.*;

public class PartTwo {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("src/input"));

		int[][] array = new int [1000][1000];
		boolean[] claims = new boolean[1302];
		int ID;
		int left;
		int top;
		int width;
		int height;

		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array.length; j++)
				array[i][j] = 0;

		for (int i = 0; i < claims.length; i++) 
			claims[i] = true;
		claims[0] = false;


		while (in.hasNext()) {
			String line = in.nextLine();
			String[] split = line.split("[#@,:x]");
			for (int i = 0; i < split.length; i++) 
				split[i] = split[i].replaceAll("\\s+","");

			ID = Integer.parseInt(split[1]);
			left = Integer.parseInt(split[2]);
			top = Integer.parseInt(split[3]);
			width = Integer.parseInt(split[4]);
			height = Integer.parseInt(split[5]);

			for (int i = left; i < left + width; i++) 
				for (int j = top; j < top + height; j++) {
					if (array[i][j] == 0)
						array[i][j] = ID;  
					else { 					
						claims[array[i][j]] = false;
						claims[ID] = false;
					}
				}
		}

		for (int i = 0; i < claims.length; i++) 
			if (claims[i])
				System.out.println(i);


		in.close();

	}

}
